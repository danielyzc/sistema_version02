/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoPlaga;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoPlagaFacadeLocal {

    void create(TipoPlaga tipoPlaga);

    void edit(TipoPlaga tipoPlaga);

    void remove(TipoPlaga tipoPlaga);

    TipoPlaga find(Object id);

    List<TipoPlaga> findAll();

    List<TipoPlaga> findRange(int[] range);

    int count();
    
}
