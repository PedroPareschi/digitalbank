package br.com.digitalbank.dtos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TransferenciaDTO implements Serializable {

    private static final long serialVersionUID = -452848685343479082L;

    @NotNull
    private Double valor;

    private String cpf;

    private String email;

    private String celular;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(Double valor, String cpf, String email, String celular) {
        this.valor = valor;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
