/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Cotizacion {
    private int idCotizacion;
    private Cliente cliente;
    private Venta venta;
    private int totalCotizacion;
    private int fechaCotizacion;

    public Cotizacion(int idCotizacion, Cliente cliente, Venta venta, int totalCotizacion, int fechaCotizacion) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.venta = venta;
        this.totalCotizacion = totalCotizacion;
        this.fechaCotizacion = fechaCotizacion;
    }



    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getTotalCotizacion() {
        return totalCotizacion;
    }

    public void setTotalCotizacion(int totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }

    public int getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(int fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    @Override
    public String toString() {
        return "Cotizacion{" + "idCotizacion=" + idCotizacion + ", rutCliente=" + cliente + ", idVenta=" + venta + ", totalCotizacion=" + totalCotizacion + ", fechaCotizacion=" + fechaCotizacion + '}';
    }
   
    
}
