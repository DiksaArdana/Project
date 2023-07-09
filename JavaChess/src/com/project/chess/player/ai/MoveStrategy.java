package com.project.chess.player.ai;

import com.project.chess.board.Board;
import com.project.chess.board.Move;

public interface MoveStrategy {
    Move execute(Board board);
}
