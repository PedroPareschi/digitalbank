package br.com.digitalbank.dtos;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class ContaDTO implements Serializable {
    private static final long serialVersionUID = -1346596879632436768L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 26, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Pattern(regexp = "[\\d]{10,11}", message = "Celular inválido")
    private String celular;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;

    public ContaDTO() {
    }

    public ContaDTO(String cpf, String nome, String email, String celular, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
