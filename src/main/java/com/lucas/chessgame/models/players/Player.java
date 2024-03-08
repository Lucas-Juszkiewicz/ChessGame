package com.lucas.chessgame.models.players;

import com.lucas.chessgame.Coordinates;
import com.lucas.chessgame.models.figures.Figures;

import static com.lucas.chessgame.ChessBoard.*;

public class Player {

    String name;
    // makeMove() -
    // String startCoordinates and String endCoordinates
    // are declared by the player
    public void makeAMove(Coordinates startCoordinates, Coordinates endCoordinates) {
        int sRow = startCoordinates.getRow();
        int sColumn = startCoordinates.getColumn();
        int eRow = endCoordinates.getRow();
        int eColumn = endCoordinates.getColumn();

        Figures figure = whatStandsHere(startCoordinates);
        for (Coordinates possibleMove : figure.getPossibleMovements()) {
            if (checkIfTheMoveIsValid(figure, endCoordinates)) {
                if (possibleMove.equals(endCoordinates)) {
                    //placing the figure on the endCoordinates
                    boardArray[eRow][eColumn] = figure;
                    figure.setCurrentPosition(endCoordinates);

                    //clearing the startCoordinates after the figure
                    boardArray[sRow][sColumn] = null;

                    //notification for me about whether the figure move was successful
                    System.out.printf("\n Valid move %s -> %s == %s\n", startCoordinates, endCoordinates, possibleMove);
                }
            }
        }
    }
}
