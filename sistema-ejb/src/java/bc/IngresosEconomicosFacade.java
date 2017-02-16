/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IngresosEconomicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IngresosEconomicosFacade extends AbstractFacade<IngresosEconomicos> implements IngresosEconomicosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresosEconomicosFacade() {
        super(IngresosEconomicos.class);
    }
    
}
