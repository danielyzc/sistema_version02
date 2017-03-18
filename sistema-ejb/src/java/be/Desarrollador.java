/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "desarrollador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desarrollador.findAll", query = "SELECT d FROM Desarrollador d"),
    @NamedQuery(name = "Desarrollador.findByIdDesarrollador", query = "SELECT d FROM Desarrollador d WHERE d.idDesarrollador = :idDesarrollador"),
    @NamedQuery(name = "Desarrollador.findByNombre", query = "SELECT d FROM Desarrollador d WHERE d.nombre = :nombre")})
public class Desarrollador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desarrollador")
    private Integer idDesarrollador;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;

    public Desarrollador() {
    }

    public Desarrollador(Integer idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public Integer getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(Integer idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesarrollador != null ? idDesarrollador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desarrollador)) {
            return false;
        }
        Desarrollador other = (Desarrollador) object;
        if ((this.idDesarrollador == null && other.idDesarrollador != null) || (this.idDesarrollador != null && !this.idDesarrollador.equals(other.idDesarrollador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Desarrollador[ idDesarrollador=" + idDesarrollador + " ]";
    }
    
}
