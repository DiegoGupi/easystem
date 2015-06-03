/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import accesodatos.ClienteBD;
import accesodatos.InsumosBD;
import java.util.ArrayList;

/**
 *
 * @author Nigga
 */
public class Insumos {

    private int idInsumo, precioInsumo, cantidadInsumo;
    private String nombreInsumo, medidaInsumo;

    public Insumos() {
    }

    public Insumos(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getMedidaInsumo() {
        return medidaInsumo;
    }

    public void setMedidaInsumo(String medidaInsumo) {
        this.medidaInsumo = medidaInsumo;
    }

    public int getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(int precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    @Override
    public String toString() {
        return nombreInsumo;
    }

    public void grabar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        InsumosBD pbd = new InsumosBD(this);
        pbd.grabar();
    }

    public ArrayList<Insumos> cargar() throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        InsumosBD pbd = new InsumosBD();
        return pbd.cargar();
    }

    public ArrayList<Insumos> cargainsumos(int cantidad, String nomproducto) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        InsumosBD pbd = new InsumosBD();
        return pbd.cargainsumos(cantidad, nomproducto);
    }
        public ArrayList<Insumos> cargainsumos2(int id_producto) throws java.lang.ClassNotFoundException,
            java.lang.InstantiationException,
            java.lang.IllegalAccessException,
            java.sql.SQLException {
        InsumosBD pbd = new InsumosBD();
        return pbd.cargainsumosporproducto(id_producto);
    }

}
