package az.turbo.turboextension.service.security;

import az.turbo.turboextension.constant.Role;
import az.turbo.turboextension.entity.security.PersonEntity;
import az.turbo.turboextension.exception.DuplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

//    @Bean
    public Boolean initializeDatabase() {
        try {
            // Your existing initialization code
            // For example:
            personService.create(new PersonEntity("Emma", "emma@example.com","111"));
            // Add more initialization data as needed
        } catch (DuplicationException e) {
            System.out.println("Initialization failed due to email duplication: " + e.getMessage());
            // Handle the exception or rethrow if necessary
            // You can log the error or take some corrective action
        }
        return true;
    }

//    public void initializeDatabase() {
//
//        System.out.println("Initializing database...");
//
//        final PersonEntity user1 = new PersonEntity("Emma", "emma@mail.com", passwordEncoder.encode("111"));
//        final PersonEntity user2 = new PersonEntity("Jhon", "jhon@mail.com", passwordEncoder.encode("222"));
//        final PersonEntity admin = new PersonEntity("Anna", "anna@mail.com", passwordEncoder.encode("333"));
//
//        admin.addRole(Role.ADMIN);
//
//        System.out.println(personService.create(user1));
//        System.out.println(personService.create(user2));
//        System.out.println(personService.create(admin));
//
//        System.out.println("Database initialized!");
//    }
}