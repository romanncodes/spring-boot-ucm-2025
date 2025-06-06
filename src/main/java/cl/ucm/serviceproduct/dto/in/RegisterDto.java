package cl.ucm.serviceproduct.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String email;
    private String name;
    private String lastName;
    private String password;
    private int rolId;
}
