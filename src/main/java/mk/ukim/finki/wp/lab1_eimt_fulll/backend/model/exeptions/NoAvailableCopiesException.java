package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions;

public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException(String message) {
        super(message);
    }
}