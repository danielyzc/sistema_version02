
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.IgvFacturaFacadeLocal;
import be.IgvFactura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
@ManagedBean
@SessionScoped
public class ManagedBeanIgvFactura implements Serializable{
    @EJB
  private  IgvFacturaFacadeLocal igvFacturaFacade;
  private List<IgvFactura> lista;
private IgvFactura igv;
 private List<SelectItem> igvItems = new LinkedList<SelectItem>();
private HashMap<Integer, IgvFactura> myigvs = new HashMap<Integer,IgvFactura>();

    public ManagedBeanIgvFactura() {
        lista = new LinkedList<IgvFactura>();
        igv = new IgvFactura();
    }

    public IgvFactura getIgv() {
        return igv;
    }

    public void setIgv(IgvFactura igv) {
        this.igv = igv;
    }

    public List<SelectItem> getIgvItems() {
 lista = new ArrayList<IgvFactura>();
        igvItems = new LinkedList<SelectItem>();
        lista = igvFacturaFacade.findAll();
        for(IgvFactura p: lista){
        myigvs.put(p.getIdIgvFactura(), p);
        igvItems.add(new SelectItem(p, p.getDescripcion()));
        }

        return igvItems;
    }

    public void setIgvItems(List<SelectItem> igvItems) {
        this.igvItems = igvItems;
    }

    public List<IgvFactura> getLista() {
        try {
            lista = igvFacturaFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<IgvFactura> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, IgvFactura> getMyigvs() {
        return myigvs;
    }

    public void setMyigvs(HashMap<Integer, IgvFactura> myigvs) {
        this.myigvs = myigvs;
    }
public IgvFactura getIgvFactura(Integer id) {
           return (IgvFactura)myigvs.get(id);

    }

}
