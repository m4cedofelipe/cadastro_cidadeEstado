/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.dao;

import br.com.exemplo.model.Cidade;
import br.com.exemplo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Felipe Macedo
 */
public class CidadeDao {

    public void salvar(Cidade cidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(cidade);

        session.getTransaction().commit();
        session.close();
    }

    public List<Cidade> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List cidades = session.getNamedQuery("Cidade.findAll").list();
        session.close();

        return cidades;
    }

    public void altera(Cidade cidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(cidade);

        session.getTransaction().commit();
        session.close();
    }

    public void deletar(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(session.get(Cidade.class, id));

        session.getTransaction().commit();
        session.close();
    }

    public Cidade pesquisaPorId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Cidade cidade = (Cidade) session.merge(session.get(Cidade.class, id));
        
        session.getTransaction().commit();
        session.close();
        
        return cidade;
    }
}
