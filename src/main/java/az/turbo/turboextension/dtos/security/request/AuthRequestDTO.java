package az.turbo.turboextension.dtos.security.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequestDTO {
    private String email;
    private String password;
}