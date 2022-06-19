package br.com.digitalbank.services;

import br.com.digitalbank.domain.Cartao;
import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.repositories.CartaoRepository;
import br.com.digitalbank.repositories.ContaRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository repository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaRepository contaRepository;

    public Cartao insert(Integer id) {
        Conta conta = contaService.find(id);
        String numero = RandomStringUtils.random(16, false, true);
        String cvv = RandomStringUtils.random(3, false, true);
        LocalDate localDate = LocalDate.now().plusYears(5L);
        int mes = localDate.getMonthValue();
        int ano = localDate.getYear();
        Cartao cartao = new Cartao(null, numero, cvv, mes, ano, conta);
        cartao = repository.save(cartao);
        conta.setCartaoDeDebito(cartao);
        contaRepository.save(conta);
        return cartao;
    }
}
