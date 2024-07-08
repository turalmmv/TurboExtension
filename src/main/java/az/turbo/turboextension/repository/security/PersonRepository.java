package az.turbo.turboextension.repository.security;


import az.turbo.turboextension.entity.security.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
