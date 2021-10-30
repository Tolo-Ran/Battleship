package battleship;

class ShipFactory {

    protected ShipFactory(GameField gameField) {
        new MessagesBattleship().inputCoordinatesAircraft();
        new ShipFactory(gameField, "Aircraft", 4);
        new MessagesBattleship().inputCoordinatesBattleship();
        new ShipFactory(gameField, "Battleship", 3);
        new MessagesBattleship().inputCoordinatesSubmarine();
        new ShipFactory(gameField, "Submarine", 2);
        new MessagesBattleship().inputCoordinatesCruiser();
        new ShipFactory(gameField, "Cruiser", 2);
        new MessagesBattleship().inputCoordinatesDestroyer();
        new ShipFactory(gameField, "Destroyer", 1);
    }

    private ShipFactory(GameField gameField, String shipName, int distance) {
        Ship ship = null;
        boolean controlFlag = true;
        while (controlFlag) {
            ship = new Ship(shipName);
            controlFlag = !ship.validateCoordinates(distance);
        }
        if (gameField.isOccuped(ship.rows, ship.columns)) {
            new ShipFactory(gameField, shipName, distance);
        } else {
            if (gameField.isTooClose(ship.rows, ship.columns)) {
                new ShipFactory(gameField, shipName, distance);
            } else {
                ship.placeShip(gameField);
                gameField.drawGameField(gameField.gameField);
            }
        }
    }
}
