package az.turbo.turboextension.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerRequestDto {
    private String name;
    private String email;
    private String password;
    private ArrayList<Long> ids;
}
