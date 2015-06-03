/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class FormaPago {
    private int idFormaPago;
    private Ventas venta;

    public FormaPago(int idFormaPago, Ventas venta) {
        this.idFormaPago = idFormaPago;
        this.venta = venta;
    }


    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "FormaPago{" + "idFormaPago=" + idFormaPago + ", idVenta=" + venta + '}';
    }
    
    
}
