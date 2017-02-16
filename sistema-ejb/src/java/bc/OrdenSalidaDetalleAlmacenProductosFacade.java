/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.OrdenSalidaDetalleAlmacenProductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class OrdenSalidaDetalleAlmacenProductosFacade extends AbstractFacade<OrdenSalidaDetalleAlmacenProductos> implements OrdenSalidaDetalleAlmacenProductosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenSalidaDetalleAlmacenProductosFacade() {
        super(OrdenSalidaDetalleAlmacenProductos.class);
    }
    
}
