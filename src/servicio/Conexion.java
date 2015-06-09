/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Gupi
 */
public class Conexion {
    public Connection conexion = null;
    public Statement un_st = null;
    public DatabaseMetaData dbmd;
    public String s_conexion = null;
    public ResultSet resultado = null;
    public String un_sql = null;

    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;

    /** Creates a new instance of Conexion
     * @param jdbc Controlador del motor de base de datos
     * @param driver Driver de conexión
     * @param host Nombre de la máquina donde se aloja la base de datos
     * @param database Nombre de la base de datos
     * @param username Usuario de conexión
     * @param password Password para la conexión
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     **/
    public Conexion(String jdbc, String driver, String host, String database,
                    String username, String password) throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException{
        this.jdbc = jdbc; 
        this.driver = driver; 
        this.host = host; 
        this.database = database; 
        this.username = username; 
        this.password = password;        
    }

    /** 
     * @return string con el driver utilizado  */
    public String getDriver() { return this.driver; }    
}
