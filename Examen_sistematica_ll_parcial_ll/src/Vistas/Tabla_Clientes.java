/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Login.Login;
import conexionsql.T_Clientes;
import conexionsql.T_Productos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tony
 */
public class Tabla_Clientes extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    Connection conn = null;
    PreparedStatement pst;
    ResultSet rs;
    
    /**
     * Creates new form Tabla_Clientes
     */
    public Tabla_Clientes() {
        initComponents();
        String ids []= {"Id", "Nombre", "Apellido", "Sexo", "Edad", "Tipo Cliente", "F_cumple", "Membrecia"};
        modelo.setColumnIdentifiers(ids);
        tablaclientes.setModel(modelo);
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
        txtbucar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cmbx_filtro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        getContentPane().add(botones_acciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 440, 50));

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
        getContentPane().add(txtbucar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 154, -1));

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 80, -1));

        cmbx_filtro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbx_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nombre", "Apellido", "Sexo", "Edad", "TipoCliente", "FechaCumple", "Membrecia" }));
        cmbx_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_filtroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbx_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

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
    
     String filtro(){
    if(cmbx_filtro.getSelectedIndex()==0){
    return "Id";
    }else if(cmbx_filtro.getSelectedIndex()==1){
        return "Nombre";
    }else if(cmbx_filtro.getSelectedIndex()==2){
    return "Apellido";
    }else if(cmbx_filtro.getSelectedIndex()==3){
    return "Sexo";
    }else if(cmbx_filtro.getSelectedIndex()==4){
    return "Edad";
    }else if(cmbx_filtro.getSelectedIndex()==5){
    return "TipoCliente";
    }else if(cmbx_filtro.getSelectedIndex()==6){
    return "FechaCumple";
    }else {
     return "Membrecia";
    }
        
    }
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtbucar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de ingresar el dato a buscar");

        }else{
            //Declaramos un DefaultTableModelpara enviar el nuevo modelo a la Tabla
            DefaultTableModel modelo= (DefaultTableModel) tablaclientes.getModel();
            //Le decimos que comience en 0
            modelo.setRowCount(0);
            //Declaramos un arreglo para almacenar los datos
            String[] datos= new String[7];

            //Obenter el dato a bsucar
            String dato= txtbucar.getText().trim();

            int cont=0;
            try {
                pst= conn.prepareStatement("select * from clientes where " + filtro() + " like '%" + dato + "%'");
                rs=pst.executeQuery();

                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[4]=rs.getString(4);
                    datos[5]=rs.getString(5);
                    datos[6]=rs.getString(6);
                    datos[7]=rs.getString(7);
                    //Enviamos el vector al modelo o tabla
                    modelo.addRow(datos);
                    //Incementa cada vez que encuentra un valor
                    cont++;
                    if(cont>0){
                        tablaclientes.setModel(modelo);
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

    private void cmbx_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbx_filtroActionPerformed

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
    private javax.swing.JComboBox<String> cmbx_filtro;
    private javax.swing.JTextField cumple;
    private javax.swing.JTextField edad;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField membrecia;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField sexo;
    private javax.swing.JPanel superior;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTextField txtbucar;
    // End of variables declaration//GEN-END:variables
}
