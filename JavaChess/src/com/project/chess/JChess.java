package com.project.chess;

import com.project.chess.board.Board;
import com.project.chess.gui.Table;


public class JChess {
    public static void main(String[] args) {
        Board board = Board.createStandardBoard();
        System.out.println(board);
        Table.get().show();
    }
}
