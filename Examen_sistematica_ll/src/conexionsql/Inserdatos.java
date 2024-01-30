/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;
import java.sql.PreparedStatement;

//clase que permitira  la insercion de datos 
public class Inserdatos extends  Conexion{ //hereda de la conexion
    
    public void Inserdatos(int id, String username, String password) {
        try {
            // variables de las columnas  y tabla
            String tabla = "usuario"; //nombre de la tabla
            String columna0 = "ID"; 
            String columna1 = "USERNAME";
            String columna2 = "PASSWORD";

            // Consulta SQL para la inserción de datos
            String query = "INSERT INTO " + tabla + 
                    " (" + columna0 + ", " + columna1 + ", " + columna2 
                    + ") VALUES (?, ?, ?)";

            // Preparar la declaración para la inserción
            PreparedStatement pstmt = conectar.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            pstmt.setString(3, password);

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
