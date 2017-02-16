/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoServicioFacadeLocal {

    void create(TipoServicio tipoServicio);

    void edit(TipoServicio tipoServicio);

    void remove(TipoServicio tipoServicio);

    TipoServicio find(Object id);

    List<TipoServicio> findAll();

    List<TipoServicio> findRange(int[] range);

    int count();
    
}
