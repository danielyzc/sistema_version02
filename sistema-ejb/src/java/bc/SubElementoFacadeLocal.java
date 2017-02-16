/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.SubElemento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface SubElementoFacadeLocal {

    void create(SubElemento subElemento);

    void edit(SubElemento subElemento);

    void remove(SubElemento subElemento);

    SubElemento find(Object id);

    List<SubElemento> findAll();

    List<SubElemento> findRange(int[] range);

    int count();
    
}
