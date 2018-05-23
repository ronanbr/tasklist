package br.com.tasklist.enums;

public enum TiposDeTarefa {

    DESENVOLVIMENTO(1, "Desenvolvimento"),
    ATENDIMENTO(2, "Atendimento"),
    MANUTENCAO(3, "Manutenção"),
    MANUTENCAO_URGENTE(4, "Manutenção Urgente");

    final int codigo;
    final String descricao;

    private TiposDeTarefa(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
