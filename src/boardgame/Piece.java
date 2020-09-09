package boardgame;

public class Piece {
protected Position postion;
private Board board;
	public Piece() {
	}
	public Piece(Board board) {
		this.board = board;
	}
	protected Board getBoard() {
		return board;
	}
	

	
}
