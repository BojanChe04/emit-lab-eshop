package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.User;

public record RegisterUserRequestDto(
        String name,
        String surname,
        String email,
        String username,
        String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password);
    }
}
