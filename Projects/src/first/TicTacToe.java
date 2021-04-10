package first;

import java.util.Scanner;

public class TicTacToe {
	
	public static String tictactoeboard[][] = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
	public static int shapeTracker = 1;
	
	public static void main(String[] args) {
		System.out.println("Hello victim! Today we will be playing a game of Tic-Tac-Toe! You vs me. You will be o and I will be x. Please choose the row and column separated by a comma.");
		System.out.println("  |   |  \n----------\n  |   |  \n----------\n  |   |  ");
		
		Scanner scanner = new Scanner(System.in);
		
		while(detectIfWon(tictactoeboard) >= 2) {
			if(shapeChooser(true) == 1) {
				System.out.println("It is Player o's turn.");
			}
			else {
				System.out.println("It is Player x's turn");
			}
			
			String choice = scanner.nextLine();
			System.out.println(outputBoard(choice));
		}
			
		if(detectIfWon(tictactoeboard) == 1 && shapeChooser(false) == 1) {
			System.out.println("O has won the game! Now back to the dungeon you go.");
			scanner.close();
		}
		else if(detectIfWon(tictactoeboard) == 1 && shapeChooser(false) == 2) {
			System.out.println("X has won the game! Now back to the dungeon you go.");
			scanner.close();
		}
		else if(detectIfWon(tictactoeboard) == 0) {
			System.out.println("It is a draw! No one wins. Okay now back to the dungeon you go.");
			scanner.close();
		}
		
	}
	
	public static int shapeChooser(boolean flag) {  
		int value;
		if (flag) shapeTracker++;
		if(shapeTracker % 2 == 0) value = 1;
		else value = 2;
		return value;
	}
	
	public static String outputBoard(String arrayLocations) {
		char colChar = arrayLocations.charAt(0);
		char rowChar = arrayLocations.charAt(2);
		
		int col = Character.getNumericValue(colChar);
		int row = Character.getNumericValue(rowChar);
		
		try {
			if(shapeChooser(false) == 1) {
			tictactoeboard[col - 1][row - 1] = "o";
			}
			else {
				tictactoeboard[col - 1][row - 1] = "x";
			}
		} catch(Exception e) {
			return "Incorrect location, your turn is skipped!";
		}
		
		
		String firstRow = tictactoeboard[0][0] + "|" + tictactoeboard[0][1] + "|" + tictactoeboard[0][2];
		String line = "-----";
		String secondRow = tictactoeboard[1][0] + "|" + tictactoeboard[1][1] + "|" + tictactoeboard[1][2];
		String thirdRow = tictactoeboard[2][0] + "|" + tictactoeboard[2][1] + "|" + tictactoeboard[2][2];
		String board = firstRow + "\n" + line + "\n" + secondRow + "\n" +  line + "\n" + thirdRow;
		
		return board;
	}
	
	public static int detectIfWon(String[][] board) {
		// 1 = win
		// 0 = draw
		int drawCheck = 0;
		if("o".equals(board[0][0]) && "o".equals(board[1][0]) && "o".equals(board[2][0])) {
			return 1; 
		}
		else if("x".equals(board[0][0]) && "x".equals(board[1][0]) && "x".equals(board[2][0])) {
			return 1; //1st column
		}
		else if("o".equals(board[0][1])  && "o".equals(board[1][1]) && "o".equals(board[2][1])) {
			return 1; 
		}
		else if("x".equals(board[0][1]) && "x".equals(board[1][1]) && "x".equals(board[2][1])) {
			return 1; //2nd column
		}
		else if("o".equals(board[0][2]) && "o".equals(board[1][2]) && "o".equals(board[2][2])) {
			return 1; 
		}
		else if("x".equals(board[0][2]) && "x".equals(board[1][2]) && "x".equals(board[2][2])) {
			return 1; //3rd column
		}
		else if("o".equals(board[0][0]) && "o".equals(board[0][1]) && "o".equals(board[0][2])) {
			return 1; 
		}
		else if("x".equals(board[0][0]) && "x".equals(board[0][1]) && "x".equals(board[0][2])) {
			return 1; //1st row
		}
		else if("o".equals(board[1][0]) && "o".equals(board[1][1]) && "o".equals(board[1][2])) {
			return 1; 
		}
		else if("x".equals(board[1][0]) && "x".equals(board[1][1]) && "x".equals(board[1][2])) {
			return 1; //2nd row
		}
		else if("o".equals(board[2][0]) && "o".equals(board[2][1]) && "o".equals(board[2][2])) {
			return 1; 
		}
		else if("x".equals(board[2][0]) && "x".equals(board[2][1]) && "x".equals(board[2][2])) {
			return 1; //3rd row
		}
		else if("o".equals(board[0][0]) && "o".equals(board[1][1]) && "o".equals(board[2][2])) {
			return 1; 
		}
		else if("x".equals(board[0][0]) && "x".equals(board[1][1]) && "x".equals(board[2][2])) {
			return 1; //left-right diagonal
		}
		else if("o".equals(board[0][2]) && "o".equals(board[1][1]) && "o".equals(board[2][0])) {
			return 1; 
		}
		else if("x".equals(board[0][2]) && "x".equals(board[1][1]) && "x".equals(board[2][0])) {
			return 1; //right-left diagonal
		}
		else {
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board[row].length; col++) {
					if(board[row][col] != " ") {
						drawCheck++;
					}
				}
			}
		}
			
		if(drawCheck == 9) {
			return 0;
		}
		return 69420;
	}
}