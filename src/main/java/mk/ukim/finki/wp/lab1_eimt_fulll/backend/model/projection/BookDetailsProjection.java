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
    //ova e vgenzden (nested) projection
    //sakame del od author ama ne celiot
    interface AuthorInfo{
        String getName();
        String getSurname();
        CountryInfo getCountry();

        interface CountryInfo{
            String getName();
        }
    }
}
//projection raboti na nivo na query
//primer kako izgleda rezultatoto od ova
/*
{
  "id": 1,
  "title": "Book 1",
  "category": "NOVEL",
  "bookState": "GOOD",
  "availableCopies": 5,
  "author": {
    "name": "John",
    "surname": "Doe",
    "country": {
      "name": "USA"
    }
  }
}
 */
