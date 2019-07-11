package utfpr.edu.cp.ads.aulareposicao.dao;
import java.io.IOException;
import java.util.List;

import javax.persistence.*;

public abstract class GenericDAO<T> {
    private Class<T> className;

    protected GenericDAO() {}

    protected GenericDAO(Class<T> name) {
        this();
        this.className = name;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aularepo");
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void create(T obj) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }

    @SuppressWarnings("unchecked")
    public List<T> read() {
        EntityManager em = this.getEntityManager();
        List<T> list = null;
        try {
            list = em.createQuery("from " + this.className).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(T obj) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }

    public void delete(int id) {
        EntityManager em = this.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(className, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }
}