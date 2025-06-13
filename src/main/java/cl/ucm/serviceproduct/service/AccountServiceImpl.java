package cl.ucm.serviceproduct.service;

import cl.ucm.serviceproduct.dto.in.RegisterDto;
import cl.ucm.serviceproduct.entities.Rol;
import cl.ucm.serviceproduct.entities.UserEntity;
import cl.ucm.serviceproduct.entities.UserRol;
import cl.ucm.serviceproduct.repository.RolRepository;
import cl.ucm.serviceproduct.repository.UserRepository;
import cl.ucm.serviceproduct.repository.UserRolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolRepository userRolRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Optional<RegisterDto> createUser(RegisterDto dto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(dto.getEmail());
        Optional<Rol> optionalRol = rolRepository.findById(dto.getRolId());
        if(optionalUserEntity.isPresent()){
            return Optional.empty();
        }
        if(optionalRol.isEmpty()){
            return Optional.empty();
        }

        UserEntity user = new UserEntity();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        UserRol userRol = new UserRol();
        userRol.setRolFK(dto.getRolId());
        userRol.setUserFK(dto.getEmail());
        userRolRepository.save(userRol);

        dto.setPassword(user.getPassword());
        return Optional.of(dto);
    }
}
