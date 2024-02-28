package com.lucas.ChessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PawnTest {

    private ChessBoard board;

    @BeforeEach
    void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void canAddPawn() {

        Figures figurePawnWhite = board.whatStandsHere("a2");
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        Figures figurePawnBlack = board.whatStandsHere("c7");
        assertEquals(figurePawnBlack.getType(), Type.PAWN);
        assertEquals(figurePawnBlack.getColor(), Color.BLACK);

        Figures figureKingWhite = board.whatStandsHere("e1");
        assertEquals(figureKingWhite.getType(), Type.KING);
        assertEquals(figureKingWhite.getColor(), Color.WHITE);
    }

    @Test
    public void pawnCanMoveOneForward() {
        Figures figurePawnWhite = board.whatStandsHere("a2");
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        //first one forward move
        board.makeAMove("a2", "a3");
        Figures figurePawnWhiteAfterOneForward = board.whatStandsHere("a3");
        assertEquals(figurePawnWhiteAfterOneForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterOneForward.getColor(), Color.WHITE);

        //second one forward move
        board.makeAMove("a3", "a4");
        Figures figurePawnWhiteAfterSecondOneForward = board.whatStandsHere("a4");
        assertEquals(figurePawnWhiteAfterSecondOneForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterSecondOneForward.getColor(), Color.WHITE);

    }

    @Test
    public void pawnCanMoveTwoForwardOnFirstMove() {
        Figures figurePawnWhite = board.whatStandsHere("a2");
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        //first two forward move
        board.makeAMove("a2", "a4");
        Figures figurePawnWhiteAfterTwoForward = board.whatStandsHere("a4");
        assertEquals(figurePawnWhiteAfterTwoForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterTwoForward.getColor(), Color.WHITE);

        //second two forward move
        board.makeAMove("a4", "a6");
        Figures figurePawnWhiteAfterSecondTwoForward = board.whatStandsHere("a6");
        assertNull(figurePawnWhiteAfterSecondTwoForward);

    }

}
