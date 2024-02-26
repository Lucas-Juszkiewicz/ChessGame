package com.lucas.ChessGame;

public class King extends Figures{
    private String currentPosition;
    private String[] possibleMovements;
    public King(Type type, Color color) {
        super(type, color);
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String coordinates) {
        this.currentPosition = coordinates;
    }


    @Override
    public String[] getPossibleMovements() {
        return new String[0];
    }
}
