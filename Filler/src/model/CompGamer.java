package model;


import java.util.Random;

/**
 * Created by Виталик on 27.08.2017.
 */
public class CompGamer {

    Random random = new Random();
    int score;
    int gamer;
    int step;



    public int move(int num){
        this.gamer = num;

        return random.nextInt()%6;
    }

}
