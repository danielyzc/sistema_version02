/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.MaterialProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class MaterialProductoFacade extends AbstractFacade<MaterialProducto> implements MaterialProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialProductoFacade() {
        super(MaterialProducto.class);
    }
    
}
