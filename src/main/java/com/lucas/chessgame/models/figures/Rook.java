package com.lucas.chessgame.models.figures;

import com.lucas.chessgame.enums.Color;
import com.lucas.chessgame.enums.Type;

public class Rook extends Figures {
    public Rook(Type type, Color color) {
        super(type, color);
    }

    @Override
    protected void setPossibleMovements(String coordinates) {

    }
}


