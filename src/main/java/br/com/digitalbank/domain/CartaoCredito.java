package br.com.digitalbank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Crédito")
public class CartaoCredito extends Cartao{

    private double limite;

    private double fatura;

    @OneToOne
    @JoinColumn(name = "boleto_id")
    private Boleto boleto;


    public CartaoCredito() {
    }

    public CartaoCredito(Integer id, String numero, String csv, int mesVencimento, int anoVencimento, Conta conta, double limite, double fatura, Boleto boleto) {
        super(id, numero, csv, mesVencimento, anoVencimento, conta);
        this.limite = limite;
        this.fatura = fatura;
        this.boleto = boleto;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getFatura() {
        return fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}
