
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.PrecioProductoFacadeLocal;
import bc.ProductoFacadeLocal;
import be.ColorProducto;
import be.EstadoProducto;
import be.MaterialProducto;
import be.ModeloProducto;
import be.PrecioProducto;
import be.Producto;
import be.TallaProducto;
import be.ZonaCiudad;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.Barcode;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.Barcode39;
import com.lowagie.text.pdf.BarcodeCodabar;
import com.lowagie.text.pdf.BarcodeDatamatrix;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.BarcodeEANSUPP;
import com.lowagie.text.pdf.BarcodeInter25;
import com.lowagie.text.pdf.BarcodePDF417;
import com.lowagie.text.pdf.BarcodePostnet;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */




@ManagedBean
@SessionScoped
public class ManagedBeanProducto implements Serializable {
    @EJB
    private ProductoFacadeLocal ProductoFacade;
    @EJB
    private  PrecioProductoFacadeLocal precioProductoFacade ;
    private Producto Producto;
    private List<SelectItem> ProductosItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Producto> myProductos = new HashMap<Integer,Producto>();
private List<Producto> lista ;

    public ManagedBeanProducto() {
   Producto = new Producto();
   lista= new LinkedList<Producto>();
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

     public Producto getProducto(Integer id) {
     //    Producto objetoProducto = new Producto(id);
   // return (Producto) myProductos.get(id);
         return ProductoFacade.find(id);
     }

    public HashMap<Integer, Producto> getMyProductos() {
        return myProductos;
    }

    public void setMyProductos(HashMap<Integer, Producto> myProductos) {
        this.myProductos = myProductos;
    }

    public List<SelectItem> getProductosItems() {
          lista = new ArrayList<Producto>();
        ProductosItems = new LinkedList<SelectItem>();
        lista = ProductoFacade.findAll();
        for(Producto p: lista){
        myProductos.put(p.getIdProducto(), p);
            ProductosItems.add(new SelectItem(p, p.getNombreProducto()));
        }

        return ProductosItems;

    }

    public void setProductosItems(List<SelectItem> ProductosItems) {
        this.ProductosItems = ProductosItems;
    }

    public List<Producto> getLista_Productos(){
        try {
            lista=new LinkedList<Producto>();
            List<Producto> lista_temp= new LinkedList<Producto>();
            lista_temp =ProductoFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }

        } catch (Exception e) {
        e.printStackTrace();
        }
        return lista;
    }

    
    public void newObject(){
  Producto = new Producto();
Producto.setFechaIngreso(new Date());
    
    }
public void crearNew(){

    try {
       Producto.setEstadoProducto(new EstadoProducto(1));
    Producto.setFechaIngreso(new Date());
    Producto.setModeloProducto(new ModeloProducto(1));
    Producto.setTallaProducto(new TallaProducto(1));
    Producto.setColorProducto(new ColorProducto(1));
    Producto.setMaterialProducto(new MaterialProducto(1));
    ProductoFacade.create(Producto);
            // actualizando codigo de barras:
        
            Producto.setNombreProducto(CodigoBarrasFinal().concat("-"+Producto.getNombreProducto()));

          
            ProductoFacade.edit(Producto);
             
             /*Agregado aqui*/

            precioProductoFacade.create(new PrecioProducto(Producto.getIdProducto(), new Date(), BigDecimal.ZERO));
            
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}
    public String Nueva(){
    Producto = new Producto();
Producto.setFechaIngreso(new Date());
    return "nuevo_producto";
    }

     public String edicion(){
return "editar_producto";
    }

    public String Crear_Producto(){
    Producto.setEstadoProducto(new EstadoProducto(1));
    Producto.setFechaIngreso(new Date());
    Producto.setModeloProducto(new ModeloProducto(1));
    Producto.setTallaProducto(new TallaProducto(1));
    Producto.setColorProducto(new ColorProducto(1));
    Producto.setMaterialProducto(new MaterialProducto(1));
        try {
            ProductoFacade.create(Producto);
            // actualizando codigo de barras:
            System.out.println("NEW CODIGO ES:" +Producto.getIdProducto());
            Producto.setNombreProducto(CodigoBarrasFinal().concat("-"+Producto.getNombreProducto()));

             System.out.println("NEW NOMBRE ES:" +Producto.getNombreProducto());
            ProductoFacade.edit(Producto);
             
             /*Agregado aqui*/

            precioProductoFacade.create(new PrecioProducto(Producto.getIdProducto(), new Date(), BigDecimal.ZERO));

        } catch (Exception e) {
        e.printStackTrace();
        }
    return "productos?faces-redirect=true";
    }

    public String editar_producto(){
        try {
            ProductoFacade.edit(Producto);
        } catch (Exception e) {
        e.printStackTrace();
        }
    return "productos?faces-redirect=true";
    }
    
    public void editarNew(){

    try {
      ProductoFacade.edit(Producto);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}

    public String Volver_Producto(){
return "index?faces-redirect=true";
     }
   public String Volver_Producto_CodBarras(){
return "productos?faces-redirect=true";
     }

 public List<Producto> completar_filtrado_Producto(String nombre) {
     System.out.println(" entramos a filtrar Producto");
     myProductos = new HashMap<Integer,Producto>();
  lista = new LinkedList<Producto>();
  for(Producto p : ProductoFacade.findAll()){
      myProductos.put(p.getIdProducto(), p);
    if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }



 // aplicacion codigo de barras

 public String CreatePdf() throws IOException, DocumentException {
     ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
System.out.println(" esta es la ruta" + extContext.getRealPath("//pdfs//CB"+Producto.getIdProducto()+".pdf"));
     // step 1
        Document document = new Document(PageSize.A4);
        document.setMargins(5, 5, 25, 25);
document.setMarginMirroring(true);
        


        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(extContext.getRealPath("//pdfs//CB"+Producto.getIdProducto()+".pdf")));
        // step 3
        document.open();
        // step 4
        PdfContentByte cb = writer.getDirectContent();


        Paragraph Titulo = new Paragraph("PRODUCTO : "+Producto.getNombreProducto().substring(14).toUpperCase()+"\n\n");
        Titulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(Titulo);

        // EAN 13
       // document.add(new Paragraph("Barcode EAN.UCC-13"));
       
        BarcodeEAN codeEAN = new BarcodeEAN();
     
        codeEAN.setCode(CodigoBarrasFinal());
        String nombre_producto="";
        if(Producto.getNombreProducto().length() >= 41){
        nombre_producto=Producto.getNombreProducto().substring(14,41);
        }else
        {
        nombre_producto=Producto.getNombreProducto().substring(14);
        }
       // document.add(new Paragraph(nombre_producto,new Font(Font.COURIER, 5, Font.NORMAL)));
       // document.add(codeEAN.createImageWithBarcode(cb,Color.BLUE , Color.BLUE));
       // codeEAN.setGuardBars(false);

       // document.add(new Paragraph(nombre_producto,new Font(Font.COURIER, 5, Font.NORMAL)));
       // codeEAN.setGuardBars(false);
        Image imagen =codeEAN.createImageWithBarcode(cb, null,null);
     imagen.scaleAbsolute(87, 45);
        //document.add(imagen);
        






        PdfPTable table = new PdfPTable(5);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
     // table.setTotalWidth(1800);
PdfPCell cell;
Phrase nombre = new Phrase(nombre_producto.toUpperCase(),new Font(Font.COURIER, 5, Font.BOLD,Color.BLACK));

cell = new PdfPCell();
cell.addElement(nombre);
//cell.addElement(new Chunk("\n"));
cell.addElement(imagen);
//cell.addElement(new Chunk("\n"));

table.addCell(cell);
//table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);








table.addCell(cell);
//table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);


table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
table.addCell(cell);
   document.add(table) ;


   

        

        
        // EAN 8 "6987";
       // String inicio ="345";
      //  int intermedio =1000+Producto.getIdProducto();
      //  String fin ="0";
       // document.add(new Paragraph(Producto.getNombreProducto(),new Font(Font.COURIER, 4, Font.NORMAL)));
       // codeEAN.setCodeType(Barcode.EAN8);
       // codeEAN.setBarHeight(codeEAN.getSize() * 1.5f);
       // codeEAN.setCode(inicio.concat(intermedio+fin));
       // document.add(codeEAN.createImageWithBarcode(cb, null, null));

        document.close();

       return  "codigo_barras_productos";
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

 public String CodigoBarrasFinal(){
 String Mascara = "7751";

        String Numero = "00000000"+Producto.getIdProducto();
    	String codigo_barras =Mascara.concat(Numero.substring(Numero.length()-8));

     // codeEAN.setCode("7751000000080");
        System.out.println(" EL CODIGO DE BARRAS SIN DIGITO DE VERIFICACION ES :"+codigo_barras);

      //  codeEAN.setCode(codigo_barras.concat(Integer.toString(codigo_verificacion(codigo_barras))));

       return codigo_barras.concat(Integer.toString(codigo_verificacion(codigo_barras)));
 }
}
