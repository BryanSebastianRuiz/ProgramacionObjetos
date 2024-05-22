public class ChessBoard {
    private char[][] board = new char[8][8];
    private static final char[] pieceSymbols = {'♖', '♘', '♗', '♕', '♔', '♗', '♘', '♖'};
    private static final char[] pawnSymbols = {'♙', '♙', '♙', '♙', '♙', '♙', '♙', '♙'};

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
        System.out.println("   a  b  c  d  e  f  g  h");
        System.out.println("  -------------------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + "| ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|" + (8 - i));
        }
        System.out.println("  -------------------------");
        System.out.println("   a  b  c  d  e  f  g  h");
    }

    public char getPieceAtPosition(String position) {
        int x = position.charAt(0) - 'a';
        int y = '8' - position.charAt(1);
        return board[y][x];
    }

    @SuppressWarnings("unused")
	public boolean movePiece(String move) {
        int startX = move.charAt(0) - 'a';
        int startY = '8' - move.charAt(1);
        int endX = move.charAt(3) - 'a';
        int endY = '8' - move.charAt(4);

        char piece = board[startY][startX];
        if (!ChessRules.isValidMove(board, move)) {
            System.out.println("Invalid move according to chess rules.");
            return false;
        }

        board[startY][startX] = ' ';
        board[endY][endX] = piece;
        return true;
    }
}
