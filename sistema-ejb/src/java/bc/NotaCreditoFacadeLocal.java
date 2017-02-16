/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.NotaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface NotaCreditoFacadeLocal {

    void create(NotaCredito notaCredito);

    void edit(NotaCredito notaCredito);

    void remove(NotaCredito notaCredito);

    NotaCredito find(Object id);

    List<NotaCredito> findAll();

    List<NotaCredito> findRange(int[] range);

    int count();
    
}
