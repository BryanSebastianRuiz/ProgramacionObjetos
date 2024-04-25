import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.printBoard();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Select the piece you want to move (e.g., e2): ");
                String startPos = scanner.nextLine();
                System.out.print("Enter the destination for the selected piece (e.g., e4): ");
                String endPos = scanner.nextLine();

                String move = startPos + "-" + endPos;

                if (board.makeMove(move)) {
                    board.printBoard();
                } else {
                    System.out.println("Try again.");
                }
            }
        }
    }
}
