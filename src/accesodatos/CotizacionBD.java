/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Cotizacion;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class CotizacionBD {

    private Cotizacion c;

    public CotizacionBD() {
    }

    public CotizacionBD(Cotizacion c) {
        this.c = c;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select id_cotizacion from cotizacion where id_cotizacion = " + c.getIdCotizacion();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 

                cdb.un_sql = "update cotizacion set id_cotizacion = " + c.getIdCotizacion() + ", id_venta = '" + c.getVenta()
                        + "' , id_cliente = " + c.getCliente()
                        + " , total_cotizacion = " + c.getTotalCotizacion()
                        + " , fecha_cotizacion = " + c.getFechaCotizacion();

                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                //("'"+ String +"', "int";")
                cdb.un_sql = "insert into cotizacion(id_cotizacion,id_venta,id_cliente,total_cotizacion,fecha_cotizacion)"
                        + " values (" + c.getIdCotizacion() + ",'" + c.getVenta() + "'," + c.getCliente() + "," + c.getTotalCotizacion() + "," + c.getFechaCotizacion() + ")";

                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into cotizacion(id_cotizacion,id_venta,id_cliente,total_cotizacion,fecha_cotizacion)"
                    + " values (" + c.getIdCotizacion() + ",'" + c.getVenta() + "'," + c.getCliente() + "," + c.getTotalCotizacion() + "," + c.getFechaCotizacion() + ")";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }
     public ArrayList<Cotizacion> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Cotizacion> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from insumos ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Cotizacion in = new Cotizacion();
            in.setIdCotizacion(cdb.resultado.getInt("id_cotizacion"));
           // in.setVenta(cdb.resultado.getInt("id_venta"));
            //in.setCliente(cdb.resultado.getInt("id_cliente"));
            in.setTotalCotizacion(cdb.resultado.getInt("total_cotizacion"));
            in.setFechaCotizacion(cdb.resultado.getInt("fecha_cotizacion"));

            registros.add(in);
        }
        return registros;
    }

}
