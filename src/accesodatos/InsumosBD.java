/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Insumos;
import Clases.Producto;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author Nigga
 */
public class InsumosBD {

    private Insumos i;

    public InsumosBD() {
    }

    public InsumosBD(Insumos i) {
        this.i = i;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select id_insumo from insumos where id_insumo = " + i.getIdInsumo();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 

                cdb.un_sql = "update insumos set id_insumo = " + i.getIdInsumo() + ", nombre_insumo = '" + i.getNombreInsumo()
                        + "' , unidadmedida_insumo = '" + i.getMedidaInsumo()
                        + "' , precio_insumo = " + i.getPrecioInsumo()
                        + " , cantidad_insumo = " + i.getCantidadInsumo()
                        + " where id_insumo = " + i.getIdInsumo();
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                //("'"+ String +"', "int";")
                cdb.un_sql = "insert into insumos(id_insumo,nombre_insumo,unidadmedida_insumo,precio_insumo,cantidad_insumo)"
                        + " values (" + i.getIdInsumo() + ",'" + i.getNombreInsumo() + "','" + i.getMedidaInsumo() + "'," + i.getPrecioInsumo() + "," + i.getCantidadInsumo() + ")";

                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into insumos(id_insumo,nombre_insumo,unidadmedida_insumo,precio_insumo,cantidad_insumo)"
                    + " values (" + i.getIdInsumo() + ",'" + i.getNombreInsumo() + "','" + i.getMedidaInsumo() + "'," + i.getPrecioInsumo() + "," + i.getCantidadInsumo() + ")";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }

    public ArrayList<Insumos> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Insumos> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from insumos ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Insumos in = new Insumos();
            in.setIdInsumo(cdb.resultado.getInt("id_insumo"));
            in.setNombreInsumo(cdb.resultado.getString("nombre_insumo"));
            in.setMedidaInsumo(cdb.resultado.getString("unidadmedida_insumo"));
            in.setPrecioInsumo(cdb.resultado.getInt("precio_insumo"));
            in.setCantidadInsumo(cdb.resultado.getInt("cantidad_insumo"));

            registros.add(in);
        }
        return registros;
    }

    public ArrayList<Insumos> cargainsumos(int cantidad, String nomproducto) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Insumos> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from insumos ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Insumos in = new Insumos();
            in.setIdInsumo(cdb.resultado.getInt("id_insumo"));
            in.setNombreInsumo(cdb.resultado.getString("nombre_insumo"));
            in.setMedidaInsumo(cdb.resultado.getString("unidadmedida_insumo"));
            in.setPrecioInsumo(cdb.resultado.getInt("precio_insumo"));
            in.setCantidadInsumo(cdb.resultado.getInt("cantidad_insumo"));

            registros.add(in);
        }
        return registros;
    }

    public ArrayList<Insumos> cargainsumosporproducto(int id_producto) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<Insumos> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT CANTIDAD_INSUMO"
                + ", NOMBRE_INSUMO"
                + ", PRECIO_INSUMO"
                + "FROM     "
                + "insumos"
                + "WHERE F.ID_PRODUCTO = '" + id_producto + "' ";

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Insumos in = new Insumos();
            Producto pr = new Producto();
            in.setCantidadInsumo(cdb.resultado.getInt("CANTIDAD_INSUMO"));
            in.setNombreInsumo(cdb.resultado.getString("NOMBRE_INSUMO"));
            in.setPrecioInsumo(cdb.resultado.getInt("PRECIO_INSUMO"));

            registros.add(in);
        }
        return registros;
    }
}
