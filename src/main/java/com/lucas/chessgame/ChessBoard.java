package com.lucas.chessgame;

import com.lucas.chessgame.models.figures.Figures;
import com.lucas.chessgame.models.players.Player;


public class ChessBoard {

    public static Figures[][] boardArray = new Figures[8][8];

    public ChessBoard() {
        Service.boardSetUp();
    }


    public static boolean checkIfTheMoveIsValid(Figures figure, String endCoordinates) {
        int row = getRow(endCoordinates);
        int column = getColumn(endCoordinates);
        if ((row >= 0 && row <= 8) && (column >= 0 && column <= 8)) {
            if (whatStandsHere(row, column) != null) {
                Figures opponent = whatStandsHere(row, column);
                return opponent.getColor() != figure.getColor();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static Figures whatStandsHere(int row, int column) {
        return boardArray[row][column];
    }

    public static int getRow(String coordinates) {
        int rowNumber = Integer.parseInt(coordinates.substring(1));
        return rowNumber - 1;
    }

    public static int getColumn(String coordinates) {
        char columnLetter = coordinates.charAt(0);
        return (int) columnLetter - 97;
    }

    public String printBoard() {
        StringBuilder answer = new StringBuilder();
        for (Figures[] boardRows : this.boardArray) {
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
