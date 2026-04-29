package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.LoginUserRequestDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.LoginUserResponseDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
