package mk.ukim.finki.wp.lab1_eimt_fulll.backend.events;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;

public record BookRentedEvent(Book book) {
}
