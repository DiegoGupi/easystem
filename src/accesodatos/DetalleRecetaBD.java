/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

/**
 *
 * @author DiegoAndrés
 */

import Clases.DetalleReceta;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

public class DetalleRecetaBD {
     private DetalleReceta dr;

    public DetalleRecetaBD() {
    }

    public DetalleRecetaBD(DetalleReceta dr) {
        this.dr = dr;
    }
     
     public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select ID_DETALLERECETA from detallereceta where ID_DETALLERECETA = " +dr.getDetalleReceta();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {

                cdb.un_sql = "update cliente set ID_DETALLERECETA = "+dr.getDetalleReceta()+", ID_RECETA = '" + dr.getReceta()+"', ID_INSUMO = '" + dr.getInsumos()+"', CANTIDAD_DETALLERECETA = '" + dr.getDetalleReceta()
                        + "' where ID_DETALLERECETA = " + dr.getDetalleReceta();
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                cdb.un_sql = "insert into detallereceta(ID_DETALLERECETA,ID_RECETA,ID_INSUMO,CANTIDAD_DETALLERECETA,CANTIDAD_DETALLERECETA)"
                        + " values ("+dr.getDetalleReceta()+",'" + dr.getReceta() + "','"+ dr.getInsumos() +"','"+ dr.getDetalleReceta() +"')";
                
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
            cdb.un_sql = "insert into detallereceta(ID_DETALLERECETA,ID_RECETA,ID_INSUMO,CANTIDAD_DETALLERECETA)"
                        + " values ("+dr.getDetalleReceta()+",'" + dr.getReceta() + "','"+ dr.getInsumos() +"','"+ dr.getDetalleReceta() +"')";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }
    
    public ArrayList<DetalleReceta> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<DetalleReceta> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from detallereceta ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            DetalleReceta dr = new DetalleReceta();
            dr.setDetalleReceta(cdb.resultado.getInt("ID_DETALLERECETA"));
           // dr.setReceta(cdb.resultado.getInt("ID_RECETA"));
            //dr.setInsumos(cdb.resultado.getInt("ID_INSUMO"));
            dr.setCantidadDetalleReceta(cdb.resultado.getString("CANTIDAD_DETALLERECETA"));
            
            registros.add(dr);
        }
        return registros;
    }
    
}
