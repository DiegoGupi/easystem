/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import accesodatos.InsumosBD;
import accesodatos.VentasBD;
import java.util.ArrayList;

/**
 *
 * @author Nigga
 */
public class Ventas {

    private int idVenta;
    private Cotizacion cotizacion;
    private String fechaVenta;
    private boolean estado;

    public Ventas() {
    }

    public Ventas(int idVenta, Cotizacion cotizacion, String fechaVenta, boolean estado) {
        this.idVenta = idVenta;
        this.cotizacion = cotizacion;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public Ventas(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + getIdVenta() + ", idCotizacion=" + getCotizacion() + ", fechaVenta=" + getFechaVenta() + '}';
    }

    /**
     * @return the idVenta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the cotizacion
     */
    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    /**
     * @param cotizacion the cotizacion to set
     */
    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    /**
     * @return the fechaVenta
     */
    public String getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
        public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        VentasBD pbd = new VentasBD(this);
        pbd.grabar();
    }
    
    
    public ArrayList<Ventas> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        VentasBD pbd = new VentasBD();
        return pbd.cargar();
    }

  
}
