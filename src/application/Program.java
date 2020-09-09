package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPosition;
import chess.Chesspiece;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			Chesspiece capturedPiece = chessMatch.performChessMove(source, target);
		}

	}

}
