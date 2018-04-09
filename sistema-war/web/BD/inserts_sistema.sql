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


insert into modelo_producto values (1,'SIN MODELO','descripcion 1',curdate(),curdate(),curdate(),0,0,0,1);
insert into color_producto(nombre_color_producto,descripcion) values ('categoria 2','');
insert into talla_producto values(1,'SIN MEDIDA','',curdate(),curdate(),curdate(),0,0,0,1);
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

insert into tipo_producto values (1,'GENERICO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(1,'SIN MARCA','',curdate(),curdate(),curdate(),0,0,0,1);


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

insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA I - 363','','','','','',1);
insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA II - 369','','','','','',1);
insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA III - 379','','','','','',1);
insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA IV - 399','','','','','',1);
insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA V - 370','','','','','',1);
insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA VI - 398','','','','','',1);








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




/* NEW AMANECER */
insert into tipo_producto values(2,'COLCHONES DE RESORTES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(2,'PARAISO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(2,'1 1/2 PLAZA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(3,'2 PLAZAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(4,'QUEEN SIZE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(5,'KING SIZE','',curdate(),curdate(),curdate(),0,0,0,1);

insert into talla_producto values(6,'1 PLAZA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(7,'1 1/2 PLAZA - MIXTO','',curdate(),curdate(),curdate(),0,0,0,1);

insert into talla_producto values(8,'2 PLAZAS 1/2','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(9,'3 PLAZAS','',curdate(),curdate(),curdate(),0,0,0,1);


insert into modelo_producto  values (2,'ABRAZZO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (3,'ROYAL DYNASTY ORGANIC','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (4,'ROYAL ELIZABETH ADVANCE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (5,'ROYAL PRINCE ORGANIC','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (6,'POCKET STAR','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (7,'SUPER STAR','',curdate(),curdate(),curdate(),0,0,0,1);



/* IMPORTANTE !!! , agregar el precio !*/
/* insert into modelo_producto  values (2,'ABRAZZO','',curdate(),curdate(),curdate(),0,0,0,1);*/

INSERT INTO  producto VALUES(1,'PARAISO ; ABRAZZO ; 1 1/2 PLAZA',2,2,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(1,curdate(),0);


INSERT INTO  producto VALUES(2,'PARAISO ; ABRAZZO ; 2 PLAZAS',2,2,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(2,curdate(),0);

INSERT INTO  producto VALUES(3,'PARAISO ; ABRAZZO ; QUEEN SIZE',2,2,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(3,curdate(),0);


INSERT INTO  producto VALUES(4,'PARAISO ; ABRAZZO ; KING SIZE',2,2,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(4,curdate(),0);

/*insert into modelo_producto  values (3,'ROYAL DYNASTY ORGANIC','',curdate(),curdate(),curdate(),0,0,0,1);*/

INSERT INTO  producto VALUES(5,'PARAISO ; ROYAL DYNASTY ORGANIC ; 1 1/2 PLAZA',2,3,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(5,curdate(),0);

INSERT INTO  producto VALUES(6,'PARAISO ; ROYAL DYNASTY ORGANIC ; 2 PLAZAS',2,3,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(6,curdate(),0);
INSERT INTO  producto VALUES(7,'PARAISO ; ROYAL DYNASTY ORGANIC ; QUEEN SIZE',2,3,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(7,curdate(),0);
INSERT INTO  producto VALUES(8,'PARAISO ; ROYAL DYNASTY ORGANIC ; KING SIZE',2,3,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(8,curdate(),0);

/* insert into modelo_producto  values (4,'ROYAL ELIZABETH ADVANCE','',curdate(),curdate(),curdate(),0,0,0,1);*/
INSERT INTO  producto VALUES(9,'PARAISO ; ROYAL ELIZABETH ADVANCE ; 1 1/2 PLAZA',2,4,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(9,curdate(),0);
INSERT INTO  producto VALUES(10,'PARAISO ; ROYAL ELIZABETH ADVANCE ; 2 PLAZAS',2,4,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(10,curdate(),0);
INSERT INTO  producto VALUES(11,'PARAISO ; ROYAL ELIZABETH ADVANCE ; QUEEN SIZE',2,4,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(11,curdate(),0);
INSERT INTO  producto VALUES(12,'PARAISO ; ROYAL ELIZABETH ADVANCE ; KING SIZE',2,4,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(12,curdate(),0);

/*insert into modelo_producto  values (5,'ROYAL PRINCE ORGANIC','',curdate(),curdate(),curdate(),0,0,0,1);*/
INSERT INTO  producto VALUES(13,'PARAISO ; ROYAL PRINCE ORGANIC ; 1 1/2 PLAZA',2,5,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(13,curdate(),0);
INSERT INTO  producto VALUES(14,'PARAISO ; ROYAL PRINCE ORGANIC ; 2 PLAZAS',2,5,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(14,curdate(),0);
INSERT INTO  producto VALUES(15,'PARAISO ; ROYAL PRINCE ORGANIC ; QUEEN SIZE',2,5,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(15,curdate(),0);
INSERT INTO  producto VALUES(16,'PARAISO ; ROYAL PRINCE ORGANIC ; KING SIZE',2,5,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(16,curdate(),0);

/*insert into modelo_producto  values (6,'POCKET STAR','',curdate(),curdate(),curdate(),0,0,0,1);*/
INSERT INTO  producto VALUES(17,'PARAISO ; POCKET STAR ; 1 1/2 PLAZA',2,6,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(17,curdate(),0);
INSERT INTO  producto VALUES(18,'PARAISO ; POCKET STAR ; 2 PLAZAS',2,6,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(18,curdate(),0);
INSERT INTO  producto VALUES(19,'PARAISO ; POCKET STAR ; QUEEN SIZE',2,6,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(19,curdate(),0);
INSERT INTO  producto VALUES(20,'PARAISO ; POCKET STAR ; KING SIZE',2,6,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(20,curdate(),0);


/*insert into modelo_producto  values (7,'SUPER STAR','',curdate(),curdate(),curdate(),0,0,0,1);*/
INSERT INTO  producto VALUES(21,'PARAISO ; SUPER STAR ; 1 1/2 PLAZA',2,7,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(21,curdate(),0);
INSERT INTO  producto VALUES(22,'PARAISO ; SUPER STAR ; 2 PLAZAS',2,7,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(22,curdate(),0);
INSERT INTO  producto VALUES(23,'PARAISO ; SUPER STAR ; QUEEN SIZE',2,7,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(23,curdate(),0);
INSERT INTO  producto VALUES(24,'PARAISO ; SUPER STAR ; KING SIZE',2,7,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(24,curdate(),0);


insert into marca_producto values(3,'RECONCILIACION','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (8,'P/T','',curdate(),curdate(),curdate(),0,0,0,1);
/*
insert into talla_producto values(2,'1 1/2 PLAZA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(3,'2 PLAZAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(4,'QUEEN SIZE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(5,'KING SIZE','',curdate(),curdate(),curdate(),0,0,0,1);
*/

/*insert into modelo_producto  values (8,'P/T','',curdate(),curdate(),curdate(),0,0,0,1);*/
INSERT INTO  producto VALUES(25,'RECONCILIACION ; P/T ; 1 1/2 PLAZA',3,8,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(25,curdate(),0);
INSERT INTO  producto VALUES(26,'RECONCILIACION ; P/T ; 2 PLAZAS',3,8,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(26,curdate(),0);
INSERT INTO  producto VALUES(27,'RECONCILIACION ; P/T ; QUEEN SIZE',3,8,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(27,curdate(),0);
INSERT INTO  producto VALUES(28,'RECONCILIACION ; P/T ; KING SIZE',3,8,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(28,curdate(),0);

insert into marca_producto values(4,'MATRIMONIAL','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (9,'GALA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (10,'GALA EXTRA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(29,'MATRIMONIAL ; GALA ; 1 1/2 PLAZA',4,9,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(29,curdate(),0);
INSERT INTO  producto VALUES(30,'MATRIMONIAL ; GALA EXTRA ; 2 PLAZAS',4,10,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(30,curdate(),0);
INSERT INTO  producto VALUES(31,'MATRIMONIAL ; GALA EXTRA ; QUEEN SIZE',4,10,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(31,curdate(),0);
INSERT INTO  producto VALUES(32,'MATRIMONIAL ; GALA EXTRA ; KING SIZE',4,10,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(32,curdate(),0);


insert into marca_producto values(5,'TENTACION','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (11,'P/T SUPER ORTO DE LUJO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (12,'SUPER ORTO DE LUJO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(33,'TENTACION ; P/T SUPER ORTO DE LUJO ; 1 1/2 PLAZA',5,11,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(33,curdate(),0);
INSERT INTO  producto VALUES(34,'TENTACION ; P/T SUPER ORTO DE LUJO ; 2 PLAZAS',5,11,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(34,curdate(),0);
INSERT INTO  producto VALUES(35,'TENTACION ; P/T SUPER ORTO DE LUJO ; QUEEN SIZE',5,11,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(35,curdate(),0);
INSERT INTO  producto VALUES(36,'TENTACION ; P/T SUPER ORTO DE LUJO ; KING SIZE',5,11,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(36,curdate(),0);

 

INSERT INTO  producto VALUES(37,'TENTACION ; SUPER ORTO DE LUJO ; 1 1/2 PLAZA',5,12,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(37,curdate(),0);
INSERT INTO  producto VALUES(38,'TENTACION ; SUPER ORTO DE LUJO ; 2 PLAZAS',5,12,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(38,curdate(),0);
INSERT INTO  producto VALUES(39,'TENTACION ; SUPER ORTO DE LUJO ; QUEEN SIZE',5,12,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(39,curdate(),0);
INSERT INTO  producto VALUES(40,'TENTACION ; SUPER ORTO DE LUJO ; KING SIZE',5,12,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(40,curdate(),0);



insert into marca_producto values(6,'ABSOLUT','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (13,'MARCO SELLADO P/T','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(41,'ABSOLUT ; MARCO SELLADO P/T ; 1 1/2 PLAZA',6,13,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(41,curdate(),0);
INSERT INTO  producto VALUES(42,'ABSOLUT ; MARCO SELLADO P/T ; 2 PLAZAS',6,13,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(42,curdate(),0);
INSERT INTO  producto VALUES(43,'ABSOLUT ; MARCO SELLADO P/T ; QUEEN SIZE',6,13,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(43,curdate(),0);




insert into marca_producto values(7,'TERNURA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (14,'MARCO SELLADO ONE SIDE','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(44,'TERNURA ; MARCO SELLADO ONE SIDE ; 1 1/2 PLAZA',7,14,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(44,curdate(),0);
INSERT INTO  producto VALUES(45,'TERNURA ; MARCO SELLADO ONE SIDE ; 2 PLAZAS',7,14,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(45,curdate(),0);




insert into marca_producto values(8,'GOLDEN DREAM','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (15,'ORTOPEDICO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (16,'P/T ORTOPEDICO','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(46,'GOLDEN DREAM ; ORTOPEDICO ; 1 PLAZA',8,15,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(46,curdate(),0);
INSERT INTO  producto VALUES(47,'GOLDEN DREAM ; ORTOPEDICO ; 1 1/2 PLAZA',8,15,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(47,curdate(),0);
INSERT INTO  producto VALUES(48,'GOLDEN DREAM ; ORTOPEDICO ; 2 PLAZAS',8,15,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(48,curdate(),0);
INSERT INTO  producto VALUES(49,'GOLDEN DREAM ; ORTOPEDICO ; QUEEN SIZE',8,15,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(49,curdate(),0);
INSERT INTO  producto VALUES(50,'GOLDEN DREAM ; ORTOPEDICO ; KING SIZE',8,15,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(50,curdate(),0);




INSERT INTO  producto VALUES(51,'GOLDEN DREAM ; P/T ORTOPEDICO ; 1 1/2 PLAZA',8,16,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(51,curdate(),0);
INSERT INTO  producto VALUES(52,'GOLDEN DREAM ; P/T ORTOPEDICO ; 2 PLAZAS',8,16,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(52,curdate(),0);
INSERT INTO  producto VALUES(53,'GOLDEN DREAM ; P/T ORTOPEDICO ; QUEEN SIZE',8,16,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(53,curdate(),0);
INSERT INTO  producto VALUES(54,'GOLDEN DREAM ; P/T ORTOPEDICO ; KING SIZE',8,16,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(54,curdate(),0);



insert into marca_producto values(9,'SIEMPRE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (17,'MP','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (18,'MP P/T','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(55,'SIEMPRE ; MP ; 1 PLAZA',9,17,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(55,curdate(),0);
INSERT INTO  producto VALUES(56,'SIEMPRE ; MP ; 1 1/2 PLAZA',9,17,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(56,curdate(),0);
INSERT INTO  producto VALUES(57,'SIEMPRE ; MP ; 2 PLAZAS',9,17,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(57,curdate(),0);


INSERT INTO  producto VALUES(58,'SIEMPRE ; MP P/T ; 1 1/2 PLAZA',9,18,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(58,curdate(),0);
INSERT INTO  producto VALUES(59,'SIEMPRE ; MP P/T ; 2 PLAZAS',9,18,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(59,curdate(),0);



insert into marca_producto values(10,'ALPINO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (19,'ORTOPEDICO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (20,'ORTOPEDICO P/T','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(60,'ALPINO ; ORTOPEDICO ; 1 PLAZA',10,19,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(60,curdate(),0);
INSERT INTO  producto VALUES(61,'ALPINO ; ORTOPEDICO ; 1 1/2 PLAZA',10,19,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(61,curdate(),0);
INSERT INTO  producto VALUES(62,'ALPINO ; ORTOPEDICO ; 2 PLAZAS',10,19,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(62,curdate(),0);


INSERT INTO  producto VALUES(63,'ALPINO ; ORTOPEDICO P/T ; 1 1/2 PLAZA',10,20,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(63,curdate(),0);
INSERT INTO  producto VALUES(64,'ALPINO ; ORTOPEDICO P/T ; 2 PLAZAS',10,20,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(64,curdate(),0);



insert into marca_producto values(11,'PASIONES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(65,'PASIONES ; ORTOPEDICO ; 1 1/2 PLAZA',11,19,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(65,curdate(),0);
INSERT INTO  producto VALUES(66,'PASIONES ; ORTOPEDICO ; 2 PLAZAS',11,19,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(66,curdate(),0);
INSERT INTO  producto VALUES(67,'PASIONES; ORTOPEDICO ; QUEEN SIZE',11,19,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(67,curdate(),0);

INSERT INTO  producto VALUES(68,'PASIONES ; ORTOPEDICO P/T ; 1 1/2 PLAZA',11,20,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(68,curdate(),0);
INSERT INTO  producto VALUES(69,'PASIONES ; ORTOPEDICO P/T ; 2 PLAZAS',11,20,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(69,curdate(),0);
INSERT INTO  producto VALUES(70,'PASIONES; ORTOPEDICO P/T ; QUEEN SIZE',11,20,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(70,curdate(),0);





--- ME QUEDE AQUI
--  insert into talla_producto values(6,'1 PLAZA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(12,'TRAVESURAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(71,'TRAVESURAS ;; 1 PLAZA',12,1,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(71,curdate(),0);
INSERT INTO  producto VALUES(72,'TRAVESURAS ;; 1 1/2 PLAZA',12,1,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(72,curdate(),0);

insert into marca_producto values(13,'CLASSIC','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (21,'ANATOMICO','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(73,'CLASSIC ; ANATOMICO ; 1 PLAZA',13,21,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(73,curdate(),0);
INSERT INTO  producto VALUES(74,'CLASSIC ; ANATOMICO ; 1 1/2 PLAZA',13,21,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(74,curdate(),0);
INSERT INTO  producto VALUES(75,'CLASSIC ; ANATOMICO ; 2 PLAZAS',13,21,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(75,curdate(),0);


insert into marca_producto values(14,'ALWAYS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (22,'SEMI ORTOPEDICO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(76,'ALWAYS ; SEMI ORTOPEDICO ; 1 PLAZA',14,22,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(76,curdate(),0);
INSERT INTO  producto VALUES(77,'ALWAYS ; SEMI ORTOPEDICO ; 1 1/2 PLAZA',14,22,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(77,curdate(),0);
INSERT INTO  producto VALUES(78,'ALWAYS ; SEMI ORTOPEDICO ; 2 PLAZAS',14,22,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(78,curdate(),0);





insert into modelo_producto  values (23,'SU MAJESTAD DE LUJO ERGOSOFT','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(79,'PARAISO ; SU MAJESTAD DE LUJO ERGOSOFT ; 1 1/2 PLAZA',2,23,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(79,curdate(),0);
INSERT INTO  producto VALUES(80,'PARAISO ; SU MAJESTAD DE LUJO ERGOSOFT ; 2 PLAZAS',2,23,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(80,curdate(),0);
INSERT INTO  producto VALUES(81,'PARAISO ; SU MAJESTAD DE LUJO ERGOSOFT ; QUEEN SIZE',2,23,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(81,curdate(),0);
INSERT INTO  producto VALUES(82,'PARAISO ; SU MAJESTAD DE LUJO ERGOSOFT ; KING SIZE',2,23,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(82,curdate(),0);

insert into modelo_producto  values (24,'SU MAJESTAD DE LUJO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(83,'PARAISO ; SU MAJESTAD DE LUJO ; 1 1/2 PLAZA',2,24,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(83,curdate(),0);
INSERT INTO  producto VALUES(84,'PARAISO ; SU MAJESTAD DE LUJO ; 2 PLAZAS',2,24,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(84,curdate(),0);
INSERT INTO  producto VALUES(85,'PARAISO ; SU MAJESTAD DE LUJO ; QUEEN SIZE',2,24,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(85,curdate(),0);
INSERT INTO  producto VALUES(86,'PARAISO ; SU MAJESTAD DE LUJO ; KING SIZE',2,24,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(86,curdate(),0);



insert into modelo_producto  values (25,'MEDALLON DAMASCO ERGOSOFT','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(87,'PARAISO ; MEDALLON DAMASCO ERGOSOFT ; 1 1/2 PLAZA',2,25,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(87,curdate(),0);
INSERT INTO  producto VALUES(88,'PARAISO ; MEDALLON DAMASCO ERGOSOFT ; 2 PLAZAS',2,25,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(88,curdate(),0);
INSERT INTO  producto VALUES(89,'PARAISO ; MEDALLON DAMASCO ERGOSOFT ; QUEEN SIZE',2,25,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(89,curdate(),0);




insert into modelo_producto  values (26,'MEDALLON DRILL','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(90,'PARAISO ; MEDALLON DRILL ; 1 PLAZA',2,26,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(90,curdate(),0);
INSERT INTO  producto VALUES(91,'PARAISO ; MEDALLON DRILL ; 1 1/2 PLAZA',2,26,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(91,curdate(),0);
INSERT INTO  producto VALUES(92,'PARAISO ; MEDALLON DRILL ; 2 PLAZAS',2,26,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(92,curdate(),0);
INSERT INTO  producto VALUES(93,'PARAISO ; MEDALLON DRILL ; QUEEN SIZE',2,26,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(93,curdate(),0);

insert into modelo_producto  values (27,'TROPICAL ERGOSOFT','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(94,'PARAISO ; TROPICAL ERGOSOFT; 1 1/2 PLAZA',2,27,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(94,curdate(),0);
INSERT INTO  producto VALUES(95,'PARAISO ; TROPICAL ERGOSOFT ; 2 PLAZAS',2,27,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(95,curdate(),0);

insert into modelo_producto  values (28,'EDEN','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(96,'PARAISO ; EDEN ; 1 PLAZA',2,28,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(96,curdate(),0);
INSERT INTO  producto VALUES(97,'PARAISO ; EDEN ; 1 1/2 PLAZA',2,28,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(97,curdate(),0);
INSERT INTO  producto VALUES(98,'PARAISO ; EDEN ; 2 PLAZAS',2,28,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(98,curdate(),0);

insert into modelo_producto  values (29,'CONSUL','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(99,'PARAISO ; CONSUL ; 1 PLAZA',2,29,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(99,curdate(),0);
INSERT INTO  producto VALUES(100,'PARAISO ; CONSUL ; 1 1/2 PLAZA',2,29,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(100,curdate(),0);


----------- 
insert into tipo_producto values(3,'COLCHONES DE ESPUMA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(15,'ZEBRA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (30,'25 DE 6\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(101,'ZEBRA ; 25 DE 6\" ; 1 1/2 PLAZA',15,30,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(101,curdate(),0);
INSERT INTO  producto VALUES(102,'ZEBRA ; 25 DE 6\" ; 2 PLAZAS',15,30,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(102,curdate(),0);

insert into modelo_producto  values (31,'25 DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(103,'ZEBRA ; 25 DE 7\" ; 1 1/2 PLAZA',15,31,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(103,curdate(),0);
INSERT INTO  producto VALUES(104,'ZEBRA ; 25 DE 7\" ; 2 PLAZAS',15,31,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(104,curdate(),0);



insert into modelo_producto  values (32,'25 DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(105,'ZEBRA ; 25 DE 8\" ; 1 1/2 PLAZA',15,32,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(105,curdate(),0);
INSERT INTO  producto VALUES(106,'ZEBRA ; 25 DE 8\" ; 2 PLAZAS',15,32,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(106,curdate(),0);

insert into modelo_producto  values (33,'25 DE 10\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(107,'ZEBRA ; 25 DE 10\" ; 1 1/2 PLAZA',15,33,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(107,curdate(),0);
INSERT INTO  producto VALUES(108,'ZEBRA ; 25 DE 10\" ; 2 PLAZAS',15,33,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(108,curdate(),0);




insert into modelo_producto  values (34,'20 DE 6\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(109,'ZEBRA ; 20 DE 6\" ; 1 1/2 PLAZA',15,34,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(109,curdate(),0);
INSERT INTO  producto VALUES(110,'ZEBRA ; 20 DE 6\" ; 2 PLAZAS',15,34,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(110,curdate(),0);

insert into modelo_producto  values (35,'20 DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(111,'ZEBRA ; 20 DE 7\" ; 1 1/2 PLAZA',15,35,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(111,curdate(),0);
INSERT INTO  producto VALUES(112,'ZEBRA ; 20 DE 7\" ; 2 PLAZAS',15,35,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(112,curdate(),0);

insert into modelo_producto  values (36,'20 DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(113,'ZEBRA ; 20 DE 8\" ; 1 1/2 PLAZA',15,36,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(113,curdate(),0);
INSERT INTO  producto VALUES(114,'ZEBRA ; 20 DE 8\" ; 2 PLAZAS',15,36,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(114,curdate(),0);


insert into modelo_producto  values (37,'20 DE 10\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(115,'ZEBRA ; 20 DE 10\" ; 1 1/2 PLAZA',15,37,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(115,curdate(),0);
INSERT INTO  producto VALUES(116,'ZEBRA ; 20 DE 10\" ; 2 PLAZAS',15,37,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(116,curdate(),0);



insert into modelo_producto  values (38,'18 DE 6\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(117,'ZEBRA ; 18 DE 6\" ; 1 PLAZA',15,38,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(117,curdate(),0);
INSERT INTO  producto VALUES(118,'ZEBRA ; 18 DE 6\" ; 1 1/2 PLAZA',15,38,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(118,curdate(),0);
INSERT INTO  producto VALUES(119,'ZEBRA ; 18 DE 6\" ; 2 PLAZAS',15,38,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(119,curdate(),0);



insert into modelo_producto  values (39,'18 DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(120,'ZEBRA ; 18 DE 7\" ; 1 PLAZA',15,39,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(120,curdate(),0);
INSERT INTO  producto VALUES(121,'ZEBRA ; 18 DE 7\" ; 1 1/2 PLAZA',15,39,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(121,curdate(),0);
INSERT INTO  producto VALUES(122,'ZEBRA ; 18 DE 7\" ; 2 PLAZAS',15,39,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(122,curdate(),0);

insert into modelo_producto  values (40,'18 DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(123,'ZEBRA ; 18 DE 8\" ; 1 PLAZA',15,40,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(123,curdate(),0);
INSERT INTO  producto VALUES(124,'ZEBRA ; 18 DE 8\" ; 1 1/2 PLAZA',15,40,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(124,curdate(),0);
INSERT INTO  producto VALUES(125,'ZEBRA ; 18 DE 8\" ; 2 PLAZAS',15,40,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(125,curdate(),0);

insert into modelo_producto  values (41,'18 DE 10\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(126,'ZEBRA ; 18 DE 10\" ; 1 PLAZA',15,41,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(126,curdate(),0);
INSERT INTO  producto VALUES(127,'ZEBRA ; 18 DE 10\" ; 1 1/2 PLAZA',15,41,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(127,curdate(),0);
INSERT INTO  producto VALUES(128,'ZEBRA ; 18 DE 10\" ; 2 PLAZAS',15,41,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(128,curdate(),0);


-- ME QUEDE AQUI
insert into modelo_producto  values (42,'16 ACOLCHADO RIBETEADO DE 5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(129,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 5\" ; 1 PLAZA',15,42,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(129,curdate(),0);
INSERT INTO  producto VALUES(130,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 5\" ; 1 1/2 PLAZA',15,42,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(130,curdate(),0);
INSERT INTO  producto VALUES(131,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 5\" ; 2 PLAZAS',15,42,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(131,curdate(),0);


insert into modelo_producto  values (43,'16 ACOLCHADO RIBETEADO DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(132,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 7\" ; 1 PLAZA',15,43,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(132,curdate(),0);
INSERT INTO  producto VALUES(133,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 7\" ; 1 1/2 PLAZA',15,43,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(133,curdate(),0);
INSERT INTO  producto VALUES(134,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 7\" ; 2 PLAZAS',15,43,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(134,curdate(),0);


insert into modelo_producto  values (44,'16 ACOLCHADO RIBETEADO DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(135,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 8\" ; 1 PLAZA',15,44,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(135,curdate(),0);
INSERT INTO  producto VALUES(136,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 8\" ; 1 1/2 PLAZA',15,44,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(136,curdate(),0);
INSERT INTO  producto VALUES(137,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 8\" ; 2 PLAZAS',15,44,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(137,curdate(),0);


insert into modelo_producto  values (45,'16 ACOLCHADO RIBETEADO DE 10\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(138,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 10\" ; 1 PLAZA',15,45,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(138,curdate(),0);
INSERT INTO  producto VALUES(139,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 10\" ; 1 1/2 PLAZA',15,45,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(139,curdate(),0);
INSERT INTO  producto VALUES(140,'ZEBRA ; 16 ACOLCHADO RIBETEADO DE 10\" ; 2 PLAZAS',15,45,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(140,curdate(),0);



insert into marca_producto values(16,'COE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (46,'EST POLISEDA RIBETEADO DE 4\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(141,'COE ; EST POLISEDA RIBETEADO DE 4\" ; 1 PLAZA',16,46,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(141,curdate(),0);
INSERT INTO  producto VALUES(142,'COE ; EST POLISEDA RIBETEADO DE 4\" ; 1 1/2 PLAZA',16,46,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(142,curdate(),0);

insert into modelo_producto  values (47,'EST POLISEDA RIBETEADO DE 5.5\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(143,'COE ; EST POLISEDA RIBETEADO DE 5.5\" ; 1 1/2 PLAZA',16,47,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(143,curdate(),0);
INSERT INTO  producto VALUES(144,'COE ; EST POLISEDA RIBETEADO DE 5.5\" ; 2 PLAZAS',16,47,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(144,curdate(),0);

insert into modelo_producto  values (48,'EST POLISEDA RIBETEADO DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(145,'COE ; EST POLISEDA RIBETEADO DE 7\" ; 1 PLAZA',16,48,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(145,curdate(),0);
INSERT INTO  producto VALUES(146,'COE ; EST POLISEDA RIBETEADO DE 7\" ; 1 1/2 PLAZA',16,48,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(146,curdate(),0);
INSERT INTO  producto VALUES(147,'COE ; EST POLISEDA RIBETEADO DE 7\" ; 2 PLAZAS',16,48,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(147,curdate(),0);


insert into modelo_producto  values (49,'EST POLISEDA RIBETEADO DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(148,'COE ; EST POLISEDA RIBETEADO DE 8\" ; 1 1/2 PLAZA',16,49,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(148,curdate(),0);
INSERT INTO  producto VALUES(149,'COE ; EST POLISEDA RIBETEADO DE 8\" ; 2 PLAZAS',16,49,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(149,curdate(),0);

insert into modelo_producto  values (50,'COL ECONOMICO DE 4\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(150,'COE ; COL ECONOMICO DE 4\" ; 1 PLAZA',16,50,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(150,curdate(),0);
INSERT INTO  producto VALUES(151,'COE ; COL ECONOMICO DE 4\" ; 1 1/2 PLAZA',16,50,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(151,curdate(),0);
INSERT INTO  producto VALUES(152,'COE ; COL ECONOMICO DE 4\" ; 2 PLAZAS',16,50,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(152,curdate(),0);


insert into modelo_producto  values (51,'COL ECONOMICO DE 5.5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(153,'COE ; COL ECONOMICO DE 5.5\" ; 1 PLAZA',16,51,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(153,curdate(),0);
INSERT INTO  producto VALUES(154,'COE ; COL ECONOMICO DE 5.5\" ; 1 1/2 PLAZA',16,51,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(154,curdate(),0);
INSERT INTO  producto VALUES(155,'COE ; COL ECONOMICO DE 5.5\" ; 2 PLAZAS',16,51,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(155,curdate(),0);


insert into modelo_producto  values (52,'COL ECONOMICO DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(156,'COE ; COL ECONOMICO DE 7\" ; 1 1/2 PLAZA',16,52,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(156,curdate(),0);
INSERT INTO  producto VALUES(157,'COE ; COL ECONOMICO DE 7\" ; 2 PLAZAS',16,52,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(157,curdate(),0);




insert into marca_producto values(17,'BABY DREAM CUNA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (53,'ESPUMA DE 5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(158,'BABY DREAM CUNA ; ESPUMA DE 5\" ; ',17,53,1,
1,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(158,curdate(),0);



insert into tipo_producto values(4,'COLCHONETAS','',curdate(),curdate(),curdate(),0,0,0,1);

insert into marca_producto values(18,'COLCHONETA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (54,'EN NON WOVEN DE 2\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(159,'COLCHONETA ; EN NON WOVEN DE 2\" ; 1 PLAZA',18,54,1,
6,CURDATE(),1,4,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(159,curdate(),0);

INSERT INTO  producto VALUES(160,'COLCHONETA ; EN NON WOVEN DE 2\" ; 1 1/2 PLAZA',18,54,1,
2,CURDATE(),1,4,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(160,curdate(),0);


insert into modelo_producto  values (55,'EN NON WOVEN DE 4\"','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(161,'COLCHONETA ; EN NON WOVEN DE 4\" ; 1 PLAZA',18,55,1,
6,CURDATE(),1,4,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(161,curdate(),0);

INSERT INTO  producto VALUES(162,'COLCHONETA ; EN NON WOVEN DE 4\" ; 1 1/2 PLAZA',18,55,1,
2,CURDATE(),1,4,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(162,curdate(),0);



insert into marca_producto values(19,'KAI','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (56,'VISCOELASTIC','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(163,'KAI ; VISCOELASTIC ; 2 PLAZAS',19,56,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(163,curdate(),0);
INSERT INTO  producto VALUES(164,'KAI ; VISCOELASTIC ; QUEEN SIZE',19,56,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(164,curdate(),0);
INSERT INTO  producto VALUES(165,'KAI ; VISCOELASTIC ; KING SIZE',19,56,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(165,curdate(),0);


insert into marca_producto values(20,'VENTTO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (57,'PILLOW TOP','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(166,'VENTTO ; PILLOW TOP ; 1 1/2 PLAZA',20,57,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(166,curdate(),0);

INSERT INTO  producto VALUES(167,'VENTTO ; PILLOW TOP ; 2 PLAZAS',20,57,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(167,curdate(),0);
INSERT INTO  producto VALUES(168,'VENTTO ; PILLOW TOP ; QUEEN SIZE',20,57,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(168,curdate(),0);
INSERT INTO  producto VALUES(169,'VENTTO ; PILLOW TOP ; KING SIZE',20,57,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(169,curdate(),0);


insert into marca_producto values(21,'VIVE','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (58,'NAMMU ONE PILLOW','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(170,'VIVE ; NAMMU ONE PILLOW ; 1 1/2 PLAZA',21,58,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(170,curdate(),0);
INSERT INTO  producto VALUES(171,'VIVE ; NAMMU ONE PILLOW ; 2 PLAZAS',21,58,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(171,curdate(),0);


insert into modelo_producto  values (59,'VANORA MP TEJ. PTO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(172,'VIVE ; VANORA MP TEJ. PTO ; 1 1/2 PLAZA',21,59,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(172,curdate(),0);
INSERT INTO  producto VALUES(173,'VIVE ; VANORA MP TEJ. PTO ; 2 PLAZAS',21,59,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(173,curdate(),0);

insert into modelo_producto  values (60,'VANORA (PTMP) PILLOW TOP MARCO POLIURETANO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(174,'VIVE ; VANORA (PTMP) PILLOW TOP MARCO POLIURETANO ; 1 1/2 PLAZA',21,60,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(174,curdate(),0);

INSERT INTO  producto VALUES(175,'VIVE ; VANORA (PTMP) PILLOW TOP MARCO POLIURETANO ; 2 PLAZAS',21,60,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(175,curdate(),0);
INSERT INTO  producto VALUES(176,'VIVE ; VANORA (PTMP) PILLOW TOP MARCO POLIURETANO ; QUEEN SIZE',21,60,1,
4,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(176,curdate(),0);
INSERT INTO  producto VALUES(177,'VIVE ; VANORA (PTMP) PILLOW TOP MARCO POLIURETANO ; KING SIZE',21,60,1,
5,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(177,curdate(),0);



insert into modelo_producto  values (61,'VANORA (MP) MARCO POLIURETANO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(178,'VIVE ; VANORA (MP) MARCO POLIURETANO ; 1 1/2 PLAZA',21,61,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(178,curdate(),0);
INSERT INTO  producto VALUES(179,'VIVE ; VANORA (MP) MARCO POLIURETANO ; 2 PLAZAS',21,61,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(179,curdate(),0);

insert into modelo_producto  values (62,'KASSE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(180,'VIVE ; KASSE ; 1 PLAZA',21,62,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(180,curdate(),0);
INSERT INTO  producto VALUES(181,'VIVE ; KASSE ; 1 1/2 PLAZA',21,62,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(181,curdate(),0);
INSERT INTO  producto VALUES(182,'VIVE ; KASSE ; 2 PLAZAS',21,62,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(182,curdate(),0);

insert into modelo_producto  values (63,'KASSE IFANTIL','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(183,'VIVE ; KASSE IFANTIL ; 1 1/2 PLAZA',21,62,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(183,curdate(),0);



insert into modelo_producto  values (64,'ENNA MP','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(184,'VIVE ; ENNA MP ; 1 1/2 PLAZA',21,64,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(184,curdate(),0);
INSERT INTO  producto VALUES(185,'VIVE ; ENNA MP ; 2 PLAZAS',21,64,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(185,curdate(),0);



insert into modelo_producto  values (65,'ENNA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(186,'VIVE ; ENNA ; 1 PLAZA',21,65,1,
6,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(186,curdate(),0);
INSERT INTO  producto VALUES(187,'VIVE ; ENNA ; 1 1/2 PLAZA',21,65,1,
2,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(187,curdate(),0);
INSERT INTO  producto VALUES(188,'VIVE ; ENNA ; 2 PLAZAS',21,65,1,
3,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(188,curdate(),0);

insert into marca_producto values(22,'CUNA RESORTES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (66,'PREMIUM F/BK','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(189,'CUNA RESORTES ; PREMIUM F/BK ;',22,66,1,
1,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(189,curdate(),0);

insert into modelo_producto  values (67,'ECONOMICO SATIN','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(190,'CUNA RESORTES ; ECONOMICO SATIN ;',22,67,1,
1,CURDATE(),1,2,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(190,curdate(),0);



/*
ME QUEDE AQUI
insert into tipo_producto values(3,'COLCHONES DE ESPUMA','',curdate(),curdate(),curdate(),0,0,0,1);*/
insert into marca_producto values(23,'ECCO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (68,'RIBETEADO POLISEDA  DE 4\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(191,'ECCO ; RIBETEADO POLISEDA  DE 4\" ; 1 PLAZA',23,68,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(191,curdate(),0);
INSERT INTO  producto VALUES(192,'ECCO ; RIBETEADO POLISEDA  DE 4\" ; 1 1/2 PLAZA',23,68,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(192,curdate(),0);
INSERT INTO  producto VALUES(193,'ECCO ; RIBETEADO POLISEDA  DE 4\" ; 2 PLAZAS',23,68,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(193,curdate(),0);

insert into modelo_producto  values (69,'RIBETEADO POLISEDA  DE 5.5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(194,'ECCO ; RIBETEADO POLISEDA  DE 5.5\" ; 1 PLAZA',23,69,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(194,curdate(),0);
INSERT INTO  producto VALUES(195,'ECCO ; RIBETEADO POLISEDA  DE 5.5\" ; 1 1/2 PLAZA',23,69,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(195,curdate(),0);
INSERT INTO  producto VALUES(196,'ECCO ; RIBETEADO POLISEDA  DE 5.5\" ; 2 PLAZAS',23,69,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(196,curdate(),0);

insert into modelo_producto  values (70,'RIBETEADO POLISEDA  DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(197,'ECCO ; RIBETEADO POLISEDA  DE 7\" ; 1 PLAZA',23,70,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(197,curdate(),0);
INSERT INTO  producto VALUES(198,'ECCO ; RIBETEADO POLISEDA  DE 7\" ; 1 1/2 PLAZA',23,70,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(198,curdate(),0);
INSERT INTO  producto VALUES(199,'ECCO ; RIBETEADO POLISEDA  DE 7\" ; 2 PLAZAS',23,70,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(199,curdate(),0);


insert into modelo_producto  values (71,'RIBETEADO POLISEDA  DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(200,'ECCO ; RIBETEADO POLISEDA  DE 8\" ; 1 PLAZA',23,71,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(200,curdate(),0);
INSERT INTO  producto VALUES(201,'ECCO ; RIBETEADO POLISEDA  DE 8\" ; 1 1/2 PLAZA',23,71,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(201,curdate(),0);
INSERT INTO  producto VALUES(202,'ECCO ; RIBETEADO POLISEDA  DE 8\" ; 2 PLAZAS',23,71,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(202,curdate(),0);

insert into modelo_producto  values (72,'POLISEDA  DE 10\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(203,'ECCO ; POLISEDA  DE 10\" ; 1 PLAZA',23,72,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(203,curdate(),0);
INSERT INTO  producto VALUES(204,'ECCO ; POLISEDA  DE 10\" ; 1 1/2 PLAZA',23,72,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(204,curdate(),0);
INSERT INTO  producto VALUES(205,'ECCO ; POLISEDA  DE 10\" ; 2 PLAZAS',23,72,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(205,curdate(),0);



insert into modelo_producto  values (73,'ACOLCHADO RIBETEADO DE 4\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(206,'ECCO ; ACOLCHADO RIBETEADO DE 4\" ; 1 PLAZA',23,73,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(206,curdate(),0);
INSERT INTO  producto VALUES(207,'ECCO ; ACOLCHADO RIBETEADO DE 4\" ; 1 1/2 PLAZA',23,73,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(207,curdate(),0);
INSERT INTO  producto VALUES(208,'ECCO ; ACOLCHADO RIBETEADO DE 4\" ; 2 PLAZAS',23,73,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(208,curdate(),0);

insert into modelo_producto  values (74,'ACOLCHADO RIBETEADO DE 5.5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(209,'ECCO ; ACOLCHADO RIBETEADO DE 5.5\" ; 1 PLAZA',23,74,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(209,curdate(),0);
INSERT INTO  producto VALUES(210,'ECCO ; ACOLCHADO RIBETEADO DE 5.5\" ; 1 1/2 PLAZA',23,74,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(210,curdate(),0);
INSERT INTO  producto VALUES(211,'ECCO ; ACOLCHADO RIBETEADO DE 5.5\" ; 2 PLAZAS',23,74,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(211,curdate(),0);

insert into modelo_producto  values (75,'ACOLCHADO RIBETEADO DE 7\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(212,'ECCO ; ACOLCHADO RIBETEADO DE 7\" ; 1 PLAZA',23,75,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(212,curdate(),0);
INSERT INTO  producto VALUES(213,'ECCO ; ACOLCHADO RIBETEADO DE 7\" ; 1 1/2 PLAZA',23,75,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(213,curdate(),0);
INSERT INTO  producto VALUES(214,'ECCO ; ACOLCHADO RIBETEADO DE 7\" ; 2 PLAZAS',23,75,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(214,curdate(),0);


insert into modelo_producto  values (76,'ACOLCHADO RIBETEADO DE 8\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(215,'ECCO ; ACOLCHADO RIBETEADO DE 8\" ; 1 PLAZA',23,76,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(215,curdate(),0);
INSERT INTO  producto VALUES(216,'ECCO ; ACOLCHADO RIBETEADO DE 8\" ; 1 1/2 PLAZA',23,76,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(216,curdate(),0);
INSERT INTO  producto VALUES(217,'ECCO ; ACOLCHADO RIBETEADO DE 8\" ; 2 PLAZAS',23,76,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(217,curdate(),0);


insert into modelo_producto  values (77,'CUNA 5\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(218,'ECCO ; CUNA 5\" ;',23,77,1,
1,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(218,curdate(),0);

insert into modelo_producto  values (78,'CUNA 6\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(219,'ECCO ; CUNA 6\" ;',23,78,1,
1,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(219,curdate(),0);


/*
ME QUEDE AQUI
insert into tipo_producto values(3,'COLCHONES DE ESPUMA','',curdate(),curdate(),curdate(),0,0,0,1);*/
insert into marca_producto values(24,'SPLENDIDO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (79,'ACOLCHADA T/AC 7\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(220,'SPLENDIDO ; ACOLCHADA T/AC 7\" ; 1 PLAZA',24,79,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(220,curdate(),0);
INSERT INTO  producto VALUES(221,'SPLENDIDO ; ACOLCHADA T/AC 7\" ; 1 1/2 PLAZA',24,79,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(221,curdate(),0);
INSERT INTO  producto VALUES(222,'SPLENDIDO ; ACOLCHADA T/AC 7\" ; 2 PLAZAS',24,79,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(222,curdate(),0);

insert into modelo_producto  values (80,'ACOLCHADA T/AC 8\"','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(223,'SPLENDIDO ; ACOLCHADA T/AC 8\" ; 1 PLAZA',24,80,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(223,curdate(),0);
INSERT INTO  producto VALUES(224,'SPLENDIDO ; ACOLCHADA T/AC 8\" ; 1 1/2 PLAZA',24,80,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(224,curdate(),0);
INSERT INTO  producto VALUES(225,'SPLENDIDO ; ACOLCHADA T/AC 8\" ; 2 PLAZAS',24,80,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(225,curdate(),0);

insert into modelo_producto  values (81,'ACOLCHADA T/AC 10\"','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(226,'SPLENDIDO ; ACOLCHADA T/AC 10\" ; 1 PLAZA',24,81,1,
6,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(226,curdate(),0);
INSERT INTO  producto VALUES(227,'SPLENDIDO ; ACOLCHADA T/AC 10\" ; 1 1/2 PLAZA',24,81,1,
2,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(227,curdate(),0);
INSERT INTO  producto VALUES(228,'SPLENDIDO ; ACOLCHADA T/AC 10\" ; 2 PLAZAS',24,81,1,
3,CURDATE(),1,3,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(228,curdate(),0);


-- EMPEZAMOS CON CAMAS.

insert into tipo_producto values(5,'CAMAS DE MADERA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(25,'BARONEZA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (82,'ALTA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(229,'BARONEZA ; ALTA ; 1 1/2 PLAZA',25,82,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(229,curdate(),0);
INSERT INTO  producto VALUES(230,'BARONEZA ; ALTA ; 2 PLAZAS',25,82,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(230,curdate(),0);


INSERT INTO  producto VALUES(231,'BARONEZA ;; 1 1/2 PLAZA',25,1,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(231,curdate(),0);
INSERT INTO  producto VALUES(232,'BARONEZA ;; 2 PLAZAS',25,1,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(232,curdate(),0);


insert into marca_producto values(26,'CAMA','',curdate(),curdate(),curdate(),0,0,0,1);

insert into modelo_producto  values (83,'TORNEADA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(233,'CAMA; TORNEADA ; 1 1/2 PLAZA',26,83,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(233,curdate(),0);
INSERT INTO  producto VALUES(234,'CAMA; TORNEADA ; 2 PLAZAS',26,83,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(234,curdate(),0);


insert into modelo_producto  values (84,'BIBLIOTECAS DE TRUJILLO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(235,'CAMA; BIBLIOTECAS DE TRUJILLO ; 1 1/2 PLAZA',26,84,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(235,curdate(),0);
INSERT INTO  producto VALUES(236,'CAMA; BIBLIOTECAS DE TRUJILLO ; 2 PLAZAS',26,84,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(236,curdate(),0);

insert into modelo_producto  values (85,'BIBLIOTECAS DE LIMA','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(237,'CAMA; BIBLIOTECAS DE LIMA ; 1 1/2 PLAZA',26,85,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(237,curdate(),0);
INSERT INTO  producto VALUES(238,'CAMA; BIBLIOTECAS DE LIMA ; 2 PLAZAS',26,85,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(238,curdate(),0);


insert into modelo_producto  values (86,'RANCHERAS DE TRUJILLO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(239,'CAMA; RANCHERAS DE TRUJILLO ; 1 1/2 PLAZA',26,86,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(239,curdate(),0);
INSERT INTO  producto VALUES(240,'CAMA; RANCHERAS DE TRUJILLO ; 2 PLAZAS',26,86,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(240,curdate(),0);


insert into modelo_producto  values (87,'RANCHERAS DE LIMA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(241,'CAMA; RANCHERAS DE LIMA ; 1 1/2 PLAZA',26,87,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(241,curdate(),0);
INSERT INTO  producto VALUES(242,'CAMA; RANCHERAS DE LIMA ; 2 PLAZAS',26,87,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(242,curdate(),0);


insert into modelo_producto  values (88,'PESCADO DE TRUJILLO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(243,'CAMA; PESCADO DE TRUJILLO ; 1 1/2 PLAZA',26,88,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(243,curdate(),0);
INSERT INTO  producto VALUES(244,'CAMA; PESCADO DE TRUJILLO ; 2 PLAZAS',26,88,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(244,curdate(),0);



insert into modelo_producto  values (89,'PESCADO DE LIMA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(245,'CAMA; PESCADO DE LIMA ; 1 1/2 PLAZA',26,89,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(245,curdate(),0);
INSERT INTO  producto VALUES(246,'CAMA; PESCADO DE LIMA ; 2 PLAZAS',26,89,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(246,curdate(),0);


insert into modelo_producto  values (90,'TABLERO CON SABANERA BAJA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(247,'CAMA; TABLERO CON SABANERA BAJA ; 1 1/2 PLAZA',26,90,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(247,curdate(),0);
INSERT INTO  producto VALUES(248,'CAMA; TABLERO CON SABANERA BAJA ; 2 PLAZAS',26,90,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(248,curdate(),0);



insert into modelo_producto  values (91,'TABLERO CON SABANERA ALTA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(249,'CAMA; TABLERO CON SABANERA ALTA ; 1 1/2 PLAZA',26,91,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(249,curdate(),0);
INSERT INTO  producto VALUES(250,'CAMA; TABLERO CON SABANERA ALTA ; 2 PLAZAS',26,91,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(250,curdate(),0);


insert into modelo_producto  values (92,'TAPIZADA COMPLETA CON SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(251,'CAMA; TAPIZADA COMPLETA CON SABANERA ; 1 1/2 PLAZA',26,92,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(251,curdate(),0);
INSERT INTO  producto VALUES(252,'CAMA; TAPIZADA COMPLETA CON SABANERA ; 2 PLAZAS',26,92,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(252,curdate(),0);



insert into modelo_producto  values (93,'RIPLEY','',curdate(),curdate(),curdate(),0,0,0,1);



INSERT INTO  producto VALUES(253,'CAMA; RIPLEY ; 1 1/2 PLAZA',26,93,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(253,curdate(),0);
INSERT INTO  producto VALUES(254,'CAMA; RIPLEY ; 2 PLAZAS',26,93,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(254,curdate(),0);


insert into modelo_producto  values (94,'RIPLEY CON BAUL','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(255,'CAMA; RIPLEY CON BAUL ; 1 1/2 PLAZA',26,94,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(255,curdate(),0);
INSERT INTO  producto VALUES(256,'CAMA; RIPLEY CON BAUL ; 2 PLAZAS',26,94,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(256,curdate(),0);


insert into modelo_producto  values (95,'CON ALEROS Y VELADORES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(257,'CAMA; CON ALEROS Y VELADORES ; 1 1/2 PLAZA',26,95,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(257,curdate(),0);
INSERT INTO  producto VALUES(258,'CAMA; CON ALEROS Y VELADORES ; 2 PLAZAS',26,95,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(258,curdate(),0);

insert into modelo_producto  values (96,'REJAS TRUJILLO','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(259,'CAMA; REJAS TRUJILLO ; 1 1/2 PLAZA',26,96,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(259,curdate(),0);


insert into modelo_producto  values (97,'DE FLEJE','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(260,'CAMA; DE FLEJE ; 1 1/2 PLAZA',26,97,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(260,curdate(),0);



insert into modelo_producto  values (98,'CONTRAPLACADA SIN SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(261,'CAMA; CONTRAPLACADA SIN SABANERA ; 1 1/2 PLAZA',26,98,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(261,curdate(),0);
INSERT INTO  producto VALUES(262,'CAMA; CONTRAPLACADA SIN SABANERA ; 2 PLAZAS',26,98,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(262,curdate(),0);




insert into modelo_producto  values (99,'DE PINO CON MELAMINE Y SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(263,'CAMA; DE PINO CON MELAMINE Y SABANERA ; 1 1/2 PLAZA',26,99,1,
2,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(263,curdate(),0);
INSERT INTO  producto VALUES(264,'CAMA; DE PINO CON MELAMINE Y SABANERA ; 2 PLAZAS',26,99,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(264,curdate(),0);



insert into modelo_producto  values (100,'TABLERO OVALADAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(265,'CAMA; TABLERO OVALADAS ; 2 PLAZAS',26,100,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(265,curdate(),0);

insert into modelo_producto  values (101,'TORNILLO ','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(266,'CAMA; TORNILLO ; 2 PLAZAS',26,101,1,
3,CURDATE(),1,5,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(266,curdate(),0);


insert into tipo_producto values(6,'CAMAS DE MADERA PARA NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (102,'BIBLIOTECA NIÑO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(267,'CAMA; BIBLIOTECA NIÑO ; 1 1/2 PLAZA',26,102,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(267,curdate(),0);



insert into modelo_producto  values (103,'BIBLIOTECA NIÑA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(268,'CAMA; BIBLIOTECA NIÑA ; 1 1/2 PLAZA',26,103,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(268,curdate(),0);




insert into modelo_producto  values (104,'BIBLIOTECA CON SABANERA NIÑO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(269,'CAMA; BIBLIOTECA CON SABANERA NIÑO ; 1 1/2 PLAZA',26,104,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(269,curdate(),0);

insert into modelo_producto  values (105,'BIBLIOTECA CON SABANERA NIÑA','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(270,'CAMA; BIBLIOTECA CON SABANERA NIÑA ; 1 1/2 PLAZA',26,105,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(270,curdate(),0);




insert into modelo_producto  values (106,'CON DISEÑO CON SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(271,'CAMA; CON DISEÑO CON SABANERA ; 1 1/2 PLAZA',26,106,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(271,curdate(),0);


insert into modelo_producto  values (107,'CUNA  EN CAPIRONA - CASITA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(272,'CAMA; CUNA EN CAPIRONA - CASITA ; 1 1/2 PLAZA',26,107,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(272,curdate(),0);



insert into modelo_producto  values (108,'CUNA ALDUCO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(273,'CAMA; CUNA ALDUCO ; 1 1/2 PLAZA',26,108,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(273,curdate(),0);


insert into modelo_producto  values (109,'CUNA  EN PINO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(274,'CAMA; CUNA  EN PINO ; 1 1/2 PLAZA',26,109,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(274,curdate(),0);



insert into modelo_producto  values (110,'CUNA EN PINO CASITA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(275,'CAMA; CUNA EN PINO CASITA ; 1 1/2 PLAZA',26,110,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(275,curdate(),0);



insert into modelo_producto  values (111,'CARRO NIÑA / NIÑO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(276,'CAMA; CARRO NIÑA / NIÑO ; 1 1/2 PLAZA',26,111,1,
2,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(276,curdate(),0);




insert into modelo_producto  values (112,'CUNA DE PINO 3 NIVELES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(277,'CAMA; CUNA DE PINO 3 NIVELES ;',26,112,1,
1,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(277,curdate(),0);



insert into modelo_producto  values (113,'CUNA DE PINO 2 NIVELES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(278,'CAMA; CUNA DE PINO 2 NIVELES ;',26,113,1,
1,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(278,curdate(),0);

insert into modelo_producto  values (114,'CUNA CON COMODA ALDUCO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(279,'CAMA; CUNA CON COMODA ALDUCO ;',26,114,1,
1,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(279,curdate(),0);





insert into modelo_producto  values (115,'CUNA CON COMODA EN PINO ALDUCO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(280,'CAMA; CUNA CON COMODA EN PINO ALDUCO ;',26,115,1,
1,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(280,curdate(),0);



insert into modelo_producto  values (116,'CUNA CON COMODA COLOR CAOBA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(281,'CAMA; CUNA CON COMODA COLOR CAOBA ;',26,116,1,
1,CURDATE(),1,6,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(281,curdate(),0);



insert into tipo_producto values(7,'CAMAROTES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(27,'CAMAROTES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (117,'RANCHEROS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(282,'CAMAROTES; RANCHEROS ; 1 1/2 PLAZA',27,117,1,
2,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(282,curdate(),0);

/* insert into talla_producto values(7,'1 1/2 PLAZA /  MIXTO','',curdate(),curdate(),curdate(),0,0,0,1);*/
insert into modelo_producto  values (118,'TABLON','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(283,'CAMAROTES; TABLON ; 1 1/2 PLAZA - MIXTO',27,118,1,
7,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(283,curdate(),0);

insert into modelo_producto  values (119,'DE PINO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(284,'CAMAROTES; DE PINO ; 1 1/2 PLAZA - MIXTO',27,119,1,
7,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(284,curdate(),0);


insert into modelo_producto  values (120,'DE PINO CON CAJONES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(285,'CAMAROTES; DE PINO CON CAJONES ; 1 1/2 PLAZA - MIXTO',27,120,1,
7,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(285,curdate(),0);

insert into modelo_producto  values (121,'DE TORNILLO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(286,'CAMAROTES; DE TORNILLO ; 1 1/2 PLAZA - MIXTO',27,121,1,
7,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(286,curdate(),0);


insert into modelo_producto  values (122,'DE TORNILLO CON CAJONES','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(287,'CAMAROTES ; DE TORNILLO CON CAJONES ; 1 1/2 PLAZA - MIXTO',27,122,1,
7,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(287,curdate(),0);



insert into modelo_producto  values (123,'DE METAL','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(288,'CAMAROTES; DE METAL ; 1 1/2 PLAZA',27,123,1,
2,CURDATE(),1,7,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(288,curdate(),0);


insert into tipo_producto values(8,'TARIMAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(28,'TARIMAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (124,'TRUJILLO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(289,'TARIMAS; TRUJILLO ; 1 1/2 PLAZA',28,124,1,
2,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(289,curdate(),0);
INSERT INTO  producto VALUES(290,'TARIMAS; TRUJILLO ; 2 PLAZAS',28,124,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(290,curdate(),0);


insert into modelo_producto  values (125,'LIMA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(291,'TARIMAS; LIMA ; 1 1/2 PLAZA',28,125,1,
2,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(291,curdate(),0);
INSERT INTO  producto VALUES(292,'TARIMAS; LIMA ; 2 PLAZAS',28,125,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(292,curdate(),0);



/*
insert into talla_producto values(8,'2 PLAZAS 1/2','',curdate(),curdate(),curdate(),0,0,0,1);
insert into talla_producto values(9,'3 PLAZAS','',curdate(),curdate(),curdate(),0,0,0,1);
 */
insert into modelo_producto  values (126,'FORRADA MARCA VIVE','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(293,'TARIMAS; FORRADA MARCA VIVE ; 1 1/2 PLAZA',28,126,1,
2,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(293,curdate(),0);
INSERT INTO  producto VALUES(294,'TARIMAS; FORRADA MARCA VIVE ; 2 PLAZAS',28,126,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(294,curdate(),0);

INSERT INTO  producto VALUES(295,'TARIMAS; FORRADA MARCA VIVE ; 2 PLAZAS 1/2',28,126,1,
8,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(295,curdate(),0);

INSERT INTO  producto VALUES(296,'TARIMAS; FORRADA MARCA VIVE ; 3 PLAZAS',28,126,1,
9,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(296,curdate(),0);


insert into modelo_producto  values (127,'FORRADA MARCA PARAISO ROYAL','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(297,'TARIMAS; FORRADA MARCA PARAISO ROYAL ; 2 PLAZAS',28,127,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(297,curdate(),0);

INSERT INTO  producto VALUES(298,'TARIMAS; FORRADA MARCA PARAISO ROYAL ; 2 PLAZAS 1/2',28,127,1,
8,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(298,curdate(),0);

INSERT INTO  producto VALUES(299,'TARIMAS; FORRADA MARCA PARAISO ROYAL ; 3 PLAZAS',28,127,1,
9,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(299,curdate(),0);



insert into modelo_producto  values (128,'FORRADA MARCA PARAISO MODELO ZEBRA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(300,'TARIMAS; FORRADA MARCA PARAISO MODELO ZEBRA ; 2 PLAZAS',28,128,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(300,curdate(),0);

INSERT INTO  producto VALUES(301,'TARIMAS; FORRADA MARCA PARAISO MODELO ZEBRA ; 2 PLAZAS 1/2',28,128,1,
8,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(301,curdate(),0);

INSERT INTO  producto VALUES(302,'TARIMAS; FORRADA MARCA PARAISO MODELO ZEBRA ; 3 PLAZAS',28,128,1,
9,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(302,curdate(),0);



insert into modelo_producto  values (129,'FORRADA MARCA PARAISO MODELO MEDALLON','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(303,'TARIMAS; FORRADA MARCA PARAISO MODELO MEDALLON ; 2 PLAZAS',28,129,1,
3,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(303,curdate(),0);

INSERT INTO  producto VALUES(304,'TARIMAS; FORRADA MARCA PARAISO MODELO MEDALLON ; 2 PLAZAS 1/2',28,129,1,
8,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(304,curdate(),0);

INSERT INTO  producto VALUES(305,'TARIMAS; FORRADA MARCA PARAISO MODELO MEDALLON ; 3 PLAZAS',28,129,1,
9,CURDATE(),1,8,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(305,curdate(),0);



insert into tipo_producto values(9,'VELADORES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(29,'VELADORES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (130,'AL DUCO','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(306,'VELADORES; AL DUCO ;',28,130,1,
1,CURDATE(),1,9,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(306,curdate(),0);



insert into modelo_producto  values (131,'DE MADERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(307,'VELADORES; DE MADERA ;',28,131,1,
1,CURDATE(),1,9,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(307,curdate(),0);



insert into tipo_producto values(10,'COMODAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(30,'COMODAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (132,'CONTRA PLACADA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(308,'COMODAS; CONTRA PLACADA ;',30,132,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(308,curdate(),0);

insert into modelo_producto  values (133,'DE MADERA MATE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(309,'COMODAS; DE MADERA MATE ;',30,133,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(309,curdate(),0);


insert into modelo_producto  values (134,'DE MADERA BRILLOSAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(310,'COMODAS; DE MADERA BRILLOSAS ;',30,134,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(310,curdate(),0);

insert into modelo_producto  values (135,'DE ISPINGO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(311,'COMODAS; DE ISPINGO ;',30,135,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(311,curdate(),0);


insert into modelo_producto  values (136,'METRO CINCUENTA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(312,'COMODAS; METRO CINCUENTA ;',30,136,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(312,curdate(),0);




insert into modelo_producto  values (137,'AL DUCO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(313,'COMODAS; AL DUCO ;',30,137,1,
1,CURDATE(),1,10,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(313,curdate(),0);



insert into tipo_producto values(11,'COMODINES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(31,'COMODINES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (138,'EN CAPIRONA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(314,'COMODINES; EN CAPIRONA ;',31,138,1,
1,CURDATE(),1,11,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(314,curdate(),0);

insert into modelo_producto  values (139,'EN MELAMINE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(315,'COMODINES; EN MELAMINE ;',31,139,1,
1,CURDATE(),1,11,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(315,curdate(),0);


insert into modelo_producto  values (140,'DE MADERA NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(316,'COMODINES; DE MADERA NIÑOS ;',31,140,1,
1,CURDATE(),1,11,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(316,curdate(),0);




insert into tipo_producto values(12,'ROPEROS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(32,'ROPERO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (141,'COMODA EN L','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(317,'ROPERO; COMODA EN L ;',32,141,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(317,curdate(),0);


insert into modelo_producto  values (142,'CONTRAPLACADO (ESPERANZA)','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(318,'ROPERO; CONTRAPLACADO (ESPERANZA) ;',32,142,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(318,curdate(),0);

insert into modelo_producto  values (143,'JUNIOR CAPIRONA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(319,'ROPERO; JUNIOR CAPIRONA ;',32,143,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(319,curdate(),0);

insert into modelo_producto  values (144,'JUNIOR EN MELAMINE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(320,'ROPERO; JUNIOR EN MELAMINE ;',32,144,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(320,curdate(),0);

insert into modelo_producto  values (145,'EN CARAPACHO TRES PUERTAS CON SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(321,'ROPERO; EN CARAPACHO TRES PUERTAS CON SABANERA ;',32,145,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(321,curdate(),0);


insert into modelo_producto  values (146,'EN CARAPACHO TRES PUERTAS SIN SABANERA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(322,'ROPERO; EN CARAPACHO TRES PUERTAS SIN SABANERA ;',32,146,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(322,curdate(),0);

insert into modelo_producto  values (147,'JUNIOR EN MELAMINE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(323,'ROPERO; JUNIOR EN MELAMINE ;',32,147,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(323,curdate(),0);


insert into modelo_producto  values (148,'EN MELAMINE TRES PUERTAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(324,'ROPERO; EN MELAMINE TRES PUERTAS ;',32,148,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(324,curdate(),0);


insert into modelo_producto  values (149,'EN MELAMINE CUATRO PUERTAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(325,'ROPERO; EN MELAMINE CUATRO PUERTAS ;',32,149,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(325,curdate(),0);


insert into modelo_producto  values (150,'EN MELAMINE DOS PUERTAS NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(326,'ROPERO; EN MELAMINE DOS PUERTAS NIÑOS ;',32,150,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(326,curdate(),0);

insert into modelo_producto  values (151,'EN MELAMINE TRES PUERTAS NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(327,'ROPERO; EN MELAMINE TRES PUERTAS NIÑOS ;',32,151,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(327,curdate(),0);

insert into modelo_producto  values (152,'EN MELAMINE CON DIBUJO NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(328,'ROPERO; EN MELAMINE CON DIBUJO NIÑOS ;',32,152,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(328,curdate(),0);

insert into modelo_producto  values (153,'DE MADERA NIÑOS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(329,'ROPERO; DE MADERA NIÑOS ;',32,153,1,
1,CURDATE(),1,12,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(329,curdate(),0);



insert into tipo_producto values(13,'RESPOSTEROS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(33,'REPOSTERO','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (154,'MADERA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(330,'REPOSTERO; MADERA ;',33,154,1,
1,CURDATE(),1,13,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(330,curdate(),0);


insert into modelo_producto  values (155,'EN MELAMINE METRO 20','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(331,'REPOSTERO; MADERA ;',33,155,1,
1,CURDATE(),1,13,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(331,curdate(),0);


insert into modelo_producto  values (156,'EN MELAMINE METRO 30','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(332,'REPOSTERO; EN MELAMINE METRO 30 ;',33,156,1,
1,CURDATE(),1,13,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(332,curdate(),0);

insert into modelo_producto  values (157,'EN MELAMINE METRO 50','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(333,'REPOSTERO; EN MELAMINE METRO 50 ;',33,157,1,
1,CURDATE(),1,13,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(333,curdate(),0);


insert into modelo_producto  values (158,'EN MELAMINE 90 CM','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(334,'REPOSTERO; EN MELAMINE 90 CM ;',33,158,1,
1,CURDATE(),1,13,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(334,curdate(),0);


insert into tipo_producto values(14,'SABANAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(34,'SABANAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (159,'ECONOMICA','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(335,'SABANAS; ECONOMICA ; 1 1/2 PLAZA',34,159,1,
2,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(335,curdate(),0);

insert into modelo_producto  values (160,'INTERMEDIA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(336,'SABANAS; INTERMEDIA ; 1 1/2 PLAZA',34,160,1,
2,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(336,curdate(),0);


insert into modelo_producto  values (161,'NANCY','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(337,'SABANAS; NANCY ; 1 1/2 PLAZA',34,161,1,
2,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(337,curdate(),0);

INSERT INTO  producto VALUES(338,'SABANAS; NANCY ; 2 PLAZAS',34,161,1,
3,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(338,curdate(),0);



insert into modelo_producto  values (162,'SABANA EN CAJITA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(339,'SABANAS; SABANA EN CAJITA ; 1 1/2 PLAZA',34,162,1,
2,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(339,curdate(),0);

INSERT INTO  producto VALUES(340,'SABANAS; SABANA EN CAJITA ; 2 PLAZAS',34,162,1,
3,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(340,curdate(),0);

INSERT INTO  producto VALUES(341,'SABANAS; SABANA EN CAJITA ; 3 PLAZAS',34,162,1,
9,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(341,curdate(),0);



insert into modelo_producto  values (163,'POLAR CON ELASTICO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(342,'SABANAS; POLAR CON ELASTICO ;',34,163,1,
1,CURDATE(),1,14,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(342,curdate(),0);




insert into tipo_producto values(15,'FRAZADAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(35,'FRAZADAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (164,'ECONOMICA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(343,'FRAZADAS; ECONOMICA ;',35,164,1,
1,CURDATE(),1,15,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(343,curdate(),0);



insert into modelo_producto  values (165,'SANTA CATALINA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(344,'FRAZADAS; SANTA CATALINA ;',35,165,1,
1,CURDATE(),1,15,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(344,curdate(),0);



insert into modelo_producto  values (166,'TIGRE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(345,'FRAZADAS; TIGRE ;',35,166,1,
1,CURDATE(),1,15,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(345,curdate(),0);



insert into tipo_producto values(16,'COLCHAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(36,'COLCHA','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (167,'DE HILO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(346,'COLCHA; DE HILO ;',36,167,1,
1,CURDATE(),1,16,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(346,curdate(),0);


insert into modelo_producto  values (168,'POLAR','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(347,'COLCHA; POLAR ;',36,168,1,
1,CURDATE(),1,16,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(347,curdate(),0);



insert into modelo_producto  values (169,'POLAR PLUSH','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(348,'COLCHA; POLAR PLUSH ;',36,169,1,
1,CURDATE(),1,16,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(348,curdate(),0);


insert into tipo_producto values(17,'ALMOHADAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(37,'ALMOHADAS','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (170,'ECONOMICA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(349,'ALMOHADAS; ECONOMICA ;',37,170,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(349,curdate(),0);


insert into modelo_producto  values (171,'ACOLCHADAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(350,'ALMOHADAS; ACOLCHADAS ;',37,171,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(350,curdate(),0);


insert into modelo_producto  values (172,'DE ESPUMA MARCA VIVE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(351,'ALMOHADAS; DE ESPUMA MARCA VIVE ;',37,172,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(351,curdate(),0);


insert into modelo_producto  values (173,'DE NAPA MARCA VIVE','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(352,'ALMOHADAS; DE NAPA MARCA VIVE ;',37,173,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(352,curdate(),0);

insert into modelo_producto  values (174,'ESPUMA SUEÑO DORADO','',curdate(),curdate(),curdate(),0,0,0,1);
INSERT INTO  producto VALUES(353,'ALMOHADAS; ESPUMA SUEÑO DORADO ;',37,174,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(353,curdate(),0);

insert into modelo_producto  values (175,'EN ALGODON SUEÑO DORADO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(354,'ALMOHADAS; EN ALGODON SUEÑO DORADO ;',37,175,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(354,curdate(),0);


insert into modelo_producto  values (176,'ESPUMA MUNDIAL','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(355,'ALMOHADAS; ESPUMA MUNDIAL ;',37,176,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(355,curdate(),0);


insert into modelo_producto  values (177,'EN ALGODON MUNDIAL','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(356,'ALMOHADAS; EN ALGODON MUNDIAL ;',37,177,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(356,curdate(),0);


insert into modelo_producto  values (178,'PARAISO SINTETICAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(357,'ALMOHADAS; PARAISO SINTETICAS ;',37,178,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(357,curdate(),0);


insert into modelo_producto  values (179,'PARAISO TELA','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(358,'ALMOHADAS; PARAISO TELA ;',37,179,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(358,curdate(),0);


insert into modelo_producto  values (180,'PARAISO BISCOLASTICAS','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(359,'ALMOHADAS; PARAISO TELA ;',37,180,1,
1,CURDATE(),1,17,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(359,curdate(),0);




insert into tipo_producto values(18,'PROTECTORES DE COLCHON','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(38,'PROTECTORES DE COLCHON','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (181,'MARCA MUNDIAL','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(360,'PROTECTORES DE COLCHON; MARCA MUNDIAL ; 1 1/2 PLAZA',38,181,1,
2,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(360,curdate(),0);
INSERT INTO  producto VALUES(361,'PROTECTORES DE COLCHON; MARCA MUNDIAL ; 2 PLAZAS',38,181,1,
3,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(361,curdate(),0);

INSERT INTO  producto VALUES(362,'PROTECTORES DE COLCHON; MARCA MUNDIAL ; 2 PLAZAS 1/2',38,181,1,
8,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(362,curdate(),0);

INSERT INTO  producto VALUES(363,'PROTECTORES DE COLCHON; MARCA MUNDIAL ; 3 PLAZAS',38,181,1,
9,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(363,curdate(),0);


insert into modelo_producto  values (182,'MARCA VIVE','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(364,'PROTECTORES DE COLCHON; MARCA VIVE ; 1 1/2 PLAZA',38,182,1,
2,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(364,curdate(),0);
INSERT INTO  producto VALUES(365,'PROTECTORES DE COLCHON; MARCA VIVE ; 2 PLAZAS',38,182,1,
3,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(365,curdate(),0);

INSERT INTO  producto VALUES(366,'PROTECTORES DE COLCHON; MARCA VIVE ; 2 PLAZAS 1/2',38,182,1,
8,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(366,curdate(),0);

INSERT INTO  producto VALUES(367,'PROTECTORES DE COLCHON; MARCA VIVE ; 3 PLAZAS',38,182,1,
9,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(367,curdate(),0);





insert into modelo_producto  values (183,'MARCA SUEÑO DORADO','',curdate(),curdate(),curdate(),0,0,0,1);

INSERT INTO  producto VALUES(368,'PROTECTORES DE COLCHON; MARCA SUEÑO DORADO ; 1 1/2 PLAZA',38,183,1,
2,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(368,curdate(),0);
INSERT INTO  producto VALUES(369,'PROTECTORES DE COLCHON; MARCA SUEÑO DORADO ; 2 PLAZAS',38,183,1,
3,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(369,curdate(),0);

INSERT INTO  producto VALUES(370,'PROTECTORES DE COLCHON; MARCA SUEÑO DORADO ; 2 PLAZAS 1/2',38,183,1,
8,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(370,curdate(),0);

INSERT INTO  producto VALUES(371,'PROTECTORES DE COLCHON; MARCA SUEÑO DORADO ; 3 PLAZAS',38,183,1,
9,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(371,curdate(),0);




insert into modelo_producto  values (184,'MARCA PARAISO','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(372,'PROTECTORES DE COLCHON; MARCA PARAISO ; 1 1/2 PLAZA',38,184,1,
2,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(372,curdate(),0);
INSERT INTO  producto VALUES(373,'PROTECTORES DE COLCHON; MARCA PARAISO ; 2 PLAZAS',38,184,1,
3,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(373,curdate(),0);

INSERT INTO  producto VALUES(374,'PROTECTORES DE COLCHON; MARCA PARAISO ; 2 PLAZAS 1/2',38,184,1,
8,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(374,curdate(),0);

INSERT INTO  producto VALUES(375,'PROTECTORES DE COLCHON; MARCA PARAISO ; 3 PLAZAS',38,184,1,
9,CURDATE(),1,18,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(375,curdate(),0);



insert into tipo_producto values(19,'EDREDONES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into marca_producto values(39,'EDREDONES','',curdate(),curdate(),curdate(),0,0,0,1);
insert into modelo_producto  values (185,'ESTANDAR','',curdate(),curdate(),curdate(),0,0,0,1);


INSERT INTO  producto VALUES(376,'EDREDONES; ESTANDAR ; 1 1/2 PLAZA',39,185,1,
2,CURDATE(),1,19,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(376,curdate(),0);
INSERT INTO  producto VALUES(377,'EDREDONES; ESTANDAR ; 2 PLAZAS',39,185,1,
3,CURDATE(),1,19,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(377,curdate(),0);

INSERT INTO  producto VALUES(378,'EDREDONES; ESTANDAR ; 2 PLAZAS 1/2',39,185,1,
8,CURDATE(),1,19,1,curdate(),curdate(),curdate(),0,0,0,1);
insert into precio_producto(id_producto ,fecha_actualizacion ,precio_producto) values(378,curdate(),0);

 


