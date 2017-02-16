
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.IngresosEconomicosFacadeLocal;
import be.Cliente;
import be.IngresosEconomicos;
import be.Negocio;
import be.Tienda;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz  Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under * the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */



@ManagedBean
@SessionScoped
public class ManagedBeanIngresoEconomico implements Serializable{
    @EJB
    private IngresosEconomicosFacadeLocal ingresosEconomicosFacade;
private List<IngresosEconomicos> lista ;
private IngresosEconomicos ingresoseconomicos;
private Date fecha_busqueda;

    public ManagedBeanIngresoEconomico() {
lista  = new LinkedList<IngresosEconomicos>();
ingresoseconomicos = new IngresosEconomicos();
fecha_busqueda  = new Date();

    }

    public IngresosEconomicos getIngresoseconomicos() {
        return ingresoseconomicos;
    }

    public void setIngresoseconomicos(IngresosEconomicos ingresoseconomicos) {
        this.ingresoseconomicos = ingresoseconomicos;
    }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }

    

 

    public  List<IngresosEconomicos> getListaIngresos(){

        try {
            lista = ingresosEconomicosFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;

    }

      public  void FiltrarListaIngresosFecha(){
         lista.clear();
        try {
            for(IngresosEconomicos p : ingresosEconomicosFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaCreacion())){
                  lista.add(p);
                }
    
                
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }

      public String Ingresos(){
ingresoseconomicos = new IngresosEconomicos();
fecha_busqueda = new Date();
  SimpleDateFormat dateformatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
  StringBuilder cadena_hoy = new StringBuilder( dateformatDDMMYYYY.format(fecha_busqueda) );
  StringBuilder cadena_comparar = null;
lista.clear();
        
        try {
            
            List<IngresosEconomicos> lista_temp= new LinkedList<IngresosEconomicos>();
                   lista_temp =ingresosEconomicosFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
         
              
                cadena_comparar = new StringBuilder( dateformatDDMMYYYY.format(lista_temp.get(i).getFechaCreacion()) );
                
                if(cadena_hoy.toString().equalsIgnoreCase(cadena_comparar.toString())){
             lista.add(lista_temp.get(i));
                }
             
                  }
          
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    return "ingresos";
    }

public void newObject(){
 ingresoseconomicos = new IngresosEconomicos();

}

public void crearNew(){

    try {
       ingresoseconomicos.setFechaCreacion(new Date());
       ingresosEconomicosFacade.create(ingresoseconomicos);
       this.buscarFecha(fecha_busqueda);
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}
    public String Nuevo(){
    ingresoseconomicos = new IngresosEconomicos();
   return "nuevo_ingreso";
    }

  public String crear(){

    try {
        ingresoseconomicos.setFechaCreacion(new Date());
                ingresosEconomicosFacade.create(ingresoseconomicos);
                   } catch (Exception e) {
        e.printStackTrace();
    }
  
    return "ingresos?faces-redirect=true";

}

   public String Volver_Ingresos(){
return "finanzas?faces-redirect=true";
     }

    public List<IngresosEconomicos> getLista() {
        return lista;
    }

    public void setLista(List<IngresosEconomicos> lista) {
        this.lista = lista;
    }



    public List<IngresosEconomicos> getRetornaLista() {

        lista.clear();
        if(fecha_busqueda == null)
        {
        fecha_busqueda = new Date();
        }
        try {
            for(IngresosEconomicos p : ingresosEconomicosFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaCreacion())){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


  

   /* public void FiltrarListaIngresosFecha2(){
         lista.clear();
       //  lista = ventaFacade.findAll();
    //  return lista;
      SimpleDateFormat fecha_buscar = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fecha_detalle = new SimpleDateFormat("dd/MM/yyyy");
   StringBuilder cadena_fecha_buscar = new StringBuilder( fecha_buscar.format(fecha_busqueda));
        for (IngresosEconomicos p : ingresosEconomicosFacade.findAll()){
            StringBuilder cadena_fecha_detalle = new StringBuilder( fecha_detalle.format( p.getFechaCreacion() ) );
        if(cadena_fecha_buscar.toString().equals(cadena_fecha_detalle.toString()))
        {
            lista.add(p);
            }
        }

    }*/
    
    
    public void handleDateSelect(SelectEvent event) {
Date date = (Date) event.getObject();

lista.clear();
        
        try {
            
             List<IngresosEconomicos> lista_temp= new LinkedList<IngresosEconomicos>();
                   lista_temp =ingresosEconomicosFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
         if(date.equals(lista_temp.get(i).getFechaCreacion())){
             lista.add(lista_temp.get(i));
         }
             
                  }
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
//Add facesmessage
}
 public void buscarFecha(Date fecha) {


lista.clear();
        
        try {
            for(IngresosEconomicos p : ingresosEconomicosFacade.findAll()){
                if(fecha.equals(p.getFechaCreacion())){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
//Add facesmessage
}   

}
