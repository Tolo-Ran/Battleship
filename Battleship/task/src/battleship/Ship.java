package battleship;

class Ship {
    protected int[] rows;
    protected int[] columns;
    private final int distanceX;
    private final int distanceY;
    private final String shipName;

    protected Ship(String shipName) {
        this.shipName = shipName;
        boolean controlFlag = true;
        InputCoordinates coordinates = null;
        while (controlFlag) {
            coordinates = new InputCoordinates();
            coordinates.inputForShipInitialization();
            controlFlag = !coordinates.isValid();
        }

        this.rows = coordinates.getRows();
        int row1 = this.rows[0];
        int row2 = this.rows[1];

        this.columns = coordinates.getColumns();
        int column1 = this.columns[0];
        int column2 = this.columns[1];

        this.distanceX = row2 - row1;
        this.distanceY = column2 - column1;
    }

    protected void placeShip(GameField gameField) {
        gameField.placeShip(rows, columns);
    }

    protected boolean validateCoordinates(int distance) {
        if (!(distanceX != distance && distanceY == distance
                || distanceX == distance && distanceY != distance)) {
            new MessagesBattleship().errorWrongLength(this.shipName);
            return false;
        }
        return true;
    }

}
