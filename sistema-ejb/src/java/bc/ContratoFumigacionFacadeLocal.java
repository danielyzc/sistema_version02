/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ContratoFumigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ContratoFumigacionFacadeLocal {

    void create(ContratoFumigacion contratoFumigacion);

    void edit(ContratoFumigacion contratoFumigacion);

    void remove(ContratoFumigacion contratoFumigacion);

    ContratoFumigacion find(Object id);

    List<ContratoFumigacion> findAll();

    List<ContratoFumigacion> findRange(int[] range);

    int count();
    
}
