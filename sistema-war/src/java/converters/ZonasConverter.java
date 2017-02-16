/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;
import be.ZonaCiudad;
import beans.ManagedBeanZona;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author root
 */
@FacesConverter(value = "zonaConverter")
public class ZonasConverter implements Converter{


       @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
throw new NullPointerException("context");
}
if (component == null) {
throw new NullPointerException("component");
}
      FacesContext ctx = FacesContext.getCurrentInstance();
      ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{managedBeanZona}",ManagedBeanZona.class);
ManagedBeanZona zonas = (ManagedBeanZona)vex.getValue(ctx.getELContext());
ZonaCiudad zona;
try {
  zona =  zonas.getZona(new Integer(value));
} catch( NumberFormatException e ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Este no es un Numero de Zona" );
throw new ConverterException( message );
}
if( zona == null ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valor Desconocido", "La Zona desconocida" );
throw new ConverterException( message );
}
return zona;
}



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {


    if (context == null){throw new NullPointerException("context");}
if (component == null){throw new NullPointerException("component");}
return ((ZonaCiudad)value).getIdZonaCiudad().toString();
    }

}
