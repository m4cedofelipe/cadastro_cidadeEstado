/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.mb;

import br.com.exemplo.dao.CidadeDao;
import br.com.exemplo.model.Cidade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe Macedo
 */
@ManagedBean
@ViewScoped
public class CidadeMB {

    private Cidade cidade;
    private List<Cidade> lista;
    private CidadeDao dao;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getLista() {
        return lista;
    }

    public void setLista(List<Cidade> lista) {
        this.lista = lista;
    }

    public CidadeDao getDao() {
        return dao;
    }

    public void setDao(CidadeDao dao) {
        this.dao = dao;
    }

    /*
        Metodos  da Classe
     */
    public void salvar() {
        dao = new CidadeDao();

        if (cidade.getId() == null) {
            dao.salvar(cidade);
        } else {
            dao.altera(cidade);
        }
        
        saveMessage("Cidade Salva");
                
        inicializarTela();
    }

    public void deletar(Cidade c) {
        dao.deletar(c.getId());

        inicializarTela();
    }

    public void carregaCidade(Cidade c) {
        cidade = c;
    }

    @PostConstruct
    public void inicializarTela() {
        dao = new CidadeDao();
        lista = dao.listar();

        limpar();
    }

    public void limpar() {
        cidade = new Cidade();
    }
    
    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successo !", message) );
        //context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
}
