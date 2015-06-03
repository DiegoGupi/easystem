/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class DetalleCotizacion {
    private int idDetalleCotizacion;
    private Producto producto;
    private Cotizacion cotizacion;

    public DetalleCotizacion(int idDetalleCotizacion, Producto producto, Cotizacion cotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
        this.producto = producto;
        this.cotizacion = cotizacion;
    }



    public int getIdDetalleCotizacion() {
        return idDetalleCotizacion;
    }

    public void setIdDetalleCotizacion(int idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public Producto getIdProducto() {
        return producto;
    }

    public void setIdProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    @Override
    public String toString() {
        return "DetalleCotizacion{" + "idDetalleCotizacion=" + idDetalleCotizacion + ", idProducto=" + producto + ", idCotizacion=" + cotizacion + '}';
    }
    
    
    
}
