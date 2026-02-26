package az.umid.customservice.repository;

import az.umid.customservice.entity.CustomsDuty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomsRepository extends JpaRepository<CustomsDuty, Long> {
    Optional<CustomsDuty> findByHsCode(String hsCode);
    boolean existsByHsCode(String hsCode);
}