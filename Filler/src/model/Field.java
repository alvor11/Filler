package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Виталик on 22.08.2017.
 */
public class Field {
    public int size = 40;
    public int color;
    public int count = 0;
    Cell[][] board;
    Cell[] controlBut = new Cell[6];
    private Random random = new Random();
    String buttonText = "Change color";

    // Инициализация игровых полей
    public void init() {
        //this.size = size;
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                board[i][j] = new Cell();
                board[i][j].status = 0;
                board[i][j].nominal = random.nextInt(6) + 1;
                board[i][j].button.setBackground(Cell.setColor(board[i][j].nominal));
            }
        }
        board[size - 1][0].status = 1;
        board[0][size - 1].status = 2;

    }
    //Создание панели кнопок управления
    public  int controlPanel(){

        for (int i = 0; i < 6; i++) {
            controlBut[i] = new Cell();
            controlBut[i].status = 0;// кнопка ничейная
            controlBut[i].nominal = i + 1;// цифровое значение кнопки
            controlBut[i].button.setBackground(Cell.setColor(i + 1));// установка цвета кнопки согласно значения
            controlBut[i].button.setText(Integer.toString(i + 1));//надпись на конпке цифрового значения

            // Слушатель нажатия на кнопку
            controlBut[i].button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String butName = e.getActionCommand();
                    color = Integer.parseInt(butName);// присваивает значения нажатой кнопки
                    //System.out.println(butName);

                }
            });

        }
        return color;
    }
    // Обновление игровых полей после хода
    public void boardUpdate(int step, int gamer) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (board[i][j].status == gamer) {
                    board[i][j].nominal = step;
                    board[i][j].button.setBackground(Cell.setColor(board[i][j].nominal));
                    boardAnalis(i, j, step, gamer);
                }
            }
        }
    }


    private  void boardAnalis(int i, int j, int step, int gamer){
        int k = i;
        int l = j;
        if (l < size - 1) Control(k, l + 1, step, gamer);
        if (l > 0) Control(k, l - 1, step, gamer);
        if (k < size - 1) Control(k + 1, l, step, gamer);
        if (k > 0) Control(k - 1, l, step, gamer);
    }

   private void Control(int k, int l, int step, int gamer){
        int o = k;
        int p = l;
       if (board[o][p].status == gamer || board[o][p].nominal != step) return;
       else {
           board[o][p].status = gamer;
           boardAnalis(o, p, step, gamer);
       }
   }

}

