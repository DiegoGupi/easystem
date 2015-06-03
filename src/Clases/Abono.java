/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Abono {
    private int idAbono;
    private int fechaAbono;
    private int montoAbono;
    private FormaPago formaPago;
    private Credito credito;

    public Abono(int idAbono, int fechaAbono, int montoAbono, FormaPago formaPago, Credito credito) {
        this.idAbono = idAbono;
        this.fechaAbono = fechaAbono;
        this.montoAbono = montoAbono;
        this.formaPago = formaPago;
        this.credito = credito;
    }



    public int getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public int getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(int fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public int getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(int montoAbono) {
        this.montoAbono = montoAbono;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Abono{" + "idAbono=" + idAbono + ", fechaAbono=" + fechaAbono + ", montoAbono=" + montoAbono + ", idFormaPago=" + formaPago + ", idCredito=" + credito + '}';
    }
    
    
    
}
