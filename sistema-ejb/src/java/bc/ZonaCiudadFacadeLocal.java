/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ZonaCiudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ZonaCiudadFacadeLocal {

    void create(ZonaCiudad zonaCiudad);

    void edit(ZonaCiudad zonaCiudad);

    void remove(ZonaCiudad zonaCiudad);

    ZonaCiudad find(Object id);

    List<ZonaCiudad> findAll();

    List<ZonaCiudad> findRange(int[] range);

    int count();
    
}
