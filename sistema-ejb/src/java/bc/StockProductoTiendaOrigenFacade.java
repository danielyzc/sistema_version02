/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Producto;
import be.StockProductoTiendaOrigen;
import be.StockProductoTiendaOrigenPK;
import be.StockProductoTiendaOrigen_;
import be.Tienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class StockProductoTiendaOrigenFacade extends AbstractFacade<StockProductoTiendaOrigen> implements StockProductoTiendaOrigenFacadeLocal {

    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockProductoTiendaOrigenFacade() {
        super(StockProductoTiendaOrigen.class);
    }

    @Override
    public List<StockProductoTiendaOrigen> lista_stock_tienda_producto(Tienda t, Producto p) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<StockProductoTiendaOrigen> registro = cq.from(StockProductoTiendaOrigen.class);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(StockProductoTiendaOrigen_.tienda), t),
                        getEntityManager().getCriteriaBuilder().equal(registro.get(StockProductoTiendaOrigen_.producto), p)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    @Override
    public List<StockProductoTiendaOrigen> lista_stock_producto(Producto p) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<StockProductoTiendaOrigen> registro = cq.from(StockProductoTiendaOrigen.class);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(StockProductoTiendaOrigen_.producto), p)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    @Override
    public List<StockProductoTiendaOrigen> lista_stock_tienda(Tienda t) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<StockProductoTiendaOrigen> registro = cq.from(StockProductoTiendaOrigen.class);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get(StockProductoTiendaOrigen_.tienda), t),
                        getEntityManager().getCriteriaBuilder().gt(registro.get(StockProductoTiendaOrigen_.cantidad), 0)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    @Override
    public List<Object[]> consulta_webservice(String parametro_) {
        String consulta = "select t.id_tienda,concat('( ',sk.cantidad,' ) ',p.nombre_producto,'  [',t.nombre_tienda,']')  as data from stock_producto_tienda_origen sk inner join tienda t\n"
                + "on sk.id_tienda_origen = t.id_tienda\n"
                + "inner join producto p on sk.id_producto = p.id_producto\n"
                + "where p.nombre_producto LIKE '" + parametro_ + "'";
        //System.out.println("EJECUTANDO - "+consulta);
        Query q = getEntityManager().createNativeQuery(consulta);
        List<Object[]> resultado = q.getResultList();
        return resultado;
    }
}
