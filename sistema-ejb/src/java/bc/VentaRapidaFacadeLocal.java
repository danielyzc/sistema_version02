/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.VentaRapida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface VentaRapidaFacadeLocal {

    void create(VentaRapida ventaRapida);

    void edit(VentaRapida ventaRapida);

    void remove(VentaRapida ventaRapida);

    VentaRapida find(Object id);

    List<VentaRapida> findAll();

    List<VentaRapida> findRange(int[] range);

    int count();
    
}
