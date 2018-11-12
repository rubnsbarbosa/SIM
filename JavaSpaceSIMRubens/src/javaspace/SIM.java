package javaspace;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lease.Lease;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

/**
 * Created by Rubens Santos Barbosa. 
 * Tupla Space - SIM November 2018
 */
public class SIM extends javax.swing.JFrame {

    private static JavaSpace space;
    private static String username;
    private String password;
    private static String latitudeStr;
    private Double latitude;
    private static String longitudeStr;
    private Double longitude;
    private String roomInputed;
    private ArrayList<UserRoom> roomList;
    public ArrayList<UserCoordinate> usersInNeighborhood = new ArrayList<UserCoordinate>();
    public ArrayList<String> usersChat = new ArrayList<String>();

    public SIM() throws Exception {
        this.createUser();
        addWindowListener(new ExitListener());
        initComponents();
    }

    public void createUser() throws Exception {
        username = JOptionPane.showInputDialog("Username: ");
        // Template para verificar a existência do usuário
        User templateUser = new User();
        templateUser.name = username;
        // Verificando se o usuário já existe
        if (!(space.read(templateUser, null, 1000) == null)) {
            JOptionPane.showMessageDialog(null, "Este usuario já existe, insira outro!");
            username = JOptionPane.showInputDialog("Username: ");
        }

        // Criando um usuário novo e escrevendo no espaco de tuplas
        User user = new User();
        user.name = username;

        password = JOptionPane.showInputDialog("Password: ");
        user.password = password;
        space.write(user, null, Lease.FOREVER);

        // Create coordinates
        latitudeStr = JOptionPane.showInputDialog("Latitude: ");
        latitude = Double.parseDouble(latitudeStr);
        longitudeStr = JOptionPane.showInputDialog("Longitude: ");
        longitude = Double.parseDouble(longitudeStr);

        this.setCoordinateUser(username, latitude, longitude);
    }

    public void setCoordinateUser(String name, double latitude, double longitude) {
        UserCoordinate userCoordinate = new UserCoordinate();
        userCoordinate.user = name;
        userCoordinate.latitude = latitude;
        userCoordinate.longitude = longitude;
        try {
            space.write(userCoordinate, null, Lease.FOREVER);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txAreaMessage = new javax.swing.JTextArea();
        btnSendMessage = new javax.swing.JButton();
        txfSend = new javax.swing.JTextField();
        lbRadar = new javax.swing.JLabel();
        imgRadar = new javax.swing.JButton();
        openRadar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbNick = new javax.swing.JLabel();
        lbLatitude = new javax.swing.JLabel();
        lbLongitude = new javax.swing.JLabel();
        mudarCoordenadas = new javax.swing.JButton();
        lbUser = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbLat = new javax.swing.JLabel();
        lbLong = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        joinChatRoom = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaRadar = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lbUser1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        createChatRoom = new javax.swing.JButton();
        deleteChatRoom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaRoom = new javax.swing.JTextArea();
        showChatRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Interação Móvel");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txAreaMessage.setEditable(false);
        txAreaMessage.setColumns(20);
        txAreaMessage.setRows(5);
        txAreaMessage.setEnabled(false);
        jScrollPane1.setViewportView(txAreaMessage);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 0, 250, 300));

        btnSendMessage.setText("Enviar");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });
        getContentPane().add(btnSendMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 301, 70, 39));
        getContentPane().add(txfSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 300, 185, 40));

        lbRadar.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbRadar.setText("Radar Área");
        getContentPane().add(lbRadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        imgRadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/radar.png"))); // NOI18N
        imgRadar.setBorderPainted(false);
        getContentPane().add(imgRadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        openRadar.setText("Ligar Radar");
        openRadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRadarActionPerformed(evt);
            }
        });
        getContentPane().add(openRadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jPanel1.setBackground(new java.awt.Color(23, 94, 195));

        lbNick.setForeground(new java.awt.Color(255, 255, 255));
        lbNick.setText("Nick:");

        lbLatitude.setForeground(new java.awt.Color(255, 255, 255));
        lbLatitude.setText("Latitude:");

        lbLongitude.setForeground(new java.awt.Color(255, 255, 255));
        lbLongitude.setText("Longitude:");

        mudarCoordenadas.setText("Mudar Coordenadas");
        mudarCoordenadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudarCoordenadasActionPerformed(evt);
            }
        });

        lbUser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setText("Usuário");

        lbUsername.setForeground(new java.awt.Color(255, 255, 255));

        lbLat.setForeground(new java.awt.Color(255, 255, 255));

        lbLong.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/team.png"))); // NOI18N
        jButton1.setBorderPainted(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        joinChatRoom.setText("Entrar");
        joinChatRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinChatRoomActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Entrar em uma sala ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mudarCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(joinChatRoom)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbNick)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbLongitude)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbLatitude)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(lbUser))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joinChatRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNick)
                    .addComponent(lbUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLatitude)
                    .addComponent(lbLat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLongitude)
                    .addComponent(lbLong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mudarCoordenadas)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 340));

        textAreaRadar.setColumns(20);
        textAreaRadar.setRows(5);
        jScrollPane2.setViewportView(textAreaRadar);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, 210));

        jPanel2.setBackground(new java.awt.Color(23, 94, 195));

        lbUser1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbUser1.setForeground(new java.awt.Color(255, 255, 255));
        lbUser1.setText("Sala de Bate Papo");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chat.png"))); // NOI18N
        jButton2.setBorderPainted(false);

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
        jScrollPane3.setViewportView(textAreaRoom);

        showChatRoom.setText("Mostrar");
        showChatRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChatRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(createChatRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteChatRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(showChatRoom)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createChatRoom)
                    .addComponent(deleteChatRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showChatRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 170, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mudarCoordenadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mudarCoordenadasActionPerformed
        UserCoordinate template = new UserCoordinate();
        template.latitude = latitude;
        template.longitude = longitude;
        // removendo latitude e longitude do espaco de tuplas
        try {
            UserCoordinate userCoordinate = (UserCoordinate) space.take(template, null, 100);
            if (userCoordinate == null) {
                System.out.println("no one in Tupla Space");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        latitudeStr = JOptionPane.showInputDialog("Latitude: ");
        latitude = Double.parseDouble(latitudeStr);
        longitudeStr = JOptionPane.showInputDialog("Longitude: ");
        longitude = Double.parseDouble(longitudeStr);

        template.latitude = latitude;
        template.longitude = longitude;
        // escrevendo a nova latitude e longitude no espaco de tuplas
        try {
            space.write(template, null, Lease.FOREVER);
            lbLat.setText(latitudeStr);
            lbLong.setText(longitudeStr);
            JOptionPane.showMessageDialog(null, "As coordenadas de(a): " + username + " foram alteradas com sucesso!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_mudarCoordenadasActionPerformed

    private void joinChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinChatRoomActionPerformed
        roomInputed = JOptionPane.showInputDialog("Digite a sala que vc quer entrar: ");

        try {
            // Template para verificar se a sala existe
            UserRoom templateRoom = new UserRoom();
            templateRoom.roomName = roomInputed;
            // Verificando se a sala já existe
            if (space.read(templateRoom, null, 200) == null) {
                JOptionPane.showMessageDialog(null, "Esta sala que voce quer entrar nao existe!");
            } else {
                templateRoom.name = username;
                templateRoom.roomName = roomInputed;
                space.write(templateRoom, null, Lease.FOREVER);
                usersChat.add(templateRoom.name);
                JOptionPane.showMessageDialog(null, username + " entrou na sala: " + roomInputed);
            }

            //Iniciando a Thread que escuta a msg
            new Thread(new messageListener()).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_joinChatRoomActionPerformed

    private void openRadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRadarActionPerformed
        UserCoordinate templateCoordinate = new UserCoordinate();
        double distance;
        boolean goOn = true;
        try {
            while (goOn) {
                UserCoordinate userCoordinate = (UserCoordinate) space.take(templateCoordinate, null, 200);
                usersInNeighborhood.add(userCoordinate);

                if (userCoordinate == null) {
                    for (UserCoordinate co : usersInNeighborhood) {
                        if (co == null) {
                            goOn = false;
                        } else {
                            space.write(co, null, Lease.FOREVER);
                        }
                    }
                } else {
                    distance = euclideanDistance(latitude, longitude, userCoordinate.latitude, userCoordinate.longitude);
                    if (distance <= 20000 && distance >= 300) {
                        textAreaRadar.append(userCoordinate.user + "\n");
                    }
                }
            }
            textAreaRadar.append("\n\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_openRadarActionPerformed

    public double euclideanDistance(double A1, double B1, double A2, double B2) {
        return Math.sqrt(Math.pow((A2 - A1), 2) + Math.pow((B2 - B1), 2));
    }

    private void createChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChatRoomActionPerformed
        roomInputed = JOptionPane.showInputDialog("Nome da Sala: ");
        UserRoom templateRoom = new UserRoom();
        templateRoom.roomName = roomInputed;
        try {
            // Verificando se a sala já existe
            if (!(space.read(templateRoom, null, 200) == null)) {
                JOptionPane.showMessageDialog(null, "Esta sala já existe!");
                return;
            } else {
                // Escrevendo a sala no espaço de tuplas
                space.write(templateRoom, null, Lease.FOREVER);
                JOptionPane.showMessageDialog(null, "Sala criada com sucesso!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_createChatRoomActionPerformed

    private void deleteChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChatRoomActionPerformed
        if (space == null) {
            System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
            System.exit(-1);
        }

        roomInputed = JOptionPane.showInputDialog("Digite o nome da sala que voce quer apagar: ");

        try {
            UserRoom templateRoom = new UserRoom();
            templateRoom.roomName = roomInputed;

            UserRoom chatRoom = (UserRoom) space.read(templateRoom, null, 500);

            if (chatRoom != null) {
                if (chatRoom.name == null) {
                    space.take(chatRoom, null, Lease.FOREVER);
                    JOptionPane.showMessageDialog(null, "Esta sala foi apagada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Esta sala não está vazia logo não pode ser apagada!");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_deleteChatRoomActionPerformed

    private void showChatRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showChatRoomActionPerformed

        roomList = new ArrayList<>();
        boolean flag = true;
        try {
            while (flag) {

                UserRoom template = new UserRoom();
                UserRoom room = (UserRoom) space.take(template, null, 100);
                roomList.add(room);

                if (room == null) {
                    for (UserRoom rm : roomList) {
                        if (rm == null) {
                            flag = false;
                        } else {
                            space.write(rm, null, Lease.FOREVER);
                        }
                    }

                } else {
                    textAreaRoom.append(room.roomName + "\n");
                }

            }
            textAreaRoom.append("\n\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_showChatRoomActionPerformed

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed

        String message = txfSend.getText();

        // create template for send message 
        UserMessage msg = new UserMessage();
        msg.from = username;
        msg.content = message;
        msg.to = "4ALL";
        msg.room = roomInputed;
        try {
            space.write(msg, null, 10 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        txfSend.setText("");
        txfSend.requestFocus();

    }//GEN-LAST:event_btnSendMessageActionPerformed

    // cd Downloads/SoftwaresJavaSpace/river/examples/space/
    
    public class messageListener implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    //Criando template para verificar a exitência da mensagem 
                    UserMessage templateMessage = new UserMessage();
                    templateMessage.to = "4ALL";
                    templateMessage.room = roomInputed;

                    // Pegando a mensagem para ser exibida
                    UserMessage msg = (UserMessage) space.take(templateMessage, null, 300);

                    // Exibindo as mensagens
                    if (msg != null) {

                        String showMsg = msg.from + ": " + msg.content + "\n";

                        txAreaMessage.append(showMsg);

                        //Colocando a mensagem novamente no espaço
                        UserMessage newMessage = msg;
                        space.write(newMessage, null, 300000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

        public class ExitListener implements WindowListener {

            @Override
            public void windowClosing(WindowEvent e) {
                // remove user of tupla space
                if (!(JOptionPane.showConfirmDialog(null, "Deseja sair?") == JOptionPane.OK_OPTION)) {
                    return;
                } else {
                    try {
                        // Template para verificar se o usuário existe.
                        UserRoom templateUser = new UserRoom();
                        templateUser.name = username;
                        templateUser.roomName = roomInputed;

                        UserRoom user = (UserRoom) space.read(templateUser, null, 200);

                        // Se o usuário existir, ou seja, se for diferente de null
                        if (user != null) {
                            UserRoom userRoom = (UserRoom) space.take(templateUser, null, 200);
                            if (userRoom.name == null) {
                                System.out.println("Usuario removido!");
                            }
                        }

                    } catch (UnusableEntryException ex) {
                        Logger.getLogger(SIM.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransactionException ex) {
                        Logger.getLogger(SIM.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SIM.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex) {
                        Logger.getLogger(SIM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }

            }

            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }

        }

        public static void main(String args[]) throws Exception {
            try {
                System.out.println("Procurando pelo servico JavaSpace...");
                Lookup finder = new Lookup(JavaSpace.class
                );
                space = (JavaSpace) finder.getService();

                if (space == null) {
                    System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
                    System.exit(-1);
                }
                System.out.println("O servico JavaSpace foi encontrado.");
            } catch (Exception e) {
                System.exit(-1);
            }

            SIM sim = new SIM();
            sim.setVisible(true);
            lbUsername.setText(username);
            lbLat.setText(latitudeStr);
            lbLong.setText(longitudeStr);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JButton createChatRoom;
    private javax.swing.JButton deleteChatRoom;
    private javax.swing.JButton imgRadar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton joinChatRoom;
    private static javax.swing.JLabel lbLat;
    private javax.swing.JLabel lbLatitude;
    private static javax.swing.JLabel lbLong;
    private javax.swing.JLabel lbLongitude;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbRadar;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbUser1;
    private static javax.swing.JLabel lbUsername;
    private javax.swing.JButton mudarCoordenadas;
    private javax.swing.JButton openRadar;
    private javax.swing.JButton showChatRoom;
    private javax.swing.JTextArea textAreaRadar;
    private javax.swing.JTextArea textAreaRoom;
    private javax.swing.JTextArea txAreaMessage;
    private javax.swing.JTextField txfSend;
    // End of variables declaration//GEN-END:variables
}
