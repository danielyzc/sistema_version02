/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.StockMateriaPrimaTiendaOrigen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class StockMateriaPrimaTiendaOrigenFacade extends AbstractFacade<StockMateriaPrimaTiendaOrigen> implements StockMateriaPrimaTiendaOrigenFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockMateriaPrimaTiendaOrigenFacade() {
        super(StockMateriaPrimaTiendaOrigen.class);
    }
    
}
