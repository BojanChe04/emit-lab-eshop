package mk.ukim.finki.wp.lab1_eimt_fulll.backend.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.events.BookRentedEvent;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.EventType;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.ActivityLogService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookRentedEventListener {

    private final ActivityLogService activityLogService;

    @EventListener
    public void handle(BookRentedEvent event) {
        Book book = event.book();

        log.info("Book rented: {}", book.getTitle());

        if (book.getAvailableCopies() == 0) {
            log.warn("Book '{}' is OUT OF STOCK!", book.getTitle());
        }
        activityLogService.log(book.getTitle(), EventType.BOOK_RENTED);
    }
}
