/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFumigacionProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleFumigacionProductoFacade extends AbstractFacade<DetalleFumigacionProducto> implements DetalleFumigacionProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFumigacionProductoFacade() {
        super(DetalleFumigacionProducto.class);
    }
    
}
