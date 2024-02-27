package com.lucas.ChessGame;

public class Pawn extends Figures {
    private String currentPosition;
    private String[] possibleMovements;

    private boolean isItFirstMove = true;

    public Pawn(Type type, Color color) {
        super(type, color);
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String coordinates) {
        this.currentPosition = coordinates;
        setPossibleMovements(coordinates);
    }

    @Override
    public String[] getPossibleMovements() {
        return this.possibleMovements;
    }


    @Override
    public void setPossibleMovements(String coordinates) {
        int currentRow = ChessBoard.getRow(coordinates);
        int currentColumn = ChessBoard.getColumn(coordinates);
        if (this.getColor() == Color.WHITE) {
            if (isItFirstMove) {
                isItFirstMove = false;
                String coordinatesMoveOne = turnInChessCoordinates(currentRow + 1, currentColumn);
                String coordinatesMoveTwo = turnInChessCoordinates(currentRow + 2, currentColumn);
                //captures
                String coordinatesCaptureThree = turnInChessCoordinates(currentRow + 1, currentColumn - 1);
                String coordinatesCaptureFour = turnInChessCoordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                String coordinatesMoveOne = turnInChessCoordinates(currentRow + 1, currentColumn);
                //captures
                String coordinatesCaptureThree = turnInChessCoordinates(currentRow + 1, currentColumn - 1);
                String coordinatesCaptureFour = turnInChessCoordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        } else if (this.getColor() == Color.BLACK) {
            if (isItFirstMove) {
                isItFirstMove = false;
                String coordinatesMoveOne = turnInChessCoordinates(currentRow - 1, currentColumn);
                String coordinatesMoveTwo = turnInChessCoordinates(currentRow - 2, currentColumn);
                //captures
                String coordinatesCaptureThree = turnInChessCoordinates(currentRow - 1, currentColumn - 1);
                String coordinatesCaptureFour = turnInChessCoordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                String coordinatesMoveOne = turnInChessCoordinates(currentRow - 1, currentColumn);
                //captures
                String coordinatesCaptureThree = turnInChessCoordinates(currentRow - 1, currentColumn - 1);
                String coordinatesCaptureFour = turnInChessCoordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        }
    }
}

