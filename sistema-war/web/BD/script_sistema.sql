/**
 *
 **copyright  2011 yury daniel zavaleta de la cruz
 * licensed under the apache license, version 2.0 (the «license»);
 * you may not use this file except in compliance with the license.
 * you may obtain a copy of the license at
 * http://www.apache.org/licenses/license-2.0
 * unless required by applicable law or agreed to in writing,
 * software distributed under the license is distributed on an «as is» basis,
 * without warranties or conditions of any kind, either express or implied.
 * see the license for the specific language governing permissions and  limitations under the license.
 */

/*agregago para matxencargo*/

create table ubicacion_fisica(
id_ubicacion_fisica int(11) not null auto_increment,
nombre_ubicacion_fisica varchar(100) not null default '',
descripcion_ubicacion_fisica varchar(100) not null default '',
primary key (id_ubicacion_fisica)
)engine=innodb;

create table zona_ciudad(
id_zona_ciudad int(11) not null auto_increment,
descripcion_zona_ciudad varchar(150) not null default '',
flag_estado varchar(2) not null default 'si',
primary key (id_zona_ciudad)
)engine=innodb;


create table modelo_producto(
id_modelo_producto int(11) not null auto_increment,
nombre_modelo_producto varchar(100) not null default '',
descripcion varchar(250) not null default '',
fec_creacion datetime,
fec_modificacion datetime,
fec_eliminacion datetime,
usu_crea int,
usu_modi int,
usu_elim int,
estado_existencia int(1),
primary key(id_modelo_producto)
)engine=innodb;

/*agregado*/
create table mercado(
id_mercado int(11) not null auto_increment,
nombre_mercado varchar(200) not null default '',
descripcion varchar(250) not null default '',
primary key(id_mercado)
)engine=innodb;

/*
agregado
*/
create table estado_producto_costo_almacen(
id_estado_producto_costo_almacen  int(3) not null auto_increment,
nombre varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_estado_producto_costo_almacen)
)engine=innodb;

/*
agregado
*/
create table procedencia_producto_almacen(
id_procedencia_producto_almacen  int(11) not null auto_increment,
nombre varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_procedencia_producto_almacen)
)engine=innodb;


/*
agregado
*/
create table estado_orden_salida_detalle_almacen_productos(
id_estado_orden_salida_detalle_almacen_productos  int(3) not null auto_increment,
nombre_estado varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_estado_orden_salida_detalle_almacen_productos)
)engine=innodb;



/*
agregado
*/
create table estado_igv(
id_estado_igv  int(3) not null auto_increment,
nombre_estado varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_estado_igv)
)engine=innodb;


/*agregado*/
create table tipo_cliente(
id_tipo_cliente int(11) not null auto_increment,
nombre_tipo_cliente varchar(100) not null default '',
descripcion varchar(250) not null default '',
primary key (id_tipo_cliente)
)engine=innodb;

/*agregado*/
create table cliente(
id_cliente int(11) not null auto_increment,
id_mercado int(11) not null,
id_tipo_cliente int(11) not null,
nombre_cliente varchar(150) not null default '',
razon_social varchar(150) not null default '',
giro_rubro varchar(150) not null default '',
contacto varchar(100) not null default '',
ruc_cliente varchar(40) not null default '',
direccion varchar(250) not null default '',
telefono varchar(25) not null default '',
celular varchar(25) not null default '',
nextel varchar(25) not null default '',
correo varchar(250) not null default '',
id_zona_ciudad int(11) not null,
primary key(id_cliente),
foreign key (id_mercado) references mercado (id_mercado),
foreign key (id_tipo_cliente) references tipo_cliente (id_tipo_cliente),
foreign key (id_zona_ciudad) references zona_ciudad (id_zona_ciudad)
)engine=innodb;


create table color_producto(
id_color_producto int(11) not null auto_increment,
nombre_color_producto varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key(id_color_producto)
)engine=innodb;

create table talla_producto(
pk_id int(11) not null auto_increment,
nombre_talla_producto varchar(100) not null default '',
descripcion varchar(170) not null default '',
fec_creacion datetime,
fec_modificacion datetime,
fec_eliminacion datetime,
usu_crea int,
usu_modi int,
usu_elim int,
estado_existencia int(1),
primary key(pk_id)
)engine=innodb;

create table estado_producto(
id_estado_producto int(11) not null auto_increment,
nombre_estado_producto varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key(id_estado_producto)
)engine=innodb;

create table material_producto(
id_material_producto int(11) not null auto_increment,
nombre_material_producto varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key(id_material_producto)
)engine=innodb;



create table tipo_producto(
id_tipo_producto int(11) not null auto_increment,
nombre_tipo_producto varchar(100) not null default '',
descripcion varchar(170) not null default '',
fec_creacion datetime,
fec_modificacion datetime,
fec_eliminacion datetime,
usu_crea int,
usu_modi int,
usu_elim int,
estado_existencia int(1),
primary key (id_tipo_producto)
)engine=innodb;

create table marca_producto(
pk_id int(11) not null auto_increment,
nombre varchar(100) not null default '',
descripcion varchar(170) not null default '',
fec_creacion datetime,
fec_modificacion datetime,
fec_eliminacion datetime,
usu_crea int,
usu_modi int,
usu_elim int,
estado_existencia int(1),
primary key (pk_id)
)engine=innodb;

create table tipo_venta(
id_tipo_venta  int(11) not null auto_increment,
nombre_tipo_venta varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_tipo_venta)
)engine=innodb;

create table estado_venta(
id_estado_venta  int(11) not null auto_increment,
nombre_testado_venta varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_estado_venta)
)engine=innodb;


create table tipo_empleado(
id_tipo_empleado int(11) not null auto_increment,
nombre varchar(100) not null default '',
descripcion varchar(170) not null default '',
primary key (id_tipo_empleado)
)engine=innodb;

create table negocio(
id_negocio int(11) not null auto_increment,
nombre_negocio varchar(350) not null default '',
primary key (id_negocio)
)engine=innodb;


create table tienda(
id_tienda int(11) not null auto_increment,
nombre_tienda varchar(350) not null default '',
direccion varchar(200) not null default '',
ciudad varchar(200) not null default '',
distrito varchar(200) not null default '',
telefonos varchar(400) not null default '',
numero_ruc varchar(20) not null default '',
id_negocio int(11) ,
primary key (id_tienda),
foreign key (id_negocio) references negocio (id_negocio)
)engine=innodb;


create table empleado(
id_empleado  int(11) not null auto_increment,
id_tienda  int(11) not null,
nombre_empleado varchar(150) not null default '',
direccion varchar(250) not null default '',
telefono varchar(48)not null default '',
correo varchar(68) not null default '',
usuario varchar(100) not null default '',
password varchar(170) not null default '',
id_tipo_empleado int(11) not null,
/*agregado daniel ferreteria*/
sueldo_base decimal(9,4),
estado_existencia int default 1,
primary key (id_empleado),
foreign key (id_tipo_empleado) references tipo_empleado (id_tipo_empleado),
foreign key (id_tienda) references tienda (id_tienda)
)engine=innodb;


create table grupo(
id_grupo int(11) not null auto_increment,
nombre_grupo varchar(100) not null default '',
descripcion_grupo varchar(100) not null default '',
primary key (id_grupo)
)engine=innodb;

create table grupo_usuario(
id_grupo_usuario int(11) not null auto_increment,
id_grupo int(11) not null ,
id_empleado int(11) not null,
primary key (id_grupo_usuario),
foreign key (id_grupo) references grupo (id_grupo),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;

delimiter //
create trigger inserta_usuarios
 before insert on empleado
 for each row
 begin

set new.password = SHA2(new.password, 256);

end//
delimiter ;

create view V_USER_ROLE as (
select e.usuario as USUARIO, e.password as PASSWORD, g.nombre_grupo as GRUPO from empleado e inner join grupo_usuario gu
on e.id_empleado = gu.id_empleado inner join grupo g on g.id_grupo=gu.id_grupo where e.estado_existencia = 1
);








create table venta(
id_venta int(11) not null auto_increment,
bloque_venta int(4) not null,
numero_venta int(6) not null,
fecha_venta date not null,
/*agregado*/
fecha_venta_emision date not null,
id_tienda int(11) not null,
id_empleado int(11) not null,
id_tipo_venta  int(11) not null,
id_estado_venta  int(11) ,
total_venta decimal(9,2) not null default 0,
observaciones varchar(200) not null default '',
/*agregado*/
id_cliente int(11) not null,
total_pagos_credito decimal(9,2) not null default 0,
/*cambio tabla*/
factura_relacionada varchar(50)  default '',
tipo_documento int(1) default 1,
dato_documento varchar(100) default '',
estado_existencia int(1) default 1,
fec_reg datetime,
primary key (id_venta),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_empleado) references empleado (id_empleado),
foreign key (id_tipo_venta) references tipo_venta (id_tipo_venta),
/*agregado*/
foreign key (id_cliente) references cliente (id_cliente),
foreign key (id_estado_venta) references estado_venta (id_estado_venta)
)engine=innodb;




/*agregando las facturas de venta*/

create table motivo_translado_factura(
id_motivo_translado_factura int(11) not null auto_increment,
motivo varchar(100) not null default '',
descripcion varchar(250) not null default '',
primary key(id_motivo_translado_factura)
)engine=innodb;

create table igv_factura(
id_igv_factura int(11) not null auto_increment,
monto decimal(4,2) not null,
descripcion varchar(250) not null default '',
id_estado_igv int (3) not null,
primary key(id_igv_factura),
foreign key (id_estado_igv) references estado_igv (id_estado_igv)
)engine=innodb;


create table unidad_transporte(
id_unidad_transporte int(11) not null auto_increment,
marca varchar(200) not null default '',
numero_placa varchar(200) not null default '',
numero_constancia_inscripcion varchar(200) not null default '',
observaciones varchar(200) not null default '',
fecha_registro date not null,
primary key (id_unidad_transporte)
)engine=innodb;

create table conductor(
id_conductor int(11) not null auto_increment,
nombre varchar(200) not null default '',
ruc varchar(200) not null default '',
numero_licencia_conducir varchar(200) not null default '',
observaciones varchar(200) not null default '',
fecha_registro date not null,
primary key (id_conductor)
)engine=innodb;






create table factura_venta(
id_factura_venta int(12) not null auto_increment,
/* el bloque y el numero sale con mod en mysql*/
bloque_factura int(4) not null,
numero_factura int(6) not null,
fecha_venta date not null,
/*agregado*/
fecha_venta_emision datetime not null,
id_tienda int(11) not null,
id_empleado int(11) not null,
id_tipo_venta  int(11) not null,
id_estado_venta  int(11) ,
total_venta decimal(9,2) not null default 0,
id_igv_factura int(11) not null,
total_venta_incluido_igv decimal(11,2) not null default 0,
observaciones varchar(200) not null default '',
/*agregado*/
id_cliente int(11) not null,
total_pagos_credito decimal(9,2) not null default 0,
estado_existencia int(1) default 1,
fec_reg datetime,
primary key (id_factura_venta),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_empleado) references empleado (id_empleado),
foreign key (id_tipo_venta) references tipo_venta (id_tipo_venta),
/*agregado*/
foreign key (id_cliente) references cliente (id_cliente),
foreign key (id_estado_venta) references estado_venta (id_estado_venta),
foreign key (id_igv_factura) references igv_factura (id_igv_factura)
)engine=innodb;

create table guia_remicion(
id_guia_remicion int(11) not null auto_increment,
punto_partida varchar(200) not null default '',
punto_llegada varchar(200) not null default '',
observaciones varchar(200) not null default '',
fecha_inicio_translado date not null,
id_unidad_transporte int(11) not null,
id_conductor int(11) not null,
id_motivo_translado_factura int(11) not null,
id_factura_venta int(12) not null,
primary key (id_guia_remicion),
foreign key (id_unidad_transporte) references unidad_transporte (id_unidad_transporte),
foreign key (id_conductor) references conductor (id_conductor),
foreign key (id_motivo_translado_factura) references motivo_translado_factura (id_motivo_translado_factura),
foreign key (id_factura_venta) references factura_venta (id_factura_venta)
)engine=innodb;



create table producto(
id_producto int(11) not null auto_increment,
nombre_producto varchar(300) not null default '',
fk_marca_producto int(11) not null,
id_modelo_producto  int(11) not null,
id_color_producto int(11) not null,
fk_talla_producto int(11) not null,
fecha_ingreso date not null,
id_estado_producto int(11) not null,
id_tipo_producto  int(11) not null,
id_material_producto int(11) not null,
fec_creacion datetime,
fec_modificacion datetime,
fec_eliminacion datetime,
usu_crea int,
usu_modi int,
usu_elim int,
estado_existencia int(1) default 1,
primary key (id_producto), 
foreign key (fk_marca_producto) references marca_producto (pk_id),
foreign key (id_modelo_producto) references modelo_producto (id_modelo_producto),
foreign key (id_tipo_producto)  references tipo_producto (id_tipo_producto),
foreign key (id_color_producto) references color_producto (id_color_producto),
foreign key (fk_talla_producto) references talla_producto (pk_id),
foreign key (id_estado_producto) references estado_producto (id_estado_producto),
foreign key (id_tipo_producto) references tipo_producto (id_tipo_producto),
foreign key (id_material_producto) references material_producto (id_material_producto)
)engine=innodb;

create table detalle_venta_producto(
id_detalle_venta_producto int(11) not null auto_increment,
id_venta int(11) not null,
id_producto int(11) not null,
cantidad int not null default 1,
precio_venta decimal (9,2) not null,
descuento decimal (9,2) not null default 0.0,
sub_total decimal (9,2) not null, 
primary key (id_detalle_venta_producto),
foreign key (id_venta)
references venta (id_venta),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;


create table detalle_factura_venta_producto(
id_detalle_factura_venta_producto int(11) not null auto_increment,
id_factura_venta int(11) not null,
id_producto int(11) not null,
cantidad int not null default 1,
precio_venta decimal (9,2) not null,
descuento decimal (9,2) not null default 0.0,
sub_total decimal (9,2) not null, 
primary key (id_detalle_factura_venta_producto),
foreign key (id_factura_venta)
references factura_venta (id_factura_venta),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;



create table devolucion_lima(
id_devolucion int(11) not null auto_increment,
id_producto int(11) not null,
fecha_devolucion date not null,
motivo_devolucion varchar(300) not null default '',
primary key (id_devolucion),
foreign key (id_producto) references producto (id_producto)
)engine=innodb;

create table cambio(
id_cambio int(11) not null auto_increment,
id_venta int(11) not null,
fecha_cambio date not null,
motivo_cambio varchar(300) not null default '',
primary key (id_cambio),
foreign key (id_venta)references venta (id_venta)
)engine=innodb;

create table detalle_cambio_producto(
id_cambio int(11) not null,
id_producto_cambio int(11) not null,
id_producto_cambiada int(11) not null,
primary key (id_cambio,id_producto_cambio,id_producto_cambiada),
foreign key (id_cambio) references cambio (id_cambio),
foreign key (id_producto_cambio) references producto (id_producto),
foreign key (id_producto_cambiada) references producto (id_producto)
)engine=innodb;

create table stock_producto_tienda_origen(
id_producto int(11) not null,
id_tienda_origen  int(11) not null,
cantidad int(5) not null,
ultima_fecha_ingreso date not null,
descripcion varchar(370) default '',
cantidad_minima_stock int not null default 1,
primary key (id_producto,id_tienda_origen),
foreign key (id_producto) references producto (id_producto),
foreign key (id_tienda_origen) references tienda (id_tienda)
)engine=innodb;


/* vamos a agregar la ubicacion del producto*/
/*   aqui es en donde se registran los ingresos */
create table ingreso_producto_tienda(
id_ingreso_producto_tienda int(11) not null auto_increment,
id_tienda int(11) not null,
id_producto int(11) not null,
cantidad  int(11) not null,
fecha_ingreso date not null,
fecha_vencimiento date not null default '1990-01-01',
motivo varchar(300) not null default '',
/*ubicacion varchar(300) not null default '',*/
id_ubicacion_fisica int(11) not null,
costo_unitario decimal (9,2) not null,
primary key (id_ingreso_producto_tienda),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_producto) references producto (id_producto),
foreign key (id_ubicacion_fisica) references ubicacion_fisica (id_ubicacion_fisica)
)engine=innodb;


create table salida_producto_tienda(
id_salida_producto_tienda int(11) not null auto_increment,
id_tienda int(11) not null,
id_producto int(11) not null,
cantidad  int(11) not null,
fecha_salida date not null,
motivo varchar(300) not null default '',
primary key (id_salida_producto_tienda),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_producto) references producto (id_producto)
)engine=innodb;


create table prestamo_producto_tienda_usuario(
id_prestamo_producto_tienda int(11) not null auto_increment,
id_tienda_presta int(11) not null,
id_tienda_recibe int(11) not null,
id_empleado int(11) not null,
cantidad  int(11) not null,
fecha_ingreso date not null,
primary key (id_prestamo_producto_tienda),
foreign key (id_empleado) references empleado (id_empleado),
foreign key (id_tienda_presta) references tienda (id_tienda),
foreign key (id_tienda_recibe) references tienda (id_tienda)
)engine=innodb;



/*agregado*/
  create table estado_orden_compra(
 id_estado_orden_compra int(11) auto_increment not null,
 nombre varchar(250) not null default '',
 descripcion varchar(100) not null default '',
 primary key (id_estado_orden_compra)
 )engine=innodb;

/*agregado*/
  create table estado_facturacion_orden_compra(
 id_estado_facturacion_orden_compra int(11) auto_increment not null,
 nombre varchar(250) not null default '',
 descripcion varchar(100) not null default '',
 primary key (id_estado_facturacion_orden_compra)
 )engine=innodb;

/*agregado*/
 create table tipo_proveedor(
 id_tipo_proveedor int(11) auto_increment not null,
 nombre varchar(250) not null default '',
 descripcion varchar(100) not null default '',
 primary key (id_tipo_proveedor)
 )engine=innodb;

/*agregado*/
 create table proveedor(
 id_proveedor int(11) auto_increment not null,
 nombre varchar(170) not null default '',
 direccion varchar(150) not null default '',
 id_tipo_proveedor int(11), 
 telefono varchar(48)not null default '',
 celular varchar(48)not null default '',
 nextel varchar(48)not null default '',
 correo varchar(68) not null default '',
 primary key (id_proveedor),
  foreign key (id_tipo_proveedor) references tipo_proveedor (id_tipo_proveedor)
 )engine=innodb;


/*agregado*/
create table orden_compra(
id_orden_compra int(11) not null auto_increment,
fecha_creacion_orden_compra date not null,
fecha_entrega_orden_compra date not null,
id_proveedor int(11),
total_orden_compra decimal(9,2) not null default 0.0,
total_pagos_credito_orden_compra decimal(9,2) not null default 0.0,
id_estado_orden_compra int(1) not null default 1,
id_estado_facturacion_orden_compra int(1) not null default 1,
observaciones varchar(300) not null default '',
 primary key (id_orden_compra),
 foreign key (id_estado_orden_compra) references estado_orden_compra (id_estado_orden_compra),
foreign key (id_estado_facturacion_orden_compra) references estado_facturacion_orden_compra (id_estado_facturacion_orden_compra),
foreign key (id_proveedor ) references proveedor (id_proveedor )
)engine=innodb;	

/*agregado*/
create table detalle_orden_compra_producto(
id_orden_compra int(11) not null,
id_producto int(11) not null,
cantidad int not null default 1,
precio_venta decimal (9,2) not null,
descuento decimal (4,2) not null default 0.0,
sub_total decimal (9,2) not null, 
primary key (id_orden_compra,id_producto),
foreign key (id_orden_compra)
references orden_compra (id_orden_compra),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;


/*agregado*/
create table factura_compra(
id_factura_compra int(11) not null auto_increment,
id_orden_compra int not null default 0,
fecha_recepcion date not null ,
numero_factura_compra varchar(68) not null default '',
numero_guia_remision  varchar(68) not null default '',
descripcion  varchar(170) not null default '',
id_empleado  int(11),
primary key (id_factura_compra),
foreign key (id_orden_compra) references orden_compra (id_orden_compra),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;

/*agregado*/
create table precio_producto(
pk_id int(11) not null auto_increment,
id_producto int(11),
fecha_actualizacion date not null,
precio_producto decimal(9,2) not null default 0,
primary key (pk_id),
foreign key (id_producto) references producto (id_producto)
)engine=innodb;



/*agregado*/
create table ingresos_economicos(
id_ingresos_economicos int(11) not null auto_increment,
motivo varchar(200) not null default '',
nota varchar(300) not null default '',
fecha_creacion date not null ,
total decimal (9,2) not null,
primary key(id_ingresos_economicos)
)engine=innodb;
/*agregado*/
create table gastos_economicos(
id_gastos_economicos int(11) not null auto_increment,
motivo varchar(200) not null default '',
nota varchar(300) not null default '',
fecha_creacion date not null ,
total decimal (9,2) not null,
primary key(id_gastos_economicos)
)engine=innodb;

/*agregado*/
create table pago_venta_credito(
id_pago_venta_credito int(11) not null auto_increment,
id_venta int(11) ,
fecha_ingreso date not null,
id_empleado int(11) ,
observaciones varchar(170) not null default '',
cantidad  decimal (9,2) not null,
primary key (id_pago_venta_credito),
foreign key (id_venta) references venta (id_venta),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;


/*agregado*/
create table pago_factura_venta_credito(
id_pago_factura_venta_credito int(11) not null auto_increment,
id_factura_venta int(12) ,
fecha_ingreso date not null,
id_empleado int(11) ,
observaciones varchar(170) not null default '',
cantidad  decimal (9,2) not null,
primary key (id_pago_factura_venta_credito),
foreign key (id_factura_venta) references factura_venta (id_factura_venta),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;




/*agregado*/
create table pago_compra_credito(
id_pago_compra_credito int(11) not null auto_increment,
id_orden_compra int(11) ,
fecha_ingreso date not null,
id_empleado int(11) not null,
observaciones varchar(170) not null default '',
cantidad  decimal (9,2) not null,
primary key (id_pago_compra_credito),
foreign key (id_orden_compra) references orden_compra (id_orden_compra),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;

/*agregado*/
create table nota_credito(
id_nota_credito int(11) not null auto_increment,
fecha_registro date not null,
cantidad decimal (9,3) not null,
descripcion varchar(200),
id_venta int(11),
primary key (id_nota_credito),
foreign key (id_venta) references venta (id_venta)
)engine=innodb;







delimiter //
create trigger inserta_detalles
 after insert on detalle_venta_producto
/*
usa este detalle, para que uses el id_venta, a traves de eso vas a poder actualizar un campo
en la venta que se llame : utilidad y que sea la resta del costo en almacen entre el precio de venta
*/
 for each row
 begin
declare x int(11) default 0;
declare id_ int(11) default 0;

/*
agregado para las salidas en almacen
*/
declare id_cliente  int(11) default 0;
declare desc_ubicacion varchar(370) default '';


declare id_deta  int(50);
declare _cant int(10);
declare _resto int(10);
declare _id_tienda  int(11);
declare err_no_more_records condition for 1329;
declare c cursor for select dt.id_detalle_almacen_productos, dt.quedaron,dt.id_tienda
,uf.nombre_ubicacion_fisica from detalle_almacen_productos dt 
inner join ubicacion_fisica uf on uf.id_ubicacion_fisica = dt.id_ubicacion_fisica
where dt.id_producto=new.id_producto and dt.id_estado_producto_costo_almacen=1

order by dt.costo;
declare exit handler for err_no_more_records



begin
end;


/*agregado un nuevo into para cliente.*/
/*select id_cliente into id_cliente from venta where id_venta = new.id_venta;   */

select distinct v.id_tienda, v.id_cliente into id_ , id_cliente  from detalle_venta_producto dt inner join venta v
on dt.id_venta=v.id_venta where v.id_venta=new.id_venta;
update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;
set _resto =new.cantidad;
open c;

set x = 0;
size: loop
fetch c into id_deta,_cant,_id_tienda,desc_ubicacion;

if id_  = _id_tienda and _cant <= _resto then



update detalle_almacen_productos set id_estado_producto_costo_almacen=2,salieron=salieron+_cant,quedaron=0  
where id_detalle_almacen_productos=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion, now(),new.id_venta,_cant,1);


set _resto = _resto - _cant;
else

if id_  = _id_tienda then
update detalle_almacen_productos set id_estado_producto_costo_almacen=1,salieron=salieron + _resto,quedaron=quedaron-_resto
where id_detalle_almacen_productos=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion,now(),new.id_venta,_resto,1);

set _resto=0;
end if;


end if;


  if _resto=0 then
 leave size; 
           
end if;

end loop size;
close c;


end//
delimiter ;

















/*
delimiter //
create trigger inserta_detalles
 after insert on detalle_venta_producto
 for each row
 begin
declare id_ int(11) default 0;
select distinct v.id_tienda into id_ from detalle_venta_producto dt inner join venta v
on dt.id_venta=v.id_venta where v.id_venta=new.id_venta;
update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;






end//
delimiter ;
*/

/*
delimiter //
create trigger inserta_detalles
 after insert on detalle_venta_producto
 for each row
 begin
declare x int(11) default 0;
declare id_ int(11) default 0;
declare id_deta  int(50);
declare err_no_more_records condition for 1329;
declare c cursor for select dt.id_detalle_almacen_productos_costos from detalle_almacen_productos_costos dt 
where dt.id_producto=new.id_producto and dt.id_estado_producto_costo_almacen=1
order by dt.costo;
declare exit handler for err_no_more_records



begin
end;

select distinct v.id_tienda into id_ from detalle_venta_producto dt inner join venta v
on dt.id_venta=v.id_venta where v.id_venta=new.id_venta;
update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;

open c;

set x = 0;
size: loop
fetch c into id_deta;



if x < new.cantidad   then             -- check the loop control variable, the handler might've modified it
update detalle_almacen_productos_costos set id_estado_producto_costo_almacen=2 
where id_detalle_almacen_productos_costos=id_deta;            
-- close c;                  -- free resources
      else    
    leave size;                    -- stop iterations 
       
end if;


set  x = x + 1;
end loop size;
close c;


end//
delimiter ;
*/






delimiter //
create trigger inserta_detalles_factura
 after insert on detalle_factura_venta_producto
/*
usa este detalle, para que uses el id_venta, a traves de eso vas a poder actualizar un campo
en la venta que se llame : utilidad y que sea la resta del costo en almacen entre el precio de venta
*/
 for each row
 begin
declare x int(11) default 0;
declare id_ int(12) default 0;

/*
agregado para las salidas en almacen
*/
declare id_cliente  int(11) default 0;
declare desc_ubicacion varchar(370) default '';


declare id_deta  int(50);
declare _cant int(10);
declare _resto int(10);
declare _id_tienda  int(11);
declare err_no_more_records condition for 1329;
declare c cursor for select dt.id_detalle_almacen_productos, dt.quedaron,dt.id_tienda
,uf.nombre_ubicacion_fisica from detalle_almacen_productos dt 
inner join ubicacion_fisica uf on uf.id_ubicacion_fisica = dt.id_ubicacion_fisica
where dt.id_producto=new.id_producto and dt.id_estado_producto_costo_almacen=1
order by dt.costo;
declare exit handler for err_no_more_records



begin
end;

/*agregado un nuevo into para cliente.*/
select distinct v.id_tienda, v.id_cliente into id_ , id_cliente from detalle_factura_venta_producto dt inner join factura_venta v
on dt.id_factura_venta=v.id_factura_venta where v.id_factura_venta=new.id_factura_venta;
update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;

set _resto =new.cantidad;
open c;

set x = 0;
size: loop
fetch c into id_deta,_cant,_id_tienda,desc_ubicacion;

if id_  = _id_tienda and _cant <= _resto then



update detalle_almacen_productos set id_estado_producto_costo_almacen=2,salieron=salieron+_cant,quedaron=0  
where id_detalle_almacen_productos=id_deta;


/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion, now(),new.id_factura_venta,_cant,1);



set _resto = _resto - _cant;
else

if id_  = _id_tienda then
update detalle_almacen_productos set id_estado_producto_costo_almacen=1,salieron=salieron + _resto,quedaron=quedaron-_resto
where id_detalle_almacen_productos=id_deta;

/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion,now(),new.id_factura_venta,_resto,1);


set _resto=0;
end if;


end if;


  if _resto=0 then
 leave size; 
           
end if;

end loop size;
close c;


end//
delimiter ;



/*
delimiter //
create trigger inserta_detalles_factura
 after insert on detalle_factura_venta_producto
 for each row
 begin
declare id_ int(12) default 0;
select distinct v.id_tienda into id_ from detalle_factura_venta_producto dt inner join factura_venta v
on dt.id_factura_venta=v.id_factura_venta where v.id_factura_venta=new.id_factura_venta;
update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;
 end//
delimiter ;

*/

delimiter //
create trigger inserta_detalles_cambio
 after insert on detalle_cambio_producto
 for each row
 begin
declare id_ int(11) default 0;
select distinct v.id_tienda into id_ from cambio c inner join detalle_cambio_producto dt
on dt.id_cambio = c.id_cambio  inner join venta v on
v.id_venta=c.id_venta  where dt.id_cambio=new.id_cambio;


update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad + 1
where stk.id_producto = new.id_producto_cambio and stk.id_tienda_origen = id_;


update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad - 1
where stk.id_producto = new.id_producto_cambiada and stk.id_tienda_origen = id_;


 end//
delimiter ;


delimiter //
create procedure ventas_fecha( in fecha_inicial date,in fecha_final date)
 begin
select v.id_venta as 'numero', v.fecha_venta as 'fecha', t.nombre_tienda as 'tienda',
tp.nombre_tipo_venta as 'tipo',v.total_venta as 'total', p.nombre_producto as 'producto' ,
dt.cantidad, dt.precio_venta, dt.descuento, dt.sub_total from venta v inner join detalle_venta_producto dt 
on dt.id_venta = v.id_venta inner join tienda t on t.id_tienda = v.id_tienda
inner join tipo_venta tp on tp.id_tipo_venta=v.id_tipo_venta
inner join producto p on dt.id_producto=p.id_producto 
where v.fecha_venta between fecha_inicial and fecha_final order by v.id_venta;

 end //
delimiter ;

delimiter //
create procedure productos_fecha( in fecha_inicial date,in fecha_final date)
 begin
select p.nombre_producto, sum(dt.cantidad) as cantidad from detalle_venta_producto dt
inner join producto p on p.id_producto = dt.id_producto inner join venta v on
dt.id_venta = v.id_venta
where v.fecha_venta between fecha_inicial and fecha_final 
group by (p.id_producto);
 end //
delimiter ;




/*
agregado para realizar el canje de credito a letras pendiente.
*/

create table estado_letras_pago_canje(
id_estado_letras_pago_canje int(11) not null auto_increment,
nombre varchar(100) ,
descripcion varchar(170),
 primary key (id_estado_letras_pago_canje) 
)engine=innodb;

create table estado_canje_orden_compra(
id_estado_canje_orden_compra int(11) not null auto_increment,
nombre varchar(100) ,
descripcion varchar(170),
 primary key (id_estado_canje_orden_compra) 
)engine=innodb;

create table canje_orden_compra(
id_canje_orden_compra int(11) not null auto_increment,
id_orden_compra int(11) not null,
fecha_creacion_canje date not null,
fecha_pago date not null,
monto_canje decimal(9,2) not null default 0.0,
numero_cuotas int(1) not null default 1,
nombre_banco_pagar varchar(150) not null default '',
numero_cuenta varchar(210) not null default '',
observaciones varchar(300) not null default '',
id_estado_canje_orden_compra int(11) ,
 primary key (id_canje_orden_compra),
 foreign key (id_orden_compra) references orden_compra (id_orden_compra),
 foreign key (id_estado_canje_orden_compra) references estado_canje_orden_compra (id_estado_canje_orden_compra)
)engine=innodb;


create table letras_pago_canje(
id_letras_pago_canje int (11) not null auto_increment,
id_canje_orden_compra int(11) not null ,
fecha_pago date not null,
fecha_realizo_pago date not null,
total_letra decimal(9,2) not null default 0.0,
observaciones varchar(300) not null default '',
id_estado_letras_pago_canje int(11),
 primary key (id_letras_pago_canje),
 foreign key (id_estado_letras_pago_canje) references estado_letras_pago_canje (id_estado_letras_pago_canje),
 foreign key (id_canje_orden_compra) references canje_orden_compra (id_canje_orden_compra)
)engine=innodb;


/*agregado*/
create table desarrollador(
id_desarrollador int(3) not null auto_increment,
nombre varchar(200),
primary key (id_desarrollador)
)engine=innodb;



delimiter //
create trigger inserta_detalles_canje
after insert on canje_orden_compra
for each row
begin
declare x  int;
declare cuota  decimal(9,2);
set cuota = new.monto_canje/new.numero_cuotas;
set x = 0;
while x  < new.numero_cuotas do
insert into letras_pago_canje(id_canje_orden_compra ,fecha_pago,
fecha_realizo_pago,total_letra,observaciones,id_estado_letras_pago_canje) values(new.id_canje_orden_compra ,adddate(new.fecha_pago, interval x month),
new.fecha_pago,cuota,x+1,1);
set  x = x + 1;
	              end while;
end//
delimiter ;



/*
modulo de produccion , a traves de materia prima y procesos de producción
*/

create table unidad_medida(
id_unidad_medida int(11) not null auto_increment,
nombre_unidad_medida varchar(50) not null default '',
descripcion varchar(170) not null default '',
primary key(id_unidad_medida)
)engine=innodb;

create table materia_prima(
id_materia_prima int(11) not null auto_increment,
nombre_materia_prima varchar(150) not null default '',
id_unidad_medida int(11),
descripcion varchar(200) not null default '',
primary key(id_materia_prima),
foreign key (id_unidad_medida) references unidad_medida (id_unidad_medida)
)engine=innodb;


create table stock_materia_prima_tienda_origen(
id_materia_prima int(11) not null,
id_tienda_origen  int(11) not null,
cantidad decimal(12,4) not null default 0,
ultima_fecha_ingreso date not null,
descripcion varchar(370) default '',
primary key (id_materia_prima,id_tienda_origen),
foreign key (id_materia_prima) references materia_prima (id_materia_prima),
foreign key (id_tienda_origen) references tienda (id_tienda)
)engine=innodb;



create table ingreso_materia_prima_tienda(
id_ingreso_materia_prima_tienda int(11) not null auto_increment,
id_tienda int(11) not null,
id_materia_prima int(11) not null,
cantidad decimal(12,4) not null default 0,
fecha_ingreso date not null,
motivo varchar(300) not null default '',
primary key (id_ingreso_materia_prima_tienda),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_materia_prima) references materia_prima (id_materia_prima)
)engine=innodb;


create table salida_materia_prima_tienda(
id_salida_materia_prima_tienda int(11) not null auto_increment,
id_tienda int(11) not null,
id_materia_prima int(11) not null,
cantidad decimal(12,4) not null default 0,
fecha_salida date not null,
motivo varchar(300) not null default '',
primary key (id_salida_materia_prima_tienda),
foreign key (id_materia_prima) references materia_prima (id_materia_prima),
foreign key (id_tienda) references tienda (id_tienda)
)engine=innodb;




create table formulacion(
id_formulacion int(11) not null auto_increment,
fecha_registro date not null,
/*
este producto es el producto principal
es decir el resultado de las materias primas
*/
id_producto int(11) not null,
palabra_clave varchar(250) not null default '',
descripcion varchar(800) not null default '',
primary key (id_formulacion),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;


create table detalle_formulacion_insumos(
id_formulacion int(11) not null ,
id_materia_prima int(11) not null,
proporcion decimal(9,3) not null default 0,
primary key (id_formulacion,id_materia_prima),
foreign key (id_formulacion )
references formulacion (id_formulacion ),
foreign key (id_materia_prima)
references materia_prima (id_materia_prima)
)engine=innodb;


create table produccion_almacen(
id_produccion_almacen int(11) not null auto_increment,
/* por aqui puede ir a orden de produccion*/
id_tienda_origen  int(11) not null,
/* tienda orgien es el almacen de donde se extrae los insumos*/
id_formulacion int(11) ,
fecha_registro date not null,
cantidad_producto_terminado int(11) not null,
descripcion varchar(350) not null default '',
primary key (id_produccion_almacen),
foreign key (id_formulacion )
references formulacion (id_formulacion ),
foreign key (id_tienda_origen) references tienda (id_tienda)
)engine=innodb;


delimiter //
create trigger inserta_produccion_almacen
after insert on produccion_almacen
 for each row
 begin
declare a decimal(9,3)  default 0;
declare x,y  int(11);
declare err_no_more_records condition for 1329;
declare c cursor for select p.cantidad_producto_terminado,dt.id_materia_prima, dt.proporcion  from detalle_formulacion_insumos dt inner join formulacion f
on f.id_formulacion = dt.id_formulacion inner join produccion_almacen p 
on p.id_formulacion = f.id_formulacion where p.id_produccion_almacen = new.id_produccion_almacen;
declare exit handler for err_no_more_records
begin
end;
open c;
size: loop
fetch c into x,y,a;

update stock_materia_prima_tienda_origen as stk
set stk.cantidad = stk.cantidad-(x*a)
where stk.id_materia_prima = y and stk.id_tienda_origen = new.id_tienda_origen;


end loop size;
close c;

 end//
delimiter ;

/* creando la seccion de costos en almacen, esta tabla no es usada. */
create table detalle_almacen_productos_costos(
id_detalle_almacen_productos_costos int (50) not null auto_increment,
id_producto int(11) not null ,
costo decimal(9,3) not null default 0,
fecha_entrada datetime not null,
fecha_salida datetime default '1990-01-01 00:00:00',
id_procedencia_producto_almacen int(11) not null ,
observaciones varchar(300) not null default '',
id_estado_producto_costo_almacen int(3),
id_tienda int(11) not null,
primary key (id_detalle_almacen_productos_costos),
foreign key (id_producto) references producto (id_producto),
foreign key (id_procedencia_producto_almacen) references procedencia_producto_almacen (id_procedencia_producto_almacen),
foreign key (id_estado_producto_costo_almacen) references estado_producto_costo_almacen (id_estado_producto_costo_almacen),
foreign key (id_tienda) references tienda (id_tienda)
)engine=innodb;

/*
esta tabla no es usada.
*/
create table orden_salida_detalle_almacen_productos_costos(
id_orden_salida_detalle_almacen_productos_costos int (50) not null auto_increment,
id_detalle_almacen_productos_costos int(50) not null,
id_cliente int(11) not null,
observaciones_ubicacion varchar(300) not null default '',
fecha_registro datetime not null,
codigo_factura_boleta varchar(150) not null,
primary key (id_orden_salida_detalle_almacen_productos_costos),
foreign key (id_detalle_almacen_productos_costos) references detalle_almacen_productos_costos (id_detalle_almacen_productos_costos),
foreign key (id_cliente) references cliente (id_cliente)
)engine=innodb;


/*
delimiter //
create trigger inserta_ingreso_almacen
 after insert on ingreso_producto_tienda
 for each row
 begin
declare x  int;
set x = 0;
while x  < new.cantidad do

insert into detalle_almacen_productos_costos(id_producto,costo,fecha_entrada,fecha_salida,id_procedencia_producto_almacen,observaciones,id_estado_producto_costo_almacen,id_tienda)
values (new.id_producto,new.costo_unitario,new.fecha_ingreso,'1990-01-01 00:00:00',1,new.motivo,1,new.id_tienda);
set  x = x + 1;
	              end while;

 end//
delimiter ;
*/

/*  crando el detalle de almacen de una forma mas eficiente */
/* esta es la tabla que controla las salidas de almacen, es casi como un stock de almacen al detalle*/
create table detalle_almacen_productos(
id_detalle_almacen_productos int (15) not null auto_increment,
id_producto int(11) not null,
costo decimal(9,3) not null default 0,
id_tienda  int(11) not null,
cantidad int(10) not null,
salieron int(10) not null,
quedaron int(10) not null,
fecha_ingreso date not null,
fecha_vencimiento date not null default '1990-01-01',
descripcion_motivo varchar(370) default '',
/*descripcion_ubicacion varchar(370) default '',*/
id_ubicacion_fisica int(11) not null ,
id_procedencia_producto_almacen int(11) not null ,
id_estado_producto_costo_almacen int(3),
id_ingreso_producto_tienda int(11) not null ,
foreign key (id_estado_producto_costo_almacen) references estado_producto_costo_almacen (id_estado_producto_costo_almacen),
primary key (id_detalle_almacen_productos),
foreign key (id_producto) references producto (id_producto),
foreign key (id_procedencia_producto_almacen) references procedencia_producto_almacen (id_procedencia_producto_almacen),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_ubicacion_fisica) references ubicacion_fisica (id_ubicacion_fisica),
foreign key (id_ingreso_producto_tienda) references ingreso_producto_tienda (id_ingreso_producto_tienda)
)engine=innodb;


/*creamos uno nuevo*/
delimiter //
create trigger inserta_ingreso_almacen
 after insert on ingreso_producto_tienda
 for each row
 begin

insert into detalle_almacen_productos(
id_producto,
costo,
id_tienda,
cantidad,
salieron,
quedaron,
fecha_ingreso,
fecha_vencimiento,
descripcion_motivo,
id_ubicacion_fisica,
id_procedencia_producto_almacen,
id_estado_producto_costo_almacen,id_ingreso_producto_tienda)
values (new.id_producto,new.costo_unitario,new.id_tienda,new.cantidad,0,new.cantidad,new.fecha_ingreso,new.fecha_vencimiento ,new.motivo,new.id_ubicacion_fisica,1,1,new.id_ingreso_producto_tienda);

 end//
delimiter ;





/*
delimiter //
create trigger inserta_ingreso_almacen
 after insert on ingreso_producto_tienda
 for each row
 begin

insert into detalle_almacen_productos(
id_producto,
costo,
id_tienda,
cantidad,
salieron,
quedaron,
fecha_ingreso,
fecha_vencimiento,
descripcion_motivo,
descripcion_ubicacion,
id_procedencia_producto_almacen,
id_estado_producto_costo_almacen)
values (new.id_producto,new.costo_unitario,new.id_tienda,new.cantidad,0,new.cantidad,new.fecha_ingreso,new.fecha_vencimiento ,new.motivo,new.ubicacion,1,1);

 end//
delimiter ;
*/


/*
creando las ordenes de salida para el almacenero.
*/


create table orden_salida_detalle_almacen_productos(
id_orden_salida_detalle_almacen_productos_costos int (50) not null auto_increment,
id_detalle_almacen_productos int (15) not null,
id_cliente int(11) not null,
observaciones_ubicacion varchar(300) not null default '',
fecha_registro date not null,
codigo_factura_boleta varchar(150) not null,
cantidad int(10) not null,
id_estado_orden_salida_detalle_almacen_productos int(3) not null,
primary key (id_orden_salida_detalle_almacen_productos_costos),
foreign key (id_detalle_almacen_productos) references detalle_almacen_productos (id_detalle_almacen_productos),
foreign key (id_cliente) references cliente (id_cliente),
foreign key (id_estado_orden_salida_detalle_almacen_productos) references estado_orden_salida_detalle_almacen_productos (id_estado_orden_salida_detalle_almacen_productos)
)engine=innodb;




/*modulo contable*/


/*agregado*/
create table tipo_cuenta_contable(
id_tipo_cuenta_contable int(11) not null auto_increment,
nombre_tipo_cuenta_contable varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_tipo_cuenta_contable)
)engine=innodb;


/*agregado*/
create table tipo_elemento(
id_tipo_elemento int(11) not null auto_increment,
nombre_tipo_elemento varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_tipo_elemento)
)engine=innodb;

/*agregado*/
create table sub_elemento(
id_sub_elemento int(11) not null auto_increment,
nombre_sub_elemento varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_sub_elemento)
)engine=innodb;


/*agregado*/
create table cuenta_contable(
id_cuenta_contable int(11) not null auto_increment,
id_tipo_cuenta_contable int(11) not null,
id_tipo_elemento int(11) not null,
id_sub_elemento int(11) not null,
numero int not null,
nombre_cuenta_contable varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_cuenta_contable),
foreign key (id_tipo_cuenta_contable) references tipo_cuenta_contable (id_tipo_cuenta_contable),
foreign key (id_tipo_elemento) references tipo_elemento (id_tipo_elemento),
foreign key (id_sub_elemento) references sub_elemento (id_sub_elemento)
)engine=innodb;



/*
agregando modulo de atencion al cliente -- 
*/



/*
se ha cambiado esta tabla 
*/
create table actividad(
id_actividad int(11) not null auto_increment,
id_cliente int(11) not null,
descripcion_actividad varchar(500) not null default '',
fecha datetime not null,
primary key (id_actividad),
foreign key (id_cliente)  references cliente(id_cliente)
)engine=innodb;

create table cliente_potencial(
id_cliente_potencial int(11) not null auto_increment,
fecha_registro date not null,
cliente_razon_social varchar(150) not null default '',
fecha_cumpleanios date not null,
direccion varchar(350) not null default '',
dni varchar(12) not null default '',
estado int(1) not null default 1,
telefono varchar(50) not null default '',
primary key (id_cliente_potencial)
)engine=innodb;

create table contrato_fumigacion(
id_contrato_fumigacion int(11) not null auto_increment,
id_venta int(11) not null,
fecha_venta date not null,
/*agregado*/
fecha_venta_emision date not null,
fecha_hora_fumigacion datetime not null,
plaga varchar(170) not null default '',
descripcion varchar(500) not null default '',
total_servicio decimal(9,2) not null default 0,
cuenta decimal(9,2) not null default 0,
saldo decimal(9,2) not null default 0,
primary key (id_contrato_fumigacion),
foreign key (id_venta)  references venta (id_venta)
)engine=innodb;



create table detalle_fumigacion_producto(
id_detalle_fumigacion_producto int(11) not null auto_increment,
id_contrato_fumigacion int(11) not null,
id_producto int(11) not null,
cantidad int not null,
utilizo decimal (9,3) not null default 0.0,
quedo decimal (9,3) not null default 0.0,
primary key (id_detalle_fumigacion_producto),
foreign key (id_contrato_fumigacion) references  contrato_fumigacion(id_contrato_fumigacion),
foreign key (id_producto) references  producto(id_producto)
)engine=innodb;


create table reporte_desratizacion(
id_reporte_desratizacion int(11) not null auto_increment,
id_contrato_fumigacion int(11) not null,
fecha date not null,
id_empleado int(11) not null,
descripcion_cliente varchar(500) not null default '',
hora_inicio varchar(20) not null default '',
duracion_minutos int not null ,
numero_estaciones_instaladas int not null,
cantidad_producto_utilizado varchar(35) not null default '',
porcentaje_avance int(4) not null,
comentarios_cliente varchar(500) not null default '',
observaciones_cliente varchar(500) not null default '',
requerimientos_dia_siguiente varchar(500) not null default '',
primary key (id_reporte_desratizacion),
foreign key (id_contrato_fumigacion) references contrato_fumigacion (id_contrato_fumigacion),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;



create table reporte_fumigacion(
id_reporte_fumigacion int(11) not null auto_increment,
id_contrato_fumigacion int(11) not null,
fecha date not null,
id_empleado int(11) not null,
descripcion_cliente varchar(350) not null default '',
caracteristicas_albiente varchar(100) not null default '',
area_estimada varchar(20) not null default '',
area_tratada varchar(20) not null default '',
tipo_plaga varchar(100) not null,
porcentaje_infestacion int not null,
porcentaje_cantidad_fuentes_alimentarias int not null,
manejo_residuos_alimenticios varchar(45) not null,
porcentaje_higiene int not null,
mobiliario varchar(250) not null default '',
dispercion varchar(400) not null default '',
porcentaje_machos int not null,
porcentaje_hembras int not null,
tapado_grietas varchar(100) not null,
zonas_equipos varchar(370) not null default '',
utilizacion_producto varchar(500) not null default '',
primary key (id_reporte_fumigacion ),
foreign key (id_contrato_fumigacion) references contrato_fumigacion (id_contrato_fumigacion),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;







/*agregado*/
create table tipo_servicio(
id_tipo_servicio int(11) not null auto_increment,
nombre_tipo_servicio varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_tipo_servicio)
)engine=innodb;


create table tipo_plaga(
id_tipo_plaga int(11) not null auto_increment,
nombre_tipo_plaga varchar(170) not null default '',
descripcion varchar(250) not null default '',
primary key (id_tipo_plaga)
)engine=innodb;

create table servicio(
id_servicio int(11) not null auto_increment,
id_tipo_servicio int(11) not null, 
fecha_registro date not null,
nombre_servicio varchar(250) not null default '',
palabra_clave varchar(250) not null default '',
descripcion varchar(800) not null default '',
primary key (id_servicio),
foreign key (id_tipo_servicio) references tipo_servicio (id_tipo_servicio)
)engine=innodb;

/*
se debe restar de los detalles de almacen, para no descuadrar el cantidad sale queda.
se ha cambiado esta tabla+++
*/

create table detalle_servicio_producto(
id_servicio int(11) not null ,
id_producto int(11) not null,
cantidad int not null default 0,
utilizo decimal (9,3) not null default 0.0,
quedo decimal (9,3) not null default 0.0,
primary key (id_servicio,id_producto),
foreign key (id_servicio)
references servicio (id_servicio),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;


/* codigo de barras */

create table inventario_fisico(
id_inventario_fisico int(11) not null auto_increment,
obervaciones varchar(100) not null default '',
fecha_inicio date not null ,
fecha_termino date not null ,
id_tienda int(11) not null,
primary key (id_inventario_fisico),
foreign key (id_tienda) references tienda (id_tienda)
)engine=innodb;

create table detalle_inventario_ubicacion_fisica(
id_detalle_inventario_ubicacion_fisica int(11) not null auto_increment,
id_inventario_fisico int(11) not null,
id_ubicacion_fisica int(11) not null,
primary key (id_detalle_inventario_ubicacion_fisica),
foreign key (id_inventario_fisico) references inventario_fisico (id_inventario_fisico),
foreign key (id_ubicacion_fisica) references ubicacion_fisica (id_ubicacion_fisica)
)engine=innodb;

create table detalle_ubicacion_fisica_producto(
id_detalle_ubicacion_fisica_producto int(11) not null auto_increment,
id_detalle_inventario_ubicacion_fisica int(11) not null,
id_producto int(11) not null,
cantidad int not null default 1,
primary key (id_detalle_ubicacion_fisica_producto),
foreign key (id_detalle_inventario_ubicacion_fisica) references detalle_inventario_ubicacion_fisica (id_detalle_inventario_ubicacion_fisica),
foreign key (id_producto) references producto (id_producto)
)engine=innodb;





create table venta_rapida(
id_venta_rapida int(11) not null auto_increment,
fecha_venta date not null ,
id_tienda int(11) not null,
primary key (id_venta_rapida),
foreign key (id_tienda) references tienda (id_tienda)
)engine=innodb;

create table detalle_venta_rapida_producto(
id_detalle_venta_rapida_producto int(11) not null auto_increment,
id_venta_rapida int(11) not null,
id_cliente int(11) not null,
id_producto int(11) not null,
precio_venta decimal (9,2) not null,
cantidad int not null default 1,
primary key (id_detalle_venta_rapida_producto),
foreign key (id_producto) references producto (id_producto),
foreign key (id_cliente) references cliente (id_cliente),
foreign key (id_venta_rapida) references venta_rapida (id_venta_rapida)
)engine=innodb;



delimiter //
create trigger inserta_venta_rapida
 after insert on detalle_venta_rapida_producto
 for each row
 begin

declare x int(11) default 0;
declare id_ int(11) default 0;

/*
agregado para las salidas en almacen
*/
declare id_cliente  int(11) default 0;
declare desc_ubicacion varchar(370) default '';



declare id_deta  int(50);
declare _cant int(10);
declare _resto int(10);
declare _id_tienda  int(11);
declare err_no_more_records condition for 1329;


declare c cursor for select dt.id_detalle_almacen_productos, dt.quedaron,dt.id_tienda
,uf.nombre_ubicacion_fisica from detalle_almacen_productos dt 
inner join ubicacion_fisica uf on uf.id_ubicacion_fisica = dt.id_ubicacion_fisica
where dt.id_producto=new.id_producto and dt.id_estado_producto_costo_almacen=1

order by dt.costo;

declare exit handler for err_no_more_records

begin
end;

select distinct v.id_tienda,dt.id_cliente  into id_,id_cliente from detalle_venta_rapida_producto dt 
inner join venta_rapida v
on dt.id_venta_rapida=v.id_venta_rapida where v.id_venta_rapida=new.id_venta_rapida;

update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad-new.cantidad
where stk.id_producto = new.id_producto and stk.id_tienda_origen = id_;
/*  tienes que agergar las ordenes de salida */
/* agregar el registro de decremento en el detalle*/

set _resto =new.cantidad;
open c;


set x = 0;
size: loop
fetch c into id_deta,_cant,_id_tienda,desc_ubicacion;

if id_  = _id_tienda and _cant <= _resto then



update detalle_almacen_productos set id_estado_producto_costo_almacen=2,salieron=salieron+_cant,quedaron=0  
where id_detalle_almacen_productos=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion, now(),concat('vr',new.id_detalle_venta_rapida_producto),_cant,1);


set _resto = _resto - _cant;
else

if id_  = _id_tienda then
update detalle_almacen_productos set id_estado_producto_costo_almacen=1,salieron=salieron + _resto,quedaron=quedaron-_resto
where id_detalle_almacen_productos=id_deta;
/*
agregando la referencia a orden de salida en almacen
*/
insert orden_salida_detalle_almacen_productos(id_detalle_almacen_productos,id_cliente,observaciones_ubicacion,
fecha_registro,codigo_factura_boleta,cantidad,id_estado_orden_salida_detalle_almacen_productos)
values (id_deta,id_cliente,desc_ubicacion,now(),concat('vr',new.id_detalle_venta_rapida_producto),_resto,1);

set _resto=0;
end if;


end if;


  if _resto=0 then
 leave size; 
           
end if;

end loop size;
close c;


end//
delimiter ;




delimiter //
create trigger elimina_venta_rapida
 before delete on detalle_venta_rapida_producto
 for each row
 begin
declare id_ int(11) default 0;

select distinct v.id_tienda into id_ from detalle_venta_rapida_producto dt 
inner join venta_rapida v
on dt.id_venta_rapida=v.id_venta_rapida where v.id_venta_rapida=old.id_venta_rapida;

update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad+old.cantidad
where stk.id_producto = old.id_producto and stk.id_tienda_origen = id_;

/*  tienes que agergar las ordenes de salida */

end//
delimiter ;




create table inventario_inicial_sistema(
id_inventario_inicial_sistema int(11) not null auto_increment,
id_inventario_fisico int(11) not null,
obervaciones varchar(50) not null default '',
fecha_registro date not null ,
primary key (id_inventario_inicial_sistema),
foreign key (id_inventario_fisico) references inventario_fisico (id_inventario_fisico)
)engine=innodb;


delimiter //
create procedure reseteo()
 begin
delete from detalle_almacen_productos where id_detalle_almacen_productos > 0;

/*alter table detalle_almacen_productos auto_increment = 1;*/

delete from stock_producto_tienda_origen where id_producto > 0 and id_tienda_origen > 0;
delete from ingreso_producto_tienda where id_ingreso_producto_tienda > 0;
delete from salida_producto_tienda where id_salida_producto_tienda > 0;
delete from orden_salida_detalle_almacen_productos where id_orden_salida_detalle_almacen_productos_costos > 0;

 end //
delimiter ;





delimiter //
create trigger inserta_inventarios_sistema
 after insert on inventario_inicial_sistema
/*
usa este detalle, para que uses el id_venta, a traves de eso vas a poder actualizar un campo
en la venta que se llame : utilidad y que sea la resta del costo en almacen entre el precio de venta
*/
 for each row
 begin
declare x int(11) default 0;
declare id_ int(11) default 0;


/*
agregado para las salidas en almacen
*/
declare id_cliente  int(11) default 0;
declare id_producto  int(11) default 0;
declare id_ubicacion int(11) default 0;


declare id_deta  int(50);
declare _cant int(10);
declare _resto int(10);
declare _id_tienda  int(11);
declare err_no_more_records condition for 1329;
declare c cursor for 


select ifs.id_inventario_fisico as id,t.id_tienda as tienda, ubf.id_ubicacion_fisica as ubicacion
,p.id_producto as producto, sum(dufp.cantidad) as cantidad
from inventario_fisico ifs
inner join detalle_inventario_ubicacion_fisica diuf
on ifs.id_inventario_fisico =diuf.id_inventario_fisico
inner join detalle_ubicacion_fisica_producto dufp on
diuf.id_detalle_inventario_ubicacion_fisica =dufp.id_detalle_inventario_ubicacion_fisica
inner join tienda t on t.id_tienda =ifs.id_tienda
inner join ubicacion_fisica ubf on ubf.id_ubicacion_fisica =diuf.id_ubicacion_fisica
inner join producto p on p.id_producto=dufp.id_producto
group by ifs.id_inventario_fisico,t.id_tienda,ubf.id_ubicacion_fisica,p.id_producto
having ifs.id_inventario_fisico=new.id_inventario_fisico
order by 4;


declare exit handler for err_no_more_records





begin
end;

/* tienes que poner a resteo para que primary empiese desde 1*/
call reseteo();
open c;

set x = 0;
size: loop
fetch c into id_deta,_id_tienda,id_ubicacion,id_producto,_cant;


insert into detalle_almacen_productos (id_producto,costo,id_tienda,cantidad,salieron
,quedaron,fecha_ingreso,fecha_vencimiento,descripcion_motivo,
id_ubicacion_fisica,id_procedencia_producto_almacen,id_estado_producto_costo_almacen)
values(id_producto,0,_id_tienda,_cant,0,_cant,curdate(),curdate(),'',id_ubicacion,1,1); 

/* update stock_producto_tienda_origen as stk
set stk.cantidad = stk.cantidad + _cant
where stk.id_producto = id_producto and stk.id_tienda_origen = _id_tienda;
 */

insert into stock_producto_tienda_origen
(id_producto,id_tienda_origen,cantidad,ultima_fecha_ingreso,descripcion)
values
(id_producto,_id_tienda,_cant, curdate(),'')
on duplicate key update
stock_producto_tienda_origen.cantidad = stock_producto_tienda_origen.cantidad + _cant;


/* hay que registrar cada ingreso */
insert into ingreso_producto_tienda(id_tienda,id_producto,cantidad,fecha_ingreso,fecha_vencimiento
,motivo,id_ubicacion_fisica,costo_unitario) values (_id_tienda,id_producto,_cant,curdate(),curdate(),'inventario sistema',
id_ubicacion,0);



end loop size;
close c;


end//
delimiter ;






/* ferreteria */

create table promocion(
id_promocion int(11) not null auto_increment,
fecha_emision date not null,
/*agregado*/
fecha_inicio date not null,
fecha_fin date not null,
id_tienda int(11) not null,
id_empleado int(11) not null,
estado_promocion  int(2) default 1,
observaciones varchar(200) not null default '',
primary key (id_promocion),
foreign key (id_tienda) references tienda (id_tienda),
foreign key (id_empleado) references empleado (id_empleado)
)engine=innodb;



create table detalle_promocion_producto(
id_detalle_promocion_producto int(11) not null auto_increment,
id_promocion int(11) not null,
id_producto int(11) not null,
precio_venta decimal (9,2) not null,
descuento_porcentaje decimal (9,2) not null default 0.0,
primary key (id_detalle_promocion_producto),
foreign key (id_promocion)
references promocion (id_promocion),
foreign key (id_producto)
references producto (id_producto)
)engine=innodb;
