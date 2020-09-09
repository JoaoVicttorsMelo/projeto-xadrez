package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public Chesspiece[][] getPieces() {
		Chesspiece[][] mat = new Chesspiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (Chesspiece) board.piece(i, j);
			}
		}
		return mat;
	}

	private void initialSetup() {
		board.PlacePiece(new Rook(board, Color.WHITE), new Position(4, 2));
		board.PlacePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.PlacePiece(new King(board, Color.WHITE), new Position(7, 4));
	}

}
