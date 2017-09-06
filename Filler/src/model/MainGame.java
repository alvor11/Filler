package model;


import view.GameField;
import java.util.Random;

/**
 * Created by Виталик on 22.08.2017.
 */
public class MainGame {
    public static void main(String[] args) throws InterruptedException {
        Field field = new Field();
        Gamer gamer = new Gamer();
        Random random = new Random();
        //CompGamer compGamer = new CompGamer();
        GameField gameField = new GameField();
        int nominal1;
        int nominal2 = 0;
        int score;
        //Инициализируем игровое поле
        field.init();
        gameField.init(field.size);
        field.controlPanel();
        gameField.setField(field.board, field.size);
        //Инициализация кнопок управления
        gameField.setControlPanel(field.controlBut);
        gameField.createDialog("Правила игры", true, "<html>Приветствую в игре FILLER! " +
                "Захватите полей больше противника. " +
                "Выберите цвет вашего поля так, чтобы он совпадал по цвету с большинством соседних," +
                " тогда они станут вашими.</br> Игрок1 начинает игру в левом нижнем углу," +
                "</br> Игрок2 в верхнем правом углу</html>");
        // поочередноое совершение ходов до конца игры
        while(true) {
                gameField.setInform("Игрок1 выберите цвет хода в нижней части окна");
            do{
                nominal1 = field.controlPanel(); // слушатели на кнопках передают число
            }while (nominal1 == nominal2); // число хода игроков должны быть разными
            field.boardUpdate(nominal1, 1);//игровое поле обновляется согласно новым данным
            score = gamer.scoreGamer(1, field.size, field.board);
            gameField.setScore1(score);
            gameField.setField(field.board, field.size);// новое поле отображается на экран
            if(score > ((field.size * field.size) / 2) + 1){
                gameField.createDialog("ПОБЕДА", true, "Игрок1 победил!!! Поздравляю!!!");
                break;// проверка на конец игры
            }
                gameField.setInform("Игрок2 выберите цвет хода в нижней части окна");
            do{
                //nominal2 = field.controlPanel();//слушатели на кнопках передают число
                nominal2 = random.nextInt(6) + 1;//слушатели на кнопках передают число
            }while (nominal2 == nominal1);// число хода игроков должны быть разными
            field.boardUpdate(nominal2, 2);//игровое поле обновляется согласно новым данным
            score = gamer.scoreGamer(2, field.size, field.board);
            gameField.setScore2(score);
            gameField.setField(field.board, field.size);// новое поле отображается на экран
            if(score > ((field.size * field.size) / 2) + 1){
                gameField.createDialog("ПОБЕДА", true, "Игрок2 победил!!! Поздравляю!!!");
                break;// проверка на конец игры
            }

        }
        gameField.setInform("Конец игры");

    }
}
