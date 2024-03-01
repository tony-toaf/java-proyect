/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;
import java.sql.PreparedStatement;

//clase que permitira  la insercion de datos 
public class Productos_insert extends  Conexion{ //hereda de la conexion
    
    public void Inserdatos(int id, String Codigo, String Nombre,int Precio, String exitencia) {
        try {
            // variables de las columnas  y tabla
            String tabla = "productos"; //nombre de la tabla
                
            String columna0 = "Id"; 
            String columna1 = "Codigo"; 
            String columna2 = "Nombre";
            String columna3 = "Precio";
            String columna4 = "Existencia";
          

            // Consulta SQL para la inserción de datos
            String query = "INSERT INTO " + tabla + 
                    " (" + columna0 + ", " + columna1 + ", " + columna2 + ", " + columna3 + ", " + columna4 + ") VALUES (?, ?, ?, ?, ?)";

            // Preparar la declaración para la inserción
            //usando los parametros del metodo
            PreparedStatement pstmt = conectar.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, Codigo);
            pstmt.setString(3, Nombre);
            pstmt.setInt(4, Precio);
            pstmt.setString(5, exitencia);
          
            

            // Ejecutar la inserción
            pstmt.executeUpdate();
            System.out.println("Se insertaron correctamene los datos");

            // Cerrar la conexión
            conectar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
