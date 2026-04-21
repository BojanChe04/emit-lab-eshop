package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.ActivityLog;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.EventType;
import org.springframework.data.domain.Page;

public interface ActivityLogService {
    void log(String bookTitle, EventType eventType);
    Page<ActivityLog> findAll(int page, int size);
}