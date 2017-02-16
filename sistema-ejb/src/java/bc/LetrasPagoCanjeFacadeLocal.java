/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.LetrasPagoCanje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface LetrasPagoCanjeFacadeLocal {

    void create(LetrasPagoCanje letrasPagoCanje);

    void edit(LetrasPagoCanje letrasPagoCanje);

    void remove(LetrasPagoCanje letrasPagoCanje);

    LetrasPagoCanje find(Object id);

    List<LetrasPagoCanje> findAll();

    List<LetrasPagoCanje> findRange(int[] range);

    int count();
    
}
