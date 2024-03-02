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
public class T_Ventas extends Conexion{
    public void buscar(){
        //pendiente de programar
    }
    
    public void Delete(int id){ //metodo delete por id unico
        try {
            String tabla = "ventas"; //nombre de la tabla
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
        }}
    
    
    public void Insert(int el_id, int el_cliente, int el_empleado, String el_producto, int el_precio, int la_cantidad) {
    try {
        // variables de las columnas  y tabla
        String tabla = "ventas"; //nombre de la tabla    
        String columna0 = "Id"; 
        String columna1 = "IdCliente"; 
        String columna2 = "IdEmpleado";
        String columna3 = "NOmbreProducto";
        String columna4 = "Precio";
        String columna5 = "Cantidad";

        
        String query = "INSERT INTO " + tabla + 
                " (" + columna0 + ", " + columna1 + ", " + columna2 + ", " + columna3 + ", " + columna4 + ", " + columna5 + ") VALUES (?, ?, ?, ?, ?, ?)";


        PreparedStatement pstmt = conectar.prepareStatement(query);
        pstmt.setInt(1, el_id);
        pstmt.setInt(2, el_cliente);
        pstmt.setInt(3, el_empleado);
        pstmt.setString(4, el_producto);
        pstmt.setInt(5, el_precio);
        pstmt.setInt(6, la_cantidad);

        //insertando
        pstmt.executeUpdate();

        // Cerrar la conexión
        conectar.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    

   public void Update(int el_id, int el_cliente, int el_empleado, String el_producto, int el_precio, int la_cantidad) {
    try {
        // Nombre de la tabla y columnas
        String tabla = "ventas";
        String columna0 = "Id"; 
        String columna1 = "IdCliente"; 
        String columna2 = "IdEmpleado";
        String columna3 = "NOmbreProducto";
        String columna4 = "Precio";
        String columna5 = "Cantidad";

        // Consulta SQL para la actualización de datos
        String query = "UPDATE " + tabla + " SET " + 
                columna1 + " = ?, " +
                columna2 + " = ?, " +
                columna3 + " = ?, " +
                columna4 + " = ?, " +
                columna5 + " = ? " +
                "WHERE " + columna0 + " = ?";

        // Preparar la declaración para la actualización
        PreparedStatement pstmt = conectar.prepareStatement(query);
        pstmt.setInt(1, el_cliente);
        pstmt.setInt(2, el_empleado);
        pstmt.setString(3, el_producto);
        pstmt.setInt(4, el_precio);
        pstmt.setInt(5, la_cantidad);
        pstmt.setInt(6, el_id);
        
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showInternalMessageDialog(null, "Se actualizó correctamente el valor con ID: " + el_id);
        } else {
            JOptionPane.showInternalMessageDialog(null, "No se encontró el dato con ID: " + el_id);
        }

        // Cerrar la conexión
        conectar.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
