package com.lucas.chessgame.models.figures;


import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;
import com.lucas.chessgame.Coordinates;

import java.util.Arrays;
import java.util.Objects;

public abstract class Figures{
    protected final Type type;
    protected final Color color;
    protected Coordinates currentCoordinates;
    protected Coordinates[] possibleMovements;

    public Figures(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Coordinates getCurrentCoordinates() {
        return this.currentCoordinates;
    }

    public void setCurrentPosition(Coordinates coordinates) {
        this.currentCoordinates = coordinates;
        setPossibleMovements();
    }

    public abstract void setPossibleMovements();

    public Coordinates[] getPossibleMovements(){
        return this.possibleMovements;
    }


    public static int[][] getStartingCoordinates(Type type, Color color) {
        return switch (type) {
            case KING -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {0},
                            {4}
                    };
                } else {
                    yield new int[][]{
                            {7},
                            {4}
                    };
                }
            }
            case QUEEN -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {0},
                            {3}
                    };
                } else {
                    yield new int[][]{
                            {7},
                            {3}
                    };
                }
            }
            case ROOK -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {0, 0},
                            {0, 7}
                    };
                } else {
                    yield new int[][]{
                            {7, 7},
                            {0, 7}
                    };
                }
            }
            case BISHOP -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {0, 0},
                            {2, 5}
                    };
                } else {
                    yield new int[][]{
                            {7, 7},
                            {2, 5}
                    };
                }
            }
            case KNIGHT -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {0, 0},
                            {1, 6}
                    };
                } else {
                    yield new int[][]{
                            {7, 7},
                            {1, 6}
                    };
                }
            }
            case PAWN -> {
                if (color == Color.WHITE) {
                    yield new int[][]{
                            {1, 1, 1, 1, 1, 1, 1, 1},
                            {0, 1, 2, 3, 4, 5, 6, 7}
                    };
                } else {
                    yield new int[][]{
                            {6, 6, 6, 6, 6, 6, 6, 6},
                            {0, 1, 2, 3, 4, 5, 6, 7}
                    };
                }
            }
        };
    }

    @Override
    public String toString() {
        return String.format("%s-%s on %s ||", this.type, this.color, currentCoordinates.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figures figures)) return false;
        return currentCoordinates.getRow() == figures.currentCoordinates.getRow() &&
                currentCoordinates.getColumn() == figures.currentCoordinates.getColumn() &&
                type == figures.type && color == figures.color && Arrays.equals(possibleMovements, figures.possibleMovements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type, color, currentCoordinates.getRow(), currentCoordinates.getColumn());
        result = 31 * result + Arrays.hashCode(possibleMovements);
        return result;
    }
}


