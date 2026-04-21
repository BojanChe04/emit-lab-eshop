package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookInfoView;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookInfoService {
    List<BookInfoView> getAllBookInfo();
}
