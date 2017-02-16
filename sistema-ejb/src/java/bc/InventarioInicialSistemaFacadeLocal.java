/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.InventarioInicialSistema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface InventarioInicialSistemaFacadeLocal {

    void create(InventarioInicialSistema inventarioInicialSistema);

    void edit(InventarioInicialSistema inventarioInicialSistema);

    void remove(InventarioInicialSistema inventarioInicialSistema);

    InventarioInicialSistema find(Object id);

    List<InventarioInicialSistema> findAll();

    List<InventarioInicialSistema> findRange(int[] range);

    int count();
    
}
