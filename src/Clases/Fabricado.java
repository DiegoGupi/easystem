/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Fabricado {
    private int idFabricado;
    private Producto producto;
    private Receta receta;

    public Fabricado(int idFabricado, Producto producto, Receta receta) {
        this.idFabricado = idFabricado;
        this.producto = producto;
        this.receta = receta;
    }



    public int getIdFabricado() {
        return idFabricado;
    }

    public void setIdFabricado(int idFabricado) {
        this.idFabricado = idFabricado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "Fabricado{" + "idFabricado=" + idFabricado + ", idProducto=" + producto + ", idReceta=" + receta + '}';
    }
    
    
    
}
