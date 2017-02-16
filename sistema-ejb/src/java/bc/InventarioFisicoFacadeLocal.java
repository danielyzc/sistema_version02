/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.InventarioFisico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface InventarioFisicoFacadeLocal {

    void create(InventarioFisico inventarioFisico);

    void edit(InventarioFisico inventarioFisico);

    void remove(InventarioFisico inventarioFisico);

    InventarioFisico find(Object id);

    List<InventarioFisico> findAll();

    List<InventarioFisico> findRange(int[] range);

    int count();
    
}
