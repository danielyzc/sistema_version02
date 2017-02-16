/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoFacturacionOrdenCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EstadoFacturacionOrdenCompraFacade extends AbstractFacade<EstadoFacturacionOrdenCompra> implements EstadoFacturacionOrdenCompraFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacturacionOrdenCompraFacade() {
        super(EstadoFacturacionOrdenCompra.class);
    }
    
}
