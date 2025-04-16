package br.edu.ifba.ncamadas.persistencia;

public enum Resultado {
    SUCESSO("Sucesso"),
    ERRO("Erro");
    private String descricao;

    private Resultado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
