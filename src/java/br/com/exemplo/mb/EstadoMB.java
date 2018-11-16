/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.mb;

import br.com.exemplo.dao.EstadoDao;
import br.com.exemplo.model.Estado;
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
public class EstadoMB {

    private Estado estado;
    private List<Estado> lista;
    private EstadoDao dao;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getLista() {
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;
    }

    public EstadoDao getDao() {
        return dao;
    }

    public void setDao(EstadoDao dao) {
        this.dao = dao;
    }

    /*
        Metodos da classe
     */
    
    @PostConstruct
    public void inicializarTela() {
        dao = new EstadoDao();
        lista = dao.listar();

        limpar();
    }

    private void limpar() {
        estado = new Estado();
    }
    
    public void salvar(){
        // TODO: fazer validações antes de salvar
        
        dao = new EstadoDao();
        dao.salvar(estado);
        
        //dao.teste();
        
        saveMessage("Estado Salvo com sucesso");
        
        inicializarTela();
    }
    
    public void saveMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successo !", message) );
        //context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
}
