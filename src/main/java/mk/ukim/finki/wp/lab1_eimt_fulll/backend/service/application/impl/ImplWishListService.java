package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.User;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.WishList;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayWishListDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.BookNotFoundException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.UserNotFoundException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.UserRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.WishListRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.WishListService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplWishListService implements WishListService {

    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ImplWishListService(WishListRepository wishListRepository,
                               UserRepository userRepository,
                               BookRepository bookRepository) {
        this.wishListRepository = wishListRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<DisplayWishListDto> getWishList(String username) {
        WishList wishList = getOrCreateWishList(username);
        return Optional.of(DisplayWishListDto.from(wishList));
    }

    @Override
    public Optional<DisplayWishListDto> addBook(String username, Long bookId) {
        WishList wishList = getOrCreateWishList(username);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        if (!wishList.getBooks().contains(book)) {
            wishList.getBooks().add(book);
            wishListRepository.save(wishList);
        }
        return Optional.of(DisplayWishListDto.from(wishList));
    }

    @Override
    public Optional<DisplayWishListDto> removeBook(String username, Long bookId) {
        WishList wishList = getOrCreateWishList(username);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        wishList.getBooks().remove(book);
        wishListRepository.save(wishList);
        return Optional.of(DisplayWishListDto.from(wishList));
    }

    private WishList getOrCreateWishList(String username) {
        return wishListRepository.findByUserUsername(username)
                .orElseGet(() -> {
                    User user = userRepository.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(username));
                    return wishListRepository.save(new WishList(user));
                });
    }
}