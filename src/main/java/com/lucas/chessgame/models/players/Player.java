package com.lucas.chessgame.models.players;

import com.lucas.chessgame.ChessBoard;
import com.lucas.chessgame.models.figures.Figures;

import static com.lucas.chessgame.ChessBoard.*;

public class Player {

    String name;
    // makeMove() -
    // String startCoordinates and String endCoordinates
    // are declared by the player
    public void makeAMove(String startCoordinates, String endCoordinates) {
        int sRow = getRow(startCoordinates);
        int sColumn = getColumn(startCoordinates);
        int eRow = getRow(endCoordinates);
        int eColumn = getColumn(endCoordinates);
        Figures figure = whatStandsHere(sRow, sColumn);
        for (String possibleMove : figure.getPossibleMovements()) {
            if (checkIfTheMoveIsValid(figure, endCoordinates)) {
                if (possibleMove.equals(endCoordinates)) {
                    //placing the figure on the endCoordinates
                    boardArray[eRow][eColumn] = figure;
                    figure.setCurrentPosition(eRow, eColumn);

                    //clearing the startCoordinates after the figure
                    boardArray[sRow][sColumn] = null;

                    //notification for me about whether the figure move was successful
                    System.out.printf("\n Valid move %s -> %s == %s\n", startCoordinates, endCoordinates, possibleMove);
                }
            }
        }
    }
}
