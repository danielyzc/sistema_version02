/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;
import be.UbicacionFisica;
import beans.ManagedBeanUbicacionFisica;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author daniel
 */
@FacesConverter(value = "ubicacionFisicaConverter")
public class UbicacionFisicaConverter implements Converter{
 @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
throw new NullPointerException("context");
}
if (component == null) {
throw new NullPointerException("component");
}
      FacesContext ctx = FacesContext.getCurrentInstance();
      ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{managedBeanUbicacionFisica}",ManagedBeanUbicacionFisica.class);
ManagedBeanUbicacionFisica ubicacionesFisicas = (ManagedBeanUbicacionFisica)vex.getValue(ctx.getELContext());
UbicacionFisica ubicacionFisica;
try {
    ubicacionesFisicas.llenar_myUbicacionesFisicas();
  ubicacionFisica =  ubicacionesFisicas.getUbicacionFisica(new Integer(value));
} catch( NumberFormatException e ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Este no es un Numero de Ubicacion" );
throw new ConverterException( message );
}
if( ubicacionFisica == null ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valor Desconocido", "La Ubicacion fisica es desconocida !" );
throw new ConverterException( message );
}
return ubicacionFisica;
}



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {


    if (context == null){throw new NullPointerException("context");}
if (component == null){throw new NullPointerException("component");}

   
    //System.out.println("Imprimiendo   " + (UbicacionFisica)value);
    if(((UbicacionFisica)value).getIdUbicacionFisica()== null){
     //  System.out.println(" TODO ES NULL ");
       return "";
    }
 else{
return ((UbicacionFisica)value).getIdUbicacionFisica().toString();
        }
 }
}
