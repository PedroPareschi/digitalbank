package br.com.digitalbank.repositories;

import br.com.digitalbank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Conta findByEmail(String email);
}
