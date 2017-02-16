/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Negocio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface NegocioFacadeLocal {

    void create(Negocio negocio);

    void edit(Negocio negocio);

    void remove(Negocio negocio);

    Negocio find(Object id);

    List<Negocio> findAll();

    List<Negocio> findRange(int[] range);

    int count();
    
}
