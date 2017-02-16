/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoClienteFacadeLocal {

    void create(TipoCliente tipoCliente);

    void edit(TipoCliente tipoCliente);

    void remove(TipoCliente tipoCliente);

    TipoCliente find(Object id);

    List<TipoCliente> findAll();

    List<TipoCliente> findRange(int[] range);

    int count();
    
}
