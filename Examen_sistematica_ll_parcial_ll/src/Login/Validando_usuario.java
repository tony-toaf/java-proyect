/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;
import conexionsql.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vistas.*;
import Login.Login;
import java.awt.Event;


/**
 *
 * @author Usuario
 */
public class Validando_usuario extends  Conexion{
    public void Iniciandosesion(String usuario, String password){ //pasandole por parametro los datos del formulario
        Conexion conexion=new Conexion();
        Statement st;
        try {
    st = conexion.conectar.createStatement();
    
    //----variable para las -------
    ResultSet resultado;
    String tabla = "usuarios"; //nombre de la tabla
    
    //nombres de las columnas que se usaran
        String columna0 = "USUARIO"; 
        String columna1 = "PASSWORD"; 
    
        //variables donde guardar el user y pass para comprovar
        String user = "";
        String pass = "";
            
    resultado = st.executeQuery("SELECT * FROM " + tabla); //consulta sql
    while (resultado.next()) {                
        user = resultado.getString(columna0);
        pass = resultado.getString(columna1);
        
    }   
    
    if (user.equals(usuario) && pass.equals(password)) {
    //---------------verificando que los datos sean correctos-------
    
        //procediendo a cerrar la ventana de login
       Login login = new Login();
       login.dispose();
//       inciiadno la vista principal
        Principal menu  = new Principal();
        menu.setVisible(true);
        
        
 
    }else{
            JOptionPane.showInternalMessageDialog(null,"Datos incorrectos");
    }
    
    conexion.conectar.close(); //finalizando la conexino
} catch (Exception e) {
    e.printStackTrace(); 
}
    }
}
