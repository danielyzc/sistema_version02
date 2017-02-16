/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.MotivoTransladoFactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MotivoTransladoFacturaFacadeLocal {

    void create(MotivoTransladoFactura motivoTransladoFactura);

    void edit(MotivoTransladoFactura motivoTransladoFactura);

    void remove(MotivoTransladoFactura motivoTransladoFactura);

    MotivoTransladoFactura find(Object id);

    List<MotivoTransladoFactura> findAll();

    List<MotivoTransladoFactura> findRange(int[] range);

    int count();
    
}
