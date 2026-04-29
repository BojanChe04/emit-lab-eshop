package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("The password is incorrect.");
    }
}
