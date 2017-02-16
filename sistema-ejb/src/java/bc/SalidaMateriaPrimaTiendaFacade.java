/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.SalidaMateriaPrimaTienda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class SalidaMateriaPrimaTiendaFacade extends AbstractFacade<SalidaMateriaPrimaTienda> implements SalidaMateriaPrimaTiendaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalidaMateriaPrimaTiendaFacade() {
        super(SalidaMateriaPrimaTienda.class);
    }
    
}
