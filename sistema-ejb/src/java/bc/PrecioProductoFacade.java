/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PrecioProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PrecioProductoFacade extends AbstractFacade<PrecioProducto> implements PrecioProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrecioProductoFacade() {
        super(PrecioProducto.class);
    }
    
}
