/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.FlowLayout;
import Login.Login;
import  conexionsql.Conexion;
import conexionsql.T_Productos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Tabla_Productos extends javax.swing.JFrame {
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Tabla_Productos
     */
    public Tabla_Productos() {
        initComponents();
        
        String ids [] = {"ID", "Codigo", "Nombre", "Precio", "Existencia"};
        modelo.setColumnIdentifiers(ids);
        tablaproductos.setModel(modelo);
        this.setLocationRelativeTo(null); //localizacion de la ventana
        
        
    }
    public void buscar(){
        
    }
    
    public void limpiando(){
        id.setText("");
        nombre.setText("");
        codigo.setText("");
        existencia.setText("");
        precio.setText("");
    }
    
    public void agregandodatos(){
        int el_id = Integer.parseInt(id.getText());
        String el_nombre = nombre.getText();
        String el_codigo = codigo.getText();
        String la_existencia = existencia.getText();
        int el_precio = Integer.parseInt(precio.getText());
        
        //agredar datos a la tabla
        modelo.addRow(new Object[] {el_id, el_codigo, el_nombre, el_precio, la_existencia});
        limpiando();
        
        //agregar daos a la base de datos
        T_Productos insertarproducto = new T_Productos();
        insertarproducto.Insert(el_id, el_codigo, el_nombre, el_precio, la_existencia);
        
    }

   public void actualizar(){
       int selectrow = tablaproductos.getSelectedRow();
       if (selectrow!=-1) {
           int el_id = Integer.parseInt(id.getText());
        String el_codigo = codigo.getText();
        String el_nombre = nombre.getText();
        int el_precio = Integer.parseInt(precio.getText());
        String la_existencia = existencia.getText();
        
        //verificar con un condiconal que los campos no esten vacios
        
        modelo.setValueAt(el_id, tablaproductos.getSelectedRow(), 0);
        modelo.setValueAt(el_codigo, tablaproductos.getSelectedRow(),1);
        modelo.setValueAt(el_nombre, tablaproductos.getSelectedRow(), 2);
        modelo.setValueAt(el_precio, tablaproductos.getSelectedRow(), 3);
        modelo.setValueAt(la_existencia, tablaproductos.getSelectedRow(), 4);
        
        
        //iniciando acutlizacion en la base de datos
        T_Productos update = new T_Productos();
        update.Insert(el_id, el_codigo, el_nombre, el_precio, la_existencia);
  
       }else{
           JOptionPane.showInternalMessageDialog(null, "Seleccione una fila para actualizar");
       }
        
   }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        superior = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        botones_acciones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Actualizar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        buscar = new javax.swing.JLabel();
        existencia = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(402, 402, 402))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(40, 40));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setBackground(new java.awt.Color(0, 255, 0));
        Titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Titulo.setText("Tabla Productos");
        superior.add(Titulo);

        getContentPane().add(superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 260, 30));

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jButton2.setText("Limpiar Todo");
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

        Actualizar1.setText("Eliminar");
        Actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar1ActionPerformed(evt);
            }
        });
        botones_acciones.add(Actualizar1);

        getContentPane().add(botones_acciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 410, 50));

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Codigo", "Nombre", "Precio", "Existencia"
            }
        ));
        jScrollPane2.setViewportView(tablaproductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 440, 240));
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 30));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-buscar-64.png"))); // NOI18N
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        existencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existenciaActionPerformed(evt);
            }
        });
        getContentPane().add(existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 90, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, -1));
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, -1));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 80, -1));

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        limpiando(); //para limpiar donde se inserta
        modelo.setRowCount(0); //para limpiar los daos de la tabla
        
        
       
        
        
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       agregandodatos();
        
// Productos_insert insertar = new  Productos_insert(); //iterando la clase
       
       
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar1ActionPerformed
       //eiliminando
  
        if (id.getText() == null || id.getText().isEmpty()) {
             modelo.removeRow(tablaproductos.getSelectedRow()); //para eliminar la fila
        }else{
             try {
            modelo.removeRow(tablaproductos.getSelectedRow());
        } catch (Exception e) {}
            T_Productos del = new T_Productos();
            del.Delete(Integer.parseInt(id.getText())); //eliminando de la base  de datoss
        }
        
       
        
    }//GEN-LAST:event_Actualizar1ActionPerformed

    private void existenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_existenciaActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Tabla_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Actualizar1;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel botones_acciones;
    private javax.swing.JLabel buscar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField existencia;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JPanel superior;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
