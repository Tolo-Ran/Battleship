package battleship;

public class Turn {

    protected Turn(GameField gameField, GameField gameFieldOpponent, int playerNumber) {
        gameFieldOpponent.drawGameField(gameFieldOpponent.shotsBookLog);
        System.out.println("---------------------");
        gameField.drawGameField(gameField.gameField);
        new MessagesBattleship().inputPlayerTakeAShot(playerNumber);
        new Shot(gameFieldOpponent);
        new MessagesBattleship().inputMoveToTheAnotherPlayer();
    }
}
