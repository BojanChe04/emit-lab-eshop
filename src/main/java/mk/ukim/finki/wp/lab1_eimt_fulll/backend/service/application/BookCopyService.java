package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookCopyDto;

import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    List<DisplayBookCopyDto> listAll();
    Optional<BookCopy> findById(Long id);
//    BookCopy create(BookCopy bookcopy);
//    BookCopy update(BookCopy bookcopy);
//    void delete(Long id);
    boolean rentCopy(Long copyId);
    void returnCopy(Long copyId);
}
