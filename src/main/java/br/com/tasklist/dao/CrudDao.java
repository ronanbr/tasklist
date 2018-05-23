package br.com.tasklist.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.tasklist.entity.BaseEntity;
import br.com.tasklist.exception.DaoException;

/**
 * Dao com metodos genericos para CRUD.
 */
public abstract class CrudDao<E extends BaseEntity<ID>, ID extends Serializable> {

    @Inject
    protected EntityManager em;

    protected Class<E> classE;

    public E salvarNova(final E entity) throws DaoException {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            tentaExecutarRollbackNaTransacao();
            e.printStackTrace();
            throw new DaoException("Não foi possivel salvar.", e);

        }
        return entity;
    }

    public E alterar(final E entity) throws DaoException {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            tentaExecutarRollbackNaTransacao();
            e.printStackTrace();
            throw new DaoException("Não foi possivel alterar", e);
        }
        return entity;
    }

    private void tentaExecutarRollbackNaTransacao() {
        try {
            em.getTransaction().rollback();
        } catch (Exception ex) {
            System.out.println("Não foi necessário o rollback!");
        }
    }

    public void remover(final ID id) throws DaoException {
        try {
            E e = buscarPorId(id);
            em.remove(e);
        } catch (Exception e) {
            tentaExecutarRollbackNaTransacao();
            e.printStackTrace();
            throw new DaoException("Não foi possivel excluir", e);

        }

    }

    public E buscarPorId(final ID id) {
        if (id == null) {
            return null;
        }

        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT e FROM ").append(getClassE().getName()).append(" e WHERE e.id = :id ");
        TypedQuery<E> query = em.createQuery(jpql.toString(), getClassE());
        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<E> listarTodas() {

        StringBuilder jpql = new StringBuilder();
        jpql.append("Select e From " + getClassE().getName() + " e ");
        jpql.append(adicionaWhereBuscarTodos());

        return em.createQuery(jpql.toString()).getResultList();
    }

    public String adicionaWhereBuscarTodos() {
        return "";
    }

    @SuppressWarnings("unchecked")
    public Class<E> getClassE() {
        if (classE == null) {
            classE = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return classE;
    }
}