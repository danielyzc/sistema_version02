/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleInventarioUbicacionFisica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleInventarioUbicacionFisicaFacadeLocal {

    void create(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica);

    void edit(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica);

    void remove(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica);

    DetalleInventarioUbicacionFisica find(Object id);

    List<DetalleInventarioUbicacionFisica> findAll();

    List<DetalleInventarioUbicacionFisica> findRange(int[] range);

    int count();
    
}
