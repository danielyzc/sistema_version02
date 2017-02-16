/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.VentaRapida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class VentaRapidaFacade extends AbstractFacade<VentaRapida> implements VentaRapidaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaRapidaFacade() {
        super(VentaRapida.class);
    }
    
}
