public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'B' : 'b';
    }

    public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        int rowDiff = Math.abs(targetRow - startRow);
        int colDiff = Math.abs(targetCol - startCol);
        return rowDiff == colDiff;
    }
}
