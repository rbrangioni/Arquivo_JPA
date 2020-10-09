package br.com.raphael.arquivos.dao;

import br.com.raphael.arquivos.entities.Pessoas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PessoasDAO {
    protected EntityManager entityManager;

    public PessoasDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-pg");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Pessoas getById(final Long id) {
        return entityManager.find(Pessoas.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Pessoas> findAll() {
        return entityManager.createQuery("FROM " + Pessoas.class.getName())
                .getResultList();
    }

    public void persist(Pessoas pessoa) {
        try {
            //entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            //entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Pessoas pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Pessoas pessoa) {
        try {
           // entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoas.class, pessoa.getId());
            entityManager.remove(pessoa);
            //entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Pessoas pessoa = getById(id);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }
}

