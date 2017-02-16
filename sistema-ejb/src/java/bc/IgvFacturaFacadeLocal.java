/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IgvFactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface IgvFacturaFacadeLocal {

    void create(IgvFactura igvFactura);

    void edit(IgvFactura igvFactura);

    void remove(IgvFactura igvFactura);

    IgvFactura find(Object id);

    List<IgvFactura> findAll();

    List<IgvFactura> findRange(int[] range);

    int count();
    
}
