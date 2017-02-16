
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.MateriaPrimaFacadeLocal;
import be.DetalleFormulacionInsumos;
import be.MateriaPrima;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class ManagedBeanMateriaPrima implements Serializable{

     @EJB
   private MateriaPrimaFacadeLocal materiaPrimaFacade;

     private List<MateriaPrima> lista;
   private MateriaPrima materia;

 private List<SelectItem> materiaItems = new LinkedList<SelectItem>();
private HashMap<Integer, MateriaPrima> mymateria = new HashMap<Integer,MateriaPrima>();
    public ManagedBeanMateriaPrima() {
        lista = new LinkedList<MateriaPrima>();
    materia = new MateriaPrima();
  
    }

 
    public List<MateriaPrima> getLista() {
         try {
        lista=new LinkedList<MateriaPrima>();
     List<MateriaPrima> lista_temp= new LinkedList<MateriaPrima>();
     lista_temp =materiaPrimaFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
         
             lista.add(lista_temp.get(i));
                  }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
    }

    public void setLista(List<MateriaPrima> lista) {
        this.lista = lista;
    }

    public MateriaPrima getMateria() {
        return materia;
    }

    public void setMateria(MateriaPrima materia) {
        this.materia = materia;
    }

    public List<SelectItem> getMateriaItems() {

        lista = new ArrayList<MateriaPrima>();
        materiaItems = new LinkedList<SelectItem>();
        lista = materiaPrimaFacade.findAll();
        for(MateriaPrima p: lista){
        mymateria.put(p.getIdMateriaPrima(), p);
           materiaItems.add(new SelectItem(p, p.getNombreMateriaPrima()));
        }
        return materiaItems;
    }

    public void setMateriaItems(List<SelectItem> materiaItems) {
        this.materiaItems = materiaItems;
    }

    public HashMap<Integer, MateriaPrima> getMymateria() {
        return mymateria;
    }

    public void setMymateria(HashMap<Integer, MateriaPrima> mymateria) {
        this.mymateria = mymateria;
    }


public MateriaPrima getMateriaPrima(Integer id) {
           return (MateriaPrima) mymateria.get(id);

    }



public String Nuevo(){
 materia = new MateriaPrima();
 return "nueva_materia_prima";
 }
public void newObject(){
   materia = new MateriaPrima();
    }

 public String crear(){
     try {

      materiaPrimaFacade.create(materia);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "materias_primas?faces-redirect=true";

 }


 public String editar(){
     try {

      materiaPrimaFacade.edit(materia);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "materias_primas?faces-redirect=true";

 }

public void editarNew(){

    try {
        materiaPrimaFacade.edit(materia);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}
  public String Volver_Materia(){
return "index?faces-redirect=true";
     }

public String edicion(){
return "editar_materia_prima";
    }


public List<MateriaPrima> completar_filtrado_Materia_prima(String nombre) {
  lista = new LinkedList<MateriaPrima>();
  //this.llenar_mymateria();
 // agregado aqui 4 de abril
 // mymateria.clear();
  for(MateriaPrima p : materiaPrimaFacade.findAll()){
//  mymateria.put(p.getIdMateriaPrima(), p);
    if (p.getNombreMateriaPrima().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);
        }
    }
       return lista;
    }

public void llenar_mymateria(){
    try {

        for(MateriaPrima p : materiaPrimaFacade.findAll()){
         mymateria.put(p.getIdMateriaPrima(), p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}
public void crearNew(){

    try {

             materiaPrimaFacade.create(materia);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}
 

}
