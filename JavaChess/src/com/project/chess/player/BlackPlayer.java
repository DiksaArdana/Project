
package com.project.chess.player;

import com.google.common.collect.ImmutableList;
import com.project.chess.board.Board;
import com.project.chess.board.Move;
import com.project.chess.board.Tile;
import com.project.chess.piece.Alliance;
import com.project.chess.piece.Piece;
import com.project.chess.piece.Rook;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlackPlayer extends Player{

    public BlackPlayer(final Board board, final Collection<Move> whiteStandardLegalMove, final Collection<Move> blackStandardLegalMove) {
        super(board, blackStandardLegalMove, whiteStandardLegalMove);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getBlackPiece();
    }

    @Override
    public Alliance getAlliance() {
        return Alliance.BLACK;
    }

    @Override
    public Player getOpponent() {
        return this.board.whitePlayer();
    }

    @Override
    protected Collection<Move> calculateKingCastles(final Collection<Move> playerLegals, final Collection<Move> opponentsLegals) {
        final List<Move> kingCastles = new ArrayList<>();
        if(this.playerKing.isFirstMove() && !this.isCheck()){
            if(!this.board.getTile(5).isTileOccupied() && !this.board.getTile(6).isTileOccupied()){
                final Tile rookTile = this.board.getTile(7);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()){
                    if(Player.calculateAttacksOnTile(5, opponentsLegals).isEmpty() &&
                            Player.calculateAttacksOnTile(6, opponentsLegals).isEmpty()&&
                            rookTile.getPiece().getPieceType().isRook()){
                        kingCastles.add(new Move.KingSideCastleMove(this.board, this.playerKing, 6, (Rook)rookTile.getPiece(), rookTile.getTileCoordinate(), 5));
                    }
                }
            }
            if(!this.board.getTile(1).isTileOccupied()&&
                    !this.board.getTile(2).isTileOccupied()&&
                    !this.board.getTile(3).isTileOccupied()){
                final Tile rookTile = this.board.getTile(0);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()&& 
                        Player.calculateAttacksOnTile(2, opponentsLegals).isEmpty()&&
                        Player.calculateAttacksOnTile(3, opponentsLegals).isEmpty()&&
                        rookTile.getPiece().getPieceType().isRook()){
                    kingCastles.add(new Move.QueenSideCastleMove(this.board, this.playerKing, 2, (Rook)rookTile.getPiece(), rookTile.getTileCoordinate(), 3));
                }
            }
        }
        return ImmutableList.copyOf(kingCastles);
    }
    
}
