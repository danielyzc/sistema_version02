/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoFacturaVentaCredito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PagoFacturaVentaCreditoFacade extends AbstractFacade<PagoFacturaVentaCredito> implements PagoFacturaVentaCreditoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagoFacturaVentaCreditoFacade() {
        super(PagoFacturaVentaCredito.class);
    }
    
}
