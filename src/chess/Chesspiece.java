package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class Chesspiece extends Piece {
	private Color color;
	private int moveCount;

	public Chesspiece() {
	}

	public Chesspiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	protected boolean isThereOpponentPiece(Position position) {
		Chesspiece p = (Chesspiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

	public Color getColor() {
		return color;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void increaseMoveCount() {
		moveCount++;
	}

	public void decreaseMoveCount() {
		moveCount--;
	}

	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

}
