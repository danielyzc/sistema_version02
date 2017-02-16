/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleVentaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleVentaProductoFacade extends AbstractFacade<DetalleVentaProducto> implements DetalleVentaProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaProductoFacade() {
        super(DetalleVentaProducto.class);
    }
    
}
