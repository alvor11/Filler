package model;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Виталик on 22.08.2017.
 */
public class Cell {
    public int nominal;//0=white, 1=red, 2=yellow, 3=green, 4=blue, 5=darkGrey
    int status;//0=free; 1= gamer1; 2=gamer2
    public JButton button = new JButton();

    //Соответствие цвета номиналу
    public static Color setColor(int nominal){
       if(nominal > 0 && nominal <= 6) switch (nominal) {
           case 1:
               return Color.white;
           //break;
           case 2:
               return Color.red;
           //break;
           case 3:
               return Color.yellow;
           //break;
           case 4:
               return Color.green;
          // break;
           case 5:
               return Color.blue;
          // break;
           case 6:
               return Color.darkGray;
           //break;
       }
        return null;
    }

}
