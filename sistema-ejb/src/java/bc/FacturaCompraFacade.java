/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.FacturaCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FacturaCompraFacade extends AbstractFacade<FacturaCompra> implements FacturaCompraFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaCompraFacade() {
        super(FacturaCompra.class);
    }
    
}
