package com.backend.Tenis.mapper.entrenador;

import com.backend.Tenis.dto.entrenador.RequestEntrenadorDTO;
import com.backend.Tenis.dto.entrenador.ResponseEntrenadorDTO;
import com.backend.Tenis.entity.Entrenador;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class EntrenadorMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EntrenadorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ResponseEntrenadorDTO> toResponseEntrenadorDTOList(List<Entrenador> entrenadores) {
        return modelMapper.map(entrenadores, List.class);
    }

    public ResponseEntrenadorDTO toResponseEntrenadorDTO(Entrenador entrenador) {
        return modelMapper.map(entrenador, ResponseEntrenadorDTO.class);
    }

    public Entrenador toEntrenadorFromResponse(ResponseEntrenadorDTO responseEntrenadorDTO) {
        return modelMapper.map(responseEntrenadorDTO, Entrenador.class);
    }

    public Entrenador toEntrenadorFromRequest(com.backend.Tenis.dto.entrenador.RequestEntrenadorDTO requestEntrenadorDTO) {
        return modelMapper.map(requestEntrenadorDTO, Entrenador.class);
    }

    public RequestEntrenadorDTO toRequestEntrenadorDTO(Entrenador entrenador) {
        return modelMapper.map(entrenador, com.backend.Tenis.dto.entrenador.RequestEntrenadorDTO.class);
    }


}
