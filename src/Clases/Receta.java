/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import accesodatos.RecetaBD;
import java.util.ArrayList;

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

    public Receta() {

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

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        RecetaBD rbd = new RecetaBD(this);
        rbd.grabar();
    }

    public ArrayList<Receta> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        RecetaBD pbd = new RecetaBD();
        return pbd.cargar();
    }

}
