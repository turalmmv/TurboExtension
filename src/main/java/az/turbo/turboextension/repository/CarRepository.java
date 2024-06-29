package az.turbo.turboextension.repository;

import az.turbo.turboextension.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    List<CarEntity> findAllByCustomerId(Long customerId);
}
