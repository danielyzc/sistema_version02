/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;
import be.Cliente;
import beans.ManagedBeanCliente;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author argos
 */
@FacesConverter(value = "clienteFinalConverter")
public class ClienteFinalConverter implements Converter{
 @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
throw new NullPointerException("context");
}
if (component == null) {
throw new NullPointerException("component");
}
      FacesContext ctx = FacesContext.getCurrentInstance();
      ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{managedBeanCliente}",ManagedBeanCliente.class);
ManagedBeanCliente clientes = (ManagedBeanCliente)vex.getValue(ctx.getELContext());
Cliente cliente;
try {
 
    clientes.llenar_myClientes();
  cliente =  clientes.getCliente(new Integer(value));
} catch( NumberFormatException e ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Este no es un Numero de Cliente" );
throw new ConverterException( message );
}
if( cliente == null ) {
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Valor Desconocido", "CLIENTE NULL" );
throw new ConverterException( message );
}
return cliente;
}



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {


    if (context == null){throw new NullPointerException("context");}
if (component == null){throw new NullPointerException("component");}
    if(value== null){return "";}

return ((Cliente)value).getIdCliente().toString();
    }
}
