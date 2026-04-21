package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookInfoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInfoViewRepository extends JpaRepository<BookInfoView, Long> {
}
