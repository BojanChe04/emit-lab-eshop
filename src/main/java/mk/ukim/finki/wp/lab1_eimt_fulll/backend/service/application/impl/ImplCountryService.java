package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Country;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.CountryCreateDto;
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

    @Override
    public Optional<DisplayCountryDto> save(CountryCreateDto countryCreateDto) {
        Country country = countryCreateDto.toCountry();
        return Optional.of(DisplayCountryDto.from(countryRepository.save(country)));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id,CountryCreateDto countryCreateDto) {
        Country country = countryRepository.findById(id).orElse(null);
        country.setName(countryCreateDto.name());
        country.setContinent(countryCreateDto.continent());
        return Optional.of(DisplayCountryDto.from(countryRepository.save(country)));
    }

    @Override
    public void deltete(Long id) {
        countryRepository.deleteById(id);
    }
}