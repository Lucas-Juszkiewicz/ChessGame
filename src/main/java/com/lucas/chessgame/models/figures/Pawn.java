package com.lucas.chessgame.models.figures;

import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;
import com.lucas.chessgame.Coordinates;

public class Pawn extends Figures{

    private boolean isItFirstMove = true;

    public Pawn(Type type, Color color) {
        super(type, color);
    }

    @Override
    public void setPossibleMovements() {
        int currentRow = currentCoordinates.getRow();
        int currentColumn = currentCoordinates.getColumn();
        if (this.getColor() == Color.WHITE) {
            if (isItFirstMove) {
                isItFirstMove = false;
                Coordinates coordinatesMoveOne = new Coordinates(currentRow + 1, currentColumn);
                Coordinates coordinatesMoveTwo = new Coordinates(currentRow + 2, currentColumn);
                //captures
                Coordinates coordinatesCaptureThree = new Coordinates(currentRow + 1, currentColumn - 1);
                Coordinates coordinatesCaptureFour = new Coordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new Coordinates[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                Coordinates coordinatesMoveOne = new Coordinates(currentRow + 1, currentColumn);
                //captures
                Coordinates coordinatesCaptureThree = new Coordinates (currentRow + 1, currentColumn - 1);
                Coordinates coordinatesCaptureFour = new Coordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new Coordinates[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        } else if (this.getColor() == Color.BLACK) {
            if (isItFirstMove) {
                isItFirstMove = false;
                Coordinates coordinatesMoveOne = new Coordinates(currentRow - 1, currentColumn);
                Coordinates coordinatesMoveTwo = new Coordinates(currentRow - 2, currentColumn);
                //captures
                Coordinates coordinatesCaptureThree = new Coordinates(currentRow - 1, currentColumn - 1);
                Coordinates coordinatesCaptureFour = new Coordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new Coordinates[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                Coordinates coordinatesMoveOne = new Coordinates(currentRow - 1, currentColumn);
                //captures
                Coordinates coordinatesCaptureThree = new Coordinates(currentRow - 1, currentColumn - 1);
                Coordinates coordinatesCaptureFour = new Coordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new Coordinates[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        }
    }
}

