package br.com.tasklist.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


@NamedQueries({

    @NamedQuery(name = "TarefaEntity.listarTodasAsTarefasFinalizadas", query = "SELECT a FROM TarefaEntity a WHERE a.fgExcluida = false "
            + "AND a.fgFinalizada = true"),
    @NamedQuery(name = "TarefaEntity.listarTodasAsTarefasEmAberto", query = "SELECT a FROM TarefaEntity a WHERE a.fgExcluida = false "
            + "AND a.fgFinalizada = false")

})
@Entity
@Table(name = "tarefa")
public class TarefaEntity extends BaseEntity<Long> {

    @Column(name = "titulo_tarefa")
    private String titulo;

    @Column(name = "ds_tarefa")
    private String descricao;

    @Column(name = "dt_alteracao")
    private Date dtAlteracao;

    @Column(name = "fg_excluida")
    private boolean fgExcluida;

    @Column(name = "fg_finalizada")
    private boolean fgFinalizada;

    @Column(name = "cd_tarefa")
    @Override
    public Long getCodigo() {
        return codigo;
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
