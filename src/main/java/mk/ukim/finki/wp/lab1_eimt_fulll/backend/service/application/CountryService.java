package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
}
