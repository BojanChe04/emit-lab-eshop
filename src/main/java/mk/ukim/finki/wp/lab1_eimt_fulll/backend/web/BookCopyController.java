package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookCopyDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookCopyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-copies")
public class BookCopyController {
    private final BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }
    @GetMapping
    public List<DisplayBookCopyDto> listAllCopies() {
        return bookCopyService.listAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookCopy> getCopy(@PathVariable Long id) {
        return bookCopyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/rent")
    public ResponseEntity<String> rentCopy(@PathVariable Long id) {
        boolean rented = bookCopyService.rentCopy(id);
        if (rented) {
            return ResponseEntity.ok("Book copy rented successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book copy is already rented.");
        }
    }
    @PostMapping("/{id}/return")
    public ResponseEntity<String> returnCopy(@PathVariable Long id) {
//        Optional<BookCopy> bookCopy = bookCopyService.findById(id);
//        if(bookCopy.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        BookCopy newBookCopy = new BookCopy();
//        if(!newBookCopy.getRented()){
//            return ResponseEntity.badRequest().body("You can not return the book copy that is not rented.");
//        }

        bookCopyService.returnCopy(id);
        return ResponseEntity.ok("Book copy returned successfully.");
    }
}
