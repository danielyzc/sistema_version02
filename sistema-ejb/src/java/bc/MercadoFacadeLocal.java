/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Mercado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MercadoFacadeLocal {

    void create(Mercado mercado);

    void edit(Mercado mercado);

    void remove(Mercado mercado);

    Mercado find(Object id);

    List<Mercado> findAll();

    List<Mercado> findRange(int[] range);

    int count();
    
}
