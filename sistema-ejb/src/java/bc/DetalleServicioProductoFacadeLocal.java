/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleServicioProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleServicioProductoFacadeLocal {

    void create(DetalleServicioProducto detalleServicioProducto);

    void edit(DetalleServicioProducto detalleServicioProducto);

    void remove(DetalleServicioProducto detalleServicioProducto);

    DetalleServicioProducto find(Object id);

    List<DetalleServicioProducto> findAll();

    List<DetalleServicioProducto> findRange(int[] range);

    int count();
    
}
