/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.dao;

import br.com.exemplo.model.Estado;
import br.com.exemplo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Felipe Macedo
 */
public class EstadoDao {

    public void salvar(Estado estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(estado);

        session.getTransaction().commit();
        session.close();
    }

    public List<Estado> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Estado> estados = session.getNamedQuery("Estado.findAll").list();

        return estados;
    }

    public Estado pesquisaPorNome(String nome) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Estado estado = (Estado) session.getNamedQuery("Estado.findByNome").setParameter("nome", nome).setMaxResults(1).uniqueResult();

        session.close();
        return estado;
    }

    public void teste() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT estado FROM Estado as estado ");
        sb.append("FROM Estado as estado ");
        sb.append("WHERE estado.nome = (:pNome);");

        Query query = session.createQuery(sb.toString())
                .setParameter("pNome", "Sao Paulo");
        
        System.out.println(query.uniqueResult());
    }

}
