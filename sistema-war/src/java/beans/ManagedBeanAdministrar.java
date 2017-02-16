
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel Copyright 2011 Zavaleta De la
 * Cruz Yury Daniel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
@SessionScoped
@ManagedBean
public class ManagedBeanAdministrar implements Serializable {

    public ManagedBeanAdministrar() {
    }

    public String reporteEspecializado() {
        return "reportes_especializados";
    }

    public String Nuevo() {
        return "administrar";
    }

    public String Productos() {
        return "productos";
    }

    public String Tiendas() {
        return "almacenes";
    }

    public String UbicacionesFisicas() {
        return "ubicaciones_fisicas";
    }

    public String Empleados() {
        return "empleados";
    }

    public String Mercados() {
        return "mercados";
    }

    public String Tipo_Clientes() {
        return "tipo_clientes";
    }

    public String Zona_clientes() {
        return "zona_clientes";
    }

    public String Tipo_Pruductos() {
        return "tipo_productos";
    }

    public String Tipo_Proveedor() {
        return "tipo_proveedor";
    }

    public String Estado_OrdenCompra() {
        return "estado_orden_compra";
    }

    public String Proveedores() {
        return "proveedores";
    }

    public String Inventario() {
        return "inventario";
    }

    public String Accesorios() {
        return "accesorios";
    }

    public String PreciProductos() {
        return "precio_productos";
    }

    public String Clientes() {
        return "clientes";
    }

    public String Ubicaciones() {
        return "ubicaciones";
    }

    public String Ubicacion1() {
        return "ubicacion1";
    }

    public String Ubicacion2() {
        return "ubicacion2";
    }

    public String Ubicacion3() {
        return "ubicacion3";
    }

    public String Vencimientos() {
        return "fechas_vencimiento";
    }

    public String Letras() {
        return "letras";
    }

    public String Unidades() {
        return "unidades";
    }

    public String MateriasPrimas() {
        return "materias_primas";
    }

    public String Formulacion() {
        return "formulas";
    }

    public String Motivos() {
        return "motivos_translado_factura";
    }

    public String Transporte() {
        return "unidades_transporte";
    }

    public String Conductores() {
        return "conductores";
    }

    public String TipoServicios() {
        return "tipo_servicio";
    }
}
