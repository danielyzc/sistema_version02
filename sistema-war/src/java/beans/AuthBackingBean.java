/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yzavaleta
 */
@ManagedBean(name = "authBackingBean")
@RequestScoped
public class AuthBackingBean implements Serializable {

    private static Logger log = Logger.getLogger(AuthBackingBean.class.getName());

    public String logout() {
        String result = "/login.jsf";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {

            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (ServletException e) {
            System.out.println("ERROR LOGOUT" + e);
            log.log(Level.SEVERE, "Failed to logout user!", e);
            result = "/loginError?faces-redirect=true";
        }

        return result;
    }
}
