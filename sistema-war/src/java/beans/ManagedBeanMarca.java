/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.MarcaProductoFacadeLocal;
import be.MarcaProducto;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author argos
 */
@ManagedBean
@SessionScoped
public class ManagedBeanMarca implements Serializable {

    @EJB
    private MarcaProductoFacadeLocal marcaProductoFacade;
    private MarcaProducto objeto;
    private List<MarcaProducto> lista;

    public ManagedBeanMarca() {
        objeto = new MarcaProducto();
        lista = new LinkedList<MarcaProducto>();
    }

    public MarcaProducto getObjeto() {
        return objeto;
    }

    public void setObjeto(MarcaProducto objeto) {
        this.objeto = objeto;
    }

    public List<MarcaProducto> getLista() {
        return lista;
    }

    public void setLista(List<MarcaProducto> lista) {
        this.lista = lista;
    }

    public List<SelectItem> getItems() {

        List<SelectItem> resultado_ = new LinkedList<SelectItem>();
        
        for(MarcaProducto p : marcaProductoFacade.listaActivos("nombre", 1)){
        resultado_.add(new SelectItem(p, p.getNombre()));
        }
       return resultado_;

    }

    public MarcaProducto traerObjeto(int id) {
        return marcaProductoFacade.find(id);
    }
}
