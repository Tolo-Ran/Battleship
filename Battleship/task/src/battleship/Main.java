package battleship;

public class Main {

    public static void main(String[] args) {

        new MessagesBattleship().inputPlayer(1);
        GameField gameField1 = new GameField();
        gameField1.drawGameField(gameField1.gameField);
        new ShipFactory(gameField1);
        gameField1.drawGameField(gameField1.gameField);
        GameField gameField2 = new GameField();
        nextPlayer();
        new MessagesBattleship().inputPlayer(2);
        gameField2.drawGameField(gameField2.gameField);
        new ShipFactory(gameField2);
        gameField2.drawGameField(gameField2.gameField);
        nextPlayer();
        try {
            while (true) {
                new Turn(gameField1, gameField2, 1);
                nextPlayer();
                new Turn(gameField2, gameField1, 2);
                nextPlayer();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void nextPlayer() {
        boolean controlFlag = true;
        new MessagesBattleship().inputMoveToTheAnotherPlayer();
        while (controlFlag) {
            controlFlag = !(new InputCoordinates().isEnterPressed());
            if (controlFlag) {
                new MessagesBattleship().inputMoveToTheAnotherPlayer();
            }
        }
    }
}
