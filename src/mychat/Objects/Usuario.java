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
}
