/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.UnidadTransporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UnidadTransporteFacadeLocal {

    void create(UnidadTransporte unidadTransporte);

    void edit(UnidadTransporte unidadTransporte);

    void remove(UnidadTransporte unidadTransporte);

    UnidadTransporte find(Object id);

    List<UnidadTransporte> findAll();

    List<UnidadTransporte> findRange(int[] range);

    int count();
    
}
