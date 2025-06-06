package cl.ucm.serviceproduct.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String username;
    private String password;
}
