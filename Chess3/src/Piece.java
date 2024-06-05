public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract char getSymbol();

    public abstract boolean isValidMove(int startRow, int startCol, int targetRow, int targetCol);
}
