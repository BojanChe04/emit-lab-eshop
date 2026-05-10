package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Country;

public record AuthorCreateDto(

        @NotNull
        String name,

        @NotNull
        String surname,

        Long countryId

) {
    public Author toAuthor(Country country) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return author;
    }
}
