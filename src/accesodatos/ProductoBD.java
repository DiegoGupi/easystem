/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Producto;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class ProductoBD {

    private Producto p;

    public ProductoBD() {
    }

    public ProductoBD(Producto p) {
        this.p = p;
    }

    /*public void grabar() throws java.lang.ClassNotFoundException,
     java.lang.InstantiationException,
     java.lang.IllegalAccessException,
     java.sql.SQLException {
     Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();

     cdb.un_sql = "insert into producto(nombre_producto,precio_producto,estado_producto) values (" + p.getNombreProducto() + ",'" + p.getPrecioProducto() + "','" + p.isEstadoproducto() + "')";

     cdb.un_st.executeUpdate(cdb.un_sql);

     }*/
    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select id_producto from producto where id_producto = " + p.getIdProducto();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 

                cdb.un_sql = "update producto set id_producto = " + p.getIdProducto()
                        + ", nombre_producto = '" + p.getNombreProducto()
                        + "' , precio_producto = " + p.getPrecioProducto()
                        + " , estado_producto = " + p.isEstadoproducto();
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                //("'"+ String +"', "int";")
                cdb.un_sql = "insert into producto(id_producto,nombre_producto,precio_producto,estado_producto)"
                        + " values (" + p.getIdProducto() + ",'"
                        + p.getNombreProducto() + "',"
                        + p.getPrecioProducto() + ","
                        + p.isEstadoproducto() + ")";

                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into producto(id_producto,nombre_producto,precio_producto,estado_producto)"
                    + " values (" + p.getIdProducto() + ",'"
                    + p.getNombreProducto() + "',"
                    + p.getPrecioProducto() + ","
                    + p.isEstadoproducto() + ")";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }

    public ArrayList<Producto> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<Producto> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from producto ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Producto cl = new Producto();
            cl.setNombreProducto(cdb.resultado.getString("nombre_producto"));
            cl.setPrecioProducto(cdb.resultado.getInt("precio_producto"));
            cl.setEstadoproducto(cdb.resultado.getBoolean("estado_producto"));
            registros.add(cl);
        }
        return registros;
    }

    public ArrayList<Producto> cargarcomboproducto() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<Producto> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select nombre_producto from producto";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Producto cl = new Producto();
            cl.setNombreProducto(cdb.resultado.getString("nombre_producto"));
            registros.add(cl);
        }
        return registros;
    }
    public ArrayList<Producto> cargarprecioproducto(String nomproducto, int cantidad) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<Producto> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select precio_producto from producto where nombre_producto ='" + nomproducto + "'";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Producto cl = new Producto();
            cl.setPrecioProducto(cantidad * cdb.resultado.getInt("precio_producto"));
            registros.add(cl);
        }
        return registros;
    }

}
