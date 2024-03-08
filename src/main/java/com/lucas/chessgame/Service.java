package com.lucas.chessgame;

import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;
import com.lucas.chessgame.models.figures.*;

public class Service {
    //boardSetUp() -
    // This function is used in the chess board constructor.
    // It is used to place thirty-two figures on the board
    // as it should look at the beginning of the game.
    public static void boardSetUp() {
        for (Type type : Type.values()) {
            for (Color color : Color.values()) {
                int[][] sPositionOfFigures = Figures.getStartingCoordinates(type, color);
                for (int i = 0; i < sPositionOfFigures[0].length; i++) {
                    int row = sPositionOfFigures[0][i];
                    int column = sPositionOfFigures[1][i];

                    //placing the figure on the board
                    Figures figure = switch (type) {
                        case BISHOP -> new Bishop(type, color);
                        case KING -> new King(type, color);
                        case KNIGHT -> new Knight(type, color);
                        case PAWN -> new Pawn(type, color);
                        case QUEEN -> new Queen(type, color);
                        case ROOK -> new Rook(type, color);
                    };
                    ChessBoard.boardArray[row][column] = figure;
                    //saving the initial coordinates in figure.currentPosition (figures.currentPosition)
                    figure.setCurrentPosition(new Coordinates(row, column));
                }
            }
        }
    }
}
