package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<DisplayAuthorDto> findAllAuthors();
    Optional<DisplayAuthorDto> findAuthorById(Long id);

}
