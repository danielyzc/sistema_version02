/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.DetalleAlmacenProductosFacadeLocal;
import bc.StockProductoTiendaOrigenFacadeLocal;
import be.DetalleAlmacenProductos;
import be.StockProductoTiendaOrigen;
import be.Tienda;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.BaseColor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import javax.faces.context.ExternalContext;

/**
 *
 * @author argos
 */
@ManagedBean
@SessionScoped
public class ManagedBeanReportes implements Serializable {

    @EJB
    private DetalleAlmacenProductosFacadeLocal detalleAlmacenProductosFacade;
    @EJB
    private StockProductoTiendaOrigenFacadeLocal stockProductoTiendaOrigenFacade;

    private Date fecha_inicio = new Date();
    Font bigFont = FontFactory.getFont("Helvetica", "Windows-1254", 14.0F, 1, BaseColor.BLACK);
    Font bigFont12 = FontFactory.getFont("Helvetica", "Windows-1254", 12.0F, 1, BaseColor.BLACK);
    Font pequeFont = FontFactory.getFont("Helvetica", "Windows-1254", 11.0F, 1, BaseColor.BLACK);
    Font titulopequeFont = FontFactory.getFont("Helvetica", "Windows-1254", 8.0F, 1, BaseColor.BLACK);
    Font peque = FontFactory.getFont("Arial", 14, BaseColor.BLACK);
    Font fontmed08 = FontFactory.getFont("Arial", 8, BaseColor.BLACK);
    Font fontmed11 = FontFactory.getFont("Arial", 11, BaseColor.BLACK);
    Font fontmed12 = FontFactory.getFont("Arial", 11, BaseColor.BLACK);
    Font fontmed12_bold = FontFactory.getFont("Arial", 11, 1, BaseColor.BLACK);
    private final float[] anchocol03 = {160, 90, 70, 70};
    private final float[] anchocol_02 = {16, 434};
    private final float[] anchocol_tabla03 = {120, 220, 50};
    private int cant_v = 0;
    private int cant_f = 0;

    public ManagedBeanReportes() {
    }

    public void inventario() throws DocumentException, IOException {
        FacesContext facexcontext = FacesContext.getCurrentInstance();
        ValueExpression vex = facexcontext.getApplication().getExpressionFactory().createValueExpression(facexcontext.getELContext(), "#{managedBeanLogin}", ManagedBeanLogin.class);
        ManagedBeanLogin beanLogin = (ManagedBeanLogin) vex.getValue(facexcontext.getELContext());

        FacesContext context = FacesContext.getCurrentInstance();

        Document document = new Document(PageSize.A4, 25, 25, 75, 25);//int marginLeft,   int marginRight,   int marginTop,   int marginBottom

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setPageEvent(new ManagedBeanReportes.Watermark(""));
        if (!document.isOpen()) {
            document.open();
        }

        try {

            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            //String imageUrl1 = extContext.getRealPath("//resources//images/logo0002.png");
            //Image welladigital = Image.getInstance(imageUrl1);
            //welladigital.setAbsolutePosition(377f, 760f);
            //welladigital.scalePercent(40);
            //document.add(welladigital);

            //crear tabla PARA NOMBRE DEL AÑO
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setTotalWidth(450f);
            // table.setTotalWidth(540f);
            table.setLockedWidth(true);
            float[] headerWidths = {120, 20, 310};
            table.setWidths(headerWidths);
            table.getDefaultCell();

            SimpleDateFormat formato = new SimpleDateFormat("EEEE dd MMMM YYYY");
            StringBuilder cadena = new StringBuilder(formato.format(fecha_inicio));

            Chunk underline = new Chunk("FECHA DE INVENTARIO:" + cadena.toString().toUpperCase(), bigFont12);
            underline.setUnderline(0.2f, -2f); //0.1 thick, -2 y-location
            PdfPCell table5 = new PdfPCell(new Paragraph(underline));
            table5.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
            table5.setColspan(3);
            table5.setBorder(Rectangle.NO_BORDER);
            table.addCell(table5);

            document.add(table);

            document.add(new Paragraph("\n", pequeFont));

            PdfPCell table2 = new PdfPCell();

            table2 = new PdfPCell(new Paragraph(beanLogin.getObjetoEmpleado().getTienda().getNombreTienda(), pequeFont));
            table2.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
            table2.setColspan(3);
            table2.setBorder(Rectangle.NO_BORDER);
            table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setTotalWidth(450f);
            table.setLockedWidth(true);
            table.setWidths(headerWidths);
            table.getDefaultCell();
            table.addCell(table2);
            document.add(table);

            document.add(new Paragraph("\n", pequeFont));

            document.add(traerSubtabla(beanLogin.getObjetoEmpleado().getTienda()));
            formato = new SimpleDateFormat("yyyy-MM-dd");
            cadena = new StringBuilder(formato.format(fecha_inicio));

            //document.add(traerSubtabla02(cadena.toString()));
            document.add(new Paragraph("\n", pequeFont));
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            document.close();
            formato = new SimpleDateFormat("dd_MM_yyyy");
            cadena = new StringBuilder(formato.format(fecha_inicio));
            String fileName = cadena.toString();

            writePDFToResponse(context.getExternalContext(), baos, fileName);
            context.responseComplete();

        } catch (Exception de) {
            de.printStackTrace();
        }
    }

    public class Watermark extends PdfPageEventHelper {

        PdfTemplate total;
        private String encabezado;
        protected Phrase watermark = new Phrase(" ",
                new Font(Font.FontFamily.HELVETICA, 8.0F, 0, new BaseColor(200, 200, 200)));

        public Watermark(String codHecho) {

            encabezado = codHecho;
        }

        public void onOpenDocument(PdfWriter writer, Document document) {
            total = writer.getDirectContent().createTemplate(30, 16);
        }

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            //ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Inicio de Pagina - El lado oscuro de Java"), 200, 830, 0);

            try {
                /* Image qrcodeImage = codigoQr.getImage();
                 qrcodeImage.setAbsolutePosition(445f, 745f);
                 document.add(qrcodeImage);
                 ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
                 String imageUrl1 = extContext.getRealPath("//resources//images//DEFAULT//membretepnp.jpg");
                 Image welladigital = Image.getInstance(imageUrl1);
                 welladigital.setAbsolutePosition(25f, 745f);
                 welladigital.scalePercent(40);
                 document.add(welladigital);
                 Paragraph parrafo = new Paragraph("CARP. POL. N°: " + encabezado, titulopequeFont);
                 agregaLineaText("CARP. POL. N°: " + encabezado, 412f, 747f, writer, 8);*/

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onCloseDocument(PdfWriter writer, Document document) {
            // ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber() - 1)), 2, 2, 0);
        }

        // Getter and Setters
        public String getEncabezado() {
            return encabezado;
        }

        public void setEncabezado(String encabezado) {
            this.encabezado = encabezado;
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte canvas = writer.getDirectContentUnder();
            //ColumnText.showTextAligned(canvas, 1, this.watermark, 298.0F, 421.0F, 45.0F);
            for (int fila = 0; fila < 50; fila++) {
                float dataFila = (float) fila * 50;

                for (int i = 0; i < 17; i++) {
                    float data = (float) i * 40;
                    //ColumnText.showTextAligned(canvas, 1, this.watermark, data, 400.0F, 40.0F);
                    //ColumnText.showTextAligned(canvas, 1, this.watermark, data, dataFila, 40.0F);
                }

            }

        }
    }

    private void writePDFToResponse(ExternalContext externalContext, ByteArrayOutputStream baos, String fileName) {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("application/pdf");
            externalContext.setResponseHeader("Expires", "0");
            externalContext.setResponseHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            externalContext.setResponseHeader("Pragma", "public");
            externalContext.setResponseHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            externalContext.setResponseContentLength(baos.size());
            OutputStream out = externalContext.getResponseOutputStream();
            baos.writeTo(out);
            externalContext.responseFlushBuffer();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public PdfPTable traerSubtabla(Tienda t) throws DocumentException {
        PdfPTable tabla_PesajeDetalle = new PdfPTable(4);
        tabla_PesajeDetalle.setWidthPercentage(100);
        tabla_PesajeDetalle.setTotalWidth(450f);
        tabla_PesajeDetalle.setLockedWidth(true);

        tabla_PesajeDetalle.setWidths(anchocol03);
        tabla_PesajeDetalle.getDefaultCell();

        PdfPCell Cell_Headers = new PdfPCell(new Paragraph("PRODUCTO", titulopequeFont));
        Cell_Headers.setBackgroundColor(BaseColor.LIGHT_GRAY);
        Cell_Headers.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        Cell_Headers.setVerticalAlignment(Paragraph.ALIGN_MIDDLE);

        tabla_PesajeDetalle.addCell(Cell_Headers);

        Cell_Headers = new PdfPCell(new Paragraph("UBICACIONES", titulopequeFont));
        Cell_Headers.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        Cell_Headers.setVerticalAlignment(Paragraph.ALIGN_MIDDLE);
        Cell_Headers.setBackgroundColor(BaseColor.LIGHT_GRAY);
        tabla_PesajeDetalle.addCell(Cell_Headers);

        Cell_Headers = new PdfPCell(new Paragraph("MINIMO", titulopequeFont));
        Cell_Headers.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        Cell_Headers.setVerticalAlignment(Paragraph.ALIGN_MIDDLE);
        Cell_Headers.setBackgroundColor(BaseColor.LIGHT_GRAY);
        tabla_PesajeDetalle.addCell(Cell_Headers);

        Cell_Headers = new PdfPCell(new Paragraph("STOCK TOTAL", titulopequeFont));
        Cell_Headers.setBackgroundColor(BaseColor.LIGHT_GRAY);
        Cell_Headers.setVerticalAlignment(Paragraph.ALIGN_MIDDLE);
        Cell_Headers.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        tabla_PesajeDetalle.addCell(Cell_Headers);

        for (StockProductoTiendaOrigen det : stockProductoTiendaOrigenFacade.lista_stock_tienda(t)) {
            tabla_PesajeDetalle.addCell(traerCelda(det.getProducto().getNombreProducto()));
            String ubicaciones_ = "";
            for (DetalleAlmacenProductos p : detalleAlmacenProductosFacade.lista_para_stock_tienda(t, det.getProducto())) {
               if(p.getUbicacionFisica().getIdUbicacionFisica()>1){
               ubicaciones_ = p.getUbicacionFisica().getNombreUbicacionFisica() + ";" + ubicaciones_;
               }
            }
            tabla_PesajeDetalle.addCell(traerCelda(ubicaciones_));
            tabla_PesajeDetalle.addCell(traerCelda(String.valueOf(det.getCantidadMinimaStock())));
            tabla_PesajeDetalle.addCell(traerCelda(String.valueOf(det.getCantidad())));
        }
        return tabla_PesajeDetalle;
    }

    public PdfPCell traerCelda(String data) {
        PdfPCell resultado = new PdfPCell(new Paragraph(data, titulopequeFont));
        resultado.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        resultado.setVerticalAlignment(Paragraph.ALIGN_MIDDLE);
        return resultado;
    }
}
