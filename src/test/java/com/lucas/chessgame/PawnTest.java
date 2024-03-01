package com.lucas.chessgame;


import com.lucas.chessgame.enums.Type;
import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.models.figures.Figures;
import com.lucas.chessgame.models.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.lucas.chessgame.ChessBoard.whatStandsHere;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PawnTest {

    private Player player;
    private ChessBoard board;

    @BeforeEach
    void setUp() {
        player = new Player();
        board = new ChessBoard();
    }

    @Test
    public void canAddPawn() {

        Figures figurePawnWhite = whatStandsHere(1, 0);
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        Figures figurePawnBlack = whatStandsHere(6, 2);
        assertEquals(figurePawnBlack.getType(), Type.PAWN);
        assertEquals(figurePawnBlack.getColor(), Color.BLACK);

        Figures figureKingWhite = whatStandsHere(0, 4);
        assertEquals(figureKingWhite.getType(), Type.KING);
        assertEquals(figureKingWhite.getColor(), Color.WHITE);
    }

    @Test
    public void pawnCanMoveOneForward() {
        Figures figurePawnWhite = whatStandsHere(1, 0);
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        //first one forward move
        player.makeAMove("a2", "a3");
        Figures figurePawnWhiteAfterOneForward = whatStandsHere(2, 0);
        assertEquals(figurePawnWhiteAfterOneForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterOneForward.getColor(), Color.WHITE);

        //second one forward move
        player.makeAMove("a3", "a4");
        Figures figurePawnWhiteAfterSecondOneForward = whatStandsHere(3, 0);
        assertEquals(figurePawnWhiteAfterSecondOneForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterSecondOneForward.getColor(), Color.WHITE);

    }

    @Test
    public void pawnCanMoveTwoForwardOnFirstMove() {
        Figures figurePawnWhite = whatStandsHere(1, 0);
        assertEquals(figurePawnWhite.getType(), Type.PAWN);
        assertEquals(figurePawnWhite.getColor(), Color.WHITE);

        //first two forward move
        player.makeAMove("a2", "a4");
        Figures figurePawnWhiteAfterTwoForward = whatStandsHere(3, 0);
        assertEquals(figurePawnWhiteAfterTwoForward.getType(), Type.PAWN);
        assertEquals(figurePawnWhiteAfterTwoForward.getColor(), Color.WHITE);

        //second two forward move
        player.makeAMove("a4", "a6");
        Figures figurePawnWhiteAfterSecondTwoForward = whatStandsHere(5, 0);
        assertNull(figurePawnWhiteAfterSecondTwoForward);

    }

}
