/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.converter;

import br.com.exemplo.dao.EstadoDao;
import br.com.exemplo.model.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Felipe Macedo
 */
@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String nome) {
        EstadoDao dao = new EstadoDao();
        return dao.pesquisaPorNome(nome);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object estado) {
        return ((Estado) estado).getNome();
    }

}
