
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ClientePotencialFacadeLocal;
import be.ClientePotencial;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */


@ManagedBean
@SessionScoped
public class ManagedBeanClientePonecial implements Serializable{
    @EJB
    private ClientePotencialFacadeLocal clientePotencialFacade;

    private  ClientePotencial cliente_potencial;
     private List<ClientePotencial> lista;
    public ManagedBeanClientePonecial() {
        cliente_potencial = new ClientePotencial();
        lista = new LinkedList<ClientePotencial>();

    }


    public String nuevo(){
        cliente_potencial = new ClientePotencial();
        cliente_potencial.setFechaRegistro(new Date());
        cliente_potencial.setFechaCumpleanios(new Date());
    return "nuevo_cliente_potencial";
    }
    
    public String Clientes(){
    return "clientes_potenciales";
    }

    public String crear(){

        try {
            clientePotencialFacade.create(cliente_potencial);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return "clientes_potenciales?faces-redirect=true";
    }

    public ClientePotencial getCliente_potencial() {
        return cliente_potencial;
    }

    public void setCliente_potencial(ClientePotencial cliente_potencial) {
        this.cliente_potencial = cliente_potencial;
    }

    public List<ClientePotencial> getLista() {
        try {
        lista =    clientePotencialFacade.findAll();
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<ClientePotencial> lista) {
        this.lista = lista;
    }

}
