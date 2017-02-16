/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoLetrasPagoCanje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoLetrasPagoCanjeFacade extends AbstractFacade<EstadoLetrasPagoCanje> implements EstadoLetrasPagoCanjeFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoLetrasPagoCanjeFacade() {
        super(EstadoLetrasPagoCanje.class);
    }
    
}
