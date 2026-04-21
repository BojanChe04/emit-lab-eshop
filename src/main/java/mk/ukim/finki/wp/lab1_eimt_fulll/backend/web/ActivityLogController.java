package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.ActivityLog;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @GetMapping
    public ResponseEntity<Page<ActivityLog>> getLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(activityLogService.findAll(page, size));
    }
}
