package com.backend.Tenis.mapper.sponsor;

import com.backend.Tenis.dto.sponsor.RequestSponsorDTO;
import com.backend.Tenis.dto.sponsor.ResponseSponsorDTO;
import com.backend.Tenis.entity.Sponsor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
public class SponsorMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SponsorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ResponseSponsorDTO> toResponseSponsorDTOList(List<Sponsor> sponsors) {
        return modelMapper.map(sponsors, List.class);
    }

    public ResponseSponsorDTO toResponseSponsorDTO(Sponsor sponsor) {
        return modelMapper.map(sponsor, ResponseSponsorDTO.class);
    }

    public Sponsor toSponsorFromResponse(ResponseSponsorDTO responseSponsorDTO) {
        return modelMapper.map(responseSponsorDTO, Sponsor.class);
    }

    public Sponsor toSponsorFromRequest(RequestSponsorDTO requestSponsorDTO) {
        return modelMapper.map(requestSponsorDTO, Sponsor.class);
    }

    public RequestSponsorDTO toRequestSponsorDTO(Sponsor sponsor) {
        return modelMapper.map(sponsor, RequestSponsorDTO.class);
    }


}
