/*
 * MyError.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servicio;


/**
 *
 * Se crea una clase MyError (en realidad una excepcion) especifica, que hereda de
 * Exception, para poder detectar y configurar nuestros propios errores y
 * para hacerlos "flotar" a las clases a nivel de GUI, si es que estas
 * exepciones ocurren a un nivel mas bajo.
 * @author Jose concha
 */
public class MyError extends Exception{

    private int codigo;
    private String mensaje;

    /** 
     * Crea una instancia de la clase MyError
     * @param codigo Representa el código del error
     * @param mensaje Descripción del error
     */
    public MyError(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo(){ return codigo; }

    public String getMensaje() { return mensaje; }
}

