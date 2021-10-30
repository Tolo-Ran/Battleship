package battleship;

import java.util.Arrays;
import java.util.Scanner;

class InputCoordinates {

    private int[] rows;
    private int[] columns;
    private boolean isValid;
    private final String coordinatesAsString;
    private final String setChars;
    private int rowTarget;
    private int columnTarget;

    protected InputCoordinates() {
        this.isValid = false;
        this.setChars = "ABCDEFGHIJ";

        Scanner scanner = new Scanner(System.in);
        this.coordinatesAsString = scanner.nextLine();
    }

    public boolean isValid() {
        return isValid;
    }

    public int[] getRows() {
        return rows;
    }

    public int[] getColumns() {
        return columns;
    }

    public int getRowTarget() {
        return rowTarget;
    }

    public int getColumnTarget() {
        return columnTarget;
    }

    protected boolean isEnterPressed() {
        return isStringEmptyOrBlank(this.coordinatesAsString);

    }

    protected boolean inputTarget() {
        if (isStringEmptyOrBlank(this.coordinatesAsString)) {
            return false;
        }
        this.rowTarget = this.setChars.indexOf(this.coordinatesAsString.charAt(0));
        if (this.rowTarget == -1) {
                return false;
        }
        char[] coordinatesCharArr = this.coordinatesAsString.toCharArray();
        char[] columnTargetCharArr;
        if (coordinatesCharArr.length == 3) {
            columnTargetCharArr = new char[2];
            columnTargetCharArr[0] = coordinatesCharArr[1];
            columnTargetCharArr[1] = coordinatesCharArr[2];
        } else {
            columnTargetCharArr = new char[1];
            columnTargetCharArr[0] = coordinatesCharArr[1];
        }
        String columnTargetAsString = new String(columnTargetCharArr);
        if (columnTargetAsString.contains("\\d+")) {
            return false;
        }
        this.columnTarget = Integer.parseInt(columnTargetAsString);
        if (this.columnTarget < 0 || this.columnTarget > 10) {
            return false;
        }
        this.columnTarget--; // Index begins with zero so -1 here
            return true;
    }

    protected void inputForShipInitialization() {
        if (!isStringEmptyOrBlank(this.coordinatesAsString)) {
            String[] coordinatesAsStringArr = this.coordinatesAsString.split(" ");
            if (coordinatesAsStringArr.length == 2) {
                char[] coordinateAsCharArr1 = coordinatesAsStringArr[0].toCharArray();
                char[] coordinateAsCharArr2 = coordinatesAsStringArr[1].toCharArray();

                if (processWithRows(this.setChars, coordinateAsCharArr1, coordinateAsCharArr2)
                        && processWithColumns(coordinatesAsStringArr)) {
                    if (!((rows[0] != rows[1] && columns[0] == columns[1]
                            || rows[0] == rows[1] && columns[0] != columns[1]))) {
                        new MessagesBattleship().errorWrongShipLocation();
                    } else {
                        this.isValid = true;
                    }
                } else {
                    new MessagesBattleship().errorWrongShipLocation();
                }
            } else {
                new MessagesBattleship().errorWrongShipLocation();
            }
        } else {
            new MessagesBattleship().errorWrongShipLocation();
        }
    }

    private boolean processWithColumns(String[] coordinatesAsStringArr) {

        int column1;
        int column2;
        this.columns = new int[2];
        try {
            String coord1StringOnlyDigit = coordinatesAsStringArr[0].substring(1);
            column1 = Integer.parseInt(coord1StringOnlyDigit);
            String coord2StringOnlyDigit = coordinatesAsStringArr[1].substring(1);
            column2 = Integer.parseInt(coord2StringOnlyDigit);

            if (column1 > 10 || column2 > 10) {
                return false;
            } else if (column1 < 0 || column2 < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        this.columns[0] = column1 - 1;
        this.columns[1] = column2 - 1;
        Arrays.sort(this.columns);
        return true;
    }

    private boolean processWithRows(String setChars, char[] coordinateCharArr1, char[] coordinateCharArr2) {
        this.rows = new int[2];
        int row1 = setChars.indexOf(coordinateCharArr1[0]);
        int row2 = setChars.indexOf(coordinateCharArr2[0]);
        if (row1 == -1 || row2 == -1) {
            return false;
        } else {
            this.rows[0] = row1;
            this.rows[1] = row2;
            Arrays.sort(this.rows);
            return true;
        }
    }

    private boolean isStringEmptyOrBlank(String string) {
       return string.isBlank() || string.isEmpty();
    }
}

