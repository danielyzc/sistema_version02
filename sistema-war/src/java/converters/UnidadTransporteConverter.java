
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;
import be.UnidadTransporte;
import beans.ManagedBeanUnidadTransporte;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
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
@FacesConverter(value = "unidadTransporteConverter")
public class UnidadTransporteConverter implements Converter{
  @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
throw new NullPointerException("context");
}
if (component == null) {
throw new NullPointerException("component");
}
      FacesContext ctx = FacesContext.getCurrentInstance();
      ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{managedBeanUnidadTransporte}",ManagedBeanUnidadTransporte.class);
ManagedBeanUnidadTransporte unidades = (ManagedBeanUnidadTransporte)vex.getValue(ctx.getELContext());
 UnidadTransporte unidad;
try {
  unidad =  unidades.getUnidadTrasporte(new Integer(value));
} catch( NumberFormatException e ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Este no es una Unidad de Transporte" );
throw new ConverterException( message );
}
if( unidad == null ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valor Desconocido", "Unidad de Transporte desconocida !" );
throw new ConverterException( message );
}
return unidad;
}



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

    if (context == null){throw new NullPointerException("context");}
if (component == null){throw new NullPointerException("component");}
return ((UnidadTransporte)value).getIdUnidadTransporte().toString();
    }


}
