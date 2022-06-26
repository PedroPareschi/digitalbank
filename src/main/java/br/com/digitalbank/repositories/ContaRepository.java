package br.com.digitalbank.repositories;

import br.com.digitalbank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query("SELECT u FROM Conta u WHERE u.email = ?1")
    Conta findByEmail(String email);
}
