package com.project.chess.board;
import com.google.common.collect.ImmutableMap;
import com.project.chess.piece.Piece;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPosibilityEmptyTile(); 

    public int getTileCoordinate() {
        return this.tileCoordinate;
    }
    
    private Tile(final int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }
    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }
    private static Map<Integer, EmptyTile> createAllPosibilityEmptyTile() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for(int i=0;i<=BoardUtils.NUM_TILES;i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }
    
    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();
    
    public static final class EmptyTile extends Tile{
        private EmptyTile(final int coordinate){
            super(coordinate);
        }
        @Override
        public String toString(){
            return "-";
        }
        @Override
        public boolean isTileOccupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    }
    
    public static final class OccupiedTile extends Tile{
        private final Piece placeOnTile;
        private OccupiedTile(int tileCoordinate,final Piece piece){
            super(tileCoordinate);
            this.placeOnTile = piece;
        }
        @Override
        public String toString(){
            return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() : getPiece().toString();
        }
        @Override
        public boolean isTileOccupied(){
            return true;
        }
        @Override
        public Piece getPiece(){
            return this.placeOnTile;
        }
    }
}
