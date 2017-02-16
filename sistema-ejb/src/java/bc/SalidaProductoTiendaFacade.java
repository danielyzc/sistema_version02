/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.SalidaProductoTienda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class SalidaProductoTiendaFacade extends AbstractFacade<SalidaProductoTienda> implements SalidaProductoTiendaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalidaProductoTiendaFacade() {
        super(SalidaProductoTienda.class);
    }
    
}
