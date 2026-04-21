package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.domain;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDomainService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book create(String title, String author);
    void delete(Long id);
    void rent(Book book);
}