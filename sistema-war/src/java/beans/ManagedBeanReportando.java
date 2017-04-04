
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import be.Cliente;
import be.Empleado;
import be.InventarioFisico;
import be.Tienda;
import be.VentaRapida;
import java.io.ByteArrayOutputStream;

import java.util.Date;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.faces.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 **Copyright 2011 Yury Daniel Zavaleta De la Cruz Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
@ManagedBean
@SessionScoped
public class ManagedBeanReportando implements Serializable {

    private Date fecha_consolidado;
    private static Connection conn = null;
    private String cadena_conexion = "jdbc:mysql://localhost/sistema";
    private String password = "sistema";
    private String nombre_reporte = "";
    private String nombre_reporte_seguimiento = "";
    private String OUTPUT_ZIP_FILE = "";
    private String SOURCE_FOLDER = "";
    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_cierre_caja;
    private Date fecha_cierre_caja2;
    private int id_venta = 0;
    private Empleado empleado;
    private Cliente cliente;
    private InventarioFisico inventarioFisico;
    private VentaRapida ventaRapida;
    List<String> fileList;
    private String nombre_reporte_cierre = "";
    private Tienda tienda;
    SimpleDateFormat fecha1_11 = new SimpleDateFormat("dd-MM-yyyy");
    StringBuilder cadena_fecha1_11 = new StringBuilder();
    SimpleDateFormat fecha2_11 = new SimpleDateFormat("dd-MM-yyyy");
    StringBuilder cadena_fecha2_11 = new StringBuilder();
    SimpleDateFormat fecha1_11_cierre = new SimpleDateFormat("dd-MM-yyyy");
    StringBuilder cadena_fecha1_cierre = new StringBuilder();
    private ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
    private FacesContext context = FacesContext.getCurrentInstance();
    String path_ = extContext.getRealPath("/");

    public ManagedBeanReportando() {
        fecha_consolidado = new Date();
        fecha_inicio = new Date();
        fecha_fin = new Date();
        fecha_cierre_caja = new Date();
        fecha_cierre_caja2 = new Date();
        empleado = new Empleado();
        fileList = new LinkedList<String>();
        cliente = new Cliente();
        tienda = new Tienda();
        inventarioFisico = new InventarioFisico();
        ventaRapida = new VentaRapida();
    }

    public VentaRapida getVentaRapida() {
        return ventaRapida;
    }

    public void setVentaRapida(VentaRapida ventaRapida) {
        this.ventaRapida = ventaRapida;
    }

    public InventarioFisico getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(InventarioFisico inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    public String getNombre_reporte_cierre() {

        return "../pdfs/" + nombre_reporte_cierre;
    }

    public void setNombre_reporte_cierre(String nombre_reporte_cierre) {
        this.nombre_reporte_cierre = nombre_reporte_cierre;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getNombre_reporte() {
        return "../pdfs/" + nombre_reporte;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha_cierre_caja() {
        return fecha_cierre_caja;
    }

    public void setFecha_cierre_caja(Date fecha_cierre_caja) {
        this.fecha_cierre_caja = fecha_cierre_caja;
    }

    public Date getFecha_cierre_caja2() {
        return fecha_cierre_caja2;
    }

    public void setFecha_cierre_caja2(Date fecha_cierre_caja2) {
        this.fecha_cierre_caja2 = fecha_cierre_caja2;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_consolidado() {
        return fecha_consolidado;
    }

    public void setFecha_consolidado(Date fecha_consolidado) {
        this.fecha_consolidado = fecha_consolidado;
    }

    public String Volver_Reporte() {
        return "index?faces-redirect=true";
    }

    public String CajaEmpleados() {
        empleado = new Empleado(1);
        return "cierre_caja_empleados";
    }

    public String Consolidado() {
        return "consolidado";
    }

    public String Reportes_servicios() {
        return "reportes_servicios";
    }

    public void addInfo(ActionEvent actionEvent) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        cadena_fecha1_11 = new StringBuilder(fecha1.format(fecha_inicio));

        SimpleDateFormat fecha2 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        cadena_fecha2_11 = new StringBuilder(fecha2.format(fecha_fin));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte entre las fechas  ", cadena_fecha1_11.toString() + "  y  " + cadena_fecha2_11.toString() + "  Se realizó correctamente."));

    }

    public void generar_consolidado() {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();
            parameters.put("fecha1", fecha_consolidado);

            //    parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_green.png"));
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//reporte_consolidado.jrxml"));

            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            // Exporta el informe a PDF
            //  JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//rep_consolidado.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "cierre_caja_diario.pdf");
//Para visualizar el pdf directamente desde java
            // JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void reporte_existencias_almacen() {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//existencias.jrxml"));

            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            // Exporta el informe a PDF
            //   JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//existencias.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "existencias.pdf");
//Para visualizar el pdf directamente desde java
            // JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void generar_Caja2() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();
            parameters.put("fecha1", fecha_cierre_caja2);
            parameters.put("id_empleado", empleado.getIdEmpleado());
            parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_red.png"));
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("reporte_ventas_filtrado_empleado.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

            JasperExportManager.exportReportToPdfFile(print, path_ + "/" + "cierre_caja_diario.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addInfoCajaEmpleados(ActionEvent actionEvent) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        StringBuilder cadena_fecha1 = new StringBuilder(fecha1.format(fecha_cierre_caja2));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El cierre de Caja para el día : ", cadena_fecha1.toString()));

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Del vendedor : ", empleado.getNombreEmpleado() + "  Se realizó correctamente."));

    }

    public String Volver_ReporteVentas() {
        return "ventas?faces-redirect=true";
    }

    public String Reportes() {
        return "nuevo_reporte";
    }

    public String Caja() {
        return "cierre_caja";
    }

    public void generar_Caja() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            cadena_fecha1_cierre = new StringBuilder(fecha1_11_cierre.format(fecha_cierre_caja));

            Map parameters = new HashMap();
            parameters.put("fecha1", fecha_cierre_caja);
            parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_gray.png"));
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_cierre_caja.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//cierre_caja_" + cadena_fecha1_cierre + ".pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "cierre_caja_" + cadena_fecha1_cierre + ".pdf");
            // agregado
            nombre_reporte_cierre = "cierre_caja_" + cadena_fecha1_cierre + ".pdf";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addInfoCaja(ActionEvent actionEvent) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        StringBuilder cadena_fecha1 = new StringBuilder(fecha1.format(fecha_cierre_caja));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El cierre de Caja para el día : ", cadena_fecha1.toString() + "  Se realizó correctamente."));
    }

    public void addInfoClientesServicios(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Reporte se Generó Correctamente.", ""));
    }

    public void addInfoVencimientos(ActionEvent actionEvent) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reporte Correcto ", " Se Generó el reporte de vencimientos correctamente"));

    }

    public void Generar_ReportesTotales() {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();
            parameters.put("fecha1", fecha_inicio);
            parameters.put("fecha2", fecha_fin);
            parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_green.png"));
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_ventas.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_ventas.pdf"));

            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_ventas.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_credito_ventas.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_ventas_credito.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_ventas_credito.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_entrada_almacen.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            //    JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_entrada_tienda.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_entrada_tienda.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_salida_almacen.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_salida_tienda.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_salida_tienda.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//reporte_ventas_empleado_final.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_ventas_empleado.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_ventas_empleado.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//existencias.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            //  JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_existencias.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_existencias.pdf");
            report = JasperCompileManager.compileReport(extContext.getRealPath("//admin//ventas_productos.jrxml"));
            print = JasperFillManager.fillReport(report, parameters, conn);
            // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_ventas_productos.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_ventas_productos.pdf");
            cadena_fecha1_11 = new StringBuilder(fecha1_11.format(fecha_inicio));
            cadena_fecha2_11 = new StringBuilder(fecha2_11.format(fecha_fin));

            fileList.clear();
            fileList = new LinkedList<String>();
            fileList.add("reporte_ventas.pdf");
            fileList.add("reporte_ventas_credito.pdf");
            fileList.add("reporte_entrada_tienda.pdf");
            fileList.add("reporte_salida_tienda.pdf");
            fileList.add("reporte_ventas_empleado.pdf");
            fileList.add("reporte_existencias.pdf");
            fileList.add("reporte_ventas_productos.pdf");

            SOURCE_FOLDER = extContext.getRealPath("//pdfs");
            //OUTPUT_ZIP_FILE = extContext.getRealPath("//pdfs//reportes_" + cadena_fecha1_11.toString() + "_HASTA_" + cadena_fecha2_11.toString() + ".zip");
            OUTPUT_ZIP_FILE = SOURCE_FOLDER + "/" + "reportes_" + cadena_fecha1_11.toString() + "_HASTA_" + cadena_fecha2_11.toString() + ".zip";
//this.generateFileList(new File(SOURCE_FOLDER));
            this.zipIt(OUTPUT_ZIP_FILE);
            nombre_reporte = "reportes_" + cadena_fecha1_11.toString() + "_HASTA_" + cadena_fecha2_11.toString() + ".zip";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void zipIt(String zipFile) {

        byte[] buffer = new byte[512];

        try {

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            // 	System.out.println("Output to Zip : " + zipFile);
            for (String file : this.fileList) {

                //System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);

                FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);

                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                in.close();

            }

            zos.closeEntry();
            //remember close it
            zos.close();

            //System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Traverse a directory and get all files, and add the file into fileList
     *
     * @param node file or directory
     */
    /*public void generateFileList(File node){

     //add file only
     if(node.isFile()){
     fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
     }

     if(node.isDirectory()){
     String[] subNote = node.list();
     for(String filename : subNote){
     generateFileList(new File(node, filename));
     }
     }

     }*/
    public void generar_Vencimientos() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_green.png"));
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//reporte_fecha_vencimiento.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//reporte_fecha_vencimiento.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/" + "reporte_fecha_vencimiento.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void generar_seguimiento_pagos() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("fecha1", fecha_inicio);
            parameters.put("fecha2", fecha_fin);
            parameters.put("id_cliente", cliente.getIdCliente());
            parameters.put("imagePath", extContext.getRealPath("//admin//leaf_banner_green.png"));

            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//reporte_pagos_ventas_credito_cliente.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //   JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//reporte_pagos_ventas_credito_cliente.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/reporte_pagos_ventas_credito_cliente.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addInfo_seguimiento_clientes(ActionEvent actionEvent) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        cadena_fecha1_11 = new StringBuilder(fecha1.format(fecha_inicio));

        SimpleDateFormat fecha2 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        cadena_fecha2_11 = new StringBuilder(fecha2.format(fecha_fin));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte de Seguimiento , para " + cliente.getNombreCliente() + " entre :  ", cadena_fecha1_11.toString() + "  y  " + cadena_fecha2_11.toString() + "  Se realizó correctamente."));

    }

    public String getNombre_reporte_seguimiento() {
        return nombre_reporte_seguimiento;
    }

    public void generar_almacenes() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_tienda", tienda.getIdTienda());

            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//existencias_filtradas.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//reporte_almacen.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/reporte_almacen.pdf");
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, extContext.getRealPath("//reporte_almacen.xls"));
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addInfo_Almacenes(ActionEvent actionEvent) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte  para  " + tienda.getNombreTienda(), "  Se realizó correctamente."));

    }

    public void Reporte_clientes_servicios() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {

            Map parameters = new HashMap();
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reporte_clientes_servicios.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//clientes_servicios.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/clientes_servicios.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String generar_Inventario() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_inventario", inventarioFisico.getIdInventarioFisico());
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//inventario_fisico.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            //JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//INVENTARIO_" + inventarioFisico.getIdInventarioFisico() + ".pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/INVENTARIO_" + inventarioFisico.getIdInventarioFisico() + ".pdf");
            return "inventario";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "inventario?faces-redirect=true";
    }

    public String generar_FechaVencimientos() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            //     parameters.put("id_inventario", inventarioFisico.getIdInventarioFisico());
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//fechasVencimiento.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//fechasVencimiento.pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/fechasVencimiento.pdf");
            return "fechas_vencimiento?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "fechas_vencimiento?faces-redirect=true";
    }

    public String Comparar_Inventario() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_inventario", inventarioFisico.getIdInventarioFisico());
            parameters.put("id_tienda", inventarioFisico.getTienda().getIdTienda());

            parameters.put("nombre_inventario", inventarioFisico.getObervaciones().toUpperCase());
            parameters.put("nombre_tienda", inventarioFisico.getTienda().getNombreTienda().toUpperCase());

            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//compara_inventario.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
           // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//COMPARA_INVENTARIO_" + inventarioFisico.getIdInventarioFisico() + ".pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/COMPARA_INVENTARIO_" + inventarioFisico.getIdInventarioFisico() + ".pdf");
            return "compara_inventario?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "compara_inventario?faces-redirect=true";
    }

    public String generar_Ventas_Rapidas() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_venta_rapida", ventaRapida.getIdVentaRapida());
            JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//ventas_rapidas.jrxml"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
           // JasperExportManager.exportReportToPdfFile(print, extContext.getRealPath("//pdfs//VENTA_RAPIDA_" + ventaRapida.getIdVentaRapida() + ".pdf"));
            JasperExportManager.exportReportToPdfFile(print, path_ + "/pdfs/VENTA_RAPIDA_" + ventaRapida.getIdVentaRapida() + ".pdf");
            return "venta_rapida";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "venta_rapida?faces-redirect=true";
    }

    public void rep1() {

        // System.out.println(" ENTRAMOS A rep1: ");
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext context = FacesContext.getCurrentInstance();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_venta_rapida", ventaRapida.getIdVentaRapida());
            //JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//ventas_rapidas.jrxml"));
            JasperReport report = (JasperReport) JRLoader.loadObject(extContext.getRealPath("//reportes//esp//stockPrecioLista.jasper"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            crearPDF(print, "StockValorizado");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void rep2() {

        System.out.println(" ENTRAMOS A rep2: ");

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext context = FacesContext.getCurrentInstance();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("id_venta_rapida", ventaRapida.getIdVentaRapida());
            //JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//ventas_rapidas.jrxml"));
            JasperReport report = (JasperReport) JRLoader.loadObject(extContext.getRealPath("//reportes//esp//stockCantidadMinima.jasper"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            crearPDF(print, "StockCantidadMinima");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void rep3() {

        System.out.println(" ENTRAMOS A rep3: ");

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext context = FacesContext.getCurrentInstance();
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        try {
            Map parameters = new HashMap();

            parameters.put("fecha1", fecha_inicio);
            parameters.put("fecha2", fecha_fin);
            //JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//ventas_rapidas.jrxml"));
            JasperReport report = (JasperReport) JRLoader.loadObject(extContext.getRealPath("//reportes//esp//ingresosMercaderia.jasper"));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
            crearPDF(print, "IngresosAlmacen");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * Cleanup antes de salir
             */
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("ROLLBACK EJECUTADO");
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void PPT() throws JRException, IOException {

        //   System.out.println(" ENTRAMOS A PPT: ");
        // Cargamos el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        }
        //Para iniciar el Logger.
        //inicializaLogger();
        try {
            conn = DriverManager.getConnection(cadena_conexion, "root", password);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }

        Map parameters = new HashMap();

        //parameters.put("id_venta_rapida", ventaRapida.getIdVentaRapida());
        //JasperReport report = JasperCompileManager.compileReport(extContext.getRealPath("//reportes//ventas_rapidas.jrxml"));
        JasperReport report = (JasperReport) JRLoader.loadObject(extContext.getRealPath("//reportes//esp//stockPrecioLista.jasper"));
        JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pptx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRPptxExporter docxExporter = new JRPptxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void crearPDF(JasperPrint print, String nombreReporte) throws JRException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombreReporte + ".pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
        exporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void crearPPT(JasperPrint print) throws JRException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pptx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRPptxExporter docxExporter = new JRPptxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void crearDOCX(JasperPrint print) throws JRException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.docx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRDocxExporter docxExporter = new JRDocxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void crearXLSX(JasperPrint print) throws JRException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.xlsx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRXlsxExporter docxExporter = new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void crearODT(JasperPrint print) throws JRException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.odt");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JROdtExporter docxExporter = new JROdtExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
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

    public void resetarFechas() {
        fecha_inicio = new Date();
        fecha_fin = new Date();
    }
}
