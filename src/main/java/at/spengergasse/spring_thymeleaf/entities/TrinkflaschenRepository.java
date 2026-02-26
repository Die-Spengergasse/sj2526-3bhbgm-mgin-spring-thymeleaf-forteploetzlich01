package at.spengergasse.spring_thymeleaf.entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ✅ RICHTIG (passt zu Entity Long id)
@Repository
public interface TrinkflaschenRepository extends JpaRepository<Trinkflaschen, Long> {
}
