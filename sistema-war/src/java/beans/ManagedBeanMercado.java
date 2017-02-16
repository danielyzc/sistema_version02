
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.MercadoFacadeLocal;
import be.Mercado;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */


@ManagedBean
@SessionScoped
public class ManagedBeanMercado implements Serializable{
    @EJB
    private MercadoFacadeLocal mercadoFacade;

 private Mercado mercado;
    private List<Mercado> lista ;
      private List<SelectItem> mercadosItems = new LinkedList<SelectItem>();
private HashMap<Integer, Mercado> mymercados = new HashMap<Integer,Mercado>();

    public ManagedBeanMercado() {
        mercado = new Mercado();
        lista = new LinkedList<Mercado>();
    }

    public List<SelectItem> getMercadosItems() {

        lista = new LinkedList<Mercado>();
        mercadosItems = new LinkedList<SelectItem>();
        lista = mercadoFacade.findAll();
        for(Mercado p: lista){
        mymercados.put(p.getIdMercado(), p);
            mercadosItems.add(new SelectItem(p, p.getNombreMercado()));
        }
       
        return mercadosItems;
    }

    public void setMercadosItems(List<SelectItem> mercadosItems) {
        this.mercadosItems = mercadosItems;
    }

    public HashMap<Integer, Mercado> getMymercados() {
        return mymercados;
    }

    public void setMymercados(HashMap<Integer, Mercado> mymercados) {
        this.mymercados = mymercados;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

 public Mercado getMercado(Integer id) {
           return (Mercado) mymercados.get(id);

    }

 public List<Mercado> getListaMercados(){
 lista = new LinkedList<Mercado>();
     try {
       lista =  mercadoFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

  public String Nuevo(){
mercado = new Mercado();
    return "nuevo_mercado";
    }

  public String crear(){

    try {
               mercadoFacade.create(mercado);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "mercados?faces-redirect=true";

}

   public String Volver_Mercados(){
return "index?faces-redirect=true";
     }

}
