/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetallePromocionProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetallePromocionProductoFacadeLocal {

    void create(DetallePromocionProducto detallePromocionProducto);

    void edit(DetallePromocionProducto detallePromocionProducto);

    void remove(DetallePromocionProducto detallePromocionProducto);

    DetallePromocionProducto find(Object id);

    List<DetallePromocionProducto> findAll();

    List<DetallePromocionProducto> findRange(int[] range);

    int count();
    
}
