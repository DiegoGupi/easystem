/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Producto;
import Clases.Receta;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class RecetaBD {

    public RecetaBD() {

    }

    private Receta r;

    public RecetaBD(Receta i) {
        this.r = i;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select id_receta from receta where id_receta = " + r.getIdReceta();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 

                cdb.un_sql = "update receta set id_receta = " + r.getIdReceta()
                        + ", ID_PRODUCTO = " + r.getProducto()
                        + " , DESCRIPCION_RECETA = '" + r.getDetalleReceta();
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                cdb.un_sql = "insert into receta(id_receta,ID_PRODUCTO,DESCRIPCION_RECETA)"
                        + " values (" + r.getIdReceta() + "," + r.getProducto() + ",'" + r.getDetalleReceta() + "')";

                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into receta(id_receta,ID_PRODUCTO,DESCRIPCION_RECETA"
                    + " values (" + r.getIdReceta() + "," + r.getProducto() + ",'" + r.getDetalleReceta() + "')";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }

    public ArrayList<Receta> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Receta> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from insumos ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Receta rc = new Receta();
            rc.setIdReceta(cdb.resultado.getInt("id_receta"));
            Producto p = new Producto(cdb.resultado.getInt("producto"));
            rc.setDetalleReceta(cdb.resultado.getString("DESCRIPCION_RECETA"));

            registros.add(rc);
        }
        return registros;
    }

}
