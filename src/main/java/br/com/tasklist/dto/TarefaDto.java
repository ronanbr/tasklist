package br.com.tasklist.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TarefaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codigo;
    private String titulo;
    private String descricao;
    private Date dtAlteracao;
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

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
}
