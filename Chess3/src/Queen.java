public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'Q' : 'q';
    }
    
    public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        int rowDiff = Math.abs(targetRow - startRow);
        int colDiff = Math.abs(targetCol - startCol);
        return (startRow == targetRow || startCol == targetCol) || (rowDiff == colDiff);
    }
}
