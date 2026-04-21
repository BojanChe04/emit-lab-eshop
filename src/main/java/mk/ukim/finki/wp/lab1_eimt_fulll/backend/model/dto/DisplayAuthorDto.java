package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Country;

import java.util.List;

public record DisplayAuthorDto(
        Long id,
        String name,
        String surname,
        String countryName,
        String continent
) {

    public static DisplayAuthorDto from(Author author) {
        Country country = author.getCountry();
        return new DisplayAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                country != null ? country.getName() : null,
                country != null ? country.getContinent() : null
        );
    }

    public static List<DisplayAuthorDto> from(List<Author> authors) {
        return authors.stream()
                .map(DisplayAuthorDto::from)
                .toList();
    }
}
