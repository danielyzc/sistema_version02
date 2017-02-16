/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.DetalleInventarioUbicacionFisicaFacadeLocal;
import bc.DetalleUbicacionFisicaProductoFacadeLocal;
import bc.InventarioFisicoFacadeLocal;
import bc.InventarioInicialSistemaFacadeLocal;
import bc.ProductoFacadeLocal;
import be.DetalleInventarioUbicacionFisica;
import be.DetalleUbicacionFisicaProducto;
import be.InventarioFisico;
import be.InventarioInicialSistema;
import be.Producto;
import be.UbicacionFisica;
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
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class ManagedBeanInventarioFisico implements Serializable{
    @EJB
    private InventarioInicialSistemaFacadeLocal inventarioInicialSistemaFacade;
    @EJB
    private ProductoFacadeLocal productoFacade;
    @EJB
    private DetalleUbicacionFisicaProductoFacadeLocal detalleUbicacionFisicaProductoFacade;
    @EJB
    private DetalleInventarioUbicacionFisicaFacadeLocal detalleInventarioUbicacionFisicaFacade;
    @EJB
    private InventarioFisicoFacadeLocal inventarioFisicoFacade;



    private DetalleUbicacionFisicaProducto detalleUbicacionFisicaProducto;
    private DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica;
    private InventarioFisico inventarioFisico;
    private UbicacionFisica ubicacionFisica;
    private List<InventarioFisico> lista_inventarios ;

    private InventarioInicialSistema inventarioSistema;


    private String codigoBarras="";
private Producto producto;
private Date fecha_inicio;
private Date fecha_termino;
private Integer cantidad;
private String nombre_producto="";
    public ManagedBeanInventarioFisico() {
    detalleInventarioUbicacionFisica = new DetalleInventarioUbicacionFisica();
    detalleUbicacionFisicaProducto = new DetalleUbicacionFisicaProducto();
    inventarioFisico = new InventarioFisico();
    lista_inventarios = new LinkedList<InventarioFisico>();
producto = new Producto();
fecha_inicio = new Date();
fecha_termino= new Date();
cantidad = new Integer(1);
inventarioSistema= new InventarioInicialSistema();
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }



    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public DetalleInventarioUbicacionFisica getDetalleInventarioUbicacionFisica() {
        return detalleInventarioUbicacionFisica;
    }

    public void setDetalleInventarioUbicacionFisica(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica) {
        this.detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisica;
    }

    public DetalleUbicacionFisicaProducto getDetalleUbicacionFisicaProducto() {
        return detalleUbicacionFisicaProducto;
    }

    public void setDetalleUbicacionFisicaProducto(DetalleUbicacionFisicaProducto detalleUbicacionFisicaProducto) {
        this.detalleUbicacionFisicaProducto = detalleUbicacionFisicaProducto;
    }

    public InventarioFisico getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(InventarioFisico inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    public List<InventarioFisico> getLista_inventarios() {
        try {
            List<InventarioFisico> lista_temporal = new LinkedList<InventarioFisico>();
           lista_inventarios= new LinkedList<InventarioFisico>();
            lista_temporal = inventarioFisicoFacade.findAll();
       
            for(int i=lista_temporal.size()-1;i>=0;i--)
            {
            lista_inventarios.add(lista_temporal.get(i));
            }
        } catch (Exception e) {
        }
        return lista_inventarios;
    }

    public void setLista_inventarios(List<InventarioFisico> lista_inventarios) {
        this.lista_inventarios = lista_inventarios;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

public String Inventarios_fisicos(){
return "inventarios_fisicos";
}
public String Inventario_Ubicacion_fisica(){
    producto = new Producto();
return "inventario_ubicacion_fisica";
}
public String Nuevo(){
    inventarioFisico = new InventarioFisico();
    inventarioFisico.setFechaInicio(fecha_inicio);
    inventarioFisico.setFechaTermino(fecha_termino);
return "nuevo_inventario_fisico";
}
public String edicion(){
return "editar_inventarios_fisicos";
}
public String Crear(){
    try {

        inventarioFisicoFacade.create(inventarioFisico);
    } catch (Exception e) {
    }
    return "inventarios_fisicos";
}


public String Nuevo_detalle_inventario_ubicacionfisica(){
return null;
}



public void agregarUbicacion(ActionEvent actionEvent){

        try {
System.out.println(" PRIMERO :- "+ inventarioFisico.getDetalleInventarioUbicacionFisicaList().size());

            this.agregar_ubicacion_detalle_inventario_fisico();

            inventarioFisico = inventarioFisicoFacade.find(inventarioFisico.getIdInventarioFisico());
System.out.println(" SEGUNDO :- "+ inventarioFisico.getDetalleInventarioUbicacionFisicaList().size());


            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);



        } catch (Exception e) {
   e.printStackTrace();

   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación",  "NO SE EJECUTO");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }

public void agregar_ubicacion_detalle_inventario_fisico(){
  detalleInventarioUbicacionFisica = new DetalleInventarioUbicacionFisica();
      detalleInventarioUbicacionFisica.setUbicacionFisica(ubicacionFisica);
      detalleInventarioUbicacionFisica.setInventarioFisico(inventarioFisico);
      detalleInventarioUbicacionFisica.setDetalleUbicacionFisicaProductoList(new LinkedList<DetalleUbicacionFisicaProducto>());
    try {
               detalleInventarioUbicacionFisicaFacade.create(detalleInventarioUbicacionFisica);
            } catch (Exception e) {
            }

}

public void nueva_ubicacion(){
ubicacionFisica = new UbicacionFisica();
}
public int getTotalListaDetalleUbicacionProducto(){
return detalleInventarioUbicacionFisica.getDetalleUbicacionFisicaProductoList().size();
}



public void registrarRapido(){
DetalleUbicacionFisicaProducto det= new DetalleUbicacionFisicaProducto();
        try {

            if(codigoBarras.length()>= 13){

            for(Producto p : productoFacade.findAll() ) {
            if(p.getNombreProducto().contains(codigoBarras))
            {
            producto = p;
           det.setProducto(producto);
          det.setDetalleInventarioUbicacionFisica(detalleInventarioUbicacionFisica);
           detalleUbicacionFisicaProductoFacade.create(det);
           detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisicaFacade.find(detalleInventarioUbicacionFisica.getIdDetalleInventarioUbicacionFisica());

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO EXITOSO",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);

            }
 else
            {
 producto = new Producto();
 }

            }

           
       // codigoBarras="";
            }

            //else
           // {
            //  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "NO SE REGISTRO",  "Se ejecuto con exito");
       // FacesContext.getCurrentInstance().addMessage(null, message);

          //  }


        } catch (Exception e) {
        e.printStackTrace();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "NO SE REGISTRO",  "Se ejecuto con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }
public void agregarLista(){
    try {
        Boolean estado = false;
        DetalleUbicacionFisicaProducto det= new DetalleUbicacionFisicaProducto();
System.out.println("JOJOJO" + producto.getIdProducto());


     for(DetalleUbicacionFisicaProducto deta: detalleInventarioUbicacionFisica.getDetalleUbicacionFisicaProductoList()){
     if(deta.getProducto().equals(producto))
     {
         det = deta;
     estado = true;
     break;
     }
     }

     if(estado){
     det.setCantidad(det.getCantidad()+cantidad);
     detalleUbicacionFisicaProductoFacade.edit(det);
     }else
     {
         det.setProducto(this.getProducto());
        det.setDetalleInventarioUbicacionFisica(detalleInventarioUbicacionFisica);
        det.setCantidad(cantidad);
     detalleUbicacionFisicaProductoFacade.create(det);
     }

        


        detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisicaFacade.find(detalleInventarioUbicacionFisica.getIdDetalleInventarioUbicacionFisica());

    } catch (Exception e) {
    }
}
public void buscar(){

try {
DetalleUbicacionFisicaProducto det= new DetalleUbicacionFisicaProducto();

            if(codigoBarras.length()>= 13){

            for(Producto p : productoFacade.findAll() ) {
            if(p.getNombreProducto().contains(codigoBarras))
            {
         producto = new Producto();
         producto =p;
nombre_producto= producto.getNombreProducto();
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "PRODUCTO SELECCIONADO",  "");
        FacesContext.getCurrentInstance().addMessage(null, message);

            }
 

            }

          }

      
        } catch (Exception e) {
        e.printStackTrace();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "NO SE REGISTRO",  "Se ejecuto con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }

System.out.println("ESTAMOS SACANDO :"+producto.getIdProducto());


    }

public void eliminar_lista_productos(){
    try {

      detalleUbicacionFisicaProductoFacade.remove(detalleUbicacionFisicaProducto);
           detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisicaFacade.find(detalleInventarioUbicacionFisica.getIdDetalleInventarioUbicacionFisica());

      producto = new Producto();
      codigoBarras="";
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO",  "SE SACO EL PRODUCTO DE LA LISTA");
        FacesContext.getCurrentInstance().addMessage(null, message);


    } catch (Exception e) {
    }

}

public String volver_inventario_ubicacion(){
    inventarioFisico = inventarioFisicoFacade.find(inventarioFisico.getIdInventarioFisico());

return "editar_inventarios_fisicos?faces-redirect=true";
}

public String volver_inventario(){
return "inventarios_fisicos?faces-redirect=true";
}

public String volver_fecha_vencimiento(){
return "index?faces-redirect=true";
}
public int getTotalProductosLista(){
int total =0;
 for(DetalleUbicacionFisicaProducto deta: detalleInventarioUbicacionFisica.getDetalleUbicacionFisicaProductoList()){
    total = total + deta.getCantidad();
     }
 return total;
}

public String RegistrarSistema(){

    try {
        inventarioSistema = new InventarioInicialSistema();
        inventarioSistema.setInventarioFisico(inventarioFisico);
        inventarioSistema.setFechaRegistro(new Date());
        inventarioSistema.setObervaciones("");

        inventarioInicialSistemaFacade.create(inventarioSistema);
     //   System.out.println("TESTEEEEEEEEE cuantas veces ????");

    } catch (Exception e) {
    }
 return "inventarios_fisicos?faces-redirect=true";

}
}
