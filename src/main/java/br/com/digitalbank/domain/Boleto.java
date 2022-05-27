package br.com.digitalbank.domain;

import br.com.digitalbank.domain.enums.EstadoBoleto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Boleto implements Serializable {

    private static final long serialVersionUID = -9155513979589956553L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private int estadoBoleto;

    private Date dataVencimento;

    private Date dataPagamento;

    public Boleto() {
    }

    public Boleto(Long id, EstadoBoleto estadoBoleto, Date dataVencimento, Date dataPagamento) {
        this.id = id;
        this.estadoBoleto = estadoBoleto.getCod();
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
