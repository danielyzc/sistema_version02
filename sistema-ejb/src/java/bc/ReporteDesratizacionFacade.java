/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ReporteDesratizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ReporteDesratizacionFacade extends AbstractFacade<ReporteDesratizacion> implements ReporteDesratizacionFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteDesratizacionFacade() {
        super(ReporteDesratizacion.class);
    }
    
}
