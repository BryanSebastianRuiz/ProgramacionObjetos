import java.util.Scanner;

public class ChessBoard {
    private char[][] board = new char[8][8];
    private static final char[] pieceSymbols = {'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'};
    private static final char[] pawnSymbols = {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};

    public ChessBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        // Set up the board with pieces in their initial positions
        for (int i = 0; i < 8; i++) {
            board[0][i] = pieceSymbols[i];
            board[1][i] = pawnSymbols[i]; // White pawns
            board[6][i] = Character.toLowerCase(pawnSymbols[i]); // Black pawns
            board[7][i] = pieceSymbols[i];
        }
    }

    public void printBoard() {
        // Print the board to the console
        System.out.println("  +------------------------+");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " | ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +------------------------+");
        System.out.println("    a  b  c  d  e  f  g  h");
    }

    public boolean makeMove(String move) {
        if (!move.matches("[a-h][1-8]-[a-h][1-8]")) {
            System.out.println("Invalid move.");
            return false;
        }

        int startX = move.charAt(0) - 'a';
        int startY = '8' - move.charAt(1);
        int endX = move.charAt(3) - 'a';
        int endY = '8' - move.charAt(4);

        char piece = board[startY][startX];
        char targetPiece = board[endY][endX];

        if (!ChessRules.isValidMove(piece, startX, startY, endX, endY, targetPiece)) {
            System.out.println("Invalid move according to chess rules.");
            return false;
        }

        board[startY][startX] = ' ';
        board[endY][endX] = piece;

        return true;
    }

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
