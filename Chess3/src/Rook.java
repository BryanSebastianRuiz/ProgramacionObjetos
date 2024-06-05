public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        return (getColor() == Color.WHITE) ? 'R' : 'r';
    }

    public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol) {
        return startRow == targetRow || startCol == targetCol;
    }
}
