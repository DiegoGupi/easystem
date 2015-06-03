/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Contado {
    private int idContado;
    private int totalContado;
    private FormaPago formaPago;
    private Venta venta;

    public Contado(int idContado, int totalContado, FormaPago formaPago, Venta venta) {
        this.idContado = idContado;
        this.totalContado = totalContado;
        this.formaPago = formaPago;
        this.venta = venta;
    }



    public int getIdContado() {
        return idContado;
    }

    public void setIdContado(int idContado) {
        this.idContado = idContado;
    }

    public int getTotalContado() {
        return totalContado;
    }

    public void setTotalContado(int totalContado) {
        this.totalContado = totalContado;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Venta getIdVenta() {
        return venta;
    }

    public void setIdVenta(Venta idVenta) {
        this.venta = idVenta;
    }

    @Override
    public String toString() {
        return "Contado{" + "idContado=" + idContado + ", totalContado=" + totalContado + ", idFormaPago=" + formaPago + ", idVenta=" + venta + '}';
    }
    
    
}
