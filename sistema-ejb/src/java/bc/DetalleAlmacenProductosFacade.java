/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleAlmacenProductosFacade extends AbstractFacade<DetalleAlmacenProductos> implements DetalleAlmacenProductosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleAlmacenProductosFacade() {
        super(DetalleAlmacenProductos.class);
    }
    
}
