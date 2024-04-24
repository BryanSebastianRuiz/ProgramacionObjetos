public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'P' : 'p';
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        int rowDiff = targetRow - startRow;
        int colDiff = Math.abs(targetCol - startCol);
        
        if (getColor() == Color.WHITE) {
            return rowDiff == -1 && colDiff == 0; // White pawn moves one square forward
        } else {
            return rowDiff == 1 && colDiff == 0; // Black pawn moves one square forward
        }
    }
}
