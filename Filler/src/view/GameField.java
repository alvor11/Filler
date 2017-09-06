package view;


import model.Cell;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Виталик on 25.08.2017.
 */
public class GameField extends JFrame {
    int score = 0;
    private JPanel jPanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    private JPanel informPanel = new JPanel();
    private JLabel information = new JLabel();
    JButton score1 = new JButton();
    JButton score2 = new JButton();
    // Инициализация игрового поля
    public void init(int size){
        setSize(850, 900);
        Container container = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel.setLayout(new GridLayout(size, size));
        controlPanel.setLayout(new GridLayout(1, 6));
        setLocationRelativeTo(null);
        setTitle("FILLER");

        informPanel.setLayout(new BorderLayout());
        informPanel.add(information, BorderLayout.CENTER);
        score1.setText("score1: " + score);
        score2.setText("score2: " + score);
        informPanel.add(score1, BorderLayout.WEST);
        informPanel.add(score2, BorderLayout.EAST);
        container.add(informPanel, "North");
        container.add(jPanel);
        container.add(controlPanel, "South");
        setVisible(true);
    }
    //Отображение игровых полей в окне
    public void setField(Cell[][] board, int size){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton jButton = board[i][j].button;
                jPanel.add(jButton);
            }
        }
    }
    // Отображение кнопок управления
    public void setControlPanel(Cell[] board){

        for (int i = 0; i < 6; i++) {

                JButton jButton = board[i].button;
                controlPanel.add(jButton);

        }
    }
    // Отображение информационной строки
    public void setInform(String inform){
        information.setFont(new Font("Verdana", Font.BOLD, 20));
        information.setIcon(new ImageIcon("(thinking)_scaled_90.png"));
        information.setText(inform);

    }
    // Отображение диалогового окна
    public void createDialog(String title, boolean modal, String text){

        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(500, 300);
        JPanel diaPanel = new JPanel();
        diaPanel.setLayout(new BorderLayout());
        JLabel diaLabel = new JLabel();
        diaLabel.setText(text);
        diaLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        diaLabel.setVerticalAlignment(SwingConstants.CENTER);
        diaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(diaLabel);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        //return dialog;
    }

    public void setScore1(int score){
        score1.setText("score1: " + score);
    }
    public void setScore2(int score){
        score2.setText("score2: " + score);
    }

}
