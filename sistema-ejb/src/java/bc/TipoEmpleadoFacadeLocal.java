/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoEmpleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoEmpleadoFacadeLocal {

    void create(TipoEmpleado tipoEmpleado);

    void edit(TipoEmpleado tipoEmpleado);

    void remove(TipoEmpleado tipoEmpleado);

    TipoEmpleado find(Object id);

    List<TipoEmpleado> findAll();

    List<TipoEmpleado> findRange(int[] range);

    int count();
    
}
