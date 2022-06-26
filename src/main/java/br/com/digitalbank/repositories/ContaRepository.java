package br.com.digitalbank.repositories;

import br.com.digitalbank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query("SELECT u FROM Conta u WHERE u.email = ?1")
    Conta findByEmail(String email);
    @Query("SELECT u FROM Conta u WHERE u.email = ?1 OR u.cpf = ?2 OR u.celular = ?3")
    Optional<Conta> findByEmailOrCpfOrCelular(String email, String cpf, String celular);
}
