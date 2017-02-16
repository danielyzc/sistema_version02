/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.InventarioFisico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class InventarioFisicoFacade extends AbstractFacade<InventarioFisico> implements InventarioFisicoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFisicoFacade() {
        super(InventarioFisico.class);
    }
    
}
