package com.backend.Tenis.mapper.academia;

import com.backend.Tenis.dto.academia.RequestAcademiaDTO;
import com.backend.Tenis.dto.academia.ResponseAcademiaDTO;
import com.backend.Tenis.entity.Academia;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class AcademiaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AcademiaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Academia fromRequestToAcademia(RequestAcademiaDTO requestAcademiaDTO) {
        return modelMapper.map(requestAcademiaDTO, Academia.class);
    }

    public RequestAcademiaDTO fromAcademiaToRequest(Academia academia) {
        return modelMapper.map(academia, RequestAcademiaDTO.class);
    }

    public Academia fromResponseToAcademia(com.backend.Tenis.dto.academia.ResponseAcademiaDTO responseAcademiaDTO) {
        return modelMapper.map(responseAcademiaDTO, Academia.class);
    }

    public ResponseAcademiaDTO fromAcademiaToResponse(Academia academia) {
        return modelMapper.map(academia, ResponseAcademiaDTO.class);
    }

    public List<ResponseAcademiaDTO> fromAcademiaListToResponseList(List<Academia> academias) {
        return modelMapper.map(academias, List.class);
    }
}
