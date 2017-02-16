/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoProductoCostoAlmacen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoProductoCostoAlmacenFacade extends AbstractFacade<EstadoProductoCostoAlmacen> implements EstadoProductoCostoAlmacenFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoProductoCostoAlmacenFacade() {
        super(EstadoProductoCostoAlmacen.class);
    }
    
}
