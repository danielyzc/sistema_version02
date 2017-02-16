
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.ActividadFacadeLocal;
import be.Actividad;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;

import org.primefaces.model.DefaultScheduleEvent;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
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
public class ManagedBeanActividad implements Serializable{
    @EJB
    private ActividadFacadeLocal actividadFacade;

    private Actividad actividad;
    private List<Actividad> lista;

    private List<Actividad> lista_lunes;
    private List<Actividad> lista_martes;
    private List<Actividad> lista_miercoles;
     private List<Actividad> lista_jueves;
    private List<Actividad> lista_viernes;
    private List<Actividad> lista_sabado;
    private List<Actividad> lista_domingo;
     private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private String theme;
    private Date fecha_inicial;
    private Date fecha_final;

         private   SimpleDateFormat fecha_lista = new SimpleDateFormat("EEEE");
          private  StringBuilder cadena_lista = new StringBuilder();
    public ManagedBeanActividad() {
        actividad = new Actividad();
        lista = new LinkedList<Actividad>();


        lista_lunes = new LinkedList<Actividad>();
        lista_martes = new LinkedList<Actividad>();
        lista_miercoles = new LinkedList<Actividad>();
        lista_jueves = new LinkedList<Actividad>();
        lista_viernes = new LinkedList<Actividad>();
        lista_sabado = new LinkedList<Actividad>();
        lista_domingo = new LinkedList<Actividad>();

        fecha_inicial = new Date();
        fecha_final = new Date();
         eventModel = new DefaultScheduleModel();

           lazyEventModel = new LazyScheduleModel() {


            public void fetchEvents(Date start, Date end) {
                clear();
            }
        };
    }

    public List<Actividad> getLista_domingo() {
         this.getLista_ordenada(lista_domingo);
        return lista_domingo;
    }

    public void setLista_domingo(List<Actividad> lista_domingo) {
        this.lista_domingo = lista_domingo;
    }

    public List<Actividad> getLista_jueves() {
         this.getLista_ordenada(lista_jueves);
        return lista_jueves;
    }

    public void setLista_jueves(List<Actividad> lista_jueves) {
        this.lista_jueves = lista_jueves;
    }

    public List<Actividad> getLista_lunes() {
         this.getLista_ordenada(lista_lunes);
        return lista_lunes;
    }

    public void setLista_lunes(List<Actividad> lista_lunes) {
        this.lista_lunes = lista_lunes;
    }

    public List<Actividad> getLista_martes() {
         this.getLista_ordenada(lista_martes);
        return lista_martes;
    }

    public void setLista_martes(List<Actividad> lista_martes) {
        this.lista_martes = lista_martes;
    }

    public List<Actividad> getLista_miercoles() {
         this.getLista_ordenada(lista_miercoles);
        return lista_miercoles;
    }

    public void setLista_miercoles(List<Actividad> lista_miercoles) {
        this.lista_miercoles = lista_miercoles;
    }

    public List<Actividad> getLista_sabado() {
         this.getLista_ordenada(lista_sabado);
        return lista_sabado;
    }

    public void setLista_sabado(List<Actividad> lista_sabado) {
        this.lista_sabado = lista_sabado;
    }

    public List<Actividad> getLista_viernes() {
        this.getLista_ordenada(lista_viernes);
        return lista_viernes;
    }

    public void setLista_viernes(List<Actividad> lista_viernes) {
        this.lista_viernes = lista_viernes;
    }


    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Date getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(Date fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }



     public void traerActividades(){
    eventModel = new DefaultScheduleModel();




    eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
             /*   eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
                eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
                eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));

                eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
                eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
                eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));
*/
                
   /*   for(Actividad le : actividadFacade.findAll()){
         
    eventModel.addEvent(new DefaultScheduleEvent(le.getDescripcionActividad(), le.getFecha(),le.getFecha(),"calendarButton"));
    }
*/

                Date d = new Date();
Calendar c1 = Calendar.getInstance();


Calendar t = Calendar.getInstance();
                t.set(Calendar.AM_PM, Calendar.AM);
                t.set(Calendar.DATE, t.get(Calendar.DATE));
                t.set(Calendar.HOUR, 8);

                Calendar t1 = Calendar.getInstance();
                t1.set(Calendar.AM_PM, Calendar.AM);
                t1.set(Calendar.DATE, t.get(Calendar.DATE));
                t1.set(Calendar.HOUR,  9);
                eventModel.addEvent(new DefaultScheduleEvent("Argos Was Here !!!", t.getTime(), t1.getTime()));

    }


   


public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);

        event = new DefaultScheduleEvent();
    }

  

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<Actividad> getLista() {
        //lista = actividadFacade.findAll();
               return lista;
    }
    
    public List<Actividad> getListaTotalSemana() {
        lista = new LinkedList<Actividad>();
        lista.addAll(lista_lunes);
        lista.addAll(lista_martes);
        lista.addAll(lista_miercoles);
        lista.addAll(lista_jueves);
        lista.addAll(lista_viernes);
        lista.addAll(lista_sabado);
        lista.addAll(lista_domingo);
        this.getLista_ordenada(lista);
               return lista;
    }

    public void filtrar() {
        lista = new LinkedList<Actividad>();
         lista_lunes = new LinkedList<Actividad>();
          lista_martes = new LinkedList<Actividad>();
           lista_miercoles = new LinkedList<Actividad>();
            lista_jueves = new LinkedList<Actividad>();
             lista_viernes = new LinkedList<Actividad>();
              lista_sabado = new LinkedList<Actividad>();
              lista_domingo = new LinkedList<Actividad>();
        fecha_lista = new SimpleDateFormat("EEEE");

        try {
       for(Actividad a : actividadFacade.findAll())
          {
          if(  a.getFecha().equals(fecha_inicial) || a.getFecha().equals(fecha_final) || (a.getFecha().after(fecha_inicial) && a.getFecha().before(fecha_final)))
          {
           
              cadena_lista = new StringBuilder( fecha_lista.format( a.getFecha() ) );

     if(cadena_lista.toString().contains("lunes")){
     lista_lunes.add(a);
     }


     if(cadena_lista.toString().contains("martes")){
     lista_martes.add(a);

     }

               if(cadena_lista.toString().contains("miércoles")){
     lista_miercoles.add(a);

     }

               if(cadena_lista.toString().contains("jueves")){
     lista_jueves.add(a);

     }


               if(cadena_lista.toString().contains("viernes")){
     lista_viernes.add(a);

     }

               if(cadena_lista.toString().contains("sábado")){
     lista_sabado.add(a);

     }
               if(cadena_lista.toString().contains("domingo")){
     lista_domingo.add(a);

     }
       
          }
          }
     /*     this.getLista_ordenada(lista_lunes);
         this.getLista_ordenada(lista_martes);
         this.getLista_ordenada(lista_miercoles);
         this.getLista_ordenada(lista_jueves);
         this.getLista_ordenada(lista_viernes);
         this.getLista_ordenada(lista_sabado);
         this.getLista_ordenada(lista_domingo);*/

        } catch (Exception e) {
        }

    }

    public void setLista(List<Actividad> lista) {
        this.lista = lista;
    }




    public String VerActividades(){
        fecha_inicial = new Date();
        fecha_final = new Date();
        lista_lunes = new LinkedList<Actividad>();
          lista_martes = new LinkedList<Actividad>();
           lista_miercoles = new LinkedList<Actividad>();
            lista_jueves = new LinkedList<Actividad>();
             lista_viernes = new LinkedList<Actividad>();
              lista_sabado = new LinkedList<Actividad>();
              lista_domingo = new LinkedList<Actividad>();

    return "calendario_actividades";
    }
public String Volver_Letras(){
return "ventas?faces-redirect=true";
     }


public String nueva(){
    actividad = new Actividad();
    Date fecha = new Date();
    actividad.setFecha(fecha);
    return "nueva_actividad";
}

public String crear(){
    try {
        actividadFacade.create(actividad);
    } catch (Exception e) {
    }
    return "calendario_actividades";
}








private Calendar today() {
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

                return calendar;
        }

        private Date previousDay8Pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
                t.set(Calendar.HOUR, 8);

                return t.getTime();
        }

        private Date previousDay11Pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
                t.set(Calendar.HOUR, 11);

                return t.getTime();
        }

        private Date today1Pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.HOUR, 1);

                return t.getTime();
        }

        private Date theDayAfter3Pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.HOUR, 3);

                return t.getTime();
        }

        private Date today6Pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.HOUR, 6);

                return t.getTime();
        }

        private Date nextDay9Am() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.AM);
                t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
                t.set(Calendar.HOUR, 9);

                return t.getTime();
        }

        private Date nextDay11Am() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.AM);
                t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
                t.set(Calendar.HOUR, 11);

                return t.getTime();
        }

        private Date fourDaysLater3pm() {
                Calendar t = (Calendar) today().clone();
                t.set(Calendar.AM_PM, Calendar.PM);
                t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
                t.set(Calendar.HOUR, 3);

    return t.getTime();
        }














          public void getLista_ordenada(List<Actividad>  lista) {
              int size = lista.size();
              List<Actividad> no_ordenada = new ArrayList<Actividad>();
         List<Actividad> ordenada = new ArrayList<Actividad>();
         no_ordenada = lista;
          Actividad act = new Actividad();
              if(size > 1){

                for(int i =0 ; i< size; i++){
                 act =this.ultimo(no_ordenada);
                 ordenada.add(act);
            //     no_ordenada.remove(act);
                }
                  
              }
// esta es
    // ordenada.addAll(lista);
      


          // aqui se agrega al ultimo a la lista.
     lista.addAll(ordenada);
          }



           public Actividad ultimo (List<Actividad>  lista_) {
           Actividad uno = lista_.get(0);
           int size = lista_.size();
               for(int i =0 ; i< size; i++)
           {
                 if(lista_.get(i).getFecha().before(uno.getFecha())){
                 uno = lista_.get(i);
                                  }
           }

         lista_.remove(uno);
               return uno;
          }

}
