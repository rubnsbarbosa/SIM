package javaspace;

import java.util.ArrayList;
import net.jini.core.entry.Entry;

/**
 * Created by Rubens Santos Barbosa. 
 * Tupla Space - SIM - JavaSpaceApacheRiver
 * November 2018
 */
public class ChatRoom implements Entry {
    
    private static final long serialVersionUID = 1L;
    public String controller;
    public ArrayList<String> arrayChatroom;
    
    public ChatRoom() {
        this.controller = "controller";
    }
    
}
