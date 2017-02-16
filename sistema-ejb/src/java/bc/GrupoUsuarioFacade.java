/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.GrupoUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class GrupoUsuarioFacade extends AbstractFacade<GrupoUsuario> implements GrupoUsuarioFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoUsuarioFacade() {
        super(GrupoUsuario.class);
    }
    
}
