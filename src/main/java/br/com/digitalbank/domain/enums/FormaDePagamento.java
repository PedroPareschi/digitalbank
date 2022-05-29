package br.com.digitalbank.domain.enums;

public enum FormaDePagamento {
    TRANSFERENCIA(1, "TED"),
    CARTAO_DE_DEBITO(2, "Cartão de Crédito"),
    CARTAO_DE_CREDITO(3, "Cartão de Débito");

    private final Integer cod;
    private final String descricao;

    FormaDePagamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaDePagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(FormaDePagamento x: FormaDePagamento.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
