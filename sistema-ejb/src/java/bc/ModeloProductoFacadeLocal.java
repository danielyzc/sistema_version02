/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ModeloProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ModeloProductoFacadeLocal {

    void create(ModeloProducto modeloProducto);

    void edit(ModeloProducto modeloProducto);

    void remove(ModeloProducto modeloProducto);

    ModeloProducto find(Object id);

    List<ModeloProducto> findAll();

    List<ModeloProducto> findRange(int[] range);

    int count();
    
}
