/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.DetallePromocionProductoFacadeLocal;
import bc.PromocionFacadeLocal;
import be.DetallePromocionProducto;
import be.Promocion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author EDINSON
 */
@ManagedBean
@SessionScoped
public class ManagedBeanPromocion implements Serializable{
    @EJB
    private DetallePromocionProductoFacadeLocal detallePromocionProductoFacade;
    @EJB
    private PromocionFacadeLocal promocionFacade;
    private Promocion promocion;
    private List<Promocion> lista;
    private DetallePromocionProducto detalle;
    private DetallePromocionProducto detalle_editar;
   private List<DetallePromocionProducto> lista_detalles;
    
    private List<DetallePromocionProducto> lista_detalles_editar;
     private List<DetallePromocionProducto> lista_detalles_editarFinal;
    
    public ManagedBeanPromocion() {
        promocion= new Promocion();
        lista = new LinkedList<Promocion>();
        detalle = new DetallePromocionProducto();
        detalle_editar = new DetallePromocionProducto();
        
        lista_detalles= new LinkedList<DetallePromocionProducto>();
        lista_detalles_editar= new LinkedList<DetallePromocionProducto>();
        lista_detalles_editarFinal= new LinkedList<DetallePromocionProducto>();
   
    }

    public DetallePromocionProducto getDetalle_editar() {
        return detalle_editar;
    }

    public void setDetalle_editar(DetallePromocionProducto detalle_editar) {
        this.detalle_editar = detalle_editar;
    }

    public List<DetallePromocionProducto> getLista_detalles_editar() {
        return lista_detalles_editar;
    }

    public void setLista_detalles_editar(List<DetallePromocionProducto> lista_detalles_editar) {
        this.lista_detalles_editar = lista_detalles_editar;
    }
    
public int tamlista(){
return lista_detalles.size();
}
public int tamlistaEditar(){
return lista_detalles_editar.size();
}
public int tamlistapROM(){
    if(promocion.getIdPromocion()!= null){
        return promocion.getDetallePromocionProductoList().size();

    
            }
    else{
    return 0;
    }
}
    public DetallePromocionProducto getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePromocionProducto detalle) {
        this.detalle = detalle;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public List<Promocion> getLista() {
        lista = new LinkedList<Promocion>();
        Date fecha_hoy =new Date();
        try {
            List<Promocion> lista_temp= new LinkedList<Promocion>();
                   lista_temp =promocionFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
              
              if(lista_temp.get(i).getEstadoPromocion()==1){
              if(lista_temp.get(i).getFechaFin().before(fecha_hoy)){
                  lista_temp.get(i).setEstadoPromocion(0);
                  promocionFacade.edit(lista_temp.get(i));
              }}
     lista.add(lista_temp.get(i));
       }  
            
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<Promocion> lista) {
        this.lista = lista;
    }
     public String editar(){
        try {
            // CREANDO AL PADRE 
          //  promocion.setDetallePromocionProductoList(new LinkedList<DetallePromocionProducto>());
           
                            
            for(DetallePromocionProducto det:lista_detalles_editar){
      
                det.setPrecioVenta(BigDecimal.ZERO);
      det.setPromocion(promocion);
      
   }
            
           promocion.setDetallePromocionProductoList(lista_detalles_editar);
           promocionFacade.edit(promocion);
            System.out.println(" se edito correctamente ");
        } catch (Exception e) {
        }
    return "promociones";
    }
    public String crear(){
        try {
            // CREANDO AL PADRE 
            promocion.setDetallePromocionProductoList(new LinkedList<DetallePromocionProducto>());
           
           promocionFacade.create(promocion);
            
            
            for(DetallePromocionProducto det:lista_detalles){
      det.setPrecioVenta(BigDecimal.ZERO);
      det.setPromocion(promocion);
      
      promocion.getDetallePromocionProductoList().add(det);
      detallePromocionProductoFacade.create(det);
   }
            
            
        } catch (Exception e) {
        }
    return "promociones?faces-redirect=true";
    }
    public String Promociones(){
        return "promociones";
        }
    
    public String Nueva(){
    promocion = new Promocion();
    promocion.setEstadoPromocion(1);
promocion.setFechaEmision(new Date());
    lista_detalles= new LinkedList<DetallePromocionProducto>();
    
    return "nueva_promocion";
    }

    public List<DetallePromocionProducto> getLista_detalles() {
        return lista_detalles;
    }

    public void setLista_detalles(List<DetallePromocionProducto> lista_detalles) {
        this.lista_detalles = lista_detalles;
    }
    
     public void agregarDetalleEditar(){
        DetallePromocionProducto detalleLista = new DetallePromocionProducto();
   detalleLista=detalle_editar;
   int bandera=0;
   
  if(lista_detalles_editar.size()>0){
   
   for(DetallePromocionProducto det:lista_detalles_editar){
   
       if(det.getProducto().getIdProducto()==detalle_editar.getProducto().getIdProducto()){
      // ESTA REPETIDO
          bandera=0; 
       }else
               {
               // aqqui 
                bandera=1;   
               }
   }
   
    if(bandera==1){
     lista_detalles_editar.add(detalleLista);
        detalle_editar =new DetallePromocionProducto();
    }
                   
   
   }else{
   
    lista_detalles_editar.add(detalleLista);
        detalle_editar =new DetallePromocionProducto();
   }
        
             System.out.println(" jojojo "+ lista_detalles_editar.size());
     lista_detalles_editarFinal=lista_detalles_editar;
    }
     
    public void agregarDetalle(){
        DetallePromocionProducto detalleLista = new DetallePromocionProducto();
   detalleLista=detalle;
   int bandera=0;
   
   if(lista_detalles.size()>0){
   
   for(DetallePromocionProducto det:lista_detalles){
   
       if(det.getProducto().getIdProducto()==detalle.getProducto().getIdProducto()){
      // ESTA REPETIDO
          bandera=0; 
       }else
               {
               // aqqui 
                bandera=1;   
               }
   }
   
    if(bandera==1){
     lista_detalles.add(detalleLista);
        detalle =new DetallePromocionProducto();
    }
                   
   
   }else{
   
    lista_detalles.add(detalleLista);
        detalle =new DetallePromocionProducto();
   }
        
        
    }
     public void removerDetalle(){
    lista_detalles.remove(detalle);
    
}
      public void removerDetalleEditar(){
    lista_detalles_editar.remove(detalle_editar);
    
}
public String edicion(){
    this.setLista_detalles_editar(promocion.getDetallePromocionProductoList());
if(lista_detalles_editar.size()>0){
detalle_editar=lista_detalles_editar.get(0);
}
   
    return "editar_promocion";
     }
}