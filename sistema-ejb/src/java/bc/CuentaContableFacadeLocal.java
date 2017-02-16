/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.CuentaContable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CuentaContableFacadeLocal {

    void create(CuentaContable cuentaContable);

    void edit(CuentaContable cuentaContable);

    void remove(CuentaContable cuentaContable);

    CuentaContable find(Object id);

    List<CuentaContable> findAll();

    List<CuentaContable> findRange(int[] range);

    int count();
    
}
