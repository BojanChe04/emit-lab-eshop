package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookCategoryStatsView;

import java.util.List;

public interface BookCategoryStatsService {
    List<BookCategoryStatsView> getAllStats();
}
