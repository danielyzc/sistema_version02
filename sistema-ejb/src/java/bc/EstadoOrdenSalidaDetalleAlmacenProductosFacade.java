/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoOrdenSalidaDetalleAlmacenProductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoOrdenSalidaDetalleAlmacenProductosFacade extends AbstractFacade<EstadoOrdenSalidaDetalleAlmacenProductos> implements EstadoOrdenSalidaDetalleAlmacenProductosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoOrdenSalidaDetalleAlmacenProductosFacade() {
        super(EstadoOrdenSalidaDetalleAlmacenProductos.class);
    }
    
}
