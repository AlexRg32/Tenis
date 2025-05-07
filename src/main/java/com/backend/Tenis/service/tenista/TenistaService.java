package com.backend.Tenis.service.tenista;

import com.backend.Tenis.dto.sponsor.AñadirSponsorDTO;
import com.backend.Tenis.dto.torneo.AñadirTorneoDTO;
import com.backend.Tenis.entity.Entrenador;
import com.backend.Tenis.entity.Sponsor;
import com.backend.Tenis.entity.Tenista;
import com.backend.Tenis.entity.Torneo;
import com.backend.Tenis.entity.relaciones.*;
import com.backend.Tenis.exception.DeleteEntityException;
import com.backend.Tenis.exception.NotFoundEntityException;
import com.backend.Tenis.repository.entrenador.IEntrenadorRepository;
import com.backend.Tenis.repository.ficha.IFichaRepository;
import com.backend.Tenis.repository.firma.IFirmaRepository;
import com.backend.Tenis.repository.gana.IGanaRepository;
import com.backend.Tenis.repository.sponsor.ISponsorRepository;
import com.backend.Tenis.repository.tenista.ITenistaRepository;
import com.backend.Tenis.repository.torneo.ITorneoRepository;
import com.backend.Tenis.service.raqueta.IRaquetaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Service

public class TenistaService implements ITenistaService {

    private ISponsorRepository sponsorRepository;
    private ITenistaRepository tenistaRepository;
    private IFirmaRepository firmaRepository;
    private IGanaRepository ganaRepository;
    private ITorneoRepository torneoRepository;
    private IRaquetaService raquetaRepository;
    private IFichaRepository fichaRepository;
    private IEntrenadorRepository entrenadorRepository;

    public TenistaService(ISponsorRepository sponsorRepository, ITenistaRepository tenistaRepository,
                          IFirmaRepository firmaRepository, IGanaRepository ganaRepository,
                          ITorneoRepository torneoRepository, IRaquetaService raquetaRepository,
                          IFichaRepository fichaRepository, IEntrenadorRepository entrenadorRepository) {
        this.sponsorRepository = sponsorRepository;
        this.tenistaRepository = tenistaRepository;
        this.firmaRepository = firmaRepository;
        this.ganaRepository = ganaRepository;
        this.torneoRepository = torneoRepository;
        this.raquetaRepository = raquetaRepository;
        this.fichaRepository = fichaRepository;
        this.entrenadorRepository = entrenadorRepository;
    }



    @Override
    public List<Tenista> findAll() {
        try {
            return (List<Tenista>) tenistaRepository.findAll();
        } catch (Exception e) {
            throw new NotFoundEntityException(null, Tenista.class);
        }
    }

    @Override
    public Tenista findById(Long id) {
        return tenistaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Tenista.class));
    }

    @Override
    public Tenista save(Tenista tenista) {
        try {
            return tenistaRepository.save(tenista);
        } catch (Exception e) {
            throw new NotFoundEntityException(null, Tenista.class);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            tenistaRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteEntityException(id, Tenista.class, e);
        }
    }

    @Override
    public Tenista update(Tenista tenista) {
        try {
            return tenistaRepository.save(tenista);
        } catch (Exception e) {
            throw new NotFoundEntityException(null, Tenista.class);
        }
    }

    @Override
    public Tenista agregarSponsor(AñadirSponsorDTO sponsorDTO) {

        Sponsor sponsor = sponsorRepository.findById(sponsorDTO.getSponsor_id()).orElseThrow(() -> new NotFoundEntityException(sponsorDTO.getSponsor_id(), Sponsor.class));

        Tenista tenista = tenistaRepository.findById(sponsorDTO.getTenista_id()).orElseThrow(() -> new NotFoundEntityException(sponsorDTO.getTenista_id(), Tenista.class));

        Firma firma = new Firma();
        firma.setSponsor(sponsor);
        firma.setTenista(tenista);
        firma.setId(new FirmaId(sponsor.getId(), tenista.getId()));
        firma.setSaldo(BigDecimal.valueOf(sponsorDTO.getSaldo()));
        firma.setFechaInicio(sponsorDTO.getFecha_inicio().toLocalDate());
        firma.setFechaFin(sponsorDTO.getFecha_fin().toLocalDate());

        if (tenista.getSponsors() == null) {
            tenista.setSponsors(new ArrayList<>());
        }
        if (sponsor.getTenistas() == null) {
            sponsor.setTenistas(new ArrayList<>());
        }

        tenista.getSponsors().add(firma);
        sponsor.getTenistas().add(firma);

        return tenistaRepository.save(tenista);
    }

    @Override
    public Tenista ganarTorneo(AñadirTorneoDTO añadirTorneoDTO) {
        try {
            Tenista tenista = tenistaRepository.findById(añadirTorneoDTO.getTenistaId())
                    .orElseThrow(() -> new NotFoundEntityException(añadirTorneoDTO.getTenistaId(), Tenista.class));

            List<Torneo> torneos = new ArrayList<>();
            for (Long torneoId : añadirTorneoDTO.getTorneosId()) {

                Torneo torneo = torneoRepository.findById(torneoId)
                        .orElseThrow(() -> new NotFoundEntityException(torneoId, Torneo.class));
                torneos.add(torneo);
            }



            List<Gana> ganaList = new ArrayList<>();
            for (Torneo torneo : torneos) {
                Gana gana = new Gana();
                gana.setId(new GanaId(torneo.getId(), tenista.getId()));
                gana.setTorneo(torneo); // Asociar el torneo completo
                gana.setTenista(tenista);
                gana.setFecha(añadirTorneoDTO.getFecha());
                ganaRepository.save(gana);
                ganaList.add(gana);
            }

            for (Gana gana : ganaList) {
                tenista.getTorneos().add(gana);
            }

            return tenistaRepository.save(tenista);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void  borrarTenista(Long id) {

        Tenista tenista = tenistaRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Tenista.class));

        tenista.getTorneos().forEach(gana -> ganaRepository.delete(gana));
        tenista.getTorneos().clear();

        tenista.getSponsors().forEach(firma -> firmaRepository.delete(firma));
        tenista.getSponsors().clear();

        tenista.getEntrenadores().forEach(ficha -> fichaRepository.delete(ficha));
        tenista.getEntrenadores().clear();

        tenista.getRaquetas().forEach( raqueta -> raquetaRepository.deleteById(raqueta.getId()));
        tenista.getRaquetas().clear();

        tenistaRepository.delete(tenista);


    }

    @Override
    public Tenista ficharEntrenador(Long idTenista, Long idEntrenador) {
        int contadorEntrenadoresContratados = 0;
        boolean checkEntrenadoresContratados = false;
        boolean checkEntrenadorActivo = false;
        Tenista tenista = tenistaRepository.findById(idTenista).orElseThrow(() -> new NotFoundEntityException(idTenista, Tenista.class));
        Entrenador entrenador = entrenadorRepository.findById(idEntrenador).orElseThrow(() -> new NotFoundEntityException(idEntrenador, Entrenador.class));


        Ficha ficha = new Ficha(new FichaId(tenista.getId(), entrenador.getId()), tenista, entrenador, null);
        //compruebo entrenadores activos dl tenista
        for (Ficha f : tenista.getEntrenadores()) {
            if (f.getFechaFin()!= null) {
                contadorEntrenadoresContratados++;
            }
        }

        if(contadorEntrenadoresContratados < 4){
            checkEntrenadoresContratados = true;
        }

        if (entrenador.isActivo()) {
            checkEntrenadorActivo = true;
        }

        if (checkEntrenadoresContratados && checkEntrenadorActivo) {
            fichaRepository.save(ficha);
          tenista.getEntrenadores().add(ficha);
        }
        return tenistaRepository.save(tenista);


    }


}
