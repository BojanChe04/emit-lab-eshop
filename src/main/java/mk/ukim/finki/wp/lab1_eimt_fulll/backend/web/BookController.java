package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.BookCreateDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookDetailsProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookShortProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookCategoryStatsView;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.views.BookInfoView;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookCategoryStatsService;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookInfoService;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookInfoService bookInfoService;
    private final BookCategoryStatsService bookCategoryStatsService;

    public BookController(BookService bookService, BookInfoService bookInfoService, BookCategoryStatsService bookCategoryStatsService) {
        this.bookService = bookService;

        this.bookInfoService = bookInfoService;
        this.bookCategoryStatsService = bookCategoryStatsService;
    }
    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayBookDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(
                bookService.findAll(page, size, sortBy)
        );
    }
    @GetMapping("/short")
    public List<BookShortProjection> getAllShort() {
        return bookService.findAllShort();
    }

    @GetMapping("/details")
    public List<BookDetailsProjection> getAllDetails() {
        return bookService.findAllDetails();
    }
    @GetMapping("/book-author-country-graph")
    public List<Book> getAllBooks() {
        return bookService.getAllBooksWithAuthorAndCountry();
    }
    @GetMapping("/book-info-view")
    public List<BookInfoView> getBookInfo() {
        return bookInfoService.getAllBookInfo();
    }
    @GetMapping("/books-stats")
    public List<BookCategoryStatsView> getBookStats() {
        return bookCategoryStatsService.getAllStats();
    }

    @GetMapping("/top10Newest")
    public List<DisplayBookDto> getTop10NewestBooks() {
        return bookService.findTop10Newest();
    }


    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> save(@RequestBody BookCreateDto bookCreateDto) {
        return bookService
                .save(bookCreateDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody BookCreateDto bookCreateDto
    ) {
        return bookService
                .update(id, bookCreateDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> rent(@PathVariable Long id) {
        Book book = bookService.rent(id);
        return ResponseEntity.ok(DisplayBookDto.from(book));
    }

}
