/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoFacturacionOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoFacturacionOrdenCompraFacadeLocal {

    void create(EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra);

    void edit(EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra);

    void remove(EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra);

    EstadoFacturacionOrdenCompra find(Object id);

    List<EstadoFacturacionOrdenCompra> findAll();

    List<EstadoFacturacionOrdenCompra> findRange(int[] range);

    int count();
    
}
