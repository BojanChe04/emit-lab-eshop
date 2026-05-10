package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.AuthorCreateDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<DisplayAuthorDto> findAllAuthors();
    Optional<DisplayAuthorDto> findAuthorById(Long id);
    Optional<DisplayAuthorDto> save(AuthorCreateDto authorCreateDto);
    Optional<DisplayAuthorDto> update(Long id,AuthorCreateDto authorCreateDto);
    void delete(Long id);
}
