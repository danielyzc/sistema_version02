/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleVentaRapidaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleVentaRapidaProductoFacade extends AbstractFacade<DetalleVentaRapidaProducto> implements DetalleVentaRapidaProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaRapidaProductoFacade() {
        super(DetalleVentaRapidaProducto.class);
    }
    
}
