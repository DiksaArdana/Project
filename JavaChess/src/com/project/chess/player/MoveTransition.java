package com.project.chess.player;

import com.project.chess.board.Board;
import com.project.chess.board.Move;


public class MoveTransition {
    private final Board transititonBoard;
    private final Move move;
    private final MoveStatus movestatus;

    public MoveTransition(final Board transititonBoard,final Move move,final MoveStatus movestatus) {
        this.transititonBoard = transititonBoard;
        this.move = move;
        this.movestatus = movestatus;
    }
    public MoveStatus getMoveStatus(){
        return this.movestatus;
    }

    public Board getTransititonBoard() {
        return this.transititonBoard;
    }
    
}
