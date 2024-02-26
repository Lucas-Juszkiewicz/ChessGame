package com.lucas.ChessGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void canAddPawn(){
        ChessBoard board = new ChessBoard();
        board.move("a2", "a3");
        assertEquals(board.whatStandsHere("a3"), Type.PAWN);
    }
}
