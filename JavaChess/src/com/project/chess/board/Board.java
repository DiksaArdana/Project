package com.project.chess.board;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.project.chess.piece.Alliance;
import com.project.chess.piece.Bishop;
import com.project.chess.piece.King;
import com.project.chess.piece.Knight;
import com.project.chess.piece.Pawn;
import com.project.chess.piece.Piece;
import com.project.chess.piece.Queen;
import com.project.chess.piece.Rook;
import com.project.chess.player.BlackPlayer;
import com.project.chess.player.Player;
import com.project.chess.player.WhitePlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> gameBoard;
    private final Collection<Piece> whitePiece;
    private final Collection<Piece> blackPiece;
    
    private final WhitePlayer whitePlayer;
    private final BlackPlayer blackPlayer;   
    private final Player currentPlayer;
    private final Pawn enPassantPawn;
    
    private Board (final Builder builder){
        this.gameBoard = createGameBoard(builder);
        this.whitePiece = calculateActivePiece(this.gameBoard, Alliance.WHITE);
        this.blackPiece = calculateActivePiece(this.gameBoard, Alliance.BLACK);
        this.enPassantPawn = builder.enPassantPawn;
        final Collection<Move> whiteStandardLegalMove = calculateLegalMoves(this.whitePiece);
        final Collection<Move> blackStandardLegalMove = calculateLegalMoves(this.blackPiece);
        
        this.whitePlayer = new WhitePlayer(this,whiteStandardLegalMove, blackStandardLegalMove);
        this.blackPlayer = new BlackPlayer(this,whiteStandardLegalMove, blackStandardLegalMove);
        
        this.currentPlayer = builder.nextMoveMaker.choosePlayer(this.whitePlayer, this.blackPlayer);
    }
    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < BoardUtils.NUM_TILES; i++){
            final String tileText = this.gameBoard.get(i).toString();
            builder.append(String.format("%3s", tileText));
            if((i+1) % BoardUtils.NUM_TILES_PER_ROW == 0){
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public Collection<Piece> getWhitePiece() {
        return this.whitePiece;
    }

    public Collection<Piece> getBlackPiece() {
        return this.blackPiece;
    }

    public Player currentPlayer() {
        return this.currentPlayer;
    }

    public Player whitePlayer() {
        return this.whitePlayer;
    }

    public Player blackPlayer() {
        return this.blackPlayer;
    }

    public Pawn getEnPassantPawn() {
        return this.enPassantPawn;
    }
    
    private Collection<Move> calculateLegalMoves(final Collection<Piece> pieces){
        final List<Move> legalMoves = new ArrayList<>();
        for(final Piece piece : pieces){
            legalMoves.addAll(piece.calculateLegalMoves(this));
        }
        return ImmutableList.copyOf(legalMoves);
    }
    private static Collection<Piece> calculateActivePiece(final List<Tile> gameBoard, final Alliance alliance){
        final List<Piece> activePiece = new ArrayList<>();
        for(final Tile tile:gameBoard){
            if(tile.isTileOccupied()){
                final Piece piece = tile.getPiece();
                if(piece.getPieceAlliance() == alliance){
                    activePiece.add(piece);
                }
            }
        }
        return ImmutableList.copyOf(activePiece);
    }
    public Tile getTile(final int tileCoordinate){
        return gameBoard.get(tileCoordinate);
    }    
    private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles =new Tile[BoardUtils.NUM_TILES];
        for(int i = 0; i < BoardUtils.NUM_TILES;i++){
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }
    public static Board createStandardBoard(){
        final Builder builder = new Builder();
        builder.setPiece(new Rook(0, Alliance.BLACK));
        builder.setPiece(new Knight(1, Alliance.BLACK));
        builder.setPiece(new Bishop(2, Alliance.BLACK));
        builder.setPiece(new Queen(3, Alliance.BLACK));
        builder.setPiece(new King(4, Alliance.BLACK));
        builder.setPiece(new Bishop(5, Alliance.BLACK));
        builder.setPiece(new Knight(6, Alliance.BLACK));
        builder.setPiece(new Rook(7, Alliance.BLACK));
        builder.setPiece(new Pawn(8, Alliance.BLACK));
        builder.setPiece(new Pawn(9, Alliance.BLACK));
        builder.setPiece(new Pawn(10, Alliance.BLACK));
        builder.setPiece(new Pawn(11, Alliance.BLACK));
        builder.setPiece(new Pawn(12, Alliance.BLACK));
        builder.setPiece(new Pawn(13, Alliance.BLACK));
        builder.setPiece(new Pawn(14, Alliance.BLACK));
        builder.setPiece(new Pawn(15, Alliance.BLACK));
        
        builder.setPiece(new Pawn(48, Alliance.WHITE));
        builder.setPiece(new Pawn(49, Alliance.WHITE));
        builder.setPiece(new Pawn(50, Alliance.WHITE));
        builder.setPiece(new Pawn(51, Alliance.WHITE));
        builder.setPiece(new Pawn(52, Alliance.WHITE));
        builder.setPiece(new Pawn(53, Alliance.WHITE));
        builder.setPiece(new Pawn(54, Alliance.WHITE));
        builder.setPiece(new Pawn(55, Alliance.WHITE));
        builder.setPiece(new Rook(56, Alliance.WHITE));
        builder.setPiece(new Knight(57, Alliance.WHITE));
        builder.setPiece(new Bishop(58, Alliance.WHITE));
        builder.setPiece(new Queen(59, Alliance.WHITE));
        builder.setPiece(new King(60, Alliance.WHITE));
        builder.setPiece(new Bishop(61, Alliance.WHITE));
        builder.setPiece(new Knight(62, Alliance.WHITE));
        builder.setPiece(new Rook(63, Alliance.WHITE));
        //user able to move white
        builder.setMoveMaker(Alliance.WHITE);
        return builder.build();
    }
    public Iterable<Move> getAllLegalMoves(){
        return Iterables.unmodifiableIterable(Iterables.concat(this.whitePlayer.getLegalMoves(), this.blackPlayer.getLegalMoves()));
    }
    public static class Builder {
        Map<Integer, Piece> boardConfig;
        Alliance nextMoveMaker;
        Pawn enPassantPawn;
        
        public Builder(){
            this.boardConfig = new HashMap<>();
        }
        public Builder setPiece(final Piece piece){
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }
        public Builder setMoveMaker(final Alliance nextMoveMaker){
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }
        public Board build(){
            return new Board(this);
        }
        public void setEnPassantPawn(Pawn enPassantPawn) {
            this.enPassantPawn = enPassantPawn;
        }
        
    }
}
