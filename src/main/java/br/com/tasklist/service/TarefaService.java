package br.com.tasklist.service;

import br.com.tasklist.dao.CrudDao;
import br.com.tasklist.dao.TarefaDao;
import br.com.tasklist.dto.TarefaDto;
import br.com.tasklist.entity.TarefaEntity;
import br.com.tasklist.exception.DaoException;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class TarefaService extends CrudService<TarefaEntity, Long, TarefaDto> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaDao tarefaDao;

    public void salvarNovaTarefa(TarefaDto tarefa) throws DaoException {
        tarefa.setDtAlteracao(Calendar.getInstance().getTime());
        tarefaDao.salvarNova(toEntity(tarefa));
    }

    public void alterarTarefa(TarefaDto tarefa) throws DaoException {
        tarefa.setDtAlteracao(Calendar.getInstance().getTime());
        tarefaDao.alterar(toEntity(tarefa));
    }

    public void excluirTarefa(TarefaDto tarefa) throws DaoException {
        tarefa.setDtAlteracao(Calendar.getInstance().getTime());
        tarefa.setFgExcluida(true);
        tarefaDao.alterar(toEntity(tarefa));
    }

    public List<TarefaDto> listarTodasAsTarefas() {
        List<TarefaDto> tarefas = new ArrayList<>();
        List<TarefaEntity> tarefasEntities = tarefaDao.listarTodas();
        for (TarefaEntity tarefaEntity : tarefasEntities) {
            tarefas.add(toDto(tarefaEntity));
        }
        return tarefas;
    }

    public List<TarefaDto> listarTodasAsTarefasEmAberto() {
        List<TarefaEntity> tarefas = tarefaDao.listarTodasAsTarefasEmAberto();
        return tarefas.stream().map(a -> toDto(a)).collect(Collectors.toList());
    }

    public List<TarefaDto> listarTodasAsTarefasFinalizadas() {
        List<TarefaEntity> tarefas = tarefaDao.listarTodasAsTarefasFinalizadas();
        return tarefas.stream().map(a -> toDto(a)).collect(Collectors.toList());
    }

    @Override
    protected CrudDao<TarefaEntity, Long> getDao() {
        return tarefaDao;
    }
}
