/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PrestamoProductoTiendaUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PrestamoProductoTiendaUsuarioFacadeLocal {

    void create(PrestamoProductoTiendaUsuario prestamoProductoTiendaUsuario);

    void edit(PrestamoProductoTiendaUsuario prestamoProductoTiendaUsuario);

    void remove(PrestamoProductoTiendaUsuario prestamoProductoTiendaUsuario);

    PrestamoProductoTiendaUsuario find(Object id);

    List<PrestamoProductoTiendaUsuario> findAll();

    List<PrestamoProductoTiendaUsuario> findRange(int[] range);

    int count();
    
}
