public class ChessRules {
    public static boolean isValidMove(char[][] board, String move) {
        if (!move.matches("[a-h][1-8]-[a-h][1-8]")) {
            return false;
        }

        int startX = move.charAt(0) - 'a';
        int startY = '8' - move.charAt(1);
        int endX = move.charAt(3) - 'a';
        int endY = '8' - move.charAt(4);

        char piece = board[startY][startX];
        char targetPiece = board[endY][endX];

        switch (Character.toLowerCase(piece)) {
            case 'p':
                return isValidPawnMove(board, startX, startY, endX, endY, targetPiece);
            case 'r':
                return isValidRookMove(board, startX, startY, endX, endY);
            case 'n':
                return isValidKnightMove(board, startX, startY, endX, endY);
            case 'b':
                return isValidBishopMove(board, startX, startY, endX, endY);
            case 'q':
                return isValidQueenMove(board, startX, startY, endX, endY);
            case 'k':
                return isValidKingMove(board, startX, startY, endX, endY);
            default:
                return false;
        }
    }

    private static boolean isValidPawnMove(char[][] board, int startX, int startY, int endX, int endY, char targetPiece) {
        // Implement pawn movement logic
        // This is a basic example and does not include captures, double move, etc.
        return (startY == endY - 1 && startX == endX && targetPiece == ' ') ||
               (startY == endY - 1 && Math.abs(startX - endX) == 1 && Character.isLowerCase(targetPiece));
    }

    private static boolean isValidRookMove(char[][] board, int startX, int startY, int endX, int endY) {
        // Implement rook movement logic
        return startX == endX || startY == endY;
    }

    private static boolean isValidKnightMove(char[][] board, int startX, int startY, int endX, int endY) {
        // Implement knight movement logic
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }

    private static boolean isValidBishopMove(char[][] board, int startX, int startY, int endX, int endY) {
        // Implement bishop movement logic
        return Math.abs(endX - startX) == Math.abs(endY - startY);
    }

    private static boolean isValidQueenMove(char[][] board, int startX, int startY, int endX, int endY) {
        // Implement queen movement logic
        return isValidRookMove(board, startX, startY, endX, endY) || isValidBishopMove(board, startX, startY, endX, endY);
    }

    private static boolean isValidKingMove(char[][] board, int startX, int startY, int endX, int endY) {
        // Implement king movement logic
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dx == 1 && dy == 1);
    }
}
