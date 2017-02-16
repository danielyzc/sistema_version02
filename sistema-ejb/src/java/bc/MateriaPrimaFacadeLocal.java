/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.MateriaPrima;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MateriaPrimaFacadeLocal {

    void create(MateriaPrima materiaPrima);

    void edit(MateriaPrima materiaPrima);

    void remove(MateriaPrima materiaPrima);

    MateriaPrima find(Object id);

    List<MateriaPrima> findAll();

    List<MateriaPrima> findRange(int[] range);

    int count();
    
}
