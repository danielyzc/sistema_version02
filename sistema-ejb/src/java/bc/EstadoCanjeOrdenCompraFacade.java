/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoCanjeOrdenCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoCanjeOrdenCompraFacade extends AbstractFacade<EstadoCanjeOrdenCompra> implements EstadoCanjeOrdenCompraFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCanjeOrdenCompraFacade() {
        super(EstadoCanjeOrdenCompra.class);
    }
    
}
