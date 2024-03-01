package com.lucas.chessgame.models.figures;



import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;

import java.util.Arrays;
import java.util.Objects;

public abstract class Figures {
    protected final Type type;
    protected final Color color;
    protected int currentRow;
    protected int currentColumn;
    protected String[] possibleMovements;

    protected Figures(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
        setPossibleMovements();
    }

    protected abstract void setPossibleMovements();

    public String[] getPossibleMovements() {
        return this.possibleMovements;
    }

    //    Conversion from numbers to coordinates from the game board
    protected String convertToChessboardCoordinates(int rowNumber, int columnNumber) {
        int numberOfTheColumnChar = columnNumber + 97;
        char actualColumnLetter = (char) numberOfTheColumnChar;
        int actualRow = rowNumber + 1;
        return String.format("%s%d", actualColumnLetter, actualRow);
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
        return String.format("%s-%s on %s ||", this.type, this.color, convertToChessboardCoordinates(getCurrentRow(), getCurrentColumn()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figures figures)) return false;
        return currentRow == figures.currentRow && currentColumn == figures.currentColumn && type == figures.type && color == figures.color && Arrays.equals(possibleMovements, figures.possibleMovements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type, color, currentRow, currentColumn);
        result = 31 * result + Arrays.hashCode(possibleMovements);
        return result;
    }
}


