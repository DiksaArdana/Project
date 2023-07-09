package com.project.chess.piece;

import com.google.common.collect.ImmutableList;
import com.project.chess.board.Board;
import com.project.chess.board.BoardUtils;
import com.project.chess.board.Move;
import com.project.chess.board.Move.AttackMove;
import com.project.chess.board.Move.MajorMove;
import com.project.chess.board.Tile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-17,-15,-10,-6,6,10,15,17};
    
    public Knight(final int piecePosition, final Alliance pieceAlliance) {
        super(PieceType.KNIGHT ,piecePosition, pieceAlliance, true);
    }
    public Knight(final int piecePosition, final Alliance pieceAlliance, final boolean isFirstMove) {
        super(PieceType.KNIGHT ,piecePosition, pieceAlliance, isFirstMove);
    }
    
    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList();
        
        for(final int currentCandidateOffset: CANDIDATE_MOVE_COORDINATE){
            final int canditateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            
            if(BoardUtils.isValidTileCoordinate(canditateDestinationCoordinate)){
                final Tile candidateDestinationTile = board.getTile(canditateDestinationCoordinate);
                if(isFirstColoumExclusion(this.piecePosition, currentCandidateOffset)|| 
                        isSecondColoumExclusion(this.piecePosition, currentCandidateOffset)||
                        isSeventhColoumExclusion(this.piecePosition, currentCandidateOffset)|| 
                        isEighthColoumExclusion(this.piecePosition, currentCandidateOffset)){
                    continue;
                }
                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board,this,canditateDestinationCoordinate));
                }else{
                    final Piece pieceDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceDestination.getPieceAlliance();
                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move.MajorAttackMove(board,this,canditateDestinationCoordinate, pieceDestination));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
    @Override
    public Knight movePiece(final Move move) {
        return new Knight(move.getDestinationCoordinate(), move.getMovedPiece().getPieceAlliance());
    }
    @Override
    public String toString() {
        return PieceType.KNIGHT.toString();
    }
    private static boolean isFirstColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.FIRST_COLUMN[currentPosition] &&(candidateOffset == -17 || candidateOffset == -10 ||
                candidateOffset == 6 || candidateOffset ==15);
    }
    private static boolean isSecondColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.SECOND_COLUMN[currentPosition] &&(candidateOffset == -10 || candidateOffset == 6);
    }
    private static boolean isSeventhColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.SEVENTH_COLUMN[currentPosition] &&(candidateOffset == -6 || candidateOffset == 10);
    }
    private static boolean isEighthColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] &&(candidateOffset == -15 || candidateOffset == -6 ||
                candidateOffset == 10 || candidateOffset == 17);
    }
  
}
