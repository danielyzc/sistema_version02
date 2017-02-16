/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.GrupoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GrupoUsuarioFacadeLocal {

    void create(GrupoUsuario grupoUsuario);

    void edit(GrupoUsuario grupoUsuario);

    void remove(GrupoUsuario grupoUsuario);

    GrupoUsuario find(Object id);

    List<GrupoUsuario> findAll();

    List<GrupoUsuario> findRange(int[] range);

    int count();
    
}
