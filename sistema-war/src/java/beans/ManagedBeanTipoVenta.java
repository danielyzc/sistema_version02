
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.TipoVentaFacadeLocal;
import be.TipoVenta;
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
public class ManagedBeanTipoVenta implements  Serializable {
    @EJB
    private  TipoVentaFacadeLocal tipoVentaFacade;
private TipoVenta tipoventa ;
 private List<TipoVenta> lista ;
private List<SelectItem> tipoventasItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoVenta> mytipoventas = new HashMap<Integer,TipoVenta>();

    public ManagedBeanTipoVenta() {
        tipoventa = new TipoVenta();
        lista = new LinkedList<TipoVenta>();
    }

    public HashMap<Integer, TipoVenta> getMytipoventas() {
        return mytipoventas;
    }

    public void setMytipoventas(HashMap<Integer, TipoVenta> mytipoventas) {
        this.mytipoventas = mytipoventas;
    }

    public TipoVenta getTipoventa() {
        return tipoventa;
    }

    public void setTipoventa(TipoVenta tipoventa) {
        this.tipoventa = tipoventa;
    }

    public List<SelectItem> getTipoventasItems() {


        lista = new ArrayList<TipoVenta>();
        tipoventasItems = new LinkedList<SelectItem>();
        lista = tipoVentaFacade.findAll();
        for(TipoVenta p: lista){
        mytipoventas.put(p.getIdTipoVenta(), p);
            tipoventasItems.add(new SelectItem(p, p.getNombreTipoVenta()));
        }
         return tipoventasItems;
    }


 



     public TipoVenta getTipoventa(Integer id) {
           return (TipoVenta) mytipoventas.get(id);

    }


    public void setTipoventasItems(List<SelectItem> tipoventasItems) {
        this.tipoventasItems = tipoventasItems;
    }




}
