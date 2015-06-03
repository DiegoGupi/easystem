/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author DiegoAndrés
 */
import accesodatos.UsuariosBD;
import java.util.ArrayList;

public class Usuarios {

    private String Nombre, nombreusuario, contraseñausuario;

    public Usuarios(String Nombre, String nombreusuario, String contraseñausuario) {
        this.Nombre = Nombre;
        this.nombreusuario = nombreusuario;
        this.contraseñausuario = contraseñausuario;
    }

    public Usuarios() {
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the nombreusuario
     */
    public String getNombreusuario() {
        return nombreusuario;
    }

    /**
     * @param nombreusuario the nombreusuario to set
     */
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    /**
     * @return the contraseñausuario
     */
    public String getContraseñausuario() {
        return contraseñausuario;
    }

    /**
     * @param contraseñausuario the contraseñausuario to set
     */
    public void setContraseñausuario(String contraseñausuario) {
        this.contraseñausuario = contraseñausuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + Nombre + ", nombreusuario=" + nombreusuario + ", contraseñausuario=" + contraseñausuario + '}';
    }

    public void grabarusuarios() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        UsuariosBD pbd = new UsuariosBD();
        pbd.grabar();
    }

    public ArrayList<Usuarios> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        UsuariosBD pbd = new UsuariosBD();
        return pbd.cargar();
    }

}
