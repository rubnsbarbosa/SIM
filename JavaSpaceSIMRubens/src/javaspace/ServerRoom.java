package javaspace;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

/**
 * Created by Rubens Santos Barbosa. 
 * Tupla Space - SIM - JavaSpaceApacheRiver
 * November 2018
 */
public class ServerRoom extends javax.swing.JFrame {

    private static JavaSpace space;
    public String room;
   
    public ServerRoom() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSalaBatePapo = new javax.swing.JLabel();
        createChatRoom = new javax.swing.JButton();
        deleteChatRoom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaRoom = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatRoom");

        lbSalaBatePapo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbSalaBatePapo.setText("Sala de Bate Bapo");

        createChatRoom.setText("Criar");
        createChatRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChatRoomActionPerformed(evt);
            }
        });

        deleteChatRoom.setText("Apagar");
        deleteChatRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChatRoomActionPerformed(evt);
            }
        });

        textAreaRoom.setColumns(20);
        textAreaRoom.setRows(5);
        jScrollPane2.setViewportView(textAreaRoom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lbSalaBatePapo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createChatRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteChatRoom)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSalaBatePapo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createChatRoom)
                    .addComponent(deleteChatRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChatRoomActionPerformed
        room = JOptionPane.showInputDialog("Nome da Sala: ");
        try {
            // Verificando se a sala já existe
            Room templateRoom = new Room();
            templateRoom.roomName = room;
            if (!(space.read(templateRoom, null, 500) == null)) {
                JOptionPane.showMessageDialog(null, "Esta sala já existe!");
                return;
            }
            // Criando uma nova sala
            Room template = new Room();
            template.roomName = room;
            // Escrevendo a sala no espaço de tuplas
            space.write(template, null, Lease.FOREVER);
            JOptionPane.showMessageDialog(null, "Sala criada com sucesso!");
            textAreaRoom.append(room + "\n");
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_createChatRoomActionPerformed

    private void deleteChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChatRoomActionPerformed
        room = JOptionPane.showInputDialog("Digite o nome da sala que voce quer apagar: ");
        try {
            // Verificando se a sala existe
            UserRoom templateRoom = new UserRoom();
            templateRoom.room = room;
            //Verificando se a sala já existe
            if (space.read(templateRoom, null, 500) == null) {
                JOptionPane.showMessageDialog(null, "Esta sala que voce quer apagar nao existe!");
                return;
            } else {
                // check users in chat room
                // in SIM view, users will been singout of screen to disconect the Tupla Space
                
                // JOptionPane.showMessageDialog(null, "Esta sala que voce quer apagar nao existe!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_deleteChatRoomActionPerformed

    public void usersInChatRoom() {
        ArrayList<String> usersInChatRoom = new ArrayList<String>();
        boolean noOneInChatRoom = false;
        try {
            //Enquanto houver usuários na sala, retiro e guardo-os no arrayList usuarios 
            while (noOneInChatRoom == false) {

                //Template para retirar os usuários da sala
                UserRoom templateUserRoom = new UserRoom();
               // templateUserRoom.room = roomInputed;

                UserRoom user = (UserRoom) space.take(templateUserRoom, null, 600);

                if (user == null) {
                    System.out.println("Time finished");
                    noOneInChatRoom = true;
                }

                if (noOneInChatRoom == false) {
                    usersInChatRoom.add(user.name);
                }
            }

            // array de usuarios vazio
            if (usersInChatRoom.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existe usuário nesta sala!");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
    public static void main(String args[]) {
        try {
            System.out.println("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            space = (JavaSpace) finder.getService();

            if (space == null) {
                System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
                System.exit(-1);
            }
            System.out.println("O servico JavaSpace foi encontrado.");
        } catch (Exception e) {
            System.exit(-1);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createChatRoom;
    private javax.swing.JButton deleteChatRoom;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbSalaBatePapo;
    private javax.swing.JTextArea textAreaRoom;
    // End of variables declaration//GEN-END:variables
}
