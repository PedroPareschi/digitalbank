package br.com.digitalbank.domain.enums;

public enum EstadoBoleto {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private final Integer cod;
    private final String descricao;

    EstadoBoleto(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoBoleto toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(EstadoBoleto x: EstadoBoleto.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
