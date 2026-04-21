package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.domain;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyDomainService {
    List<BookCopy> listAll();
    Optional<BookCopy> findById(Long id);
    BookCopy create(BookCopy bookCopy);
    BookCopy update(BookCopy bookCopy);
    void delete(Long id);


    void rentCopy(BookCopy bookCopy);
    void returnCopy(BookCopy bookCopy);
}
