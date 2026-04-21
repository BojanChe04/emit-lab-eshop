package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Integer id) {
        super("Author with id " + id + " was not found.");
    }
}
