/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.FacturaVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FacturaVentaFacade extends AbstractFacade<FacturaVenta> implements FacturaVentaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaVentaFacade() {
        super(FacturaVenta.class);
    }
    
}
