/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Venta {
    private int idVenta;
    private Cotizacion cotizacion;
    private int fechaVenta;

    public Venta(int idVenta, Cotizacion cotizacion, int fechaVenta) {
        this.idVenta = idVenta;
        this.cotizacion = cotizacion;
        this.fechaVenta = fechaVenta;
    }

  

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public int getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(int fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCotizacion=" + cotizacion + ", fechaVenta=" + fechaVenta + '}';
    }
    
    
    
}
