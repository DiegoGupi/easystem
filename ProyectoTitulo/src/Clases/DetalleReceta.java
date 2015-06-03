/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class DetalleReceta {
    private int detalleReceta;
    private Insumos insumos;
    private Receta receta;
    private int cantidadDetalleReceta;

    public DetalleReceta(int detalleReceta, Insumos insumos, Receta receta, int cantidadDetalleReceta) {
        this.detalleReceta = detalleReceta;
        this.insumos = insumos;
        this.receta = receta;
        this.cantidadDetalleReceta = cantidadDetalleReceta;
    }





    public int getDetalleReceta() {
        return detalleReceta;
    }

    public void setDetalleReceta(int detalleReceta) {
        this.detalleReceta = detalleReceta;
    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public int getCantidadDetalleReceta() {
        return cantidadDetalleReceta;
    }

    public void setCantidadDetalleReceta(int cantidadDetalleReceta) {
        this.cantidadDetalleReceta = cantidadDetalleReceta;
    }

    @Override
    public String toString() {
        return "DetalleReceta{" + "detalleReceta=" + detalleReceta + ", idInsumo=" + insumos + ", idReceta=" + receta + ", cantidadDetalleReceta=" + cantidadDetalleReceta + '}';
    }
    
    
    
}
