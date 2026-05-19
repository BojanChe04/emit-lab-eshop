package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayWishListDto;

import java.util.Optional;

public interface WishListService {
    Optional<DisplayWishListDto> getWishList(String username);
    Optional<DisplayWishListDto> addBook(String username, Long bookId);
    Optional<DisplayWishListDto> removeBook(String username, Long bookId);
}