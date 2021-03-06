package br.com.digitalbank.domain;

import br.com.digitalbank.domain.enums.FormaDePagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Atividade implements Serializable {

    private static final long serialVersionUID = -5281374730077202620L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double valor;

    private Date data;

    private String categoria;

    private int formaDePagamento;

    private String nomeContaDestino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;


    public Atividade() {
    }

    public Atividade(Integer id, double valor, Date data, String categoria, FormaDePagamento formaDePagamento, String nomeContaDestino, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.nomeContaDestino = nomeContaDestino;
        this.formaDePagamento = formaDePagamento.getCod();
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public FormaDePagamento getFormaDePagamento() {
        return FormaDePagamento.toEnum(formaDePagamento);
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento.getCod();
    }

    public void setFormaDePagamento(int formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getNomeContaDestino() {
        return nomeContaDestino;
    }

    public void setNomeContaDestino(String nomeContaDestino) {
        this.nomeContaDestino = nomeContaDestino;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividade)) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(id, atividade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
