package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection;

import jakarta.persistence.Column;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.BookState;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.Category;

public interface BookDetailsProjection {
    Long getId();
    String getTitle();
    Category getCategory();
    BookState getBookState();
    //@Column(name = "available_copies")
    Integer getAvailableCopies();

    AuthorInfo getAuthor();
    interface AuthorInfo{
        String getName();
        String getSurname();
        CountryInfo getCountry();

        interface CountryInfo{
            String getName();
        }
    }
}
