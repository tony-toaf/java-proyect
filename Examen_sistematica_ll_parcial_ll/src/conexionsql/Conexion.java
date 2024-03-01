/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;
//---------clase conectar principal -----------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion{
    public Connection conectar; //variable que inicia la conexion
    
    public Conexion(){
        String url_de_la_base = "jdbc:mysql://localhost:3306/"; //ruta de done se encuetra sql con el puerto
        String basededatos = "productos"; //nombre de la base de datos
        String usuario = "root"; //usuario para ingresar a sql
        String Password = "";  //contrasegna para ingresar a sql
        
        //-----------iniciando la conexionn---------
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar=DriverManager.getConnection(url_de_la_base +  basededatos,usuario,Password);
            
            System.out.println("LA CONEXION FUE EXITOSA");
            
        } catch (Exception e) {
            System.err.println("ERROR:" + e); //PARA OBTENER EL ERROR 
        }
    }
}
