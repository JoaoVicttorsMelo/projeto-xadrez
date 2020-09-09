package chess.pieces;

import boardgame.Board;
import chess.Chesspiece;
import chess.Color;

public class Rook extends Chesspiece {

	public Rook() {
	}

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

}
