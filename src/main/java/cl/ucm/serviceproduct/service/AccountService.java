package cl.ucm.serviceproduct.service;

import cl.ucm.serviceproduct.dto.in.RegisterDto;

import java.util.Optional;

public interface AccountService {
    Optional<RegisterDto> createUser(RegisterDto dto);
}
