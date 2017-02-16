/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFacturaVentaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleFacturaVentaProductoFacade extends AbstractFacade<DetalleFacturaVentaProducto> implements DetalleFacturaVentaProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaVentaProductoFacade() {
        super(DetalleFacturaVentaProducto.class);
    }
    
}
