package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookInfoView;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookInfoViewRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplBookInfoService implements BookInfoService {
    private final BookInfoViewRepository repository;


    public ImplBookInfoService(BookInfoViewRepository repository) {
        this.repository = repository;
    }

    public List<BookInfoView> getAllBookInfo() {
        return repository.findAll();
    }
}
