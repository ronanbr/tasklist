package br.com.tasklist.service;

import br.com.tasklist.dao.CrudDao;
import br.com.tasklist.dao.TarefaDao;
import br.com.tasklist.dto.TarefaDto;
import br.com.tasklist.entity.TarefaEntity;
import br.com.tasklist.exception.DaoException;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaService extends CrudService<TarefaEntity, Long, TarefaDto> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaDao tarefaDao;

    // TRANSAÇÕES

    public void salvarNovaTarefa(TarefaDto tarefa) throws DaoException {
        tarefaDao.salvarNova(tarefa.toEntity());
    }

    public void alterarTarefa(TarefaDto tarefa) throws DaoException {
        tarefaDao.alterar(tarefa.toEntity());
    }

    public void excluirTarefa(TarefaDto tarefa) throws DaoException {
        tarefa.setFgExcluida(true);
        tarefaDao.alterar(tarefa.toEntity());

    }

    // LISTAGENS

    public List<TarefaDto> listarTodasAsTarefas() {

        List<TarefaDto> tarefas = new ArrayList<>();

        List<TarefaEntity> tarefasEntities = tarefaDao.listarTodas();
        for (TarefaEntity tarefaEntity : tarefasEntities) {
            tarefas.add(tarefaEntity.toDto());
        }

        return tarefas;
    }

    public List<TarefaDto> listarTodasAsTarefasEmAberto() {
        List<TarefaEntity> tarefas = tarefaDao.listarTodasAsTarefasEmAberto();
        return tarefas.stream().map(a -> a.toDto()).collect(Collectors.toList());
    }

    public List<TarefaDto> listarTodasAsTarefasFinalizadas() {
        List<TarefaEntity> tarefas = tarefaDao.listarTodasAsTarefasFinalizadas();
        return tarefas.stream().map(a -> a.toDto()).collect(Collectors.toList());
    }

    @Override
    protected CrudDao<TarefaEntity, Long> getDao() {
        return tarefaDao;

    }
}
