/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TallaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TallaProductoFacadeLocal {

    void create(TallaProducto tallaProducto);

    void edit(TallaProducto tallaProducto);

    void remove(TallaProducto tallaProducto);

    TallaProducto find(Object id);

    List<TallaProducto> findAll();

    List<TallaProducto> findRange(int[] range);

    int count();
    
}
