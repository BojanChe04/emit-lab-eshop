package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;


import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.User;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.Role;

public record RegisterUserResponseDto(
        String username,
        String name,
        String surname,
        String email,
        Role role
) {
    public static RegisterUserResponseDto from(User user) {
        return new RegisterUserResponseDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }
}

