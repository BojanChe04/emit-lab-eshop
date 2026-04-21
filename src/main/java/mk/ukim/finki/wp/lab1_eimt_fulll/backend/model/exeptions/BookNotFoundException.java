package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book with id " + id + " was not found.");
    }
}