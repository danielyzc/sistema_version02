/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleUbicacionFisicaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleUbicacionFisicaProductoFacadeLocal {

    void create(DetalleUbicacionFisicaProducto detalleUbicacionFisicaProducto);

    void edit(DetalleUbicacionFisicaProducto detalleUbicacionFisicaProducto);

    void remove(DetalleUbicacionFisicaProducto detalleUbicacionFisicaProducto);

    DetalleUbicacionFisicaProducto find(Object id);

    List<DetalleUbicacionFisicaProducto> findAll();

    List<DetalleUbicacionFisicaProducto> findRange(int[] range);

    int count();
    
}
