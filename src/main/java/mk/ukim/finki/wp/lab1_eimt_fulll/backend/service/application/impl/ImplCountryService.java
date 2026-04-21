package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayCountryDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.CountryRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCountryService implements CountryService {

    private final CountryRepository countryRepository;

    public ImplCountryService(CountryRepository countryRepository, CountryRepository countryRepository1) {

        this.countryRepository = countryRepository1;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryRepository.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryRepository.findById(id).map(DisplayCountryDto::from);
    }
}