package br.com.digitalbank.services;

import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.repositories.ContaRepository;
import br.com.digitalbank.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ContaRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Conta conta = repo.findByEmail(email);
        if (conta == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(conta.getId(), conta.getEmail(), conta.getSenha(), conta.getPerfis());
    }
}
