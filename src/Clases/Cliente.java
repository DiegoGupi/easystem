/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import accesodatos.ClienteBD;
import java.util.ArrayList;

/**
 *
 * @author Nigga
 */
public class Cliente {
    
    private String rutCliente, nombreCliente,direccionCliente,empresaCliente,mailCliente,tipoCliente;
    private int idcliente, telefonoCliente;

    public Cliente() {
    }

    public Cliente(String rutCliente, String nombreCliente, String direccionCliente, String empresaCliente, String mailCliente, String tipoCliente, int idcliente, int telefonoCliente) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.empresaCliente = empresaCliente;
        this.mailCliente = mailCliente;
        this.tipoCliente = tipoCliente;
        this.idcliente = idcliente;
        this.telefonoCliente = telefonoCliente;
    }

    
    @Override
    public String toString() {
        return this.nombreCliente;
    }


    
    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ClienteBD pbd = new ClienteBD(this);
        pbd.grabar();
    }
    
    
    public ArrayList<Cliente> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ClienteBD pbd = new ClienteBD();
        return pbd.cargar();
    }
        public ArrayList<Cliente> cargarcliente() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ClienteBD pbd = new ClienteBD();
        return pbd.cargarcombocliente();
    }

    /**
     * @return the rutCliente
     */
    public String getRutCliente() {
        return rutCliente;
    }

    /**
     * @param rutCliente the rutCliente to set
     */
    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     * @return the empresaCliente
     */
    public String getEmpresaCliente() {
        return empresaCliente;
    }

    /**
     * @param empresaCliente the empresaCliente to set
     */
    public void setEmpresaCliente(String empresaCliente) {
        this.empresaCliente = empresaCliente;
    }

    /**
     * @return the mailCliente
     */
    public String getMailCliente() {
        return mailCliente;
    }

    /**
     * @param mailCliente the mailCliente to set
     */
    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    /**
     * @return the tipoCliente
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @param tipoCliente the tipoCliente to set
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the telefonoCliente
     */
    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    /**
     * @param telefonoCliente the telefonoCliente to set
     */
    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
}
