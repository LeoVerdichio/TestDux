/* Todos los productos del rubro "librería", creados hoy*/
SELECT p.nombre,p.fecha_creacion FROM rubro r ,producto p
 WHERE r.id_rubro=1 and p.fecha_creacion=current_date();
/* Monto total vendido por cliente (mostrar nombre del cliente y monto) */
SELECT c.nombre,sum(cantidad*precio_unitario) as Monto from cliente c 
INNER JOIN ventas v ON v.id_cliente=c.id_cliente GROUP BY c.nombre; 
/* • Cantidad de ventas por producto.*/
SELECT codigo_producto, COUNT(codigo_producto) FROM ventas GROUP BY codigo_producto;
/*  Cantidad de productos comprados por cliente en el mes actual. */
SELECT c.nombre,sum(v.cantidad) as productos FROM ventas v
 INNER JOIN cliente c ON c.id_cliente=v.id_cliente
 WHERE MONTH(fecha)=MONTH(NOW()) GROUP BY c.nombre;
 /* Ventas que tienen al menos un producto del rubro "bazar" */
 SELECT COUNT(v.codigo_producto) as Productosbazar from ventas v,producto p
 WHERE v.codigo_producto=p.codigo and p.id_rubro=2;
 


