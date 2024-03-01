package com.lucas.chessgame;

import com.lucas.chessgame.models.players.Player;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Player player = new Player();

        System.out.println(board.printBoard());

        player.makeAMove("b2", "b4");
        System.out.println(board.printBoard());

        player.makeAMove("b4", "b5");
        System.out.println(board.printBoard());

        player.makeAMove("a7", "a6");
        System.out.println(board.printBoard());

        player.makeAMove("b5", "a6");
        System.out.println(board.printBoard());
    }
}
