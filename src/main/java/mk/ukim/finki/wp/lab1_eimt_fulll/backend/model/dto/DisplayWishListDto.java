package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.WishList;

import java.util.List;

public record DisplayWishListDto(
        Long id,
        List<DisplayBookDto> books
) {
    public static DisplayWishListDto from(WishList wishList) {
        return new DisplayWishListDto(
                wishList.getId(),
                DisplayBookDto.from(wishList.getBooks())
        );
    }
}