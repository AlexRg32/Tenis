package com.backend.Tenis.mapper.raqueta;

import com.backend.Tenis.dto.raqueta.RequestRaquetaDTO;
import com.backend.Tenis.dto.raqueta.ResponseRaquetaDTO;
import com.backend.Tenis.entity.Raqueta;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor

public class RaquetaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RaquetaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ResponseRaquetaDTO> toResponseRaquetaDTOList(List<Raqueta> raquetas) {
        return modelMapper.map(raquetas, List.class);
    }

    public ResponseRaquetaDTO toResponseRaquetaDTO(Raqueta raqueta) {
        return modelMapper.map(raqueta, ResponseRaquetaDTO.class);
    }

    public Raqueta toRaquetaFromResponse(ResponseRaquetaDTO responseRaquetaDTO) {
        return modelMapper.map(responseRaquetaDTO, Raqueta.class);
    }

    public Raqueta toRaquetaFromRequest(com.backend.Tenis.dto.raqueta.RequestRaquetaDTO requestRaquetaDTO) {
        return modelMapper.map(requestRaquetaDTO, Raqueta.class);
    }

    public RequestRaquetaDTO toRequestRaquetaDTO(Raqueta raqueta) {
        return modelMapper.map(raqueta, com.backend.Tenis.dto.raqueta.RequestRaquetaDTO.class);
    }


}
