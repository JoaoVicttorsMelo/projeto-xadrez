package chess.pieces;

import boardgame.Board;
import chess.Chesspiece;
import chess.Color;

public class King extends Chesspiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

}
