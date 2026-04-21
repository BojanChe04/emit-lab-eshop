package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;


import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}