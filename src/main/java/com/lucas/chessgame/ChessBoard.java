package com.lucas.chessgame;

import com.lucas.chessgame.models.figures.Figures;


public class ChessBoard {

    public static Figures[][] boardArray = new Figures[8][8];

    public ChessBoard() {
        Service.boardSetUp();
    }


    public static boolean checkIfTheMoveIsValid(Figures figure, Coordinates endCoordinates) {
        int row = endCoordinates.getRow();
        int column = endCoordinates.getColumn();
        if ((row >= 0 && row <= 8) && (column >= 0 && column <= 8)) {
            if (whatStandsHere(endCoordinates) != null) {
                Figures opponent = whatStandsHere(endCoordinates);
                return opponent.getColor() != figure.getColor();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Figures whatStandsHere(Coordinates coordinates) {
        return boardArray[coordinates.getRow()][coordinates.getColumn()];
    }

    public String printBoard() {
        StringBuilder answer = new StringBuilder();
        for (Figures[] boardRows : boardArray) {
            for (Figures figure : boardRows) {
                if (figure != null) {
                    answer.append(figure).append(" ");
                } else {
                    answer.append("       null      ||");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }
}
