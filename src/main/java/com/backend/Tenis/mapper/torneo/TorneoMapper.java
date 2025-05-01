package com.backend.Tenis.mapper.torneo;

import com.backend.Tenis.dto.torneo.RequestTorneoDTO;
import com.backend.Tenis.dto.torneo.ResponseTorneoDTO;
import com.backend.Tenis.entity.Torneo;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class TorneoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TorneoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        System.out.println("hola");
    }

    public RequestTorneoDTO toRequestTorneoDTO(Torneo torneo) {
        return modelMapper.map(torneo, RequestTorneoDTO.class);
    }

    public Torneo toTorneoFromRequest(RequestTorneoDTO requestTorneoDTO) {
        return modelMapper.map(requestTorneoDTO, Torneo.class);
    }

    public ResponseTorneoDTO toResponseTorneoDTO(Torneo torneo) {
        return modelMapper.map(torneo, ResponseTorneoDTO.class);
    }

    public Torneo toTorneoFromResponse(ResponseTorneoDTO responseTorneoDTO) {
        return modelMapper.map(responseTorneoDTO, Torneo.class);
    }

    public List<ResponseTorneoDTO> toResponseTorneoDTOList(List<Torneo> torneos) {
        return modelMapper.map(torneos, List.class);
    }


}
