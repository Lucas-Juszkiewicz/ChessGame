package com.lucas.chessgame.models.figures;

import com.lucas.chessgame.ChessBoard;
import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;

public class Pawn extends Figures {

    private boolean isItFirstMove = true;

    public Pawn(Type type, Color color) {
        super(type, color);
    }

    @Override
    public void setPossibleMovements(String coordinates) {
        int currentRow = ChessBoard.getRow(coordinates);
        int currentColumn = ChessBoard.getColumn(coordinates);
        if (this.getColor() == Color.WHITE) {
            if (isItFirstMove) {
                isItFirstMove = false;
                String coordinatesMoveOne = convertToChessboardCoordinates(currentRow + 1, currentColumn);
                String coordinatesMoveTwo = convertToChessboardCoordinates(currentRow + 2, currentColumn);
                //captures
                String coordinatesCaptureThree = convertToChessboardCoordinates(currentRow + 1, currentColumn - 1);
                String coordinatesCaptureFour = convertToChessboardCoordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                String coordinatesMoveOne = convertToChessboardCoordinates(currentRow + 1, currentColumn);
                //captures
                String coordinatesCaptureThree = convertToChessboardCoordinates(currentRow + 1, currentColumn - 1);
                String coordinatesCaptureFour = convertToChessboardCoordinates(currentRow + 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        } else if (this.getColor() == Color.BLACK) {
            if (isItFirstMove) {
                isItFirstMove = false;
                String coordinatesMoveOne = convertToChessboardCoordinates(currentRow - 1, currentColumn);
                String coordinatesMoveTwo = convertToChessboardCoordinates(currentRow - 2, currentColumn);
                //captures
                String coordinatesCaptureThree = convertToChessboardCoordinates(currentRow - 1, currentColumn - 1);
                String coordinatesCaptureFour = convertToChessboardCoordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesMoveTwo, coordinatesCaptureThree, coordinatesCaptureFour};
            } else {
                String coordinatesMoveOne = convertToChessboardCoordinates(currentRow - 1, currentColumn);
                //captures
                String coordinatesCaptureThree = convertToChessboardCoordinates(currentRow - 1, currentColumn - 1);
                String coordinatesCaptureFour = convertToChessboardCoordinates(currentRow - 1, currentColumn + 1);

                this.possibleMovements = new String[]{coordinatesMoveOne, coordinatesCaptureThree, coordinatesCaptureFour};
            }
        }
    }
}

