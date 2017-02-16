/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.CuentaContable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CuentaContableFacade extends AbstractFacade<CuentaContable> implements CuentaContableFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaContableFacade() {
        super(CuentaContable.class);
    }
    
}
