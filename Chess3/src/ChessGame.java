import java.util.Scanner;

public class ChessGame {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        board.initializeBoard();
        board.displayBoard();

        while (true) {
            System.out.println("Enter the position of the piece you want to move (e.g., 'a2'):");
            String input = scanner.nextLine();
            if (input.length() != 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            char column = input.charAt(0);
            char row = input.charAt(1);

            if (!isValidCoordinate(column, row)) {
                System.out.println("Invalid coordinate. Try again.");
                continue;
            }

            int rowIndex = Character.getNumericValue(row) - 1;
            int columnIndex = column - 'a';

            if (board.movePiece(rowIndex, columnIndex)) {
                board.displayBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static boolean isValidCoordinate(char column, char row) {
        return (column >= 'a' && column <= 'h' && row >= '1' && row <= '8');
    }
}
