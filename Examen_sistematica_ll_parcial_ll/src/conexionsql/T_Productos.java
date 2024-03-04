/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class T_Productos extends  Conexion{
  
    //fin del metodo 
    
   public void Update(int id, String nuevoCodigo, String nuevoNombre, int nuevoPrecio, String nuevaExistencia) {
    try {
        // Nombre de la tabla y columnas
        String tabla = "productos";
        String columna0 = "Id"; 
        String columna1 = "Codigo"; 
        String columna2 = "Nombre";
        String columna3 = "Precio";
        String columna4 = "Existencia";

        // Consulta SQL para la actualización de datos
        String query = "UPDATE " + tabla + " SET " + 
                columna1 + " = ?, " +
                columna2 + " = ?, " +
                columna3 + " = ?, " +
                columna4 + " = ? " +
                "WHERE " + columna0 + " = ?";

        // Preparar la declaración para la actualización
        PreparedStatement pstmt = conectar.prepareStatement(query);
        pstmt.setString(1, nuevoCodigo);
        pstmt.setString(2, nuevoNombre);
        pstmt.setInt(3, nuevoPrecio);
        pstmt.setString(4, nuevaExistencia);
        pstmt.setInt(5, id);
        
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showInternalMessageDialog(null, "Se actualizó correctamente el valor con ID: " + id);
            // System.out.println("Se actualizó correctamente: " + id);
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se encontró el dato con ID: " + id);
            // System.out.println("No se encontró el dato: " + id);
        }

        // Cerrar la conexión
        conectar.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
    public void Delete(int id){ //metodo delete por id unico
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
                JOptionPane.showInternalMessageDialog(null, "Se elimino correctamente valor con id: " + id);
                //System.out.println("Se elimino correctamente: " + id);
            } else {
                JOptionPane.showInternalMessageDialog(null, "No se encontro el dato con el valor: " + id);
                //System.out.println("No se encontro el dato: " + id);
            }

            // Cerrar la conexión
            conectar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
   
    }
    
     public void Insert(int id, String Codigo, String Nombre,int Precio, String exitencia) {
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

            // Cerrar la conexión
            conectar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
