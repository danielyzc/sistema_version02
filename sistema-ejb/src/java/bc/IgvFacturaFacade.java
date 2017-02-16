/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IgvFactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class IgvFacturaFacade extends AbstractFacade<IgvFactura> implements IgvFacturaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IgvFacturaFacade() {
        super(IgvFactura.class);
    }
    
}
