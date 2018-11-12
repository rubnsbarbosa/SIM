package javaspace;

import net.jini.core.entry.Entry;

/**
 * Created by Rubens Santos Barbosa. 
 * Tupla Space - SIM November 2018
 */
public class UserMessage implements Entry {
    
    public String room;
    public String from;
    public String content;
    public String to;

    public UserMessage() {

    }

}
