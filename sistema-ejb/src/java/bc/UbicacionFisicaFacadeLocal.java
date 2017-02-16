/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.UbicacionFisica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UbicacionFisicaFacadeLocal {

    void create(UbicacionFisica ubicacionFisica);

    void edit(UbicacionFisica ubicacionFisica);

    void remove(UbicacionFisica ubicacionFisica);

    UbicacionFisica find(Object id);

    List<UbicacionFisica> findAll();

    List<UbicacionFisica> findRange(int[] range);

    int count();
    
}
