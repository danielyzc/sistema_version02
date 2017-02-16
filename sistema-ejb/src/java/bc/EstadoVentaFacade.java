/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoVentaFacade extends AbstractFacade<EstadoVenta> implements EstadoVentaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoVentaFacade() {
        super(EstadoVenta.class);
    }
    
}
