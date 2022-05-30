package br.com.digitalbank.domain;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Conta implements Serializable {

    private static final long serialVersionUID = 5150922383894893540L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @CPF
    private String cpf;

    private String nome;

    private String celular;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_de_debito_id", referencedColumnName = "id")
    private Cartao cartaoDeDebito;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_de_credito_id", referencedColumnName = "id")
    private CartaoCredito cartaoCredito;

    @OneToMany(mappedBy = "conta")
    private List<Atividade> atividades;

    public Conta(Integer id, String cpf, String nome, String celular, String email, Cartao cartaoDeDebito, CartaoCredito cartaoCredito) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.cartaoDeDebito = cartaoDeDebito;
        this.cartaoCredito = cartaoCredito;
    }

    public Conta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao getCartaoDeDebito() {
        return cartaoDeDebito;
    }

    public void setCartaoDeDebito(Cartao cartaoDeDebito) {
        this.cartaoDeDebito = cartaoDeDebito;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
