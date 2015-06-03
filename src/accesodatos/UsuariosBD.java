/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import Clases.Usuarios;
import java.util.ArrayList;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author DiegoAndrés
 */
public class UsuariosBD {

    private Usuarios c;

    public UsuariosBD() {
    }

    public UsuariosBD(Usuarios c) {
        this.c = c;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();

        cdb.un_sql = "insert into usuario(nombre,nombre_usuario,contrasena_usuario) values (" + c.getNombre() + ",'" + c.getNombreusuario() + "','" + c.getContraseñausuario() + "')";

        cdb.un_st.executeUpdate(cdb.un_sql);

    }

    public ArrayList<Usuarios> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            //añademos la execion para cdb.resultado
            java.sql.SQLException {
        ArrayList<Usuarios> registros = new ArrayList();
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();
        cdb.un_sql = "select * from usuarios ";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        while (cdb.resultado.next()) {
            Usuarios cl = new Usuarios();
            cl.setNombre(cdb.resultado.getString("nombre"));
            cl.setNombreusuario(cdb.resultado.getString("nombre_usuario"));
            cl.setContraseñausuario(cdb.resultado.getString("contrasena_usuario"));
            registros.add(cl);
        }
        return registros;
    }
}
