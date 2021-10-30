package battleship;

class MessagesBattleship {
    /*
     * INPUTS
     * */


    protected void inputMoveToTheAnotherPlayer() {
        System.out.println("Press Enter and pass the move to another player");
    }
    protected void inputPlayer(int playerNumber) {
        System.out.printf("Player %d, place your ships on the game field%n", playerNumber);
    }

    protected void inputPlayerTakeAShot(int player) {
        System.out.printf("Player %d, it's your turn:%n", player);
    }

    protected void inputCoordinatesAircraft() {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
    }

    protected void inputCoordinatesBattleship() {
        System.out.println("Enter the coordinates of the Battleship (4 cells)");
    }

    protected void inputCoordinatesSubmarine() {
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
    }

    protected void inputCoordinatesCruiser() {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
    }

    protected void inputCoordinatesDestroyer() {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
    }

    /*
    * ERRORS
    * */
    protected void errorTooCloseAnotherOne() {
        System.out.println("Error! You placed it too close to another one. Try again:");
    }

    protected void errorWrongShipLocation() {
        System.out.println("Error! Wrong ship location! Try again:");
    }

    protected void errorWrongLength(String shipName) {
        System.out.printf("Error! Wrong length of the %s! Try again:%n", shipName);
    }

    protected void errorYouEnteredAWrongCoordinate() {
        System.out.println("Error! You entered the wrong coordinates! Try again:");
    }

    /*
     * GAME STATES
     * */
    protected void stateYouWin() {
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    protected void stateYouSankAShip() {
        System.out.println("You sank a ship! Specify a new target:");
    }

    protected void stateYouHitAShip() {
        System.out.println("You hit a ship!");
    }

    protected void stateYouMissed() {
        System.out.println("You missed!");
    }


}
