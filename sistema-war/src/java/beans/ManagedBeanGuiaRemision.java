
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.GuiaRemicionFacadeLocal;
import be.GuiaRemicion;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ManagedBeanGuiaRemision implements Serializable {
    @EJB
    private GuiaRemicionFacadeLocal guiaRemicionFacade;
private List<GuiaRemicion> lista;
private GuiaRemicion guia;
 private List<SelectItem> guiasItems = new LinkedList<SelectItem>();
private HashMap<Integer, GuiaRemicion> myguias = new HashMap<Integer,GuiaRemicion>();



    public ManagedBeanGuiaRemision() {
  lista = new LinkedList<GuiaRemicion>();
  guia = new GuiaRemicion();
    }

    public GuiaRemicion getGuia() {
        return guia;
    }

    public void setGuia(GuiaRemicion guia) {
        this.guia = guia;
    }

    public List<SelectItem> getGuiasItems() {
        lista = new ArrayList<GuiaRemicion>();
        guiasItems = new LinkedList<SelectItem>();
        lista = guiaRemicionFacade.findAll();
        for(GuiaRemicion p: lista){
        myguias.put(p.getIdGuiaRemicion(), p);
        guiasItems.add(new SelectItem(p, p.getObservaciones()));
        }

        return guiasItems;
    }

    public void setGuiasItems(List<SelectItem> guiasItems) {
        this.guiasItems = guiasItems;
    }

    public List<GuiaRemicion> getLista() {
        try {
            lista = guiaRemicionFacade.findAll();
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<GuiaRemicion> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, GuiaRemicion> getMyguias() {
        return myguias;
    }

    public void setMyguias(HashMap<Integer, GuiaRemicion> myguias) {
        this.myguias = myguias;
    }

public String Nueva(){
guia = new GuiaRemicion();
 return "nueva_guia";
 }


    public String crear(){
     try {
    guiaRemicionFacade.create(guia);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "guias?faces-redirect=true";
 }

    public String Volver_Guia(){
return "index?faces-redirect=true";
     }

}
