/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoVentaCredito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PagoVentaCreditoFacade extends AbstractFacade<PagoVentaCredito> implements PagoVentaCreditoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagoVentaCreditoFacade() {
        super(PagoVentaCredito.class);
    }
    
}
