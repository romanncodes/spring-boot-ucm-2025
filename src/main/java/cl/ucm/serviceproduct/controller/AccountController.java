package cl.ucm.serviceproduct.controller;

import cl.ucm.serviceproduct.dto.in.LoginDto;
import cl.ucm.serviceproduct.dto.in.RegisterDto;
import cl.ucm.serviceproduct.security.JwtUtil;
import cl.ucm.serviceproduct.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "auth")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "create")
    public ResponseEntity<?> createUser(@RequestBody RegisterDto dto){
        Optional<RegisterDto> optional = service.createUser(dto);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = authenticationManager.authenticate(login);
        log.info("Auth principal: {}", authentication.getPrincipal());
        log.info("Authorities: {}", authentication.getAuthorities().stream().toList().toString());
        String jwt = jwtUtil.create(dto.getUsername(),authentication.getAuthorities().stream().toList().toString() );
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return ResponseEntity.ok(map);

    }


}
