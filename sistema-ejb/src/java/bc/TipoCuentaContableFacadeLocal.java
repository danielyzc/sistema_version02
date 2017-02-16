/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoCuentaContable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoCuentaContableFacadeLocal {

    void create(TipoCuentaContable tipoCuentaContable);

    void edit(TipoCuentaContable tipoCuentaContable);

    void remove(TipoCuentaContable tipoCuentaContable);

    TipoCuentaContable find(Object id);

    List<TipoCuentaContable> findAll();

    List<TipoCuentaContable> findRange(int[] range);

    int count();
    
}
