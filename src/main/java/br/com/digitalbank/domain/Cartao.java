package br.com.digitalbank.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Débito")
public class Cartao implements Serializable {

    private static final long serialVersionUID = 1675952686388448334L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String numero;

    private String csv;

    private int mesVencimento;

    private int anoVencimento;

    @OneToOne(mappedBy = "cartaoCredito")
    private Conta conta;

    public Cartao() {
    }

    public Cartao(Integer id, String numero, String csv, int mesVencimento, int anoVencimento, Conta conta) {
        this.id = id;
        this.numero = numero;
        this.csv = csv;
        this.mesVencimento = mesVencimento;
        this.anoVencimento = anoVencimento;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }

    public int getMesVencimento() {
        return mesVencimento;
    }

    public void setMesVencimento(int mesVencimento) {
        this.mesVencimento = mesVencimento;
    }

    public int getAnoVencimento() {
        return anoVencimento;
    }

    public void setAnoVencimento(int anoVencimento) {
        this.anoVencimento = anoVencimento;
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
        if (!(o instanceof Cartao)) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(id, cartao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
