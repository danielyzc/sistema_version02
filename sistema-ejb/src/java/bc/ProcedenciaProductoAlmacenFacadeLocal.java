/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ProcedenciaProductoAlmacen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ProcedenciaProductoAlmacenFacadeLocal {

    void create(ProcedenciaProductoAlmacen procedenciaProductoAlmacen);

    void edit(ProcedenciaProductoAlmacen procedenciaProductoAlmacen);

    void remove(ProcedenciaProductoAlmacen procedenciaProductoAlmacen);

    ProcedenciaProductoAlmacen find(Object id);

    List<ProcedenciaProductoAlmacen> findAll();

    List<ProcedenciaProductoAlmacen> findRange(int[] range);

    int count();
    
}
