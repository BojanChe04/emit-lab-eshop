package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.ActivityLog;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.EventType;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.ActivityLogRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplActivityLogService implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Override
    public void log(String bookTitle, EventType eventType) {
        ActivityLog log = new ActivityLog(bookTitle, eventType);
        activityLogRepository.save(log);
    }

    @Override
    public Page<ActivityLog> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("eventTime").descending());
        return activityLogRepository.findAllByOrderByEventTimeDesc(pageable);
    }
}