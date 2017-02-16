
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.IngresoMateriaPrimaTiendaFacadeLocal;
import bc.SalidaMateriaPrimaTiendaFacadeLocal;
import bc.StockMateriaPrimaTiendaOrigenFacadeLocal;
import be.IngresoMateriaPrimaTienda;
import be.SalidaMateriaPrimaTienda;
import be.StockMateriaPrimaTiendaOrigen;
import be.StockMateriaPrimaTiendaOrigenPK;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class ManagedBeanStockMateriaPrima implements Serializable{
    @EJB
    private SalidaMateriaPrimaTiendaFacadeLocal salidaMateriaPrimaTiendaFacade;
    @EJB
    private IngresoMateriaPrimaTiendaFacadeLocal ingresoMateriaPrimaTiendaFacade;
    @EJB
    private StockMateriaPrimaTiendaOrigenFacadeLocal stockMateriaPrimaTiendaOrigenFacade;

private List<StockMateriaPrimaTiendaOrigen> lista;
private StockMateriaPrimaTiendaOrigen stock_materia_prima;
private IngresoMateriaPrimaTienda ingreso;
        private SalidaMateriaPrimaTienda salida;
    public ManagedBeanStockMateriaPrima() {
        lista = new LinkedList<StockMateriaPrimaTiendaOrigen>();
        stock_materia_prima = new StockMateriaPrimaTiendaOrigen();
        ingreso = new IngresoMateriaPrimaTienda();
        salida = new SalidaMateriaPrimaTienda();
    }

    public List<StockMateriaPrimaTiendaOrigen> getLista() {
        try {
        lista = stockMateriaPrimaTiendaOrigenFacade.findAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
    }

    public IngresoMateriaPrimaTienda getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoMateriaPrimaTienda ingreso) {
        this.ingreso = ingreso;
    }

    public SalidaMateriaPrimaTienda getSalida() {
        return salida;
    }

    public void setSalida(SalidaMateriaPrimaTienda salida) {
        this.salida = salida;
    }

    public void setLista(List<StockMateriaPrimaTiendaOrigen> lista) {
        this.lista = lista;
    }

    public StockMateriaPrimaTiendaOrigen getStock_materia_prima() {
        return stock_materia_prima;
    }

    public void setStock_materia_prima(StockMateriaPrimaTiendaOrigen stock_materia_prima) {
        this.stock_materia_prima = stock_materia_prima;
    }

public String stock_materia_primas(){
      lista.clear();
    stock_materia_prima = new StockMateriaPrimaTiendaOrigen();

return "stocks_materia_primas";
}

public String Volver_Stock(){
return "index?faces-redirect=true";
     }

public String nuevo_stock(){
   stock_materia_prima = new StockMateriaPrimaTiendaOrigen();
  stock_materia_prima.setUltimaFechaIngreso(new Date());
   return "nuevo_stock_materia_prima";
}


public String registrar(){
    try {
         ingreso = new IngresoMateriaPrimaTienda();
         ingreso.setCantidad(stock_materia_prima.getCantidad());
ingreso.setFechaIngreso(new Date());
ingreso.setMateriaPrima(stock_materia_prima.getMateriaPrima());
ingreso.setMotivo("Primer Ingreso");
ingreso.setTienda(stock_materia_prima.getTienda());


        stock_materia_prima.setStockMateriaPrimaTiendaOrigenPK(new StockMateriaPrimaTiendaOrigenPK(stock_materia_prima.getMateriaPrima().getIdMateriaPrima(),stock_materia_prima.getTienda().getIdTienda() ));
        stockMateriaPrimaTiendaOrigenFacade.create(stock_materia_prima);
ingresoMateriaPrimaTiendaFacade.create(ingreso);
    } catch (Exception e) {
        e.printStackTrace();
    }
  return "stocks_materia_primas?faces-redirect=true";
}


public String entra(){
    ingreso = new IngresoMateriaPrimaTienda();
return "ingreso_materia_prima_almacen";
}


public String sale(){
    salida = new SalidaMateriaPrimaTienda();
return "salida_materia_prima_almacen";
}



public String Registro_Incremento(){

      try {
   stock_materia_prima.setCantidad(stock_materia_prima.getCantidad().add(ingreso.getCantidad()));
   stockMateriaPrimaTiendaOrigenFacade.edit(stock_materia_prima);

   ingreso.setFechaIngreso(new Date());
   ingreso.setMateriaPrima(stock_materia_prima.getMateriaPrima());
   ingreso.setTienda(stock_materia_prima.getTienda());
ingresoMateriaPrimaTiendaFacade.create(ingreso);
  
    } catch (Exception e) {
    e.printStackTrace();
    }
  return "stocks_materia_primas?faces-redirect=true";
}


public String Registro_Decremento(){

      try {
   stock_materia_prima.setCantidad(stock_materia_prima.getCantidad().subtract(salida.getCantidad()));
   stockMateriaPrimaTiendaOrigenFacade.edit(stock_materia_prima);

   salida.setFechaSalida(new Date());
      salida.setMateriaPrima(stock_materia_prima.getMateriaPrima());
   salida.setTienda(stock_materia_prima.getTienda());
   salidaMateriaPrimaTiendaFacade.create(salida);

    } catch (Exception e) {
    e.printStackTrace();
    }
  return "stocks_materia_primas?faces-redirect=true";
}



public void Registro_Incremento2(){

      try {

           stock_materia_prima.setCantidad(stock_materia_prima.getCantidad().add(ingreso.getCantidad()));
stockMateriaPrimaTiendaOrigenFacade.edit(stock_materia_prima);
 ingreso.setFechaIngreso(new Date());
ingreso.setMateriaPrima(stock_materia_prima.getMateriaPrima());
   ingreso.setTienda(stock_materia_prima.getTienda());
 
  ingreso.setMotivo("Primer Ingreso");
  ingresoMateriaPrimaTiendaFacade.create(ingreso);
    } catch (Exception e) {
    e.printStackTrace();
    }

}

}
