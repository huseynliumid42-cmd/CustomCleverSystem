package az.umid.aiintegrationservice.repository;

import az.umid.aiintegrationservice.entity.AIQueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AIQueryRepository extends JpaRepository<AIQueryLog, Long> {
    List<AIQueryLog> findByUserId(Long userId);
}