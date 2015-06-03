/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Nigga
 */
public class RegistroMovimiento {
    private int idMovimiento;
    private Insumos insumos;
    private int fechaMovimiento;
    private int cantidadMovimiento;

    public RegistroMovimiento(int idMovimiento, Insumos insumos, int fechaMovimiento, int cantidadMovimiento) {
        this.idMovimiento = idMovimiento;
        this.insumos = insumos;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    public int getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(int fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getCantidadMovimiento() {
        return cantidadMovimiento;
    }

    public void setCantidadMovimiento(int cantidadMovimiento) {
        this.cantidadMovimiento = cantidadMovimiento;
    }
    
    
}
