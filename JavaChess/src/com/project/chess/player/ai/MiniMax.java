package com.project.chess.player.ai;

import com.project.chess.board.Board;
import com.project.chess.board.Move;
import com.project.chess.player.MoveTransition;


public class MiniMax implements MoveStrategy {
    private final BoardEvaluator boardEvaluator;
    private final int searchDepth;
    public MiniMax(final int searchDepth) {
        this.boardEvaluator = new StandardBoardEvaluator();
        this.searchDepth = searchDepth;
    }
    @Override
    public String toString() {
        return "MiniMax";
    }   
    @Override
    public Move execute(Board board) {
        final long starttime = System.currentTimeMillis();
        Move bestMove = null;
        int highestSeenvalue = Integer.MIN_VALUE;
        int lowestSeenValue = Integer.MAX_VALUE;
        int currentValue;
        System.out.println(board.currentPlayer() + " Thinking with depth: "+this.searchDepth);
        int numMoves = board.currentPlayer().getLegalMoves().size();
        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                currentValue = board.currentPlayer().getAlliance().isWhite() ?
                        min(moveTransition.getTransititonBoard(), this.searchDepth -1):
                        max(moveTransition.getTransititonBoard(), this.searchDepth -1);
                if(board.currentPlayer().getAlliance().isWhite() && currentValue >= highestSeenvalue){
                    highestSeenvalue = currentValue;
                    bestMove = move;
                }else if(board.currentPlayer().getAlliance().isBlack() && currentValue <= lowestSeenValue){
                    lowestSeenValue = currentValue;
                    bestMove = move;
                }
            }
        }
        final long executeTime = System.currentTimeMillis() - starttime;
        return bestMove;
    }
    
    public int min(final Board board,final int depth){
        if(depth == 0 || isEndGameScenario(board)){
            return this.boardEvaluator.evaluate(board, depth);
        }
        int lowestSeenValue = Integer.MAX_VALUE;
        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                final int currentValue = max(moveTransition.getTransititonBoard(),depth -1);
                if(currentValue <= lowestSeenValue){
                    lowestSeenValue = currentValue;
                }
            }
        }
        return lowestSeenValue;
    }
    private static boolean isEndGameScenario(final Board board){
        return board.currentPlayer().isCheckMate() |
                board.currentPlayer().isInStaleMate();
    }
    public int max(final Board board,final int depth){
        if(depth == 0 || isEndGameScenario(board)){
            return this.boardEvaluator.evaluate(board, depth);
        }
        int highestSeenValue = Integer.MIN_VALUE;
        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                final int currentValue = min(moveTransition.getTransititonBoard(),depth -1);
                if(currentValue >= highestSeenValue){
                    highestSeenValue = currentValue;
                }
            }
        }
        return highestSeenValue;
    }
    
}
