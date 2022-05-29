package br.com.digitalbank.resources;

import br.com.digitalbank.domain.Atividade;
import br.com.digitalbank.domain.enums.FormaDePagamento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeResource {

    @RequestMapping(method=RequestMethod.GET)
    public List<Atividade> listar() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        List<Atividade> atividades = null;
        try {
            Atividade atividade1 = new Atividade(1, 30, simpleDateFormat.parse("20/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA);
            Atividade atividade2 = new Atividade(2, 30, simpleDateFormat.parse("19/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA);
            Atividade atividade3 = new Atividade(3, 30, simpleDateFormat.parse("17/05/22"), "supermercado", FormaDePagamento.TRANSFERENCIA);
            Atividade fatura1 = new Atividade(4, 10.95, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura2 = new Atividade(5, 23.85, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura8 = new Atividade(6, 10.95, simpleDateFormat.parse("02/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura3 = new Atividade(7, 23.85, simpleDateFormat.parse("03/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura4 = new Atividade(8, 10.95, simpleDateFormat.parse("05/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura5 = new Atividade(9, 23.85, simpleDateFormat.parse("06/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura6 = new Atividade(10, 10.95, simpleDateFormat.parse("08/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);
            Atividade fatura7 = new Atividade(11, 23.85, simpleDateFormat.parse("08/05/22"), "outros", FormaDePagamento.CARTAO_DE_CREDITO);

            atividades = new ArrayList<>();
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

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return atividades;
    }


}
