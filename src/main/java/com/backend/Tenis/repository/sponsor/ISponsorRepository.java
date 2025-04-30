package com.backend.Tenis.repository.sponsor;

import com.backend.Tenis.entity.Sponsor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISponsorRepository extends CrudRepository<Sponsor, Long> {
}
