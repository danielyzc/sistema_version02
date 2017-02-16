/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IngresoProductoTienda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IngresoProductoTiendaFacade extends AbstractFacade<IngresoProductoTienda> implements IngresoProductoTiendaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoProductoTiendaFacade() {
        super(IngresoProductoTienda.class);
    }
    
}
