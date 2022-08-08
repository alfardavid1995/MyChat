/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mychat.Objects;

import java.util.ArrayList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
