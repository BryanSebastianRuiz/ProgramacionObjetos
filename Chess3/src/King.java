public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'K' : 'k';
    }
    
    public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        int rowDiff = Math.abs(targetRow - startRow);
        int colDiff = Math.abs(targetCol - startCol);
        return rowDiff <= 1 && colDiff <= 1;
    }
}
