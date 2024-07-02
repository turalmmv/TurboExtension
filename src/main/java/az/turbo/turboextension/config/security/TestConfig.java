package az.turbo.turboextension.config.security;

import az.turbo.turboextension.service.security.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TestConfig {
    private final DatabaseService databaseService;

    @Bean
    public Boolean initializeDatabase() {
        databaseService.initializeDatabase();
        return true;
    }
}
