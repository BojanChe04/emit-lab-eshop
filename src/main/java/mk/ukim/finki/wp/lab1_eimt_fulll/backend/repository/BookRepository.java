package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.BookState;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.Category;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookDetailsProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByCategory(Category category, Pageable pageable);
    Page<Book> findByBookState(BookState bookState, Pageable pageable);
    Page<Book> findByAuthor_NameContaining(String author, Pageable pageable);
    Page<Book> findByAvailableCopiesGreaterThan(int primerociBr, Pageable pageable);

    List<BookShortProjection> findAllBy();
    @Query("""
        SELECT b.id AS id,
               b.title AS title,
               b.category AS category,
               b.bookState AS bookState,
               b.availableCopies AS availableCopies,
               a AS author
        FROM Book b
        JOIN b.author a
    """)
    List<BookDetailsProjection> findAllDetailedBy();

    @EntityGraph(value = "book-author-country-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT b FROM Book b")
    List<Book> findAllWithAuthorAndCountry();

    List<Book> findTop10ByOrderByDatePublishedDesc();
}

