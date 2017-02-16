/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Grupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GrupoFacadeLocal {

    void create(Grupo grupo);

    void edit(Grupo grupo);

    void remove(Grupo grupo);

    Grupo find(Object id);

    List<Grupo> findAll();

    List<Grupo> findRange(int[] range);

    int count();
    
}
