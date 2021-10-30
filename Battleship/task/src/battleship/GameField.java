package battleship;

class GameField {

    protected char[][] gameField;
    protected char[][] shotsBookLog;
    private final String setChars;
    private final char ship;
    private final char fog;
    private final char hit;
    private final char missed;

    protected GameField() {
        this.ship = 'O';
        this.fog = '~';
        this.hit = 'X';
        this.missed = 'M';
        this.setChars = "ABCDEFGHIJ";
        this.gameField = new char[10][10];
        createGameField(this.gameField);
        this.shotsBookLog = new char[10][10];
        createGameField(this.shotsBookLog);
    }

    protected boolean isAShipSank(int row, int column) {
        int countShips = 0;
        for (int k = column; k > -1; k--) {
            if (gameField[row][k] == this.fog || gameField[row][k] == this.missed) {
              break;
            }

            if (gameField[row][k] == this.ship) {
                countShips++;
            }
        }
        for (int k = column; k < gameField.length; k++) {
            if (gameField[row][k] == this.fog || gameField[row][k] == this.missed) {
                break;
            }

            if (gameField[row][k] == this.ship) {
                countShips++;
            }
        }
        for (int i = row; i > -1; i--) {
            if (gameField[i][column] == this.fog || gameField[i][column] == this.missed) {
                break;
            }

            if (gameField[i][column] == this.ship) {
                countShips++;
            }
        }
        for (int i = row; i < gameField.length; i++) {
            if (gameField[i][column] == this.fog || gameField[i][column] == this.missed) {
                break;
            }

            if (gameField[i][column] == this.ship) {
                countShips++;
            }
        }
        return countShips == 0;
    }

    protected boolean isEndOfWar() {
        for (char[] gameField : gameField
        ) {
            for (char field : gameField
            ) {
                if (field == this.ship) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void isHit(int row, int column) {
        if (this.gameField[row][column] == this.ship
                || this.gameField[row][column] == this.hit) {
            this.shotsBookLog[row][column] = this.hit;
            this.gameField[row][column] = this.hit;
            if (isEndOfWar()) {
                new MessagesBattleship().stateYouWin();
                System.exit(0);
            }
            if (isAShipSank(row, column)) {
                new MessagesBattleship().stateYouSankAShip();
            } else {
                new MessagesBattleship().stateYouHitAShip();
            }
        } else {
            this.shotsBookLog[row][column] = this.missed;
            this.gameField[row][column] = this.missed;
            new MessagesBattleship().stateYouMissed();
        }
    }

    protected boolean isTooClose(int[] rows, int[] columns) {
        int row1 = rows[0];
        int row2 = rows[1];
        int column1 = columns[0];
        int column2 = columns[1];
        if (column1 != 0) {
            column1--;
        }
        if (row1 != 0) {
            row1--;
        }
        if (row2 != 9) {
            row2++;
        }
        if (column2 != 9) {
            column2++;
        }
        int count = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                if (gameField[i][j] == this.ship) {
                    count++;
                }
            }
        }
        if (count != 0) {
            new MessagesBattleship().errorTooCloseAnotherOne();
            return true;
        }
        return false;
    }

    protected boolean isOccuped(int[] rows, int[] columns) {
        int row1 = rows[0];
        int row2 = rows[1];
        int column1 = columns[0];
        int column2 = columns[1];

        int count = 0;

        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                if (this.gameField[i][j] == this.ship) {
                    count++;
                }
            }
        }
        if (count != 0) {
            new MessagesBattleship().errorTooCloseAnotherOne();
            return true;
        }
        return false;
    }

    protected void drawGameField(char[][] gameField) {
        //print first row with num (1-10)
        System.out.print("  ");
        for (int i = 1; i < 11; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < this.gameField.length; i++) {
            // Print first column with chars (A-I) from String setChars
            System.out.print(this.setChars.charAt(i) + " ");

            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected void placeShip(int[] rows, int[] columns) {
        int row1 = rows[0];
        int row2 = rows[1];
        int column1 = columns[0];
        int column2 = columns[1];
        for (int i = row1; i <= row2; i++) {
            for (int j = column1; j <= column2; j++) {
                this.gameField[i][j] = this.ship;
            }
        }
    }

    private void createGameField(char[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (j == 0) {
                    gameField[i][j] = setChars.charAt(i);
                }
                gameField[i][j] = '~';
            }
        }
    }
}
