package com.lucas.ChessGame;

public class Rook extends Figures{
    String currentPosition;
    private String[] possibleMovements;

    public Rook(Type type, Color color) {
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
