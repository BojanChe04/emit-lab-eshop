package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with username '%s' does not exist.".formatted(username));
    }
}
