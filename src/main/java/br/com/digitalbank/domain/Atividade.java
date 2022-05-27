package br.com.digitalbank.domain;

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
    private Long id;

    private double valor;

    private Date data;

    private String categoria;

    private boolean ehFatura;

    public Atividade() {
    }

    public Atividade(Long id, double valor, Date data, String categoria, boolean ehFatura) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.ehFatura = ehFatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isEhFatura() {
        return ehFatura;
    }

    public void setEhFatura(boolean ehFatura) {
        this.ehFatura = ehFatura;
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
