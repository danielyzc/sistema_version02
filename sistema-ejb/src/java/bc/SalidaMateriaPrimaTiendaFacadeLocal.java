/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.SalidaMateriaPrimaTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface SalidaMateriaPrimaTiendaFacadeLocal {

    void create(SalidaMateriaPrimaTienda salidaMateriaPrimaTienda);

    void edit(SalidaMateriaPrimaTienda salidaMateriaPrimaTienda);

    void remove(SalidaMateriaPrimaTienda salidaMateriaPrimaTienda);

    SalidaMateriaPrimaTienda find(Object id);

    List<SalidaMateriaPrimaTienda> findAll();

    List<SalidaMateriaPrimaTienda> findRange(int[] range);

    int count();
    
}
