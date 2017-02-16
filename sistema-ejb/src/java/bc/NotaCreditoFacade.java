/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.NotaCredito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class NotaCreditoFacade extends AbstractFacade<NotaCredito> implements NotaCreditoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaCreditoFacade() {
        super(NotaCredito.class);
    }
    
}
