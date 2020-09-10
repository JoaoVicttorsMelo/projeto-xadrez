package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;
import chess.Chesspiece;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<Chesspiece> list = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, list);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				Chesspiece capturedPiece = chessMatch.performChessMove(source, target);

				if (capturedPiece != null) {
					list.add(capturedPiece);
				}
				if (chessMatch.getPromotion() != null) {
					System.out.println("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine();
					while (!type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("N") && !type.equalsIgnoreCase("R")
							&& !type.equalsIgnoreCase("Q")) {

						System.out.println("INALID VALUE! Enter piece for promotion (B/N/R/Q): ");
						type = sc.nextLine();
					}
					chessMatch.ReplacePromotedPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (NullPointerException e) {
				System.out.println("There is no piece in source \nPress Enter");
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, list);

	}

}
