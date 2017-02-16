/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PrestamoProductoTiendaUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PrestamoProductoTiendaUsuarioFacade extends AbstractFacade<PrestamoProductoTiendaUsuario> implements PrestamoProductoTiendaUsuarioFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoProductoTiendaUsuarioFacade() {
        super(PrestamoProductoTiendaUsuario.class);
    }
    
}
