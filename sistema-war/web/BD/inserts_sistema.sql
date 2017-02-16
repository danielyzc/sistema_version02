insert into desarrollador(nombre) values('zavaleta de la cruz, yury daniel');


insert into negocio(nombre_negocio) values ('comercial daniel');

/*obligatorio*/

insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion)values('no atendido','no revisado en almacen');
insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion)values('atendido','revisado en almacen');
insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion)values('eliminado','revuelto');

insert into estado_igv(nombre_estado, descripcion)values('activo','en funcionamiento');
insert into estado_igv(nombre_estado, descripcion)values('inactivo','fuera de funcionamiento');

insert into igv_factura(monto,descripcion,id_estado_igv) values('0.18','18%',1);	
insert into mercado(nombre_mercado,descripcion) values('mercado sistema','');
insert into estado_letras_pago_canje(nombre,descripcion) values('letra pendiente','');
insert into estado_letras_pago_canje(nombre,descripcion) values('letra pagada','');

insert into estado_canje_orden_compra(nombre,descripcion) values('canje pendiente','');
insert into estado_canje_orden_compra(nombre,descripcion) values('canje pagado','');


insert into estado_producto_costo_almacen(nombre,descripcion) values('activo','');
insert into estado_producto_costo_almacen(nombre,descripcion) values('inactivo','');
insert into estado_producto_costo_almacen(nombre,descripcion) values('eliminado','');

insert into procedencia_producto_almacen(nombre,descripcion) values('compras proveedores','');
insert into procedencia_producto_almacen(nombre,descripcion) values('produccion interna','');
insert into procedencia_producto_almacen(nombre,descripcion) values('otro','');


insert into estado_facturacion_orden_compra(nombre,descripcion) values('sin facturar',''); 
insert into estado_facturacion_orden_compra(nombre,descripcion) values('facturada','');
insert into estado_facturacion_orden_compra(nombre,descripcion) values('fac.canjeada','');


insert into modelo_producto(nombre_modelo_producto ,descripcion) values ('catergoria 1','descripcion 1');
insert into color_producto(nombre_color_producto,descripcion) values ('categoria 2','');
insert into talla_producto(nombre_talla_producto,descripcion) values ('categoria 3','');
insert into material_producto(nombre_material_producto,descripcion) values ('categoria 4','descripcion cat 4');


insert into estado_producto(nombre_estado_producto,descripcion) values ('activo','producto en almacen');
insert into estado_producto(nombre_estado_producto,descripcion) values ('inactivo','producto inactivo');
insert into estado_producto(nombre_estado_producto,descripcion) values ('cambiado','producto cambiado');
/*obligatorio*/

insert into tipo_venta(nombre_tipo_venta,descripcion) values ('boleta','ventas con boletas');
insert into tipo_venta(nombre_tipo_venta,descripcion) values ('factura','ventas con facturas');

insert into  estado_orden_compra(nombre,descripcion) values('compra pagada','');
insert into  estado_orden_compra(nombre,descripcion) values('compra al credito','');
insert into  estado_orden_compra(nombre,descripcion) values('compra al credito-pagada','');


/*
para prestacion de servicios
*/

insert into tipo_venta(nombre_tipo_venta,descripcion) values ('boleta-servicios','ventas con boletas ofreciendo servicios');
insert into tipo_venta(nombre_tipo_venta,descripcion) values ('factura-servicios','ventas con facturas ofreciendo servicios');




insert into estado_venta(nombre_testado_venta ,descripcion) values ('contado','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito-total pagado','');

/*
para prestacion de servicios
*/

insert into estado_venta(nombre_testado_venta ,descripcion) values ('contado-servicio pendiente','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('contado-servicio terminado','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito-servicio pendiente','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito-servicio terminado','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito-servicio terminado-total pagado','');
insert into estado_venta(nombre_testado_venta ,descripcion) values ('credito-servicio pendiente-total pagado','');


insert into tipo_empleado(nombre,descripcion) values ('vendedor','');
insert into tipo_empleado(nombre,descripcion) values ('tecnico','');

insert into tipo_producto(nombre_tipo_producto ,descripcion) values ('GENERICO','');


/* para codigo de barras bioagrotec */
insert into zona_ciudad(descripcion_zona_ciudad,flag_estado) values('zona del sistema','si');
insert into ubicacion_fisica(nombre_ubicacion_fisica,descripcion_ubicacion_fisica)
values('7757000000013-ubicacion sistema','sistema');



insert into tipo_cliente(nombre_tipo_cliente,descripcion)values ('publico','personas del publico');
insert into cliente(id_mercado,id_tipo_cliente,nombre_cliente,razon_social,
giro_rubro,
contacto,
ruc_cliente,
direccion,
telefono,
celular,
nextel,
correo,
id_zona_ciudad) values (1,1,'publico','publico','publico','','','','','','','',1);


insert into negocio(nombre_negocio) values ('NEGOCIO SISTEMA');


insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA SISTEMA','','','','','',1);


insert into empleado(
id_empleado,
id_tienda,
nombre_empleado,
direccion,
telefono,
correo,
usuario,
password,
id_tipo_empleado,
/*agregado daniel ferreteria*/
sueldo_base,
estado_existencia) values (1,1,'YURY DANIEL ZAVALETA DE LA CRUZ','','','','admin','admin',1,0,1);


insert into grupo(nombre_grupo,descripcion_grupo) values ('administrador','');

insert into grupo_usuario(id_grupo,id_empleado) values(1,1);

