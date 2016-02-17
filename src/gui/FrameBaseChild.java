package gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Admin on 03.02.2016.
 */
public abstract class FrameBaseChild extends JFrame {

    FrameBaseChild(){
        setCloseOperation();
    }

    private JFrame parentFrame;

    protected void openFrame(JFrame parent){
        parentFrame = parent;
        parent.setVisible(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setResizable(false);

    }

    protected void closeFrame(){
        if (parentFrame == null) throw new IllegalArgumentException("");
        parentFrame.setVisible(true);
        super.setVisible(false);
    }

    protected void setCloseOperation(){
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }
}
