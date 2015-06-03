/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Cotizacion;
import Clases.Ventas;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class VentasBD {

    private Ventas c;

    public VentasBD() {
    }

    public VentasBD(Ventas c) {
        this.c = c;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select id_venta from venta where id_venta = " + c.getIdVenta();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 

                cdb.un_sql = "update venta set id_venta = " + c.getIdVenta()
                        + ", id_cotizacion = '" + c.getCotizacion()
                        + "', estado_venta = '" + c.isEstado()
                        + "', fecha_venta = '" + c.getFechaVenta();

                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                //("'"+ String +"', "int";")
                cdb.un_sql = "insert into venta(id_venta,id_cotizacion,estado_venta,fecha_venta)"
                        + " values (" + c.getIdVenta() + ",'" + c.getCotizacion() + "','" + c.isEstado() + "','" + c.getFechaVenta() + "')";

                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into venta(id_venta,id_cotizacion,estado_venta,fecha_venta)"
                    + " values (" + c.getIdVenta() + ",'" + c.getCotizacion() + "','" + c.isEstado() + "','" + c.getFechaVenta() + "')";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }

    public ArrayList<Ventas> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<Ventas> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from venta ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Ventas cl = new Ventas();
            Cotizacion c = new Cotizacion(cdb.resultado.getInt("cotizacion"));
            cl.setEstado(cdb.resultado.getBoolean("estado_venta"));
            cl.setFechaVenta(cdb.resultado.getString("fecha_venta"));
            cl.setIdVenta(cdb.resultado.getInt("id_venta"));
            registros.add(cl);
        }
        return registros;

    }



}
