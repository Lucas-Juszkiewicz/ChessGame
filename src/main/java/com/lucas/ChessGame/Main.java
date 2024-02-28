package com.lucas.ChessGame;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();

        System.out.println(board.printBoard());

        board.makeAMove("b2", "b4");
        System.out.println(board.printBoard());

        board.makeAMove("b4", "b5");
        System.out.println(board.printBoard());

        board.makeAMove("a7", "a6");
        System.out.println(board.printBoard());

        board.makeAMove("b5", "a6");
        System.out.println(board.printBoard());
    }
}
