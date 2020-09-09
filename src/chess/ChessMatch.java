package chess;

import boardgame.Board;

public class ChessMatch {
	private Board board;
	

	public ChessMatch() {
		board= new Board(8,8);
	}
	public Chesspiece[][] getPieces(){
		Chesspiece[][] mat= new Chesspiece[board.getRows()][board.getColumns()];
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j]= (Chesspiece) board.piece(i,j);
			}
		}
		return mat;
	}
	

}
