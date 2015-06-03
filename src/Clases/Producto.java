/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import accesodatos.ProductoBD;
import java.util.ArrayList;

/**
 *
 * @author Nigga
 */
public class Producto {

    private String nombreProducto;
    private int idProducto, precioProducto;
    private boolean estadoproducto;

    public Producto() {
    }

    public Producto(String nombreProducto, int idProducto, int precioProducto, boolean estadoproducto) {
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.precioProducto = precioProducto;
        this.estadoproducto = estadoproducto;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return this.nombreProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the precioProducto
     */
    public int getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    /**
     * @return the estadoproducto
     */
    public boolean isEstadoproducto() {
        return estadoproducto;
    }

    /**
     * @param estadoproducto the estadoproducto to set
     */
    public void setEstadoproducto(boolean estadoproducto) {
        this.estadoproducto = estadoproducto;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ProductoBD pbd = new ProductoBD(this);
        pbd.grabar();
    }

    public ArrayList<Producto> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ProductoBD pbd = new ProductoBD();
        return pbd.cargar();
    }

    public ArrayList<Producto> cargarproducto() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ProductoBD pbd = new ProductoBD();
        return pbd.cargarcomboproducto();
    }

    public ArrayList<Producto> cargarprecio(String nomproducto, int cantidad) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        ProductoBD pbd = new ProductoBD();
        return pbd.cargarprecioproducto(nomproducto, cantidad);
    }

}
