package br.com.tasklist.uteis;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceGeneral");

    @Produces
    @SessionScoped
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        em.close();
    }

}