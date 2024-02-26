package com.lucas.ChessGame;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.boardSetUp();
        System.out.println(board.printBoard());
    }
}
