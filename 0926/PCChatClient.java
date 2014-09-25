/*
 * 그림??+�???�?
 *
 * <?��??��?>
 * 1. �???�? - 콤보�??��???? ?��??? ?????? �? ?��????�?�? �???�?
 * 2. ???��?? ?��?? ???�창
 * 3. ???? ?��?? ???? ????�? ??면�?? ????
 * 4. 그림???? ?????? �???방�?? ?????? ????
 *
 * �??? ???? ?��???? - ??�? ?��???? ?��??????
 */
package newpackage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;

public class PCChatClient extends javax.swing.JFrame {

    CardLayout card;
    private Socket sk;
    private PrintWriter pw;
    private String nickName;
    private DefaultListModel dlm;
    private String ip;
    private String port;
    private String color;
    private Color cr;
    private int ptx = 0,  pty = 0;

    public PCChatClient() {
        color = "WHITE"; // 기본???? ?��??
        dlm = new DefaultListModel(); // 리�?��?�모?? ????
        initComponents();
        conClientList.setModel(dlm); // ?????? 리�?��?��?? 리�?��?�모?��?�기
    }

    // Generated Code ???? Canvas ?��??��?��?��?��? 구�??
    // ptx, pty, cr(컬�??) �??��? 그림?? 그�?��???
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNick = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        pnl2 = new javax.swing.JPanel();
        sc1 = new javax.swing.JScrollPane();
        txtMain = new javax.swing.JTextArea();
        txtField = new javax.swing.JTextField();
        sc2 = new javax.swing.JScrollPane();
        conClientList = new javax.swing.JList();
        btnSend = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        cbx = new javax.swing.JComboBox();
        txtUser = new javax.swing.JTextField();
        can = new java.awt.Canvas()
        {
            @Override
            public void paint(Graphics g) {
                if ((ptx != 0) || (pty !=0)) {
                    g.setColor(cr);
                    g.fillOval(ptx, pty, 10, 10);
                }
            }

            @Override
            public void update(Graphics g) {
                paint(g);
            }

        }
        ;
        btnRed = new javax.swing.JButton();
        btnGreen = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnCyan = new javax.swing.JButton();
        btnMagenta = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        btnBlack = new javax.swing.JButton();
        btnWhite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("�??? ????�?");
        getContentPane().setLayout(new java.awt.CardLayout());

        pnl1.setPreferredSize(new java.awt.Dimension(590, 700));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PainterChat/mainImg.JPG"))); // NOI18N

        jLabel2.setText("????�? :");

        btnEnter.setText("?? ?? �? �?");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel3.setText("IP Address :");

        jLabel4.setText("Port :");

        txtIp.setText("localhost");

        txtPort.setText("7777");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(71, 71, 71)))
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPort, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEnter, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(73, 73, 73))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pnl1, "connectCard");

        pnl2.setPreferredSize(new java.awt.Dimension(590, 700));

        txtMain.setColumns(20);
        txtMain.setRows(5);
        sc1.setViewportView(txtMain);

        txtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldKeyPressed(evt);
            }
        });

        sc2.setBorder(javax.swing.BorderFactory.createTitledBorder("????????"));
        sc2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        conClientList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        sc2.setViewportView(conClientList);

        btnSend.setText("????");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnExit.setText("??�?�?");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder("�?그�?��?"));

        can.setBackground(new java.awt.Color(255, 255, 255));

        btnRed.setBackground(new java.awt.Color(255, 0, 0));
        btnRed.setText("R");
        btnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedActionPerformed(evt);
            }
        });

        btnGreen.setBackground(new java.awt.Color(0, 204, 51));
        btnGreen.setText("G");
        btnGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGreenActionPerformed(evt);
            }
        });

        btnBlue.setBackground(new java.awt.Color(0, 0, 255));
        btnBlue.setText("B");
        btnBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueActionPerformed(evt);
            }
        });

        btnCyan.setBackground(new java.awt.Color(0, 255, 204));
        btnCyan.setText("C");
        btnCyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCyanActionPerformed(evt);
            }
        });

        btnMagenta.setBackground(new java.awt.Color(255, 51, 204));
        btnMagenta.setText("M");
        btnMagenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMagentaActionPerformed(evt);
            }
        });

        btnYellow.setBackground(new java.awt.Color(255, 255, 0));
        btnYellow.setText("Y");
        btnYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYellowActionPerformed(evt);
            }
        });

        btnBlack.setBackground(new java.awt.Color(0, 0, 0));
        btnBlack.setText("K");
        btnBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlackActionPerformed(evt);
            }
        });

        btnWhite.setBackground(new java.awt.Color(255, 255, 255));
        btnWhite.setText("W");
        btnWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(can, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sc1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnExit))
                            .addGroup(pnl2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl2Layout.createSequentialGroup()
                                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnBlack, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnMagenta, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnBlue, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnRed, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnWhite, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnYellow, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnCyan, 0, 0, Short.MAX_VALUE)
                                            .addComponent(btnGreen, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))))
                            .addGroup(pnl2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(sc2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtField, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(can, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(sc1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBlue)
                            .addComponent(btnCyan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMagenta)
                            .addComponent(btnYellow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBlack)
                            .addComponent(btnWhite))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sc2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRed)
                    .addComponent(btnGreen))
                .addContainerGap(684, Short.MAX_VALUE))
        );

        getContentPane().add(pnl2, "chatCard");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ????�? (IP, Port, ????�? ???? ????)
    // ?��?��?�? ??�? ??
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if (!txtNick.getText().equals("")) { // ????�??? �??��??�? ???�면
            nickName = txtNick.getText(); // ????�??? ???��??�?
            ip = txtIp.getText(); // ???��?��?? ???��??�?
            port = txtPort.getText(); // ?��?��?? ???��??�?

            // 카�?? ???��?? ?��?? �? ?��?? 카�??�? 보�?��???
            card = (CardLayout) getContentPane().getLayout(); // ???��?��?? ???��?????? ?��?��??
            card.show(getContentPane(), "chatCard"); // ?��?? 카�??�? 보�?��?
            setTitle("�???�?"); // ???��?? ?��??
            txtUser.setText(nickName + " ??"); // ??면�?? ?????? ?��??? 보�?��?
            exe();
        }
}//GEN-LAST:event_btnEnterActionPerformed

    // ?��?? �?????
    private void exe() {
        try {
            sk = new Socket(ip, Integer.parseInt(port)); // ip ?? port �? ??�? ????
            pw = new PrintWriter(sk.getOutputStream(), true); // �??? ?��?�림
            pw.println("enter/" + nickName + "/none/none"); // ???��???�?�? ?��?
        } catch (UnknownHostException ex) {
            System.out.println("???��?�????? ?��?��?? ???��?�?");
        } catch (IOException ex) {
            System.out.println("??�? ???? or PrintWriter ???? ??�??? ???��?�?");
        }

        /*
         * *** ?��?��?? ???? ???? ***
         * type1/type2/type3/type4
         * 
         * ????> enter/????�?/null/null
         * ?��??> exit/????�?/null/null
         * 그리�?> draw/????/x/y
         * �???�?> whiper/?��???��??/�??????��??/??�?
         * ?��?�기> talk/??�?/�??????��??/??�?
         */

        // ?�기 Thread ???? �? ?��??
        Thread t = new Thread(new Runnable() {

            public void run() {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                    String list = br.readLine(); // �????? ???? ???????? 리�?��?? ?�기
                    StringTokenizer stn = new StringTokenizer(list, "/"); // ??????�? ????
                    while (stn.hasMoreTokens()) {
                        String nm = stn.nextToken();
                        dlm.addElement(nm); // ??�??? ?????? 리�?��?��?? ????
                    }
                    // 콤보�??��?? ??�??? �?�?
                    cbx.addItem("??�?"); // �??�먼?? [??�?] �? �?�?
                    for (int i = 0; i < dlm.getSize(); i++) {
                        cbx.addItem(dlm.get(i)); // ??�??? 콤보�??��?? �?�?
                    }

                    // ?�기?? �??? �???�? ?�기 ??�?
                    while (true) {
                        String str = br.readLine();
                        stn = new StringTokenizer(str, "/");
                        String com = stn.nextToken();
                        // 첫�?�? ???��?? ?��?��?? �?�?
                        if (com.equals("enter")) { // ???��?�?
                            com = stn.nextToken(); // ?��?? ???��?? ?��?��??(????�?)
                            dlm.addElement(com); // ????리�?��?��?? �?�?
                            txtMain.append("**" + com + "** ?? ???��???��?��????" + "\n"); // ???��???�? ?????? ??면�?? 보�?��?
                            cbx.addItem(com); // 콤보�??��???? �?�?
                        } else if (com.equals("exit")) { // ?��?��?�?
                            com = stn.nextToken(); // ?��?? ???��?? ?��?��??(????�?)
                            dlm.removeElement(com); // ????리�?��?��???? ??�?
                            txtMain.append("**" + com + "** ?? ?��?��???��?��????" + "\n"); // ?��?��???�? ?????? ??면�?? 보�?��?
                            cbx.removeItem(com); // 콤보�??��???? ??�?
                        } else if (com.equals("draw")) { // ?��?��? �?�?
                            com = stn.nextToken(); // ????�?
                            ptx = Integer.parseInt(stn.nextToken()); // x�???
                            pty = Integer.parseInt(stn.nextToken()); // y�???

                            // ????�? ?��??
                            if (com.equals("RED")) {
                                cr = Color.RED;
                            } else if (com.equals("GREEN")) {
                                cr = Color.GREEN;
                            } else if (com.equals("BLUE")) {
                                cr = Color.BLUE;
                            } else if (com.equals("CYAN")) {
                                cr = Color.CYAN;
                            } else if (com.equals("MAGENTA")) {
                                cr = Color.MAGENTA;
                            } else if (com.equals("YELLOW")) {
                                cr = Color.YELLOW;
                            } else if (com.equals("BLACK")) {
                                cr = Color.BLACK;
                            } else if (com.equals("WHITE")) {
                                cr = Color.WHITE;
                            }
                            // 그림?? 그�?��???
                            can.repaint();

                        } else { // ????경�?? �???�? �?�?
                            txtMain.append(str + "\n"); // �???�?�? ?????? ??면�?? 보�?��?
                        }
                        txtMain.setCaretPosition(txtMain.getText().length());
                    }
                } catch (IOException ex) {
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException ex) {
                        }
                    }
                }
            }
        });
        t.start();

        // �?�??��?? �??��?�모??리�?��?? �?�?
        can.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                // �??��?��?? x, y �???�? ?��?
                int x = e.getX();
                int y = e.getY();
                // 그림?? ???��?? ?????��? x, y �????? 그리?��? �???�? ?��?
                pw.println("draw" + "/" + color + "/" + x + "/" + y);
            }
        });
    }

    // ???? �??? ?�릭?? - �???�?
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtField.getText().equals("")) { // ???��?? ????�? �??��??�? ???�면
            String str = txtField.getText();
            txtField.setText("");
            String type = (String) cbx.getSelectedItem(); // ???????��???? ???????? ????
            // ??체�?��? �???�??��? 구�? ?��??
            if (type.equals("??�?")) { // ??체�? ???????��???�면
                str = "talk" + "/" + "all" + "/" + nickName + "/" + str;
            } else { // ?�른 ??�??? ???????��???�면
                str = "whisper" + "/" + type + "/" + nickName + "/" + str;
            }
            pw.println(str); // �???�? ?��?
        }
}//GEN-LAST:event_btnSendActionPerformed

    // ??�?�? �??? ?�릭??
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        pw.println("exit/" + nickName + "/none/none"); // ?��?? �???�? ?��?
        System.exit(0); // ???��?? �?�?
}//GEN-LAST:event_btnExitActionPerformed

    // ???��?��? ??????�? ???? ?�벤??
    private void txtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // ???��? ???��??경�??
            // ?��?��?? �??��??�????�면 ???? �??�과 �??? ?????? ????
            if (!txtField.getText().equals("")) {
                String str = txtField.getText();
                txtField.setText("");
                String type = (String) cbx.getSelectedItem();
                if (type.equals("??�?")) {
                    str = "talk" + "/" + "all" + "/" + nickName + "/" + str;
                } else {
                    str = "whisper" + "/" + type + "/" + nickName + "/" + str;
                }
                pw.println(str);
            }
        }
    }//GEN-LAST:event_txtFieldKeyPressed

    // �??? ?? ???? ?��??
    private void btnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedActionPerformed
        color = "RED";
}//GEN-LAST:event_btnRedActionPerformed

    private void btnGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGreenActionPerformed
        color = "GREEN";
}//GEN-LAST:event_btnGreenActionPerformed

    private void btnBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueActionPerformed
        color = "BLUE";
}//GEN-LAST:event_btnBlueActionPerformed

    private void btnCyanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCyanActionPerformed
        color = "CYAN";
}//GEN-LAST:event_btnCyanActionPerformed

    private void btnMagentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagentaActionPerformed
        color = "MAGENTA";
}//GEN-LAST:event_btnMagentaActionPerformed

    private void btnYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYellowActionPerformed
        color = "YELLOW";
}//GEN-LAST:event_btnYellowActionPerformed

    private void btnBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlackActionPerformed
        color = "BLACK";
}//GEN-LAST:event_btnBlackActionPerformed

    private void btnWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhiteActionPerformed
        color = "WHITE";
}//GEN-LAST:event_btnWhiteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PCChatClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlack;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnCyan;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnMagenta;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnWhite;
    private javax.swing.JButton btnYellow;
    private java.awt.Canvas can;
    private javax.swing.JComboBox cbx;
    private javax.swing.JList conClientList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JScrollPane sc1;
    private javax.swing.JScrollPane sc2;
    private javax.swing.JTextField txtField;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextArea txtMain;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
