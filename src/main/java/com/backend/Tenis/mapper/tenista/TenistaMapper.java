package com.backend.Tenis.mapper.tenista;

import com.backend.Tenis.dto.tenista.RequestTenistaDTO;
import com.backend.Tenis.dto.tenista.ResponseTenistaDTO;
import com.backend.Tenis.entity.Tenista;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class TenistaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TenistaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Tenista toTenistaFromRequest(RequestTenistaDTO requestTenistaDTO) {
        return modelMapper.map(requestTenistaDTO, Tenista.class);
    }

    public RequestTenistaDTO toRequestTenistaDTO(Tenista tenista) {
        return modelMapper.map(tenista, RequestTenistaDTO.class);
    }

    public Tenista toTenistaFromResponse(ResponseTenistaDTO responseTenistaDTO) {
        return modelMapper.map(responseTenistaDTO, Tenista.class);
    }

    public ResponseTenistaDTO toResponseTenistaDTO(Tenista tenista) {
        return modelMapper.map(tenista, ResponseTenistaDTO.class);
    }

    public List<ResponseTenistaDTO> toResponseTenistaDTOList(List<Tenista> tenistas) {
        return modelMapper.map(tenistas, List.class);
    }
}
