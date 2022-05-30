package br.com.digitalbank.domain;

import br.com.digitalbank.domain.enums.EstadoBoleto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Boleto implements Serializable {

    private static final long serialVersionUID = -9155513979589956553L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private int estadoBoleto;

    private Date dataVencimento;

    private Date dataPagamento;

    @OneToOne(mappedBy = "boleto")
    private CartaoCredito cartaoCredito;

    public Boleto() {
    }

    public Boleto(Integer id, int estadoBoleto, Date dataVencimento, Date dataPagamento, CartaoCredito cartaoCredito) {
        this.id = id;
        this.estadoBoleto = estadoBoleto;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.cartaoCredito = cartaoCredito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoBoleto getEstadoBoleto() {
        return EstadoBoleto.toEnum(estadoBoleto);
    }

    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto.getCod();
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boleto)) return false;
        Boleto boleto = (Boleto) o;
        return Objects.equals(id, boleto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
