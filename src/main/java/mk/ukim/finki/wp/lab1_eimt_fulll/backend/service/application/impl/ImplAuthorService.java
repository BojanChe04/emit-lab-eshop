package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayAuthorDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.AuthorRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplAuthorService implements AuthorService {

    private final AuthorRepository authorRepository;

    public ImplAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<DisplayAuthorDto> findAllAuthors() {
        return DisplayAuthorDto.from(authorRepository.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(DisplayAuthorDto::from);
    }
}

