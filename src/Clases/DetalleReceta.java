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

    private int id_detalleReceta;
    private Insumos insumos;
    private Receta receta;
    private String DetalleReceta;

    public DetalleReceta(int id_detalleReceta, Insumos insumos, Receta receta, String DetalleReceta) {
        this.id_detalleReceta = id_detalleReceta;
        this.insumos = insumos;
        this.receta = receta;
        this.DetalleReceta = DetalleReceta;
    }

    public DetalleReceta() {
        
    }

    public int getDetalleReceta() {
        return id_detalleReceta;
    }

    public void setDetalleReceta(int id_detalleReceta) {
        this.id_detalleReceta = id_detalleReceta;
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

    public String getCantidadDetalleReceta() {
        return DetalleReceta;
    }

    public void setCantidadDetalleReceta(String DetalleReceta) {
        this.DetalleReceta = DetalleReceta;
    }

    @Override
    public String toString() {
        return "DetalleReceta{" + "id_detalleReceta=" + id_detalleReceta + ", idInsumo=" + insumos + ", idReceta=" + receta + ", cantidadDetalleReceta=" + DetalleReceta + '}';
    }

}
