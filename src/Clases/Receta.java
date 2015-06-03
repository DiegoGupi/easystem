/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class Receta {
   private int idReceta;
   private String detalleReceta;
   private Producto producto;

    //   private Fabricado idFabricado;
    public Receta(int idReceta, String detalleReceta, Producto producto) {
        this.idReceta = idReceta;
        this.detalleReceta = detalleReceta;
        this.producto = producto;
    }
    


    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getDetalleReceta() {
        return detalleReceta;
    }

    public void setDetalleReceta(String detalleReceta) {
        this.detalleReceta = detalleReceta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
   

    
   
   
    
}
