/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.UnidadTransporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class UnidadTransporteFacade extends AbstractFacade<UnidadTransporte> implements UnidadTransporteFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadTransporteFacade() {
        super(UnidadTransporte.class);
    }
    
}
