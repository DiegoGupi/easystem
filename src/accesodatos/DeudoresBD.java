/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Cliente;
import Clases.Credito;
import Clases.Ventas;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class DeudoresBD {

    private Cliente c;
    private Credito cr;
    private Ventas v;

    public DeudoresBD() {
    }

    public DeudoresBD(Cliente c, Credito cr, Ventas v) {
        this.c = c;
        this.cr = cr;
        this.v = v;
    }

    public ArrayList<DeudoresBD> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ArrayList<DeudoresBD> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "SELECT\n"
                + "  cliente.NOMBRE_CLIENTE,\n"
                + "  credito.TOTAL_CREDITO,\n"
                + "  venta.ID_VENTA,\n"
                + "  venta.FECHA_VENTA,\n"
                + "  credito.ID_VENTA\n"
                + "FROM venta\n"
                + "  INNER JOIN credito\n"
                + "    ON venta.ID_VENTA = credito.ID_VENTA\n"
                + "  INNER JOIN cotizacion\n"
                + "    ON cotizacion.ID_VENTA = venta.ID_VENTA\n"
                + "    AND venta.ID_COTIZACION = cotizacion.ID_COTIZACION\n"
                + "  INNER JOIN cliente\n"
                + "    ON cotizacion.ID_CLIENTE = cliente.ID_CLIENTE ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Cliente cl = new Cliente();
            Credito cr = new Credito();
            Ventas v = new Ventas();
            cl.setIdcliente(cdb.resultado.getInt("NOMBRE_CLIENTE"));
            cr.setTotalCredito(cdb.resultado.getInt("TOTAL_CREDITO"));
            v.setIdVenta(cdb.resultado.getInt("ID_VENTA"));
            v.setFechaVenta(cdb.resultado.getString("FECHA_VENTA"));
            registros.add(this);
            
        }
        return registros;
    }


}
