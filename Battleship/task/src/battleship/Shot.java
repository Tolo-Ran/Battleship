package battleship;

class Shot {
    protected Shot(GameField gameField) {
        InputCoordinates target = null;
        boolean controlFlag = true;
        while (controlFlag) {
            target = new InputCoordinates();
            if (!target.inputTarget()) {
                new MessagesBattleship().errorYouEnteredAWrongCoordinate();
                continue;
            }
            controlFlag = false;
        }
        gameField.isHit(target.getRowTarget(), target.getColumnTarget());
    }
}
