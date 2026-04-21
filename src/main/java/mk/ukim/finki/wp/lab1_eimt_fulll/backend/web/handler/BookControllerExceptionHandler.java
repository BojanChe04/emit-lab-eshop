package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web.handler;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.BookNotFoundException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.NoAvailableCopiesException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.web.BookController;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiError> handleBookNotFound(BookNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(NoAvailableCopiesException.class)
    public ResponseEntity<ApiError> handleNoAvailableCopies(NoAvailableCopiesException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

}
