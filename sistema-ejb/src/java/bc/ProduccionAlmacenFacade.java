/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ProduccionAlmacen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ProduccionAlmacenFacade extends AbstractFacade<ProduccionAlmacen> implements ProduccionAlmacenFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduccionAlmacenFacade() {
        super(ProduccionAlmacen.class);
    }
    
}
