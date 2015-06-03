/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Credito {
    private int idCredito;
    private FormaPago formaPago;
    private Venta venta;
    private String detalleCredito;
    private int totalCredito;
    private int fechaCredito;

    public Credito(int idCredito, FormaPago formaPago, Venta venta, String detalleCredito, int totalCredito, int fechaCredito) {
        this.idCredito = idCredito;
        this.formaPago = formaPago;
        this.venta = venta;
        this.detalleCredito = detalleCredito;
        this.totalCredito = totalCredito;
        this.fechaCredito = fechaCredito;
    }



    public int getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getDetalleCredito() {
        return detalleCredito;
    }

    public void setDetalleCredito(String detalleCredito) {
        this.detalleCredito = detalleCredito;
    }

    public int getTotalCredito() {
        return totalCredito;
    }

    public void setTotalCredito(int totalCredito) {
        this.totalCredito = totalCredito;
    }

    public int getFechaCredito() {
        return fechaCredito;
    }

    public void setFechaCredito(int fechaCredito) {
        this.fechaCredito = fechaCredito;
    }

    @Override
    public String toString() {
        return "Credito{" + "idCredito=" + idCredito + ", idFormaPago=" + formaPago + ", idVenta=" + venta + ", detalleCredito=" + detalleCredito + ", totalCredito=" + totalCredito + ", fechaCredito=" + fechaCredito + '}';
    }
    
    
}
