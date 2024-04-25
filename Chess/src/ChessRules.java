public class ChessRules {
    public static boolean isValidMove(char piece, int startX, int startY, int endX, int endY, char targetPiece) {
        switch (piece) {
            case 'P': // White pawn
                return isValidPawnMove(startX, startY, endX, endY, targetPiece);
            case 'p': // Black pawn
                return isValidPawnMove(startX, startY, endX, endY, targetPiece);
            case 'R': // Rook
            case 'r':
                return isValidRookMove(startX, startY, endX, endY);
            case 'N': // Knight
            case 'n':
                return isValidKnightMove(startX, startY, endX, endY);
            case 'B': // Bishop
            case 'b':
                return isValidBishopMove(startX, startY, endX, endY);
            case 'Q': // Queen
            case 'q':
                return isValidQueenMove(startX, startY, endX, endY);
            case 'K': // King
            case 'k':
                return isValidKingMove(startX, startY, endX, endY);
            default:
                return false;
        }
    }

    private static boolean isValidPawnMove(int startX, int startY, int endX, int endY, char targetPiece) {
        // Implement pawn movement logic
        // This is a basic example and does not include captures, double move, etc.
        return (startY == endY - 1 && startX == endX && targetPiece == ' ') ||
               (startY == endY - 1 && Math.abs(startX - endX) == 1 && Character.isLowerCase(targetPiece));
    }

    private static boolean isValidRookMove(int startX, int startY, int endX, int endY) {
        // Implement rook movement logic
        return startX == endX || startY == endY;
    }

    private static boolean isValidKnightMove(int startX, int startY, int endX, int endY) {
        // Implement knight movement logic
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }

    private static boolean isValidBishopMove(int startX, int startY, int endX, int endY) {
        // Implement bishop movement logic
        return Math.abs(endX - startX) == Math.abs(endY - startY);
    }

    private static boolean isValidQueenMove(int startX, int startY, int endX, int endY) {
        // Implement queen movement logic
        return isValidRookMove(startX, startY, endX, endY) || isValidBishopMove(startX, startY, endX, endY);
    }

    private static boolean isValidKingMove(int startX, int startY, int endX, int endY) {
        // Implement king movement logic
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1) || (dx == 1 && dy == 1);
    }
}
