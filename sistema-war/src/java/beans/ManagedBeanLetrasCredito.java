
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.LetrasPagoCanjeFacadeLocal;
import be.LetrasPagoCanje;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

import java.io.Serializable;
import java.util.Calendar;
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
public class ManagedBeanLetrasCredito implements Serializable{
    @EJB
    private LetrasPagoCanjeFacadeLocal letrasPagoCanjeFacade;
private    LetrasPagoCanje letra;
private List<LetrasPagoCanje> lista;

      private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private String theme;



    public ManagedBeanLetrasCredito() {
letra = new LetrasPagoCanje();
lista = new LinkedList<LetrasPagoCanje>();


    eventModel = new DefaultScheduleModel();


      //  eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", new Date(), new Date()));

  /*  for(LetrasPagoCanje le : letrasPagoCanjeFacade.findAll()){
    eventModel.addEvent(new DefaultScheduleEvent("Letra", le.getFechaPago(), le.getFechaPago()));

    }
*/
       
 
        lazyEventModel = new LazyScheduleModel() {


            public void fetchEvents(Date start, Date end) {
                clear();
            }
        };




    }

    public void traerLetras(){
eventModel = new DefaultScheduleModel();
     //   eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", new Date(), new Date()));

     for(LetrasPagoCanje le : letrasPagoCanjeFacade.findAll()){
    eventModel.addEvent(new DefaultScheduleEvent("Letra Nº :" + le.getObservaciones() + " " + le.getCanjeOrdenCompra().getNombreBancoPagar(), le.getFechaPago(), le.getFechaPago()));
    }

    }
    public LetrasPagoCanje getLetra() {
        return letra;
    }

    public void setLetra(LetrasPagoCanje letra) {
        this.letra = letra;
    }

    public List<LetrasPagoCanje> getLetras(){
        try {
            lista = letrasPagoCanjeFacade.findAll();
        } catch (Exception e) {
        e.printStackTrace();
        }
    return lista;
    }

    public String VerLetras(){
    return "calendario_letras";
    }
public String Volver_Letras(){
return "compras?faces-redirect=true";
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

}
