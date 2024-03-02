/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsql;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class T_Clientes  extends Conexion{
    public void Update(int id, String Nombre, String Apellido, String Sexo, String EdadString, String Tipocliente, String FechaCumple, String Membrecia) {
    try {
        
        String tabla = "clientes"; 
        String columna0 = "Id";
        String columna2 = "Nombre";
        String columna3 = "Apellido";
        String columna4 = "Sexo";
        String columna5 = "Edad";
        String columna6 = "TipoCliente";
        String columna7 = "FechaCumple";
        String columna8 = "Membrecia";

        String query = "UPDATE " + tabla + " SET " + 
                columna2 + " = ?, " +
                columna3 + " = ?, " +
                columna4 + " = ?, " +
                columna5 + " = ?, " +
                columna6 + " = ?, " +
                columna7 + " = ?, " +
                columna8 + " = ? " +
                "WHERE " + columna0 + " = ?";

        PreparedStatement pstmt = conectar.prepareStatement(query);
        pstmt.setString(1, Nombre);
        pstmt.setString(2, Apellido);
        pstmt.setString(3, Sexo);
        pstmt.setString(4, EdadString);
        pstmt.setString(5, Tipocliente);
        pstmt.setString(6, FechaCumple);
        pstmt.setString(7, Membrecia);
        pstmt.setInt(8, id);
        
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showInternalMessageDialog(null, "Se actualizó correctamente el valor con ID: " + id);
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se encontró el dato con ID: " + id);
        }

        // Cerrar la conexión
        conectar.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

  
   public void Insert(int id, String Nombre, String Apellido, String Sexo, String EdadString, String Tipocliente, String FechaCumple, String Membrecia) {
    try {
        // nombres de las columnas  y tabla
        String tabla = "clientes"; //nombre de la tabla

        String columna0 = "Id";
        String columna2 = "Nombre";
        String columna3 = "Apellido";
        String columna4 = "Sexo";
        String columna5 = "Edad";
        String columna6 = "TipoCliente";
        String columna7 = "FechaCumple";
        String columna8 = "Membrecia";

        String query = "INSERT INTO " + tabla +
                " (" + columna0 + ", " + columna2 + ", " + columna3 + ", " + columna4 + ", " + columna5 + ", " +
                columna6 + ", " + columna7 + ", " + columna8 + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conectar.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.setString(2, Nombre);
        pstmt.setString(3, Apellido);
        pstmt.setString(4, Sexo);
        pstmt.setString(5, EdadString);
        pstmt.setString(6, Tipocliente);
        pstmt.setString(7, FechaCumple);
        pstmt.setString(8, Membrecia);

        pstmt.executeUpdate();

        conectar.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void Delete(int id){ //metodo delete por id unico
        try {
            String tabla = "clientes"; //nombre de la tabla
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
  
}
