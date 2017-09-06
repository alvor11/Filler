package model;



/**
 * Created by Виталик on 22.08.2017.
 */
public class Gamer {
    int score;
    int gamer;

    //Пересчет количества полей игрока и определение победы
    public int scoreGamer(int gamer, int size, Cell[][] board ){
        this.gamer = gamer;
        score = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].status == gamer)
                    score++;
            }
        }
        //if(score > ((size * size) / 2) + 1){

        return score;
    }
}
