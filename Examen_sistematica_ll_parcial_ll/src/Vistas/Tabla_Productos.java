/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.FlowLayout;
import Login.Login;
import  conexionsql.Conexion;
import conexionsql.T_Productos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Tabla_Productos extends javax.swing.JFrame {
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    Connection conn = null;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form Tabla_Productos
     */
    public Tabla_Productos() {
        initComponents();
        
        String ids [] = {"ID", "Codigo", "Nombre", "Precio", "Existencia"};
        modelo.setColumnIdentifiers(ids);
        tablaproductos.setModel(modelo);
        this.setLocationRelativeTo(null); //localizacion de la ventana
        getConnection();
        
        
    }
    
     public Connection getConnection(){
        try {
            Class.forName("java.sql.DriverManager");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos?useSSL=false","root","");
            if(conn !=null){
               System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null,"Ocurrior un error al conectarse a la BD");
            System.err.println("Error:.." + e.getMessage());
        }
          return conn;
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
        existencia = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        cmbx_filtro = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        getContentPane().add(botones_acciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 410, 50));

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

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 130, 30));

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

        cmbx_filtro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbx_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Codigo", "Nombre", "Precio", "Existencia" }));
        cmbx_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_filtroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbx_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 30));

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, 30));

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

    private void cmbx_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbx_filtroActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed
    
    String filtro(){
    if(cmbx_filtro.getSelectedIndex()==0){
    return "Id";
    }else if(cmbx_filtro.getSelectedIndex()==1){
        return "Codigo";
    }else if(cmbx_filtro.getSelectedIndex()==2){
    return "Nombre";
    }
    else if(cmbx_filtro.getSelectedIndex()==3){
    return "Precio";
    }else {
     return "Existencia";
    }
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtbuscar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de ingresar el dato a buscar");
        
        }else{
            //Declaramos un DefaultTableModelpara enviar el nuevo modelo a la Tabla
        DefaultTableModel modelo= (DefaultTableModel) tablaproductos.getModel();
        //Le decimos que comience en 0
        modelo.setRowCount(0);
        //Declaramos un arreglo para almacenar los datos
        String[] datos= new String[4];
        
        //Obenter el dato a bsucar
        String dato= txtbuscar.getText().trim();
        
        int cont=0;
            try {
                pst= conn.prepareStatement("select * from productos where " + filtro() + " like '%" + dato + "%'");
                rs=pst.executeQuery();
                
                while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                //Enviamos el vector al modelo o tabla
                modelo.addRow(datos);
                //Incementa cada vez que encuentra un valor
                cont++;
                if(cont>0){
                tablaproductos.setModel(modelo);
                }else{
                JOptionPane.showMessageDialog(null, "No se encontro resultados en la busqueda");
                
                }
                }
            }catch ( SQLException e) {
                 JOptionPane.showMessageDialog(null,"Ocurrio un error al hacer la busqueda de los datos del usuario");
                 System.err.println("Error" + e.getMessage());
             }finally{
                 try {
                     pst.close();
                 } catch (Exception e) {
                     System.err.println("Error" + e.getMessage());
                 }
            }
             }
    }//GEN-LAST:event_jButton1ActionPerformed

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

        /* Create int selectedIndex = cmbx_filtro.getSelectedIndex();
    String filtroSeleccionado = filtro(selectedIndex);

    if (txtbuscar.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar el dato a buscar");
    } else {
        T_Productos buscando = new T_Productos();
        buscando.buscar(filtroSeleccionado);
    } and display the form */
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
    private javax.swing.JComboBox<String> cmbx_filtro;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField existencia;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
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
