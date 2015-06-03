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
    
    private String nombreCliente,direccionCliente,empresaCliente,mailCliente,tipoCliente;
    private int rutCliente,telefonoCliente;

    public Cliente() {
    }
    
    public Cliente(String nombreCliente, String direccionCliente, String empresaCliente, String mailCliente, String tipoCliente, int rutCliente, int telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.empresaCliente = empresaCliente;
        this.mailCliente = mailCliente;
        this.tipoCliente = tipoCliente;
        this.rutCliente = rutCliente;
        this.telefonoCliente = telefonoCliente;
    }



    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getEmpresaCliente() {
        return empresaCliente;
    }

    public void setEmpresaCliente(String empresaCliente) {
        this.empresaCliente = empresaCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
        public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "nombreCliente=" + nombreCliente + ", direccionCliente=" + direccionCliente + ", empresaCliente=" + empresaCliente + ", mailCliente=" + mailCliente + ", telefonoCliente=" + telefonoCliente + '}';
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
    
}
