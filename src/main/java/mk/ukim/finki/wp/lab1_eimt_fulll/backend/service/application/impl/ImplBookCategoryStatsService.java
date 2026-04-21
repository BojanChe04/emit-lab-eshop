package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookCategoryStatsView;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookCategoryStatsViewRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookCategoryStatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplBookCategoryStatsService implements BookCategoryStatsService {

    private final BookCategoryStatsViewRepository repository;

    public ImplBookCategoryStatsService(BookCategoryStatsViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookCategoryStatsView> getAllStats() {
        return repository.findAll();
    }
}
