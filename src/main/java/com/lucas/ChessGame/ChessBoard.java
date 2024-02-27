package com.lucas.ChessGame;

public class ChessBoard {

    Figures[][] boardArray = new Figures[8][8];

    public ChessBoard() {

    }

    public void makeAMove(String startCoordinates, String endCoordinates) {
        Figures figure = whatStandsHere(startCoordinates);
        for (String possibleMove : figure.getPossibleMovements()) {
            if (checkIfTheMoveIsValid(figure, endCoordinates)) {
                if (possibleMove.equals(endCoordinates)) {
                    int endRow = getRow(endCoordinates);
                    int endColumn = getColumn(endCoordinates);
                    boardArray[endRow][endColumn] = figure;
                    figure.setCurrentPosition(endCoordinates);

                    int startRow = getRow(startCoordinates);
                    int startColumn = getColumn(startCoordinates);
                    boardArray[startRow][startColumn] = null;

                    System.out.printf("\n Valid move %s -> %s == %s\n", startCoordinates, endCoordinates, possibleMove);
                }
            }
        }

    }

    private boolean checkIfTheMoveIsValid(Figures figure, String endCoordinates) {
        int row = getRow(endCoordinates);
        int column = getColumn(endCoordinates);
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

    public void boardSetUp() {

        //white Pawns
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Type.PAWN, Color.WHITE);
            int row = getRow(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            int column = getColumn(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            pawn.setCurrentPosition(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            this.boardArray[row][column] = pawn;
        }

        //black Pawns
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Type.PAWN, Color.BLACK);
            int row = getRow(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            int column = getColumn(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            pawn.setCurrentPosition(getStartPosition(pawn.getType(), pawn.getColor(), boardArray));
            this.boardArray[row][column] = pawn;
        }

        //white King
        for (int i = 0; i < 1; i++) {
            King king = new King(Type.KING, Color.WHITE);
            int row = getRow(getStartPosition(king.getType(), king.getColor(), boardArray));
            int column = getColumn(getStartPosition(king.getType(), king.getColor(), boardArray));
            king.setCurrentPosition(getStartPosition(king.getType(), king.getColor(), boardArray));
            this.boardArray[row][column] = king;
        }

        //black King
        for (int i = 0; i < 1; i++) {
            King king = new King(Type.KING, Color.BLACK);
            int row = getRow(getStartPosition(king.getType(), king.getColor(), boardArray));
            int column = getColumn(getStartPosition(king.getType(), king.getColor(), boardArray));
            king.setCurrentPosition(getStartPosition(king.getType(), king.getColor(), boardArray));
            this.boardArray[row][column] = king;
        }

        //white Queen
        for (int i = 0; i < 1; i++) {
            Queen queen = new Queen(Type.QUEEN, Color.WHITE);
            int row = getRow(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            int column = getColumn(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            queen.setCurrentPosition(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            this.boardArray[row][column] = queen;
        }

        //black Queen
        for (int i = 0; i < 1; i++) {
            Queen queen = new Queen(Type.QUEEN, Color.BLACK);
            int row = getRow(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            int column = getColumn(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            queen.setCurrentPosition(getStartPosition(queen.getType(), queen.getColor(), boardArray));
            this.boardArray[row][column] = queen;
        }
        //white Rooks
        for (int i = 0; i < 2; i++) {
            Rook rook = new Rook(Type.ROOK, Color.WHITE);
            int row = getRow(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            int column = getColumn(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            rook.setCurrentPosition(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            this.boardArray[row][column] = rook;
        }

        //black Rooks
        for (int i = 0; i < 2; i++) {
            Rook rook = new Rook(Type.ROOK, Color.BLACK);
            int row = getRow(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            int column = getColumn(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            rook.setCurrentPosition(getStartPosition(rook.getType(), rook.getColor(), boardArray));
            this.boardArray[row][column] = rook;
        }

        //white Bishops
        for (int i = 0; i < 2; i++) {
            Bishop bishop = new Bishop(Type.BISHOP, Color.WHITE);
            int row = getRow(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            int column = getColumn(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            bishop.setCurrentPosition(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            this.boardArray[row][column] = bishop;
        }

        //black Bishops
        for (int i = 0; i < 2; i++) {
            Bishop bishop = new Bishop(Type.BISHOP, Color.BLACK);
            int row = getRow(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            int column = getColumn(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            bishop.setCurrentPosition(getStartPosition(bishop.getType(), bishop.getColor(), boardArray));
            this.boardArray[row][column] = bishop;
        }

        //white Knights
        for (int i = 0; i < 2; i++) {
            Knight knight = new Knight(Type.KNIGHT, Color.WHITE);
            int row = getRow(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            int column = getColumn(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            knight.setCurrentPosition(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            this.boardArray[row][column] = knight;
        }

        //black Knights
        for (int i = 0; i < 2; i++) {
            Knight knight = new Knight(Type.KNIGHT, Color.BLACK);
            int row = getRow(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            int column = getColumn(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            knight.setCurrentPosition(getStartPosition(knight.getType(), knight.getColor(), boardArray));
            this.boardArray[row][column] = knight;
        }
    }

    public Figures whatStandsHere(String coordinates) {
        return boardArray[getRow(coordinates)][getColumn(coordinates)];
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

    public String getStartPosition(Type type, Color color, Figures[][] boardArray) {
        return switch (type) {
            case KING -> color.toString().equals("WHITE") ? "e1" : "e8";
            case QUEEN -> color.toString().equals("WHITE") ? "d1" : "d8";
            case ROOK -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("a1") == null) {
                        yield "a1";
                    } else if (whatStandsHere("h1") == null) {
                        yield "h1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("a8") == null) {
                        yield "a8";
                    } else if (whatStandsHere("h8") == null) {
                        yield "h8";
                    } else {
                        yield null;
                    }
                }
            }
            case KNIGHT -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("b1") == null) {
                        yield "b1";
                    } else if (whatStandsHere("g1") == null) {
                        yield "g1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("b8") == null) {
                        yield "b8";
                    } else if (whatStandsHere("g8") == null) {
                        yield "g8";
                    } else {
                        yield null;
                    }
                }
            }
            case BISHOP -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("c1") == null) {
                        yield "c1";
                    } else if (whatStandsHere("f1") == null) {
                        yield "f1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("c8") == null) {
                        yield "c8";
                    } else if (whatStandsHere("f8") == null) {
                        yield "f8";
                    } else {
                        yield null;
                    }
                }
            }
            case PAWN -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("a2") == null) {
                        yield "a2";
                    } else if (whatStandsHere("b2") == null) {
                        yield "b2";
                    } else if (whatStandsHere("c2") == null) {
                        yield "c2";
                    } else if (whatStandsHere("d2") == null) {
                        yield "d2";
                    } else if (whatStandsHere("e2") == null) {
                        yield "e2";
                    } else if (whatStandsHere("f2") == null) {
                        yield "f2";
                    } else if (whatStandsHere("g2") == null) {
                        yield "g2";
                    } else if (whatStandsHere("h2") == null) {
                        yield "h2";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("a7") == null) {
                        yield "a7";
                    } else if (whatStandsHere("b7") == null) {
                        yield "b7";
                    } else if (whatStandsHere("c7") == null) {
                        yield "c7";
                    } else if (whatStandsHere("d7") == null) {
                        yield "d7";
                    } else if (whatStandsHere("e7") == null) {
                        yield "e7";
                    } else if (whatStandsHere("f7") == null) {
                        yield "f7";
                    } else if (whatStandsHere("g7") == null) {
                        yield "g7";
                    } else if (whatStandsHere("h7") == null) {
                        yield "h7";
                    } else {
                        yield null;
                    }
                }
            }
        };
    }
}
