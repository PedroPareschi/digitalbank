package br.com.digitalbank.services;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.domain.enums.Perfil;
import br.com.digitalbank.repositories.AtividadeRepository;
import br.com.digitalbank.repositories.ContaRepository;
import br.com.digitalbank.security.UserSS;
import br.com.digitalbank.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private ContaRepository contaRepository;


    public Page<Atividade> search(Integer conta_id, Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user==null || !user.hasRole(Perfil.ADMIN) && !conta_id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Conta conta = contaRepository.getById(conta_id);
        return repository.findAtividadesByConta(conta, pageRequest);

    }
}
