/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bc.StockProductoTiendaOrigenFacadeLocal;
import beans.ManagedBeanStock;
import beans.ManagedBeanVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.naming.ldap.ManageReferralControl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author root
 */
@WebServlet(name = "Servicio", urlPatterns = {"/Servicio"})
public class Servicio extends HttpServlet {

    @EJB
    private StockProductoTiendaOrigenFacadeLocal stockProductoTiendaOrigenFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("estado", -100);
        try {
            if (request.getParameter("datos01") != null && request.getParameter("datos01") != "") {
                jsonResult.put("estado", validar(request.getParameter("datos01").trim()));
            } else {
                jsonResult.put("estado", 10);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            jsonResult.put("estado", -1);
        } finally {
            out.println(jsonResult);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String validar(String datos) {
        Date momento = new Date();
        String resultado_ = "0";
        //System.out.println(" entramos ... " + datos);
        String param_ = "%" + datos.trim().replace(" ", "%") + "%";
        //System.out.println(" enviando .." + param_.toUpperCase());
        try {
            List<Object[]> res = stockProductoTiendaOrigenFacade.consulta_webservice(param_.toUpperCase());
            if (res.size() > 0) {
                resultado_ = "";
            }
            for (Object[] o : res) {
                resultado_ = resultado_ + String.valueOf(o[1]) + "\n\n";
            }

            /*List<Object[]>  res = stockProductoTiendaOrigenFacade.consulta_webservice(param_.toUpperCase());
             for(int i=0; i < res.size();i++){
             //  System.out.println(res.get(i)[1]);
             resultado_ = resultado_ + String.valueOf(res.get(i)[1])+ "\n";
             }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(" vamos a devolver :" + resultado_);
        return resultado_;
    }

}
