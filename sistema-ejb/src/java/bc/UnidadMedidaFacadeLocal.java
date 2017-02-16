/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.UnidadMedida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UnidadMedidaFacadeLocal {

    void create(UnidadMedida unidadMedida);

    void edit(UnidadMedida unidadMedida);

    void remove(UnidadMedida unidadMedida);

    UnidadMedida find(Object id);

    List<UnidadMedida> findAll();

    List<UnidadMedida> findRange(int[] range);

    int count();
    
}
