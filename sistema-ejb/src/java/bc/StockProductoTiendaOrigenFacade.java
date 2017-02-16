/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.StockProductoTiendaOrigen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class StockProductoTiendaOrigenFacade extends AbstractFacade<StockProductoTiendaOrigen> implements StockProductoTiendaOrigenFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockProductoTiendaOrigenFacade() {
        super(StockProductoTiendaOrigen.class);
    }
    
}
