/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;
import java.sql.PreparedStatement;

//clase que permitira  la insercion de datos 
public class Inserdatos extends  Conexion{ //hereda de la conexion
    
    public void Inserdatos(int id, String Descripsion, int StockMinimo, int StockMaximo, int PrecioCompra, int PrecioUnitario,
            String Garantia, String Observaciones, String Estado) {
        try {
            // variables de las columnas  y tabla
            String tabla = "productos"; //nombre de la tabla
                
            String columna0 = "IdProducto"; 
            String columna1 = "Descripcion"; 
            String columna2 = "StockMinimo";
            String columna3 = "StockMaximo";
            String columna4 = "PrecioCompra";
            String columna5 = "PrecioUnitario";
            String columna6 = "Garantia";
            String columna7 = "Observaciones";
            String columna8 = "Estado";

            // Consulta SQL para la inserción de datos
            String query = "INSERT INTO " + tabla + 
                    " (" + columna0 + ", " + columna1 + ", " + columna2 + ", " + columna3 + ", " + columna4 + ", " + columna5
                    + ", " + columna6 + ", " + columna7 + ", " + columna8 + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar la declaración para la inserción
            //usando los parametros del metodo
            PreparedStatement pstmt = conectar.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, Descripsion);
            pstmt.setInt(3, StockMinimo);
            pstmt.setInt(4, StockMaximo);
            pstmt.setInt(5, PrecioCompra);
            pstmt.setInt(6, PrecioUnitario);
            pstmt.setString(7, Garantia);
            pstmt.setString(8, Observaciones);
            pstmt.setString(9, Estado);
            

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
