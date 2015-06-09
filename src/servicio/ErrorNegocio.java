/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author Gupi
 */
public class ErrorNegocio extends Exception {

    private String mensaje;

    public ErrorNegocio(String mensaje) {
        super(mensaje);
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
