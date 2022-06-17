package br.com.digitalbank.repositories;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
    @Transactional(readOnly = true)
    Page<Atividade> findAtividadesByConta(Conta conta, Pageable pageable);
}
