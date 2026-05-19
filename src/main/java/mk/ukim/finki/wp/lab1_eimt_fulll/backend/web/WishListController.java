package mk.ukim.finki.wp.lab1_eimt_fulll.backend.web;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.User;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayWishListDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping
    public ResponseEntity<DisplayWishListDto> getWishList(@AuthenticationPrincipal User user) {
        return wishListService.getWishList(user.getUsername())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add/{bookId}")
    public ResponseEntity<DisplayWishListDto> addBook(@AuthenticationPrincipal User user,
                                                      @PathVariable Long bookId) {
        return wishListService.addBook(user.getUsername(), bookId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove/{bookId}")
    public ResponseEntity<DisplayWishListDto> removeBook(@AuthenticationPrincipal User user,
                                                         @PathVariable Long bookId) {
        return wishListService.removeBook(user.getUsername(), bookId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}