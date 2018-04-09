/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author root
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> buscarTerminoExacto(String campoBuscar, String terminoBusqueda, String campoOrdenar, int tipoOrden) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> registro = cq.from(entityClass);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
// TIpo de Orden: descendente=0 , ascendente =1 
// Con campo a ordenar hacemos que : cq.orderBy(cb.asc(registro.get("pkId"))); sea dinamico
        if (tipoOrden == 0) {
            cq.orderBy(cb.desc(registro.get(campoOrdenar)));
        } else {
            cq.orderBy(cb.asc(registro.get(campoOrdenar)));
        }

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("estadoExistencia"), 1),
                        getEntityManager().getCriteriaBuilder().equal(registro.get(campoBuscar), terminoBusqueda)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    public List<T> listaActivos(String campoOrdenar, int tipoOrden) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> registro = cq.from(entityClass);
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
// TIpo de Orden: descendente=0 , ascendente =1 
// Con campo a ordenar hacemos que : cq.orderBy(cb.asc(registro.get("pkId"))); sea dinamico
        if (tipoOrden == 0) {
            cq.orderBy(cb.desc(registro.get(campoOrdenar)));
        } else {
            cq.orderBy(cb.asc(registro.get(campoOrdenar)));
        }

        cq.where(
                getEntityManager().getCriteriaBuilder().and(
                        getEntityManager().getCriteriaBuilder().equal(registro.get("estadoExistencia"), 1)
                )
        );

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
}
