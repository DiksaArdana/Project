package com.project.chess.piece;

import com.google.common.collect.ImmutableList;
import com.project.chess.board.Board;
import com.project.chess.board.BoardUtils;
import com.project.chess.board.Move;
import com.project.chess.board.Tile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends Piece {
    private final static int[] CANDIDATE_MOVE_COORDINATE = {-9, -8,-7, -1, 1, 7, 8, 9};

    public King(final int piecePosition,final Alliance pieceAlliance) {
        super(PieceType.KING ,piecePosition, pieceAlliance,true);
    }
     public King(final int piecePosition,final Alliance pieceAlliance, final boolean isFirstMove) {
        super(PieceType.KING ,piecePosition, pieceAlliance,isFirstMove);
    }
    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList();
        
        for(final int currentCandidateOffset: CANDIDATE_MOVE_COORDINATE){
            final int canditateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            if(isFirstColoumExclusion(this.piecePosition, currentCandidateOffset)|| 
                        isEighthColoumExclusion(this.piecePosition, currentCandidateOffset)){
                    continue;
                }
            if(BoardUtils.isValidTileCoordinate(canditateDestinationCoordinate)){
                final Tile candidateDestinationTile = board.getTile(canditateDestinationCoordinate);
                
                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move.MajorMove(board,this,canditateDestinationCoordinate));
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
    public King movePiece(final Move move) {
        return new King(move.getDestinationCoordinate(), move.getMovedPiece().getPieceAlliance());
    }
    @Override
    public String toString() {
        return PieceType.KING.toString();
    }
    private static boolean isFirstColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.FIRST_COLUMN[currentPosition] &&(candidateOffset == -9 || candidateOffset == -1 ||
                candidateOffset == 7 );
    }
    private static boolean isEighthColoumExclusion(final int currentPosition, final int candidateOffset ){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] &&(candidateOffset == -7 || candidateOffset == 1 ||
                candidateOffset == 9);
    }
    
}
