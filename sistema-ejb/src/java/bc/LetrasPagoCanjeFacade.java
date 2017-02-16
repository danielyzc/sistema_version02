/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.LetrasPagoCanje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class LetrasPagoCanjeFacade extends AbstractFacade<LetrasPagoCanje> implements LetrasPagoCanjeFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LetrasPagoCanjeFacade() {
        super(LetrasPagoCanje.class);
    }
    
}
