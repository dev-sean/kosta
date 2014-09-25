/*
 * ê·¸ë¦¼??+ì±???ë°?
 *
 * <?¹ì??¤ë?>
 * 1. ê·???ë§? - ì½¤ë³´ë°??¤ì???? ?´ë??? ?????? ê·? ?¬ë????ê²?ë§? ë§???ê¸?
 * 2. ???´í?? ?¬í?? ???¥ì°½
 * 3. ???? ?¬ì?? ???? ????ëª? ??ë©´ì?? ????
 * 4. ê·¸ë¦¼???? ?????? ì±???ë°©ì?? ?????? ????
 *
 * ê°??? ???? ?´ë???? - ??ë²? ?¤í???? ?¤í??????
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
        color = "WHITE"; // ê¸°ë³¸???? ?°ì??
        dlm = new DefaultListModel(); // ë¦¬ì?¤í?¸ëª¨?? ????
        initComponents();
        conClientList.setModel(dlm); // ?????? ë¦¬ì?¤í?¸ì?? ë¦¬ì?¤í?¸ëª¨?¸ë?£ê¸°
    }

    // Generated Code ???? Canvas ?¤ë??¼ì?´ë?©ì?¼ë? êµ¬í??
    // ptx, pty, cr(ì»¬ë??) ê°??¼ë? ê·¸ë¦¼?? ê·¸ë?¤ì???
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
        setTitle("ì±??? ????ì°?");
        getContentPane().setLayout(new java.awt.CardLayout());

        pnl1.setPreferredSize(new java.awt.Dimension(590, 700));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PainterChat/mainImg.JPG"))); // NOI18N

        jLabel2.setText("????ëª? :");

        btnEnter.setText("?? ?? ê°? ê¸?");
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

        btnExit.setText("??ê°?ê¸?");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder("ë¡?ê·¸ì?¸ì?"));

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

    // ????ì°? (IP, Port, ????ëª? ???? ????)
    // ?¤ì?´ê?ê¸? ??ë¥? ??
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if (!txtNick.getText().equals("")) { // ????ëª??? ë¹??´ì??ì§? ???¼ë©´
            nickName = txtNick.getText(); // ????ëª??? ???¥í??ê³?
            ip = txtIp.getText(); // ???´í?¼ë?? ???¥í??ê³?
            port = txtPort.getText(); // ?¬í?¸ë?? ???¥í??ê³?

            // ì¹´ë?? ???´ì?? ?¤ì?? ë°? ?¤ì?? ì¹´ë??ë¥? ë³´ì?¬ì???
            card = (CardLayout) getContentPane().getLayout(); // ???¬í?¬ì?? ???´ì?????? ?»ì?´ë??
            card.show(getContentPane(), "chatCard"); // ?¤ì?? ì¹´ë??ë¥? ë³´ì?¬ì?
            setTitle("ì±???ì°?"); // ???´í?? ?¤ì??
            txtUser.setText(nickName + " ??"); // ??ë©´ì?? ?????? ?´ë??? ë³´ì?¬ì?
            exe();
        }
}//GEN-LAST:event_btnEnterActionPerformed

    // ?¤í?? ë©?????
    private void exe() {
        try {
            sk = new Socket(ip, Integer.parseInt(port)); // ip ?? port ë¡? ??ì¼? ????
            pw = new PrintWriter(sk.getOutputStream(), true); // ì¶??? ?¤í?¸ë¦¼
            pw.println("enter/" + nickName + "/none/none"); // ???¥ë???ì§?ë¥? ?¡ì?
        } catch (UnknownHostException ex) {
            System.out.println("???¤ì?ì§????? ?¸ì?¤í?? ???¸ì?ë¦?");
        } catch (IOException ex) {
            System.out.println("??ì¼? ???? or PrintWriter ???? ??ì¶??? ???¸ì?ë¦?");
        }

        /*
         * *** ?°ì?´í?? ???? ???? ***
         * type1/type2/type3/type4
         * 
         * ????> enter/????ëª?/null/null
         * ?´ì??> exit/????ëª?/null/null
         * ê·¸ë¦¬ê¸?> draw/????/x/y
         * ê·???ë§?> whiper/?¤ì???¬ë??/ë§??????¬ë??/??ë§?
         * ?´ì?¼ê¸°> talk/??ì²?/ë§??????¬ë??/??ë§?
         */

        // ?½ê¸° Thread ???? ë°? ?¤í??
        Thread t = new Thread(new Runnable() {

            public void run() {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                    String list = br.readLine(); // ì²????? ???? ???????? ë¦¬ì?¤í?? ?½ê¸°
                    StringTokenizer stn = new StringTokenizer(list, "/"); // ??????ë¥? ????
                    while (stn.hasMoreTokens()) {
                        String nm = stn.nextToken();
                        dlm.addElement(nm); // ??ëª??? ?????? ë¦¬ì?¤í?¸ì?? ????
                    }
                    // ì½¤ë³´ë°??¤ì?? ??ëª??? ì¶?ê°?
                    cbx.addItem("??ì²?"); // ê°??¥ë¨¼?? [??ì²?] ë¥? ì¶?ê°?
                    for (int i = 0; i < dlm.getSize(); i++) {
                        cbx.addItem(dlm.get(i)); // ??ëª??? ì½¤ë³´ë°??¤ì?? ì¶?ê°?
                    }

                    // ?¬ê¸°?? ë¶??? ë©???ì§? ?½ê¸° ??ê¸?
                    while (true) {
                        String str = br.readLine();
                        stn = new StringTokenizer(str, "/");
                        String com = stn.nextToken();
                        // ì²«ë?ì§? ???°ì?? ?°ë?¼ì?? ë¶?ë¥?
                        if (com.equals("enter")) { // ???¥ì?ë¦?
                            com = stn.nextToken(); // ?¤ì?? ???°ì?? ?½ì?´ì??(????ëª?)
                            dlm.addElement(com); // ????ë¦¬ì?¤í?¸ì?? ì¶?ê°?
                            txtMain.append("**" + com + "** ?? ???¥í???¨ì?µë????" + "\n"); // ???¥ë???ì§? ?????? ??ë©´ì?? ë³´ì?¬ì?
                            cbx.addItem(com); // ì½¤ë³´ë°??¤ì???? ì¶?ê°?
                        } else if (com.equals("exit")) { // ?´ì?¥ì?ë¦?
                            com = stn.nextToken(); // ?¤ì?? ???°ì?? ?½ì?´ì??(????ëª?)
                            dlm.removeElement(com); // ????ë¦¬ì?¤í?¸ì???? ??ê±?
                            txtMain.append("**" + com + "** ?? ?´ì?¥í???¨ì?µë????" + "\n"); // ?´ì?¥ë???ì§? ?????? ??ë©´ì?? ë³´ì?¬ì?
                            cbx.removeItem(com); // ì½¤ë³´ë°??¤ì???? ??ê±?
                        } else if (com.equals("draw")) { // ?´ë?¸ì? ì²?ë¦?
                            com = stn.nextToken(); // ????ê°?
                            ptx = Integer.parseInt(stn.nextToken()); // xì¢???
                            pty = Integer.parseInt(stn.nextToken()); // yì¢???

                            // ????ê°? ?¤ì??
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
                            // ê·¸ë¦¼?? ê·¸ë?¤ì???
                            can.repaint();

                        } else { // ????ê²½ì?? ë©???ì§? ì²?ë¦?
                            txtMain.append(str + "\n"); // ë©???ì§?ë¥? ?????? ??ë©´ì?? ë³´ì?¬ì?
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

        // ìº?ë²??¤ì?? ë§??°ì?¤ëª¨??ë¦¬ì?¤ë?? ì¶?ê°?
        can.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                // ë§??°ì?¤ì?? x, y ì¢???ë¥? ?½ê?
                int x = e.getX();
                int y = e.getY();
                // ê·¸ë¦¼?? ???¬ì?? ?????¼ë? x, y ì¢????? ê·¸ë¦¬?¼ê? ë©???ì§? ?¡ì?
                pw.println("draw" + "/" + color + "/" + x + "/" + y);
            }
        });
    }

    // ???? ë²??? ?´ë¦­?? - ì±???ì°?
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtField.getText().equals("")) { // ???¤í?? ????ê°? ë¹??´ì??ì§? ???¼ë©´
            String str = txtField.getText();
            txtField.setText("");
            String type = (String) cbx.getSelectedItem(); // ???????´ì???? ???????? ????
            // ??ì²´ì?¸ì? ê·???ë§??¸ì? êµ¬ë? ?¤ì??
            if (type.equals("??ì²?")) { // ??ì²´ê? ???????´ì???¼ë©´
                str = "talk" + "/" + "all" + "/" + nickName + "/" + str;
            } else { // ?¤ë¥¸ ??ëª??? ???????´ì???¼ë©´
                str = "whisper" + "/" + type + "/" + nickName + "/" + str;
            }
            pw.println(str); // ë©???ì§? ?¡ì?
        }
}//GEN-LAST:event_btnSendActionPerformed

    // ??ê°?ê¸? ë²??? ?´ë¦­??
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        pw.println("exit/" + nickName + "/none/none"); // ?´ì?? ë©???ì§? ?¡ì?
        System.exit(0); // ???¤í?? ì¢?ë£?
}//GEN-LAST:event_btnExitActionPerformed

    // ???°í?¤ë? ??????ê¸? ???? ?´ë²¤??
    private void txtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // ???°ê? ???¥ë??ê²½ì??
            // ?´ì?©ì?? ë¹??´ì??ì§????¼ë©´ ???? ë²??¼ê³¼ ê°??? ?????? ????
            if (!txtField.getText().equals("")) {
                String str = txtField.getText();
                txtField.setText("");
                String type = (String) cbx.getSelectedItem();
                if (type.equals("??ì²?")) {
                    str = "talk" + "/" + "all" + "/" + nickName + "/" + str;
                } else {
                    str = "whisper" + "/" + type + "/" + nickName + "/" + str;
                }
                pw.println(str);
            }
        }
    }//GEN-LAST:event_txtFieldKeyPressed

    // ë²??? ?? ???? ?¤ì??
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
