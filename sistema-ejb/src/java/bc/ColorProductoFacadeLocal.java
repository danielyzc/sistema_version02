/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ColorProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ColorProductoFacadeLocal {

    void create(ColorProducto colorProducto);

    void edit(ColorProducto colorProducto);

    void remove(ColorProducto colorProducto);

    ColorProducto find(Object id);

    List<ColorProducto> findAll();

    List<ColorProducto> findRange(int[] range);

    int count();
    
}
