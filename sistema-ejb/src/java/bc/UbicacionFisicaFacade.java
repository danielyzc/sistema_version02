/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.UbicacionFisica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class UbicacionFisicaFacade extends AbstractFacade<UbicacionFisica> implements UbicacionFisicaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicacionFisicaFacade() {
        super(UbicacionFisica.class);
    }
    
}
