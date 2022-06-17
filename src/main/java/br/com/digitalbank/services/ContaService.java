package br.com.digitalbank.services;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.domain.enums.Perfil;
import br.com.digitalbank.dtos.ContaDTO;
import br.com.digitalbank.repositories.ContaRepository;
import br.com.digitalbank.security.UserSS;
import br.com.digitalbank.services.exceptions.AuthorizationException;
import br.com.digitalbank.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Conta insert(Conta conta) {
        conta.setId(null);
        return repository.save(conta);
    }

    public Conta find(Integer id) {
        UserSS user = UserService.authenticated();
        if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }
        Optional<Conta> conta = repository.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }

    public Conta fromDTO(ContaDTO contaDTO){
        return new Conta(null, contaDTO.getCpf(), contaDTO.getNome(), contaDTO.getCelular(), contaDTO.getEmail(), passwordEncoder.encode(contaDTO.getSenha()), null, null);
    }
}
