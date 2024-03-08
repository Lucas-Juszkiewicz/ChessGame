package com.lucas.chessgame;

import java.util.Objects;

public class Coordinates {
    int row;
    int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinates(String coordinates){
        int rowNumber = Integer.parseInt(coordinates.substring(1));
        this.row = rowNumber - 1;

        char columnLetter = coordinates.charAt(0);
        this.column =  (int) columnLetter - 97;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    @Override
    public String toString() {
        int numberOfTheColumnChar = getColumn() + 97;
        char actualColumnLetter = (char) numberOfTheColumnChar;
        int actualRow = getRow() + 1;
        return String.format("%s%d", actualColumnLetter, actualRow);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates that)) return false;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
