package az.turbo.turboextension.dtos.security.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequestDTO {
    private String email;
    private String password;
    private String passConfirm;
}
