/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mychat.Objects;

import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.Date;//Se utiliza el Date Sql para que la consulta funcione correctamente

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author css124646
 */
public class Usuario extends Persona {
    ArrayList<Usuario> listaAmigos = new ArrayList<Usuario>();
    ArrayList<Chat> listaChat = new ArrayList<Chat>(); 

    public Usuario() {
    }

    public ArrayList<Usuario> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(ArrayList<Usuario> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public ArrayList<Chat> getListaChat() {
        return listaChat;
    }

    public void setListaChat(ArrayList<Chat> listaChat) {
        this.listaChat = listaChat;
    }

    @Override
    public void eliminarDatos() {
       
            try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement("Delete from usuarios where nombreusuarios=?");
            consulta.setString(1, JOptionPane.showInputDialog("Digite el nombre"));
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado usuario");
            
                
            
            
        }catch (SQLException ex){
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null, ex);
        }
        
          
        
            
        }
    

    @Override
    public void crearDatos() {
           try{
            DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
            this.nombrePersona=JOptionPane.showInputDialog("Digite el nombre");
            this.apellido1=JOptionPane.showInputDialog("Digite el primer apellido");
            this.apellido2=JOptionPane.showInputDialog("Digite el segundo apellido");
            this.fechaNacimiento=Date.valueOf(JOptionPane.showInputDialog("Digite la fecha de nacimiento del estudiante"));
            this.email=JOptionPane.showInputDialog("Digite el email");
          
            PreparedStatement ps=Conexion.getConexion().prepareStatement("INSERT INTO usuarios(nombreusuarios,primerApellido,SegundoApellido,Email,FechaNacimiento,ipv4,idrole)VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, nombrePersona);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, email);
            ps.setDate(5, fechaNacimiento);
            ps.setString(6, "192.168.0.2");
            ps.setInt(7, 1);
            ps.execute();
            System.out.println("Guardado");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null, exception);
        }
    }

    @Override
    public void modificarDatos() {
      try{
            DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
            this.nombrePersona=JOptionPane.showInputDialog("Digite el nombre");
            this.apellido1=JOptionPane.showInputDialog("Digite el primer apellido");
            this.apellido2=JOptionPane.showInputDialog("Digite el segundo apellido");
            this.fechaNacimiento=Date.valueOf(JOptionPane.showInputDialog("Digite la fecha de nacimiento del estudiante"));
            this.email=JOptionPane.showInputDialog("Digite el email");
          
            PreparedStatement ps=Conexion.getConexion().prepareStatement("update usuarios set nombreusuarios=?,"
                    + "primerApellido=? ,SegundoApellido=? , Email=?,FechaNacimiento=? where idusuario=2" );
            ps.setString(1, nombrePersona);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, email);
            ps.setDate(5, fechaNacimiento);
          ;
            ps.executeUpdate();
            System.out.println("Guardado");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null, exception);
        }   
    }

    @Override
    public void actualizarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
