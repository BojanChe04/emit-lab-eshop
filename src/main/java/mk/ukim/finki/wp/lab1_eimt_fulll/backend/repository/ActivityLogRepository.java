package mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.ActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    Page<ActivityLog> findAllByOrderByEventTimeDesc(Pageable pageable);
}