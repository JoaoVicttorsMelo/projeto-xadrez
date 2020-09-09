package chess;

import boardgame.Board;
import boardgame.Piece;

public class Chesspiece extends Piece{
	private Color color;
	
	public Chesspiece() {
	}

	public Chesspiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	

}
