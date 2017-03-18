/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cliente.findByGiroRubro", query = "SELECT c FROM Cliente c WHERE c.giroRubro = :giroRubro"),
    @NamedQuery(name = "Cliente.findByContacto", query = "SELECT c FROM Cliente c WHERE c.contacto = :contacto"),
    @NamedQuery(name = "Cliente.findByRucCliente", query = "SELECT c FROM Cliente c WHERE c.rucCliente = :rucCliente"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByNextel", query = "SELECT c FROM Cliente c WHERE c.nextel = :nextel"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "giro_rubro")
    private String giroRubro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 40)
    @Column(name = "ruc_cliente")
    private String rucCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 25)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 25)
    @Column(name = "nextel")
    private String nextel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;
    @JoinColumn(name = "id_mercado", referencedColumnName = "id_mercado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mercado mercado;
    @JoinColumn(name = "id_tipo_cliente", referencedColumnName = "id_tipo_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoCliente tipoCliente;
    @JoinColumn(name = "id_zona_ciudad", referencedColumnName = "id_zona_ciudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ZonaCiudad zonaCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreCliente, String razonSocial, String giroRubro, String contacto, String rucCliente, String direccion, String telefono, String celular, String nextel, String correo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.razonSocial = razonSocial;
        this.giroRubro = giroRubro;
        this.contacto = contacto;
        this.rucCliente = rucCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.nextel = nextel;
        this.correo = correo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getGiroRubro() {
        return giroRubro;
    }

    public void setGiroRubro(String giroRubro) {
        this.giroRubro = giroRubro;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNextel() {
        return nextel;
    }

    public void setNextel(String nextel) {
        this.nextel = nextel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public ZonaCiudad getZonaCiudad() {
        return zonaCiudad;
    }

    public void setZonaCiudad(ZonaCiudad zonaCiudad) {
        this.zonaCiudad = zonaCiudad;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductosCostos> getOrdenSalidaDetalleAlmacenProductosCostosList() {
        return ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosCostosList(List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList) {
        this.ordenSalidaDetalleAlmacenProductosCostosList = ordenSalidaDetalleAlmacenProductosCostosList;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
