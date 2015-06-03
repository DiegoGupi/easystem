/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author DiegoAndrés
 */
public class carrito {

    private String nombreinsumo = "";
    private int cantidad = 0;
    private String preciounitario = "0";

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getnombreinsumo() {
        return nombreinsumo;
    }

    public void setnombreinsumo(String nombreinsumo) {
        this.nombreinsumo = nombreinsumo;
    }

    public String getPrecio() {
        return preciounitario;
    }

    public void setPrecio(String preciounitario) {
        this.preciounitario = preciounitario;
    }

}
