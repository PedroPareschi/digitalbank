package br.com.digitalbank.services;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Transactional
    public Conta insert(Conta conta) {
        conta.setId(null);
        return repository.save(conta);
    }

    public Conta find(Integer id) {
        Optional<Conta> conta = repository.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }
}
