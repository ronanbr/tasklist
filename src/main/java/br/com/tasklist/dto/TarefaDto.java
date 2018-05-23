package br.com.tasklist.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import br.com.tasklist.entity.TarefaEntity;
import br.com.tasklist.enums.TiposDeTarefa;

public class TarefaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String titulo;
    private String descricao;
    private TiposDeTarefa tipo;
    private boolean fgExcluida;
    private boolean fgFinalizada;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TiposDeTarefa getTipo() {
        return tipo;
    }

    public int getCodigoTipo() {
        return tipo.getCodigo();
    }

    public void setTipo(TiposDeTarefa tipo) {
        this.tipo = tipo;
    }

    public boolean isFgExcluida() {
        return fgExcluida;
    }

    public void setFgExcluida(boolean fgExcluida) {
        this.fgExcluida = fgExcluida;
    }

    public boolean isFgFinalizada() {
        return fgFinalizada;
    }

    public void setFgFinalizada(boolean fgFinalizada) {
        this.fgFinalizada = fgFinalizada;
    }

    public boolean isManutencaoUrgente() {
        return this.tipo.equals(TiposDeTarefa.MANUTENCAO_URGENTE);
    }

    public boolean isAtendimento() {
        return this.tipo.equals(TiposDeTarefa.ATENDIMENTO);
    }

    public TarefaEntity toEntity() {
        return new ModelMapper().map(this, TarefaEntity.class);
    }

}
