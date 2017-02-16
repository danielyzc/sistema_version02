/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IngresoMateriaPrimaTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface IngresoMateriaPrimaTiendaFacadeLocal {

    void create(IngresoMateriaPrimaTienda ingresoMateriaPrimaTienda);

    void edit(IngresoMateriaPrimaTienda ingresoMateriaPrimaTienda);

    void remove(IngresoMateriaPrimaTienda ingresoMateriaPrimaTienda);

    IngresoMateriaPrimaTienda find(Object id);

    List<IngresoMateriaPrimaTienda> findAll();

    List<IngresoMateriaPrimaTienda> findRange(int[] range);

    int count();
    
}
