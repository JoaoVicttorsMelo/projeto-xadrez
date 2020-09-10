package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.Chesspiece;
import chess.Color;

public class Bishop extends Chesspiece {

	public Bishop() {
	}

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// NW

		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// NE

		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);

		}
		// SW

		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// SE

		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}

}
