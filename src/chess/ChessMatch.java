package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentPlayer;

	public ChessMatch() {
		board = new Board(8, 8);
		turn=1;
		currentPlayer= Color.WHITE;
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

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public Chesspiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (Chesspiece) capturedPiece;

	}

	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can´t move to target position");
		}
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.PlacePiece(p, target);
		return capturedPiece;

	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		return board.piece(position).possibleMoves();

	}

	private void validateSourcePosition(Position position) {
		if (!board.ThereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (currentPlayer != ((Chesspiece) board.piece(position)).getColor()) {
			throw new ChessException("the chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("there is no possible  moves for the chosen piece");
		}
	}

	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;

	}

	private void placeNewPiece(char column, int row, Chesspiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
