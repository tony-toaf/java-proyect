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
    String tabla = "productos"; //nombre de la tabla
    
    //nombres de las columnas que se usaran
        String columna0 = "IdProducto"; 
        String columna1 = "Descripcion"; 
        String columna2 = "StockMinimo";
        String columna3 = "StockMaximo";
        String columna4 = "PrecioCompra";
        String columna5 = "PrecioUnitario";
        String columna6 = "Garantia";
        String columna7 = "Observaciones";
        String columna8 = "Estado";
            
    resultado = st.executeQuery("SELECT * FROM " + tabla); //consulta sql
    
    while (resultado.next()) {                
        System.out.println(resultado.getInt(columna0) + 
                " " + resultado.getString(columna1) + 
                " " + resultado.getString(columna2)+ 
                " " + resultado.getString(columna3)+ 
                " " + resultado.getString(columna4)+ 
                " " + resultado.getString(columna5)+ 
                " " + resultado.getString(columna6)+ 
                " " + resultado.getString(columna7)+ 
                " " + resultado.getString(columna8)
        
        );
    }
    conexion.conectar.close(); //finalizando la conexino
} catch (Exception e) {
    e.printStackTrace(); 
}
    }
    
}
