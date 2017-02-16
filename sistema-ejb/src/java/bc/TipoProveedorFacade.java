/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoProveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoProveedorFacade extends AbstractFacade<TipoProveedor> implements TipoProveedorFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProveedorFacade() {
        super(TipoProveedor.class);
    }
    
}
