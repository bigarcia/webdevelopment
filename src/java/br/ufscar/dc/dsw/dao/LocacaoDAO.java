package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Locacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class LocacaoDAO extends GenericDAO<Locacao> {

    @Override
    Locacao get(Long id_locacao) {
        EntityManager em = this.getEntityManager();
        Locacao locacao = em.find(Locacao.class, id_locacao);
        em.close();
        return locacao;
    }

    @Override
    public List<Locacao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Locacao.findAll");
        List<Locacao> lista = q.getResultList();
        em.close();
        return lista;
    }

    @Override
    public void save(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(locacao);
        tx.commit();
        em.close();
    }

    @Override
    void update(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(locacao);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locacao = em.getReference(Locacao.class, locacao.getId_locacao());
        tx.begin();
        em.remove(locacao);
        tx.commit();
    }

    public Locacao getById(String id_locacao) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Locacao> q = em.createNamedQuery("Locacao.findById", Locacao.class);
        q.setParameter("id_locacao", id_locacao);
        return q.getSingleResult();
    }
}
