package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ClienteDAO extends GenericDAO<Cliente> {

    @Override
    Cliente get(Long id_cliente) {
        EntityManager em = this.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id_cliente);
        em.close();
        return cliente;
    }

    @Override
    public List<Cliente> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cliente.findAll");
        List<Cliente> lista = q.getResultList();
        em.close();
        return lista;
    }

    @Override
    public void save(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();
        em.close();
    }

    @Override
    void update(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(cliente);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Cliente cliente) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        cliente = em.getReference(Cliente.class, cliente.getId_cliente());
        tx.begin();
        em.remove(cliente);
        tx.commit();
    }

    public Cliente getByNome(String nome_cliente) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByNome", Cliente.class);
        q.setParameter("nome", nome_cliente);
        return q.getSingleResult();
    }
}