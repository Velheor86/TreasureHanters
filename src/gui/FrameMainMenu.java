package gui;

import collection.MapCollection;
import enums.MapSource;
import gui.map.JTableMap;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FrameMainMenu extends JFrame {


    FrameMainMenu(){
        initMenu();
    }

    private FrameGame framenewgame = new FrameGame();
    private FrameStatistic framestatistic = new FrameStatistic();
    private FrameLoadGame frameloadgame = new FrameLoadGame();
    private JTableMap mapa = new JTableMap(MapSource.FS, "map.map",new MapCollection());

    JPanel panel;
    JButton newgame;
    JButton loadgame;
    JButton statistic;
    JButton exit;


    private void initMenu() {
         panel = new JPanel();
         newgame = new JButton("Новая Прогулка");
         loadgame = new JButton("Загрузить игру");
         statistic = new JButton("Статистика");
         exit = new JButton("Выход");
         Box box = Box.createVerticalBox();
         FromListener form = new FromListener();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rasta Faray");
        setResizable(false);
        setSize(250,350);
        setLocationRelativeTo(null);

        add(panel);
        panel.add(box);

        box.add(Box.createVerticalStrut(30));
        box.add(newgame);
        newgame.setAlignmentX(CENTER_ALIGNMENT);
        newgame.setIcon(new ImageIcon(getClass().getResource("../res/new.png")));
        newgame.add(Box.createHorizontalStrut(130));
        newgame.add(Box.createVerticalStrut(30));
        newgame.addActionListener(form);

        box.add(Box.createVerticalStrut(30));
        box.add(loadgame);
        loadgame.setAlignmentX(CENTER_ALIGNMENT);
        loadgame.setIcon(new ImageIcon(getClass().getResource("../res/load.png")));
        loadgame.add(Box.createHorizontalStrut(130));
        loadgame.add(Box.createVerticalStrut(30));
        loadgame.addActionListener(form);

        box.add(Box.createVerticalStrut(30));
        box.add(statistic);
        statistic.setAlignmentX(CENTER_ALIGNMENT);
        statistic.setIcon(new ImageIcon(getClass().getResource("../res/stat.png")));
        statistic.add(Box.createHorizontalStrut(130));
        statistic.add(Box.createVerticalStrut(30));
        statistic.addActionListener(form);

        box.add(Box.createVerticalStrut(30));
        box.add(exit);
        exit.setAlignmentX(CENTER_ALIGNMENT);
        exit.setIcon(new ImageIcon(getClass().getResource("../res/exit.png")));
        exit.add(Box.createHorizontalStrut(130));
        exit.add(Box.createVerticalStrut(30));
        exit.addActionListener(form);
    }


    private class FromListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newgame){
                framenewgame.setMap(mapa);
                openFrame(framenewgame);
            }else if (e.getSource() == loadgame){
                openFrame(frameloadgame);
            }else if (e.getSource() == statistic){
                openFrame(framestatistic);
            }else if (e.getSource() == exit){
                System.exit(0);
            }
        }
    }

    public void openFrame(FrameBaseChild childframe){
        childframe.openFrame(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               new FrameMainMenu().setVisible(true);
            }
        });

    }
     {
        File soundFile = new File("2.wav"); //Звуковой файл
         AudioInputStream ais = null;
         Clip clip = null;
        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }

        clip.setFramePosition(0);
        clip.start();
    }

}
