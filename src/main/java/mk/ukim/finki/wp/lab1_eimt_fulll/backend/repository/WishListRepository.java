package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    Optional<WishList> findByUserUsername(String username);
}
