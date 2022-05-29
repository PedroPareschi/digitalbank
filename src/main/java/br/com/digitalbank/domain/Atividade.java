package br.com.digitalbank.domain;

import br.com.digitalbank.domain.enums.FormaDePagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Atividade implements Serializable {

    private static final long serialVersionUID = -5281374730077202620L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private double valor;

    private Date data;

    private String categoria;

    private int formaDePagamento;

    public Atividade() {
    }

    public Atividade(Integer id, double valor, Date data, String categoria, FormaDePagamento formaDePagamento) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.formaDePagamento = formaDePagamento.getCod();
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
