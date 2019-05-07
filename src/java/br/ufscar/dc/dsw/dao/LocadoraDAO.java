package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Locadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class LocadoraDAO extends GenericDAO<Locadora> {

    @Override
    Locadora get(Long id_locadora) {
        EntityManager em = this.getEntityManager();
        Locadora locadora = em.find(Locadora.class, id_locadora);
        em.close();
        return locadora;
    }

    @Override
    public List<Locadora> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locadora.findAll");
        List<Locadora> lista = q.getResultList();
        em.close();
        return lista;
    }

    @Override
    public void save(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(locadora);
        tx.commit();
        em.close();
    }

    @Override
    void update(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(locadora);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locadora = em.getReference(Locadora.class, locadora.getId_locadora());
        tx.begin();
        em.remove(locadora);
        tx.commit();
    }

    public Locadora getByCidade(String cidade_locadora) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Locadora> q = em.createNamedQuery("Locadora.findByCidade", Locadora.class);
        q.setParameter("cidade_locadora", cidade_locadora);
        return q.getSingleResult();
    }
}
