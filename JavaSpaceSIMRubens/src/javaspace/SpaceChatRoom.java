package javaspace;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

/**
 * Created by Rubens Santos Barbosa. Tupla Space - SIM - JavaSpaceApacheRiver
 * November 2018
 */
public class SpaceChatRoom {

    public JavaSpace space;
    //public ArrayList<String> chat = new ArrayList<String>();

    public void connection() {
        try {
            System.out.println("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            this.space = (JavaSpace) finder.getService();
            if (space == null) {
                System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
            } else {
                System.out.println("O servico JavaSpace foi encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newChatRoom(String nameRoom) throws Exception {
        Room room = new Room();
        room.roomName = nameRoom;
        this.space.write(room, null, Lease.FOREVER);
        this.createTuplaController(nameRoom);
    }

    public void createTuplaController(String nameChatRoom) throws Exception {
        ChatRoom template = new ChatRoom();
        ChatRoom chatRoomController = (ChatRoom) this.space.takeIfExists(template, null, 100);
        if (chatRoomController != null) {
            ArrayList<String> chatController = chatRoomController.arrayChatroom;
            chatController.add(nameChatRoom);
            ChatRoom chat = new ChatRoom();
            chat.arrayChatroom = chatController;
            this.space.write(chat, null, Lease.FOREVER);
        }
    }

    public void removeAmbiente(String nameRoom) throws Exception {
        Room room = new Room();
        room.roomName = nameRoom;
        this.space.takeIfExists(room, null, 10 * 1000);
        this.removeTuplaController(nameRoom);
    }

    public void removeTuplaController(String nameChatRoom) throws Exception {
        ChatRoom template = new ChatRoom();
        ChatRoom chatRoomController = (ChatRoom) this.space.takeIfExists(template, null, 10 * 1000);
        if (chatRoomController != null) {
            ArrayList<String> arrayChatController = chatRoomController.arrayChatroom;
            System.out.println(arrayChatController);
            for (int i = 0; i < arrayChatController.size(); i++) {
                if (arrayChatController.get(i).equals(nameChatRoom)) {
                    arrayChatController.remove(i);
                }
            }
            ChatRoom chat = new ChatRoom();
            chat.arrayChatroom = arrayChatController;
            this.space.write(chat, null, Lease.FOREVER);
        }
    }

    public static void main(String[] args) throws Exception {

        String inputNameChatRoom = null;

        SpaceChatRoom spaceChatRoom = new SpaceChatRoom();
        spaceChatRoom.connection();

        inputNameChatRoom = JOptionPane.showInputDialog("Digite o nome da sala de bate papo:");
        if (inputNameChatRoom == null) {
            System.exit(0);
        } else {
            spaceChatRoom.newChatRoom(inputNameChatRoom);
            JOptionPane.showMessageDialog(null, "Sala " + inputNameChatRoom + " criada com sucesso!");
            System.exit(0);
        }

    }

}
