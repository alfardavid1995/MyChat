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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author css124646
 */
public class Administrador extends Persona {
    
    final String SELECT_TODOS_LOS_USUARIOS="Select * from mostrarUsuarios";
    ArrayList listaUsuarios=new ArrayList<>();
    ArrayList<Administrador> listaAmigos = new ArrayList<Administrador>();
    ArrayList<Chat> listaChat = new ArrayList<Chat>(); 
    Direcciónred direcciónred =new Direcciónred();
    private String ip ;
    private String tipored; 
    private String tipoRol;//este espara imprimir en la tabla
    private int rol;//esta para añadir registro
    public  DefaultTableModel modelo=new DefaultTableModel();
    
    public Administrador() {
    }
    

    public ArrayList<Administrador> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(ArrayList<Administrador> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public ArrayList<Chat> getListaChat() {
        return listaChat;
    }

    public void setListaChat(ArrayList<Chat> listaChat) {
        this.listaChat = listaChat;
    }

    public String getTipored() {
        return tipored;
    }

    public void setTipored(String tipored) {
        this.tipored = tipored;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    

    
    @Override
    public void eliminarDatos() {
       
            try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement("Delete from usuarios where nombreusuarios=?");
            consulta.setString(1, JOptionPane.showInputDialog("Digite el nombre"));
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado usuario");
            
                
            
            
        }catch (SQLException ex){
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, ex);
        }
        
          
        
            
        }
    

    @Override
    public void crearDatos() {
           try{
//            DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
//            this.nombrePersona=JOptionPane.showInputDialog("Digite el nombre");
//            this.apellido1=JOptionPane.showInputDialog("Digite el primer apellido");
//            this.apellido2=JOptionPane.showInputDialog("Digite el segundo apellido");
//            this.fechaNacimiento=Date.valueOf(JOptionPane.showInputDialog("Digite la fecha de nacimiento del estudiante"));
//            this.email=JOptionPane.showInputDialog("Digite el email");
            int ipsiguien=contarIdSiguiente();
            JOptionPane.showMessageDialog(null, ipsiguien);
            PreparedStatement ps=Conexion.getConexion().prepareStatement("INSERT INTO usuarios(nombreusuarios,primerApellido,SegundoApellido,Email,FechaNacimiento,ipv4)VALUES (?,?,?,?,?,?)");
            PreparedStatement consutaRoles=Conexion.getConexion().prepareStatement("INSERT INTO rol_usuario values(?,?)");
            ps.setString(1, nombrePersona);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, email);
            ps.setDate(5, fechaNacimiento);
            ps.setString(6, ip);
            consutaRoles.setInt(1,ipsiguien);
            consutaRoles.setInt(2, rol);
            ps.execute();
            consutaRoles.execute();
            JOptionPane.showMessageDialog(null,"Se ha guardado el usuario");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, exception);
        }
    }
    public int contarIdSiguiente()
    {int siguienteid;
        try {
            
        
        PreparedStatement consulta =Conexion.getConexion().prepareStatement("Select c.idusuario from usuarios as c");
        ResultSet rs= consulta.executeQuery();
          
       
        while(rs!=null&&rs.next())
            {
                
                this.id=rs.getInt(1);   
               
            }
        } catch (SQLException e) {
             Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);
        } 
        return  siguienteid=id+1;
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
          
       
            ps.executeUpdate();
            System.out.println("Guardado");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, exception);
        }   
    }

    @Override
    public void actualizarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void  mostrarDatos()
    {try {
            
        
        PreparedStatement consulta =Conexion.getConexion().prepareStatement(SELECT_TODOS_LOS_USUARIOS);
        ResultSet rs= consulta.executeQuery();
          
                
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("Primer apellido");
                modelo.addColumn("Segundo Apellido");
                modelo.addColumn("Email");
                modelo.addColumn("Fecha Nacimiento");
                modelo.addColumn("Direccion ip");
                modelo.addColumn("Roles");    
        while(rs!=null&&rs.next())
            {
                this.id=rs.getInt(1);
                this.nombrePersona=rs.getString(2);
                this.apellido1=rs.getString(3);
                this.apellido2=rs.getString(4);
                this.email=rs.getString(5);
                this.fechaNacimiento=rs.getDate(6);
                this.direcciónred.setIpv4(rs.getString(7));
                this.tipoRol=rs.getString(8);
                listaUsuarios.add(0,id);
                listaUsuarios.add(1,nombrePersona);
                listaUsuarios.add(2,apellido1);
                listaUsuarios.add(3,apellido2);
                listaUsuarios.add(4,email);
                listaUsuarios.add(5,fechaNacimiento);
                listaUsuarios.add(6,direcciónred.getIpv4());
                listaUsuarios.add(7,tipoRol);
                modelo.addRow(listaUsuarios.toArray());
                
            }
        } catch (SQLException e) {
             Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);
        }        // TODO add your handling code here:
    }
 
    
}
