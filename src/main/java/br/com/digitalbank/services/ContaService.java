package br.com.digitalbank.services;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.domain.enums.FormaDePagamento;
import br.com.digitalbank.dtos.ContaDTO;
import br.com.digitalbank.dtos.TransferenciaDTO;
import br.com.digitalbank.repositories.AtividadeRepository;
import br.com.digitalbank.repositories.ContaRepository;
import br.com.digitalbank.services.exceptions.ObjectNotFoundException;
import br.com.digitalbank.services.exceptions.SaldoInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Conta insert(Conta conta) {
        conta.setId(null);
        return repository.save(conta);
    }

    public Conta find(Integer id) {
        Optional<Conta> conta = repository.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }

    public Conta fromDTO(ContaDTO contaDTO) {
        return new Conta(null, contaDTO.getCpf(), contaDTO.getNome(), contaDTO.getCelular(),
                contaDTO.getEmail(), passwordEncoder.encode(contaDTO.getSenha()), 0.0, null, null);
    }

    public void transferir(Conta contaOrigem, TransferenciaDTO transferenciaDTO) {
        double valor = transferenciaDTO.getValor();
        double valorOrigemComTransferencia = contaOrigem.getSaldo() - valor;
        if (valorOrigemComTransferencia >= 0.0) {
            contaOrigem.setSaldo(valorOrigemComTransferencia);
            Atividade atividadeOrigem = new Atividade(null, valor, new Date(),
                    "Transferência para conta corrente", FormaDePagamento.TRANSFERENCIA,
                    "Conta corrente", contaOrigem);
            atividadeRepository.save(atividadeOrigem);
            contaOrigem.getAtividades().add(atividadeOrigem);
            repository.save(contaOrigem);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente! Saldo atual: " + contaOrigem.getSaldo());
        }
    }
}
