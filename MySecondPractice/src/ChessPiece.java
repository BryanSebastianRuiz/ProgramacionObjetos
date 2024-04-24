
public class ChessPiece implements Piece{
	
	//Place attributes white or black
	public String Color;
	//Piece shape
	public String PlaceType;
	//Handles position of the piece
	public PositionClass Position;
	
	/**
	 * This is the piece constructor
	 */
	public ChessPiece(String pieceType) throws Exception {
		
		boolean isValid = ChessPiece.pieces.contains(pieceType);
		}
		
		switch (pieceType) {}
			case "Peon":
				//Body
				break;
			case "Alfil":
				break;
			//..
			default:
				//default behaviour
				break;
				
	}

	public void Move(int x, int y) {
		// TODO Auto-generated method stub

	}

}
