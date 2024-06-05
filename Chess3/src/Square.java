public class Square {
    private Piece piece;

    public Square() {
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public char getPieceSymbol() {
        if (piece == null) {
            return '-';
        } else {
            return piece.getSymbol();
        }
    }
}
