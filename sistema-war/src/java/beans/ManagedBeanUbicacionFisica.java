/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.UbicacionFisicaFacadeLocal;
import be.Tienda;
import be.UbicacionFisica;
import be.ZonaCiudad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class ManagedBeanUbicacionFisica implements Serializable{
    @EJB
    private UbicacionFisicaFacadeLocal ubicacionFisicaFacade;
private UbicacionFisica ubicacionfisica;
private List<UbicacionFisica> lista ;
private List<SelectItem> ubicacionItems = new LinkedList<SelectItem>();
private HashMap<Integer, UbicacionFisica> myubicaciones = new HashMap<Integer,UbicacionFisica>();

    public ManagedBeanUbicacionFisica() {
        ubicacionfisica= new UbicacionFisica();
        lista = new LinkedList<UbicacionFisica>();
    }



    public List<UbicacionFisica> getLista() {
        try {
            lista=new LinkedList<UbicacionFisica>();
            List<UbicacionFisica> lista_temp= new LinkedList<UbicacionFisica>();
            lista_temp =ubicacionFisicaFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
          
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<UbicacionFisica> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, UbicacionFisica> getMyubicaciones() {
        return myubicaciones;
    }

    public void setMyubicaciones(HashMap<Integer, UbicacionFisica> myubicaciones) {
        this.myubicaciones = myubicaciones;
    }

    public List<SelectItem> getUbicacionItems() {
        lista = new ArrayList<UbicacionFisica>();
        ubicacionItems = new LinkedList<SelectItem>();
        lista = ubicacionFisicaFacade.findAll();
        for(UbicacionFisica p: lista){
        myubicaciones.put(p.getIdUbicacionFisica(), p);
            ubicacionItems.add(new SelectItem(p, p.getNombreUbicacionFisica()));
        }
        return ubicacionItems;
    }

    public void setUbicacionItems(List<SelectItem> ubicacionItems) {
        this.ubicacionItems = ubicacionItems;
    }

    public UbicacionFisica getUbicacionfisica() {
        return ubicacionfisica;
    }

    public void setUbicacionfisica(UbicacionFisica ubicacionfisica) {
        this.ubicacionfisica = ubicacionfisica;
    }
public UbicacionFisica getUbicacionFisica(Integer id) {
           return (UbicacionFisica) myubicaciones.get(id);

    }





public void newObject(){
ubicacionfisica = new UbicacionFisica();
    
    }
public void crearNew(){

    try {
 ubicacionFisicaFacade.create(ubicacionfisica);
    
            ubicacionfisica.setNombreUbicacionFisica(CodigoBarrasFinal(ubicacionfisica).concat("-"+ubicacionfisica.getNombreUbicacionFisica()));

        
           ubicacionFisicaFacade.edit(ubicacionfisica);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}


public String Nuevo(){
ubicacionfisica = new UbicacionFisica();
    return "nueva_ubicacion_fisica";

    }


  public String Editar(){
    return "editar_ubicacion_fisica";
    }

  public String crear(){

    try {
     ubicacionFisicaFacade.create(ubicacionfisica);
     // actualizando codigo de barras:
            System.out.println("NEW CODIGO ES:" +ubicacionfisica.getIdUbicacionFisica());
            ubicacionfisica.setNombreUbicacionFisica(CodigoBarrasFinal(ubicacionfisica).concat("-"+ubicacionfisica.getNombreUbicacionFisica()));

             System.out.println("NEW NOMBRE ES:" +ubicacionfisica.getNombreUbicacionFisica());
           ubicacionFisicaFacade.edit(ubicacionfisica);
    
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "ubicaciones_fisicas?faces-redirect=true";

}

  public String editar(){

    try {
        ubicacionFisicaFacade.edit(ubicacionfisica);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "ubicaciones_fisicas?faces-redirect=true";

}


  public void editarNew(){

    try {
       ubicacionFisicaFacade.edit(ubicacionfisica);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}
  
   public String Volver_UbicacionesFisicas(){
return "index?faces-redirect=true";
     }
public String Volver_UbicacionesFisicas_CodBarras(){
return "ubicaciones_fisicas?faces-redirect=true";
     }

   public List<UbicacionFisica> completar_filtrado_UbicacionFisica(String nombre) {
  lista = new LinkedList<UbicacionFisica>();
  for(UbicacionFisica p : ubicacionFisicaFacade.findAll()){

  myubicaciones.put(p.getIdUbicacionFisica(), p);
    if (p.getNombreUbicacionFisica().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }

    public void llenar_myUbicacionesFisicas(){
    try {

        for(UbicacionFisica p : ubicacionFisicaFacade.findAll()){
        myubicaciones.put(p.getIdUbicacionFisica(),p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}








    public String CreatePdf() throws IOException, DocumentException {
        try {


        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
System.out.println(" esta es la ruta" + extContext.getRealPath("//pdfs//CBU.pdf"));
     // step 1
        Document document = new Document(PageSize.A4);
        document.setMargins(5, 5, 25, 25);
document.setMarginMirroring(true);



        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(extContext.getRealPath("//pdfs//CBU.pdf")));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();


        Paragraph Titulo = new Paragraph("LISTADO DE UBICACIONES FISICAS"+"\n\n");
        Titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(Titulo);
BarcodeEAN codeEAN = new BarcodeEAN();
String nombre_producto="";
        // EAN 13
       // document.add(new Paragraph("Barcode EAN.UCC-13"));


 // table.setTotalWidth(1800);
     List<PdfPCell> lista_celdas = new LinkedList<PdfPCell>();
int iteracion =0;
for (UbicacionFisica p : ubicacionFisicaFacade.findAll())
{
    PdfPCell celda = new PdfPCell();
    codeEAN = new BarcodeEAN();
    codeEAN.setCode(CodigoBarrasFinal(p));
 nombre_producto="";
 if(p.getNombreUbicacionFisica().length() >= 41){
        nombre_producto=p.getNombreUbicacionFisica().substring(14,41);
        }else
        {
        nombre_producto=p.getNombreUbicacionFisica().substring(14);
        }

 Image imagen =codeEAN.createImageWithBarcode(cb, null,null);
 imagen.scaleAbsolute(87, 45);
  Phrase nombre = new Phrase(nombre_producto.toUpperCase(),new Font(Font.COURIER, 5, Font.BOLD,Color.BLACK));


celda.addElement(nombre);
celda.addElement(imagen);

//System.out.println("NOMBRE ="+nombre);
lista_celdas.add(celda);
}
   // System.out.println("CANTIDAD DE ELEMENTOS LISTA ="+lista_celdas.size());
        
    
  //  for (int i=0;i<lista_celdas.size();i++){
   // int indice = i;
   // table.addCell(lista_celdas.get(indice));
   // }
    PdfPTable table = new PdfPTable(5);
   // table.addCell(lista_celdas.get(0));
   int sobrante =0;
   sobrante=  lista_celdas.size()%5;
   for(int i=0;i<lista_celdas.size();i++)
   {
       
   

   if((i%5==0)&& i>0 )
   {
    document.add(table);
    table = new PdfPTable(5);
  
       //System.out.println("ENTRAMOS EN IF "+(i+1)+"  SE VA A RESETEAR");
       
       
      // document.add(new Chunk("NUEVA TABLA \n"));
       table.addCell(lista_celdas.get(i));
   // document.add(table);
     
   }else
   {
//System.out.println("ENTRAMOS EN ELSE "+(i+1)+"  NO SE RESETEA");

      table.addCell(lista_celdas.get(i));
   
   }

   }

   if(sobrante>0)
   {
table = new PdfPTable(sobrante);
//document.add(new Chunk("NUEVA TABLA  SOBRANTE  TAMAÑO "+sobrante+"\n"));
for(int x=sobrante;x >=1 ;x--)
{
//System.out.println("ENTRAMOS en tabla "+(lista_celdas.size()-x));

       table.addCell(lista_celdas.get(lista_celdas.size()-x));
}
   }
      
document.add(table);


        document.close();
 
         }
       catch (Exception e) {
           e.printStackTrace();
        }
return  "codigo_barras_ubicaciones";
    }
 public int codigo_verificacion(String codBarras){

int resultado = Integer.parseInt(Character.toString(codBarras.charAt(0)))*1 + Integer.parseInt(Character.toString(codBarras.charAt(1)))*3+Integer.parseInt(Character.toString(codBarras.charAt(2)))*1+Integer.parseInt(Character.toString(codBarras.charAt(3)))*3+Integer.parseInt(Character.toString(codBarras.charAt(4)))*1+Integer.parseInt(Character.toString(codBarras.charAt(5)))*3+Integer.parseInt(Character.toString(codBarras.charAt(6)))*1+Integer.parseInt(Character.toString(codBarras.charAt(7)))*3+Integer.parseInt(Character.toString(codBarras.charAt(8)))*1+Integer.parseInt(Character.toString(codBarras.charAt(9)))*3+Integer.parseInt(Character.toString(codBarras.charAt(10)))*1+Integer.parseInt(Character.toString(codBarras.charAt(11)))*3;
System.out.println(" RESULTADO :"+resultado);
System.out.println(" modulo RESULTADO :"+resultado%10);
 System.out.println(" RESTA RESULTADO :"+ (10- (resultado%10)));
 System.out.println(" CODIGO DE VERIFICACION :"+ (10- (resultado%10)));

 if(resultado%10 == 0){
     return 0;
 }
     else{
      return (10- (resultado%10));
     }

 }

 public String CodigoBarrasFinal(UbicacionFisica ubi){
 String Mascara = "7757";

        String Numero = "00000000"+ubi.getIdUbicacionFisica();
    	String codigo_barras =Mascara.concat(Numero.substring(Numero.length()-8));

     // codeEAN.setCode("7751000000080");
        System.out.println(" EL CODIGO DE BARRAS SIN DIGITO DE VERIFICACION ES :"+codigo_barras);

      //  codeEAN.setCode(codigo_barras.concat(Integer.toString(codigo_verificacion(codigo_barras))));

       return codigo_barras.concat(Integer.toString(codigo_verificacion(codigo_barras)));
 }


}
