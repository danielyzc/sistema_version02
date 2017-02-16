/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ReporteDesratizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ReporteDesratizacionFacadeLocal {

    void create(ReporteDesratizacion reporteDesratizacion);

    void edit(ReporteDesratizacion reporteDesratizacion);

    void remove(ReporteDesratizacion reporteDesratizacion);

    ReporteDesratizacion find(Object id);

    List<ReporteDesratizacion> findAll();

    List<ReporteDesratizacion> findRange(int[] range);

    int count();
    
}
