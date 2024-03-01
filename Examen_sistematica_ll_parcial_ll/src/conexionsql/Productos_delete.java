/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//clase que se usara para eliminar los datos 
package conexionsql;
import java.sql.PreparedStatement;

public class Productos_delete  extends Conexion{
    
    public void eliminarDatosPorID(int id) {
        try {
            String tabla = "productos"; //nombre de la tabla
            String columna0 = "Id";

            // Consulta sql
            String query = "DELETE FROM " + tabla + 
                " WHERE " + columna0 + " = ?";

            PreparedStatement pstmt = conectar.prepareStatement(query);
            pstmt.setInt(1, id);

            // elmnando el dato
            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Se elimino correctamente: " + id);
            } else {
                System.out.println("No se encontro el dato: " + id);
            }

            // Cerrar la conexión
            conectar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

