
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.DesarrolladorFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import be.Desarrollador;
import java.util.LinkedList;
import java.util.List;
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
public class ManagedBeanDesarrollador implements Serializable{
    @EJB
    private DesarrolladorFacadeLocal desarrolladorFacade;
private Desarrollador desarrollador ;
 private List<Desarrollador> lista;

    public ManagedBeanDesarrollador() {
        desarrollador = new Desarrollador();
        lista = new LinkedList<Desarrollador>();
    }

public Desarrollador getDesarrollador() {
        try {
        for(Desarrollador d: desarrolladorFacade.findAll()) {

        desarrollador = d;
        }
        } catch (Exception e) {
        }
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    
}
