package br.com.tasklist.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.tasklist.dao.CrudDao;
import br.com.tasklist.entity.BaseEntity;
import br.com.tasklist.exception.DaoException;

import javax.inject.Inject;

/**
 * Service com metodos genericos para CRUD.
 */
public abstract class CrudService<E extends BaseEntity<ID>, ID extends Serializable, D> {

    protected ModelMapper mapper;

    private Class<E> classE;
    private Class<D> classDto;

    public E inserir(E entity) throws DaoException {
        getDao().salvarNova(entity);
        return entity;
    }

    public D inserirDto(D dto) throws DaoException {
        E entity = toEntity(dto);
        return toDto(inserir(entity));
    }

    public E atualizar(E entity) throws DaoException {
        E entityMerged = getDao().alterar(entity);
        return entityMerged;
    }

    public D atualizarDto(D dto) throws DaoException {
        E entity = toEntity(dto);
        return toDto(atualizar(entity));
    }

    public void remover(ID id) throws DaoException {
        getDao().remover(id);
    }

    public E buscarPorId(ID id) {
        return getDao().buscarPorId(id);
    }

    public D buscarDtoPorId(ID id) {
        return toDto(buscarPorId(id));
    }

    public List<E> buscarTodos() {
        return getDao().listarTodas();
    }

    public List<D> buscarTodosDtos() {
        return toDto(buscarTodos());
    }

    public E toEntity(D dto) {
        return getMapper().map(dto, getClassE());
    }

    public D toDto(E entidade) {
        return getMapper().map(entidade, getClassDto());
    }

    public List<D> toDto(List<E> entidades) {
        return entidades.stream().map(e -> getMapper().map(e, getClassDto())).collect(Collectors.toList());
    }

    public ModelMapper getMapper() {
        if(mapper == null){
            this.mapper = new ModelMapper();
        }
        return mapper;
    }

    protected abstract CrudDao<E, ID> getDao();

    @SuppressWarnings("unchecked")
    protected Class<E> getClassE() {
        if (classE == null) {
            this.classE = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return classE;
    }

    @SuppressWarnings("unchecked")
    protected Class<D> getClassDto() {
        if (classDto == null) {
            this.classDto = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        }
        return classDto;
    }
}