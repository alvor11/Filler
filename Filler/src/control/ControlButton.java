package control;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Виталик on 27.08.2017.
 */
public class ControlButton {
    int color;

    public int getColor(JButton jbutton){
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String butName = e.getActionCommand();
                int color = Integer.parseInt(butName);

            }
        });
        return color;
    }

}
