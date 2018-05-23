package br.com.tasklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.tasklist.dto.TarefaDto;
import br.com.tasklist.enums.TiposDeTarefa;

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

    @Column(name = "tp_tarefa")
    @Enumerated(EnumType.STRING)
    private TiposDeTarefa tipo;

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

    public TiposDeTarefa getTipo() {
        return tipo;
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

    public TarefaDto toDto() {
        return new ModelMapper().map(this, TarefaDto.class);
    }

}
