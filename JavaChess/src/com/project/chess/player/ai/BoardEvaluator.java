
package com.project.chess.player.ai;

import com.project.chess.board.Board;

public interface BoardEvaluator {
    int evaluate(Board board, int depth);
}
