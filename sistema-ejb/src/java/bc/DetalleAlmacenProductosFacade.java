/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductos;
import be.DetalleAlmacenProductos_;
import be.Producto;
import be.Tienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author root
 */
@Stateless
public class DetalleAlmacenProductosFacade extends AbstractFacade<DetalleAlmacenProductos> implements DetalleAlmacenProductosFacadeLocal {

    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleAlmacenProductosFacade() {
        super(DetalleAlmacenProductos.class);
    }

    @Override
    public List<DetalleAlmacenProductos> lista_para_stock_tienda(Tienda t, Producto p) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<DetalleAlmacenProductos> registro = cq.from(DetalleAlmacenProductos.class);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(DetalleAlmacenProductos_.tienda), t),
                        getEntityManager().getCriteriaBuilder().equal(registro.get(DetalleAlmacenProductos_.producto), p),
                        getEntityManager().getCriteriaBuilder().gt(registro.get(DetalleAlmacenProductos_.quedaron), 0)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
}
