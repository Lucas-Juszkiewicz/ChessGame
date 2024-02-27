package com.lucas.ChessGame;

public abstract class Figures {
    private final Type type;
    private final Color color;
    private String currentPosition;
    private String[] possibleMovements;

    public Figures(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public abstract void setPossibleMovements(String coordinates);

    public abstract String[] getPossibleMovements();

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String coordinates) {
        this.currentPosition = coordinates;
    }

    public String turnInChessCoordinates(int rowNumber, int columnNumber){
        int actualColumnNumber = columnNumber+97;
        char actualColumnLetter = (char) actualColumnNumber;
        int actualRow = rowNumber+1;
        return String.format("%s%d",actualColumnLetter, actualRow);
    }


    @Override
    public String toString() {
        return String.format("%s-%s on %s ||", this.type, this.color, getCurrentPosition());
    }
}


