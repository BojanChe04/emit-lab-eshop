package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("User with username '%s' already exists.".formatted(username));
    }
}
