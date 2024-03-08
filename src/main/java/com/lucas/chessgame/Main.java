package com.lucas.chessgame;

import com.lucas.chessgame.models.players.Player;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Player player = new Player();

        System.out.println(board.printBoard());

        player.makeAMove(new Coordinates("b2"), new Coordinates("b4"));
        System.out.println(board.printBoard());

        player.makeAMove(new Coordinates("b4"), new Coordinates("b5"));
        System.out.println(board.printBoard());

        player.makeAMove(new Coordinates("a7"), new Coordinates("a6"));
        System.out.println(board.printBoard());

        player.makeAMove(new Coordinates("b5"), new Coordinates("a6"));
        System.out.println(board.printBoard());
    }
}
