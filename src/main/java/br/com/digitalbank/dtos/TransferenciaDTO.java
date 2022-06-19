package br.com.digitalbank.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TransferenciaDTO implements Serializable {

    private static final long serialVersionUID = -452848685343479082L;

    @NotNull
    private Double valor;

    @NotNull
    private Integer contaDestinoId;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(Integer tipoTransferencia, Double valor, Integer contaDestinoId) {
        this.valor = valor;
        this.contaDestinoId = contaDestinoId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getContaDestinoId() {
        return contaDestinoId;
    }

    public void setContaDestinoId(Integer contaDestinoId) {
        this.contaDestinoId = contaDestinoId;
    }
}
