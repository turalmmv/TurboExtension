package az.turbo.turboextension.service.security;

import az.turbo.turboextension.constant.Role;
import az.turbo.turboextension.dtos.security.response.PersonResponseDto;
import az.turbo.turboextension.entity.security.PersonEntity;
import az.turbo.turboextension.exception.DuplicationException;
import az.turbo.turboextension.exception.NotFoundException;
import az.turbo.turboextension.repository.security.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public PersonEntity findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found: " + id));
    }

    public PersonEntity findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("Person not found: " + email));
    }

    public List<PersonEntity> findAll() {
        return repository.findAll();
    }

    public PersonEntity create(PersonEntity person) {
        person.setId(null);
        person.addRole(Role.USER);
        checkEmailDuplication(person);
        return repository.save(person);
    }

    public PersonResponseDto create(PersonResponseDto dto) {
        return new PersonResponseDto(create(new PersonEntity(dto)));
    }

    public PersonEntity update(PersonEntity person) {
        checkEmailDuplication(person);
        PersonEntity p = findById(person.getId());
        p.setEmail(person.getEmail());
        p.setRoles(person.getRoles());
        return repository.save(p);
    }

    public void delete(Long id) {
        final PersonEntity p = findById(id);
        repository.delete(p);
    }

    private void checkEmailDuplication(PersonEntity person) {
        final String email = person.getEmail();
        if (email != null && email.length() > 0) {
            final Long id = person.getId();
            final PersonEntity p = repository.findByEmail(email).orElse(null);
            if (p != null && Objects.equals(p.getEmail(), email) && !Objects.equals(p.getId(), id)) {
                throw new DuplicationException("Email duplication: " + email);
            }
        }
    }
}
