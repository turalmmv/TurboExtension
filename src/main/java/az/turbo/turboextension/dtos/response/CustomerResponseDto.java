package az.turbo.turboextension.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Long> carId;
}
