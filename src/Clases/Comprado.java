/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Comprado {
    private int idComprado;
    private Producto producto;

    public Comprado(int idComprado, Producto producto) {
        this.idComprado = idComprado;
        this.producto = producto;
    }


    public int getIdComprado() {
        return idComprado;
    }

    public void setIdComprado(int idComprado) {
        this.idComprado = idComprado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Comprado{" + "idComprado=" + idComprado + ", idProducto=" + producto + '}';
    }
    
    
}
