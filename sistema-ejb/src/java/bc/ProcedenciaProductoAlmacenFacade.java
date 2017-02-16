/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ProcedenciaProductoAlmacen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ProcedenciaProductoAlmacenFacade extends AbstractFacade<ProcedenciaProductoAlmacen> implements ProcedenciaProductoAlmacenFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcedenciaProductoAlmacenFacade() {
        super(ProcedenciaProductoAlmacen.class);
    }
    
}
