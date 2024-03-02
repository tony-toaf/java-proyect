/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Login.Login;
import conexionsql.T_Clientes;
import conexionsql.T_Productos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tony
 */
public class Tabla_Clientes extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Tabla_Clientes
     */
    public Tabla_Clientes() {
        initComponents();
        String ids []= {"Id", "Nombre", "Apellido", "Sexo", "Edad", "Tipo Cliente", "F_cumple", "Membrecia"};
        modelo.setColumnIdentifiers(ids);
        tablaclientes.setModel(modelo);
    }
    
    
    public void limpiando(){
        id.setText("");
        nombre.setText("");
        apellido.setText("");
        sexo.setText("");
        edad.setText("");
        cliente.setText("");
        cumple.setText("");
        membrecia.setText("");
    }
    
    public void agregandodatos(){
        int el_id = Integer.parseInt(id.getText());
        String el_nombre = nombre.getText();
        String el_apellido = apellido.getText();
        String el_sexo = sexo.getText();
        String la_edad = edad.getText();
        String el_cliente = cliente.getText();
        String el_cumple = cumple.getText();
        String la_membrecia = membrecia.getText();
        
        modelo.addRow(new Object[] {el_id, el_nombre, el_apellido, el_sexo, la_edad, el_cliente, el_cumple, la_membrecia});
        limpiando();
        
         //insercion en la base de  datos clientes
        T_Clientes insertando = new T_Clientes();
        insertando.Insert(el_id, el_nombre, el_apellido, el_sexo, el_sexo, el_cliente, el_cumple, la_membrecia);
        
    }
    
   public void actualizar(){
       int selectrow = tablaclientes.getSelectedRow();
       if (selectrow!=-1) {
           int el_id = Integer.parseInt(id.getText());
        String el_nombre = nombre.getText();
        String el_apellido = apellido.getText();
        String el_sexo = sexo.getText();
        String la_edad = edad.getText();
        String el_cliente = cliente.getText();
        String el_cumple = cumple.getText();
        String la_membrecia = membrecia.getText();
        
        //agregando valores a la tabla
        modelo.setValueAt(el_id, tablaclientes.getSelectedRow(), 0);
        modelo.setValueAt(el_nombre, tablaclientes.getSelectedRow(),1);
        modelo.setValueAt(el_apellido, tablaclientes.getSelectedRow(), 2);
        modelo.setValueAt(el_sexo, tablaclientes.getSelectedRow(), 3);
        modelo.setValueAt(la_edad, tablaclientes.getSelectedRow(), 4);
        modelo.setValueAt(el_cliente, tablaclientes.getSelectedRow(), 5);
        modelo.setValueAt(el_cumple, tablaclientes.getSelectedRow(), 6);
        modelo.setValueAt(la_membrecia, tablaclientes.getSelectedRow(), 7);
        
        
        //actualizando valors de la base de datos
        T_Clientes actualizando = new T_Clientes();
        actualizando.Update(el_id, el_nombre, el_apellido, el_sexo, el_sexo, el_cliente, el_cumple, la_membrecia);

       }else{
           JOptionPane.showInternalMessageDialog(null, "Selecione una fila para actualizar");
           
       }
        
   }

   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        superior = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        botones_acciones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        botones_acciones2 = new javax.swing.JPanel();
        membrecia = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        sexo = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        cliente = new javax.swing.JTextField();
        cumple = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtprecio2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setBackground(new java.awt.Color(0, 255, 0));
        Titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Titulo.setText("Tabla Clientes");
        superior.add(Titulo);

        getContentPane().add(superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 11, 260, 30));

        jButton2.setText("Limpiar datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        botones_acciones.add(jButton2);

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        botones_acciones.add(Actualizar);

        jButton3.setText("Insertar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        botones_acciones.add(jButton3);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        botones_acciones.add(eliminar);

        getContentPane().add(botones_acciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 440, 50));

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 6, -1, 40));

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellido", "Sexo", "Edad", "Tipo_cliente", "F_Cumple", "Membrecia"
            }
        ));
        jScrollPane1.setViewportView(tablaclientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 115, 640, 140));

        botones_acciones2.setLayout(new javax.swing.BoxLayout(botones_acciones2, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(botones_acciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 301, 154, -1));
        getContentPane().add(membrecia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 80, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 80, -1));
        getContentPane().add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 70, -1));
        getContentPane().add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 80, -1));
        getContentPane().add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 80, -1));
        getContentPane().add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 80, -1));
        getContentPane().add(cumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 80, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-buscar-64.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));
        getContentPane().add(txtprecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 154, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiando();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       agregandodatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (id.getText() == null || id.getText().isEmpty()) {
             modelo.removeRow(tablaclientes.getSelectedRow()); //para eliminar la fila
        }else{
             try {
            modelo.removeRow(tablaclientes.getSelectedRow());
        } catch (Exception e) {}
            T_Clientes del = new T_Clientes();
            del.Delete(Integer.parseInt(id.getText())); //eliminando de la base  de datoss
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_ActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField apellido;
    private javax.swing.JPanel botones_acciones;
    private javax.swing.JPanel botones_acciones2;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField cumple;
    private javax.swing.JTextField edad;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField membrecia;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField sexo;
    private javax.swing.JPanel superior;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTextField txtprecio2;
    // End of variables declaration//GEN-END:variables
}
