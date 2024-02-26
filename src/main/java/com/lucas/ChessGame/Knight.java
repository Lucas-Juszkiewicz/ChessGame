package com.lucas.ChessGame;

public class Knight extends Figures{

    String currentPosition;
    private String[] possibleMovements;


    public Knight(Type type, Color color) {
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
