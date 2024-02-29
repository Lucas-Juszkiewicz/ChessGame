package com.lucas.chessgame.models.figures;

import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;

import java.util.Arrays;
import java.util.Objects;

public abstract class Figures {
    protected final Type type;
    protected final Color color;
    protected String currentPosition;
    protected String[] possibleMovements;

    protected Figures(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }


    protected String getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(String coordinates) {
        this.currentPosition = coordinates;
        setPossibleMovements(coordinates);
    }

    protected abstract void setPossibleMovements(String coordinates);

    public String[] getPossibleMovements() {
        return this.possibleMovements;
    }

    //    Conversion from numbers to coordinates from the game board
    protected String convertToChessboardCoordinates(int rowNumber, int columnNumber) {
        int numberOfTheColumnChar = columnNumber + 97;
        char actualColumnLetter = (char) numberOfTheColumnChar;
        int actualRow = rowNumber + 1;
        return String.format("%s%d", actualColumnLetter, actualRow);
    }

    @Override
    public String toString() {
        return String.format("%s-%s on %s ||", this.type, this.color, getCurrentPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figures figures)) return false;
        return type == figures.type && color == figures.color && Objects.equals(currentPosition, figures.currentPosition) && Arrays.equals(possibleMovements, figures.possibleMovements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type, color, currentPosition);
        result = 31 * result + Arrays.hashCode(possibleMovements);
        return result;
    }
}


