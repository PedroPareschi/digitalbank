package br.com.digitalbank.services;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.Cartao;
import br.com.digitalbank.domain.CartaoCredito;
import br.com.digitalbank.domain.Conta;
import br.com.digitalbank.domain.enums.FormaDePagamento;
import br.com.digitalbank.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBServices {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public void instantiateTestDatabase(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        try {
            Conta conta1 = new Conta();
            conta1.setNome("Enzo Iago da Cruz");
            conta1.setCpf("38565157717");
            conta1.setCelular("65989851967");
            conta1.setEmail("enzo_dacruz@cincoentretenimentos.com.br");

            Cartao debitoConta1 = new Cartao(null, "5384281090319170", "289", 3, 2024, conta1);

            conta1.setCartaoDeDebito(debitoConta1);

            CartaoCredito creditoConta1 = new CartaoCredito();
            creditoConta1.setCvv("556");
            creditoConta1.setNumero("5426145021735160");
            creditoConta1.setFatura(0);
            creditoConta1.setLimite(100);
            creditoConta1.setMesVencimento(10);
            creditoConta1.setAnoVencimento(2022);
            creditoConta1.setConta(conta1);

            conta1.setCartaoCredito(creditoConta1);

            Atividade atividade1 = new Atividade(1, 30, simpleDateFormat.parse("20/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA, conta1);
            Atividade atividade2 = new Atividade(2, 30, simpleDateFormat.parse("19/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA, conta1);
            Atividade atividade3 = new Atividade(3, 30, simpleDateFormat.parse("17/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA, conta1);
            Atividade fatura1 = new Atividade(4, 10.95, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura2 = new Atividade(5, 23.85, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura8 = new Atividade(6, 10.95, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura3 = new Atividade(7, 23.85, simpleDateFormat.parse("03/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura4 = new Atividade(8, 10.95, simpleDateFormat.parse("05/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura5 = new Atividade(9, 23.85, simpleDateFormat.parse("06/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura6 = new Atividade(10, 10.95, simpleDateFormat.parse("08/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);
            Atividade fatura7 = new Atividade(11, 23.85, simpleDateFormat.parse("08/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO, conta1);

            List<Atividade> atividades = new ArrayList<>();
            atividades.add(atividade1);
            atividades.add(atividade2);
            atividades.add(atividade3);
            atividades.add(fatura1);
            atividades.add(fatura2);
            atividades.add(fatura3);
            atividades.add(fatura4);
            atividades.add(fatura5);
            atividades.add(fatura6);
            atividades.add(fatura7);

            conta1.setAtividades(atividades);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
