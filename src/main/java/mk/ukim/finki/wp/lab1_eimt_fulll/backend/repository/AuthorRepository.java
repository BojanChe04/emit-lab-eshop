package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
