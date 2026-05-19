package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WishList extends BaseAuditableEntity {

    @OneToOne
    private User user;

    @ManyToMany
    private List<Book> books = new ArrayList<>();

    public WishList(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}