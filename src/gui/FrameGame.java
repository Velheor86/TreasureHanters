package gui;


import Objects.Heroe;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;
import interfaces.map.PaintMap;
import interfaces.object.MoveObject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FrameGame extends FrameBaseChild {
    private PaintMap map;


    private JButton btnleft;
    private JButton btndown;
    private JButton btnright;
    private JButton btnup;
    private JButton btnwait;
    private JButton btnmenu;
    private JButton btnsave;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JSeparator jSeparator1;

    public FrameGame() {
        initComponents();
    }

    public void setMap(PaintMap map){
        this.map = map;
        map.paintMap();

        jPanel1.removeAll();
        jPanel1.add(map.getMap());
        jLabel3.setText(String.valueOf(Heroe.getScore()));
        jLabel4.setText(String.valueOf(map.getGameMap().getLimit()));
        MoveTimer timer = new MoveTimer();
        timer.start();

    }

    private void initComponents() {

        jSeparator1 = new JSeparator();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        btnup = new JButton();
        btnleft = new JButton();
        btndown = new JButton();
        btnright = new JButton();
        btnwait = new JButton();
        jPanel3 = new JPanel();
        btnsave = new JButton();
        btnmenu = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        ButtonListener lis = new ButtonListener();

        jSeparator1.setBorder(BorderFactory.createEtchedBorder());

        jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel1.setForeground(new Color(100, 100, 100));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

        btnup.setBackground(UIManager.getDefaults().getColor("info"));
        btnup.setText("В");
        btnup.addActionListener(lis);

        btnleft.setBackground(UIManager.getDefaults().getColor("info"));
        btnleft.setText("Л");
        btnleft.addActionListener(lis);

        btndown.setBackground(UIManager.getDefaults().getColor("info"));
        btndown.setText("Н");
        btndown.addActionListener(lis);

        btnright.setBackground(UIManager.getDefaults().getColor("info"));
        btnright.setText("П");
        btnright.addActionListener(lis);

        btnwait.setBackground(UIManager.getDefaults().getColor("info"));
        btnwait.setText("Пропустить");
        btnwait.addActionListener(lis);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnwait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(btnleft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btndown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnright, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(btnup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnleft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btndown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnright, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnwait)
                                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnsave.setBackground(javax.swing.UIManager.getDefaults().getColor("info"));
        btnsave.setText("Сохранить");
        btnsave.addActionListener(lis);

        btnmenu.setBackground(javax.swing.UIManager.getDefaults().getColor("info"));
        btnmenu.setText("Меню");
        btnmenu.addActionListener(lis);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnsave)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("Счет:");

        jLabel2.setText("Осталось ходов:");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0,0, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        setSize(616,413);

    }



    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnleft) {
                moving(MovingDirect.LEFT, GameObjectType.HEROE);
            } else if (e.getSource() == btnright) {
                moving(MovingDirect.RIGHT, GameObjectType.HEROE);
            } else if (e.getSource() == btnup) {
                moving(MovingDirect.UP, GameObjectType.HEROE);
            } else if (e.getSource() == btndown) {
                moving(MovingDirect.DOWN, GameObjectType.HEROE);
            } else if (e.getSource() == btnwait) {
            } else if (e.getSource() == btnmenu) closeFrame();
            else if (e.getSource() == btnsave) {
            }
        }

        private void moving(MovingDirect direct, GameObjectType type) {

            MoveAction action = map.getGameMap().getGameCollection().moveObject(direct, type);
            if (action == MoveAction.DIE || map.getGameMap().getLimit()== 0){
                JOptionPane.showConfirmDialog(null, "Поражение", "Вы проиграли!", JOptionPane.PLAIN_MESSAGE);
                closeFrame();

            }
            else if (action == MoveAction.STAY){

            }
            else
            {
                map.getGameMap().setLimit(map.getGameMap().getLimit() - 1);
                jLabel4.setText(String.valueOf(map.getGameMap().getLimit()));
                jLabel3.setText(String.valueOf(Heroe.getScore()));
            }

        }


    }


    private class MoveTimer implements ActionListener {
        private javax.swing.Timer time;

        private MoveTimer() {
            time = new javax.swing.Timer(1000, this);
            time.setInitialDelay(0);
        }

        public  void start() {
            time.start();
        }

        public void stop() {
            time.stop();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            map.getGameMap().getGameCollection().moveObject(randomDirect(),GameObjectType.MONSTER);
        }


        private MovingDirect randomDirect(){
            Random r = new Random();
            MovingDirect dir = null;
            switch (r.nextInt(4)){
                case 0:{
                    dir = MovingDirect.UP;
                    break;
                }
                case 1:{
                    dir = MovingDirect.DOWN;
                    break;
                }
                case 2:{
                    dir = MovingDirect.LEFT;
                    break;
                }
                case 3:{
                    dir = MovingDirect.RIGHT;
                    break;
                }
            }
            return dir;
        }
    }

}
