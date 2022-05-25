package br.com.saks.interesseservice.repository;

import br.com.saks.interesseservice.model.Interesse;
import br.com.saks.interesseservice.model.InteresseIdentity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteresseRepository extends JpaRepository<Interesse,InteresseIdentity>{
    
    Optional<Interesse> findByInteresseIdentityIdCliente(Long idCliente);
}
