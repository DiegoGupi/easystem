/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import java.sql.DriverManager;

/**
 *
 * @author Gupi
 */
public final class Conexion_MySQL extends Conexion{
    private final String opciones;
    private static final String JDBC = "jdbc:mysql://";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost";

    /** Creates a new instance of Conexion_MySQL usando un username y password
     * @param database Nombre de la base de datos
     * @param username Nombre del usuario de conexión
     * @param password Password de conexión
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public Conexion_MySQL(String database, String username,
                          String password) throws java.lang.ClassNotFoundException,
                                           java.lang.InstantiationException,
                                           java.lang.IllegalAccessException,
                                           java.sql.SQLException{
        super(JDBC, DRIVER, HOST, database, username, password);
        this.opciones = "charSet=UTF8";
        initdb();
    }
    
    public Conexion_MySQL() throws java.lang.ClassNotFoundException,
                                           java.lang.InstantiationException,
                                           java.lang.IllegalAccessException,
                                           java.sql.SQLException{
        this("easystem", "root", "");
    }
    
    public void initdb() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException{
        
        s_conexion = jdbc + host + "/" + database; 
        Class.forName(driver).newInstance();

        // Aqui se usan las opciones
        conexion = DriverManager.getConnection(jdbc + host + "/" + database + "?" + opciones, username, password);
        dbmd = conexion.getMetaData();
        un_st = conexion.createStatement();
    }    
}
