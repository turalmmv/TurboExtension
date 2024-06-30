package az.turbo.turboextension.dtos.security.response;


import az.turbo.turboextension.constant.Role;
import az.turbo.turboextension.entity.security.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class PersonResponseDto {
    private Long id;
    private String email;
    private String password;
    private String passConfirm;
    private Set<String> roles = new HashSet<>();

    public PersonResponseDto() {
        super();
    }

    public PersonResponseDto(Long id, String email, String password, String passConfirm, Set<String> roles) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.passConfirm = passConfirm;
        this.roles = roles;
    }

    public PersonResponseDto(PersonEntity person) {
        super();
        this.id = person.getId();
        this.email = person.getEmail();
        this.setRoles(person.getRoles());
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles.stream().map(r -> r.getDescription()).collect(Collectors.toSet());
    }
}