/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ClientePotencial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ClientePotencialFacadeLocal {

    void create(ClientePotencial clientePotencial);

    void edit(ClientePotencial clientePotencial);

    void remove(ClientePotencial clientePotencial);

    ClientePotencial find(Object id);

    List<ClientePotencial> findAll();

    List<ClientePotencial> findRange(int[] range);

    int count();
    
}
