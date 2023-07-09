package com.project.chess.player.ai;

import com.project.chess.board.Board;
import com.project.chess.piece.Piece;
import com.project.chess.player.Player;

public final class StandardBoardEvaluator implements BoardEvaluator {
    private static final int CHECK_BONUS = 50;
    private static final int CHECK_MATE_BONUS = 10000;
    private static final int DEPTH_BONUS = 100;
    private static final int CASTLE_BONUS = 60;

    
    @Override
    public int evaluate(final Board board, int depth) {
        return scorePlayer(board, board.whitePlayer(), depth)-
                scorePlayer(board, board.blackPlayer(), depth);
    }

    private int scorePlayer(final Board board,final Player player,final int depth) {
        return pieceValue(player) + mobility(player) + check(player) + checkMate(player,depth)+ castle(player);
    }
    private static int mobility(final Player player) {
        return player.getLegalMoves().size();
    }
    private static int check(Player player) {
        return player.getOpponent().isCheck() ? CHECK_BONUS : 0;
    }
    private static int checkMate(Player player, int depth) {
        return player.getOpponent().isCheck() ? CHECK_MATE_BONUS * depthBonus(depth) : 0;
    }
    private static int depthBonus(int depth) {
        return depth == 0 ? 1 : DEPTH_BONUS * depth;
    }
    private static int castle(Player player) {
        return player.getOpponent().isCheck() ? CASTLE_BONUS : 0;
    }
    private static int pieceValue(final Player player) {
        int pieceValueScore = 0;
        for(final Piece piece : player.getActivePieces()){
            pieceValueScore += piece.getPieceValue();
        }
        return pieceValueScore;
    }

    


    
}
