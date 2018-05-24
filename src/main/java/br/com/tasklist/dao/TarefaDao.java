package br.com.tasklist.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tasklist.entity.TarefaEntity;

public class TarefaDao extends CrudDao<TarefaEntity, Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    @Override
    public String adicionaWhereBuscarTodos() {
        return "WHERE fgExcluida = false";
    }

    public List<TarefaEntity> listarTodasAsTarefasFinalizadas() {
        return this.listarTarefas("TarefaEntity.listarTodasAsTarefasFinalizadas");
    }

    public List<TarefaEntity> listarTodasAsTarefasEmAberto() {
        return this.listarTarefas("TarefaEntity.listarTodasAsTarefasEmAberto");
    }

    public List<TarefaEntity> listarTarefas(String namedQuery) {
        TypedQuery<TarefaEntity> query = em.createNamedQuery(namedQuery, TarefaEntity.class);
        return query.getResultList();
    }
}
