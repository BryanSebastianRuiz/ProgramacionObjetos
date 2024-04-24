import java.util.ArrayList;
import java.util.List;

public interface Piece {
	public static final List<String> pieces =
			new ArrayList<String>(List.of("Peon", "Reina", "Rey", "Alfil", "etc.."));
	public void Move(int x, int y);
}
