
public class PositionClass implements Position{
	
	private int x;
	private int y;
	
	/**
	 * This is the class constructor we need to know
	 * the starting position
	 * @x this is the initial x position
	 * @x this is the initial y position
	 **/
	public PositionClass(int x, int) {
	
	/**
	 * This moves along x
	 */
	
	@Override
	public void MoveInX(int steps) {
		this.x += steps;
	}
	
	/**
	 * This moves along x
	 */
	
	@Override
	public void MoveInY(int steps) {
		this.y += steps;
	}

}
