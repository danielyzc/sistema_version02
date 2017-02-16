/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.InventarioInicialSistema;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class InventarioInicialSistemaFacade extends AbstractFacade<InventarioInicialSistema> implements InventarioInicialSistemaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioInicialSistemaFacade() {
        super(InventarioInicialSistema.class);
    }
    
}
