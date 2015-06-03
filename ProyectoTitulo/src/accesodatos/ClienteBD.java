/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Cliente;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author Nigga
 */
public class ClienteBD {
    private Cliente c;

    public ClienteBD() {
    }

    
    public ClienteBD(Cliente c) {
        this.c = c;
    }
    
    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select rut_cliente from cliente where rut_cliente = " +c.getRutCliente();

        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);

        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                //next verificar si esta 


                cdb.un_sql = "update cliente set rut_cliente = "+c.getRutCliente()+", nombre_cliente = '" + c.getNombreCliente()
                        +"', direccion_cliente = '" + c.getDireccionCliente()
                        +"', empresa_cliente = '" + c.getEmpresaCliente()
                        +"', telefono_cliente = " + c.getTelefonoCliente()
                        +", mail_cliente = '"+ c.getMailCliente()
                        +"', tipo_cliente = '"+ c.getTipoCliente()
                        + "' where rut_cliente = " + c.getRutCliente();
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                //("'"+ String +"', "int";")
                cdb.un_sql = "insert into cliente(rut_cliente,nombre_cliente,direccion_cliente,empresa_cliente,telefono_cliente,mail_cliente,tipo_cliente)"
                        + " values ("+c.getRutCliente()+",'" + c.getNombreCliente() + "','"+ c.getDireccionCliente() +"','"+ c.getEmpresaCliente() +"',"+ c.getTelefonoCliente() +",'"+ c.getMailCliente() +"','"+ c.getTipoCliente()+ "')";
                
                cdb.un_st.executeUpdate(cdb.un_sql);
            }
        } else {
           cdb.un_sql ="insert into cliente(rut_cliente,nombre_cliente,direccion_cliente,empresa_cliente,telefono_cliente,mail_cliente,tipo_cliente)"
                        + " values ("+c.getRutCliente()+",'" + c.getNombreCliente() + "','"+ c.getDireccionCliente() +"','"+ c.getEmpresaCliente() +"',"+ c.getTelefonoCliente() +",'"+ c.getMailCliente() +"','"+ c.getTipoCliente()+ "')";
            cdb.un_st.executeUpdate(cdb.un_sql);
        }
    }
    
    public ArrayList<Cliente> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Cliente> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from cliente ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Cliente cl = new Cliente();
            cl.setRutCliente(cdb.resultado.getInt("rut_cliente"));
            cl.setNombreCliente(cdb.resultado.getString("nombre_cliente"));
            cl.setDireccionCliente(cdb.resultado.getString("direccion_cliente"));
            cl.setEmpresaCliente(cdb.resultado.getString("empresa_cliente"));
            cl.setTelefonoCliente(cdb.resultado.getInt("telefono_cliente"));
            cl.setMailCliente(cdb.resultado.getString("mail_cliente"));
            cl.setTipoCliente(cdb.resultado.getString("tipo_cliente"));
            registros.add(cl);
        }
        return registros;
    }
     

    
}
