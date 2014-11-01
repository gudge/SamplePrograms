import java.util.ArrayList;
import java.util.Scanner;

class Player {
	final static int PAWN1 = 1;
	final static int PAWN2 = 2;
	final static int KNIGHT1 = 3;
	final static int KNIGHT2 = 4;
}

class Solution {
	private static void dumpLine(final int row, final int col, final String msg, final String l) {
		System.out.println();
		System.out.println("row " + row + " " + " col " + col);
		System.out.println(msg);
		System.out.println("line = " + l);
	}
	private static boolean  checkInputLine (Scanner sc, final int row, String l) {
		final int len = l.length();
		final char outsideBox = 'x';
		if (len != 12) {
			dumpLine(0, 0, "Wrong formatted input", l);
			sc.close();
			return false;
		}
		if (row == 3 || row == 14) {
			if (l.charAt(0) != outsideBox && l.charAt(11) != outsideBox) {
				dumpLine(row, -1, "Illegal Squares 1", l);
				sc.close();
				return false;
			}
			for (int i = 1; i < len - 1; i++) {
				if (l.charAt(i) == 'X') {
					dumpLine(row, i, "Illegal Sqaures 2", l);
					sc.close();
					return false;
				}
			}
		} else if (row == 2 || row == 15) {
			if (l.charAt(0) != outsideBox && l.charAt(1) != outsideBox
					&& l.charAt(11) != outsideBox && l.charAt(10) != outsideBox) {
				dumpLine(row, -3, "Illegal Sqaures 3", l);
				sc.close();
				return false;
			}
			for (int i = 1; i < len - 2; i++) {
				if (l.charAt(i) == 'X') {
					dumpLine(row, i , "Illegal Sqaures 4", l);
					sc.close();
					return false;
				}
			}
			return true;
		} else if (row == 1 || row == 16) {
			if (l.charAt(5) == outsideBox || l.charAt(6) == outsideBox) {
				dumpLine(row, -5, "Illegal Squares 5", l);
				sc.close();
				return false;
			}
			for (int i = 0; i < len; i++) {
				if (i == 5 || i == 6) {
					continue;
				}
				if (l.charAt(i) != outsideBox) {
					dumpLine(row, i, "Illegal Squares 6", l);
					sc.close();
					return false;
				}
			}
			return true;
		} else {
			for (int i = 0; i < len; i++) {
				if (l.charAt(i) == outsideBox) {
					dumpLine(row, i, "Illegal Squares 7", l);
					sc.close();
					return false;
				}
			}
		}
		return true;
	}
	private static boolean skipCell(int row, int col, String l) {
		if (row == 3 || row == 14) {
			if (col == 1 || col == 12)
				return true;
		} else if (row == 2 || row == 15) {
			if (col == 1 || col == 2 || col == 12 || col == 11)
				return true;
		} else if (row == 1 || row == 16) {
			if (!(col == 6 || col == 7))
				return true;
		}
		if (l.charAt(col - 1) == '-')
			return true;
		char value = l.charAt(col-1);
		if (!(value == 's' || value == 'S' || value == 'h' || value == 'H')) {
			dumpLine(row, col, "Wrong input 12", l);
			System.out.println(value);
			return true;
		}
		return false;
	}
	private static int getCell(char value) {
		switch (value) {
		case 'S':
			return Player.PAWN1;
		case 's':
			return Player.PAWN2;
		case 'H':
			return Player.KNIGHT1;
		}
		return Player.KNIGHT2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.nextLine();
		if (l.length() != 1) {
			dumpLine(-1, -1, "Wrong Input 1", l);
			sc.close();
			return;
		}
		final int startingPiece = Integer.parseInt(l);
		if (!(startingPiece == 1 || startingPiece == 2)) {
			dumpLine(-2, -2, "Wrong starting player", l);
			sc.close();
			return;
		}
		//boolean startingPlayer = startingPiece == 1 ? true : false;
		while (true) {
			for (int row = 1; row <= 16; row++) {
				l = sc.nextLine();
				if (!checkInputLine(sc, row, l)) {
					return;
				}
				int[][] board = new int[16][10];
				for (int col = 1; col <= 12; col++) {
					if (skipCell(row, col, l))
						continue;
					char value = l.charAt(col - 1);
//					boolean startingPlayer2 = value == 'S' || value == 'H' ? true : false;
//					boolean pawn = value == 's' || value == 'h' ? true : false;
					board[row - 1][col - 1] = getCell(value); 
				}
			}
			System.out.println("Things fine");
			break;
		}
		sc.close();
	}
}