package com.lucas.ChessGame;

public class Rook extends Figures {
    String currentPosition;
    private String[] possibleMovements;

    public Rook(Type type, Color color) {
        super(type, color);
    }

    @Override
    public void setPossibleMovements(String coordinates) {

    }

    @Override
    public String[] getPossibleMovements() {
        return new String[0];
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String coordinates) {
        this.currentPosition = coordinates;
    }

}


