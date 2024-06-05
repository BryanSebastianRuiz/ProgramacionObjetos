public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'N' : 'n';
    }

    public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        int rowDiff = Math.abs(targetRow - startRow);
        int colDiff = Math.abs(targetCol - startCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
