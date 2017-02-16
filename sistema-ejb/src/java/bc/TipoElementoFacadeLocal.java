/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoElemento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoElementoFacadeLocal {

    void create(TipoElemento tipoElemento);

    void edit(TipoElemento tipoElemento);

    void remove(TipoElemento tipoElemento);

    TipoElemento find(Object id);

    List<TipoElemento> findAll();

    List<TipoElemento> findRange(int[] range);

    int count();
    
}
