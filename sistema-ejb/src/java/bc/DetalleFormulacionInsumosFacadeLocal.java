/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFormulacionInsumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleFormulacionInsumosFacadeLocal {

    void create(DetalleFormulacionInsumos detalleFormulacionInsumos);

    void edit(DetalleFormulacionInsumos detalleFormulacionInsumos);

    void remove(DetalleFormulacionInsumos detalleFormulacionInsumos);

    DetalleFormulacionInsumos find(Object id);

    List<DetalleFormulacionInsumos> findAll();

    List<DetalleFormulacionInsumos> findRange(int[] range);

    int count();
    
}
