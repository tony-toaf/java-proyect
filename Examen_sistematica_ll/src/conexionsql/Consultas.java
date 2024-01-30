/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;

import java.sql.ResultSet;
import java.sql.Statement;

//-------clase de consultas ---------

public class Consultas extends Conexion{
    
    public void consultas(){
        Conexion conexion=new Conexion();
        Statement st;
        try {
    st = conexion.conectar.createStatement();
    
    //----variables a susar para las consultas-------
    ResultSet resultado;
    String tabla = "usuario"; //nombre de la tabla
    String columna0 = "ID"; //nombres de las columnas que se usaran
    String columna1 = "USERNAME";
    String columna2 = "PASSWORD";
    resultado = st.executeQuery("SELECT * FROM " + tabla); //consulta sql
    
    while (resultado.next()) {                
        System.out.println(resultado.getInt(columna0) + 
                " " + resultado.getString(columna1) + 
                " " + resultado.getString(columna2));
    }
    conexion.conectar.close(); //finalizando la conexino
} catch (Exception e) {
    e.printStackTrace(); 
}
    }
    
}
