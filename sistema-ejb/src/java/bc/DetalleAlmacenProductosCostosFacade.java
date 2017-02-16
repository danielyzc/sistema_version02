/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductosCostos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleAlmacenProductosCostosFacade extends AbstractFacade<DetalleAlmacenProductosCostos> implements DetalleAlmacenProductosCostosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleAlmacenProductosCostosFacade() {
        super(DetalleAlmacenProductosCostos.class);
    }
    
}
