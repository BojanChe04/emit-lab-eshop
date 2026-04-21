package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.events.BookRentedEvent;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookCopyDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookCopyRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookCopyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;
import java.util.Optional;

@Service
public class ImplBookCopyService implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ImplBookCopyService(BookCopyRepository bookCopyRepository, BookRepository bookRepository, ApplicationEventPublisher eventPublisher) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public List<DisplayBookCopyDto> listAll() {
        return DisplayBookCopyDto.from(bookCopyRepository.findAll());
    }

    @Override
    public Optional<BookCopy> findById(Long id) {
        return bookCopyRepository.findById(id);
    }

//    @Override
//    public BookCopy create(BookCopy bookcopy) {
//        return bookCopyRepository.save(bookcopy);
//    }
//
//    @Override
//    public BookCopy update(BookCopy bookcopy) {
//        if (bookCopyRepository.existsById(bookcopy.getId())) {
//            return bookCopyRepository.save(bookcopy);
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        bookCopyRepository.deleteById(id);
//    }
    @Transactional
    public boolean rentCopy(Long copyId) {
        BookCopy copy = bookCopyRepository.findById(copyId)
                .orElseThrow(() -> new RuntimeException("Book copy not found"));
        if (copy.getRented()) {
            return false;
        }
        copy.setRented(true);
        bookCopyRepository.save(copy);

        Book book = copy.getBook();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        eventPublisher.publishEvent(new BookRentedEvent(book));
        return true;
    }

    @Transactional
    public void returnCopy(Long copyId) {
        BookCopy copy = bookCopyRepository.findById(copyId)
                .orElseThrow(() -> new RuntimeException("Book copy not found"));

        if (!copy.getRented()) {
            return;
        }
        copy.setRented(false);
        bookCopyRepository.save(copy);

        Book book = copy.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
    }
}
