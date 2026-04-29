package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.domain;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findByUsername(String username);

    User register(User user);

    User login(String username, String password);
}

