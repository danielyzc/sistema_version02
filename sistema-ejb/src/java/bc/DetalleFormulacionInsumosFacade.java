/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFormulacionInsumos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleFormulacionInsumosFacade extends AbstractFacade<DetalleFormulacionInsumos> implements DetalleFormulacionInsumosFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFormulacionInsumosFacade() {
        super(DetalleFormulacionInsumos.class);
    }
    
}
