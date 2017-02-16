/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ReporteFumigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ReporteFumigacionFacadeLocal {

    void create(ReporteFumigacion reporteFumigacion);

    void edit(ReporteFumigacion reporteFumigacion);

    void remove(ReporteFumigacion reporteFumigacion);

    ReporteFumigacion find(Object id);

    List<ReporteFumigacion> findAll();

    List<ReporteFumigacion> findRange(int[] range);

    int count();
    
}
