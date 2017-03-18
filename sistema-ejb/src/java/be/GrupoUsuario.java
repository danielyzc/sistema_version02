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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "grupo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoUsuario.findAll", query = "SELECT g FROM GrupoUsuario g"),
    @NamedQuery(name = "GrupoUsuario.findByIdGrupoUsuario", query = "SELECT g FROM GrupoUsuario g WHERE g.idGrupoUsuario = :idGrupoUsuario")})
public class GrupoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_usuario")
    private Integer idGrupoUsuario;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Grupo grupo;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public GrupoUsuario() {
    }

    public GrupoUsuario(Integer idGrupoUsuario) {
        this.idGrupoUsuario = idGrupoUsuario;
    }

    public Integer getIdGrupoUsuario() {
        return idGrupoUsuario;
    }

    public void setIdGrupoUsuario(Integer idGrupoUsuario) {
        this.idGrupoUsuario = idGrupoUsuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoUsuario != null ? idGrupoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuario)) {
            return false;
        }
        GrupoUsuario other = (GrupoUsuario) object;
        if ((this.idGrupoUsuario == null && other.idGrupoUsuario != null) || (this.idGrupoUsuario != null && !this.idGrupoUsuario.equals(other.idGrupoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.GrupoUsuario[ idGrupoUsuario=" + idGrupoUsuario + " ]";
    }
    
}
