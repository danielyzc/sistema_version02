/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleInventarioUbicacionFisica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DetalleInventarioUbicacionFisicaFacade extends AbstractFacade<DetalleInventarioUbicacionFisica> implements DetalleInventarioUbicacionFisicaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleInventarioUbicacionFisicaFacade() {
        super(DetalleInventarioUbicacionFisica.class);
    }
    
}
