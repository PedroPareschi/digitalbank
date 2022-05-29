package br.com.digitalbank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Crédito")
public class CartaoCredito extends Cartao{

    private double limite;

    private double fatura;


    public CartaoCredito() {
    }

    public CartaoCredito(Integer id, String numero, String csv, int mesVencimento, int anoVencimento, double limite, double fatura) {
        super(id, numero, csv, mesVencimento, anoVencimento);
        this.limite = limite;
        this.fatura = fatura;
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


}
