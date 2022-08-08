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
public class Chat {
    private String Nombrechat;
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
    
    boolean tipoChat; //tipo de chat si es unicast o grupo
    boolean alertachat; //notificacion pendiente sin leer
}
