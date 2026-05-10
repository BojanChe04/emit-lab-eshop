package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Country;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.AuthorCreateDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayAuthorDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.AuthorRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.CountryRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplAuthorService implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public ImplAuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<DisplayAuthorDto> findAllAuthors() {
        return DisplayAuthorDto.from(authorRepository.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> save(AuthorCreateDto authorCreateDto) {
        Country country = countryRepository.findById(authorCreateDto.countryId()).orElse(null);
        Author author = authorCreateDto.toAuthor(country);
        return Optional.of(DisplayAuthorDto.from(authorRepository.save(author)));
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id,AuthorCreateDto authorCreateDto) {
        Author author = authorRepository.findById(id).orElse(null);
        Country country = countryRepository.findById(authorCreateDto.countryId()).orElse(null);
        author.setName(authorCreateDto.name());
        author.setSurname(authorCreateDto.surname());
        author.setCountry(country);
        return Optional.of(DisplayAuthorDto.from(authorRepository.save(author)));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}

