package mars;

public class Rover {

	private int currentX;
	private int currentY;
	private String currentOrientation;

	public Rover(int current_x, int current_y, String current_orientation) {
		this.currentX = current_x;
		this.currentY = current_y;
		this.currentOrientation = current_orientation;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public String getCurrentOrientation() {
		return currentOrientation;
	}

	public void setCurrentOrientation(String currentOrientation) {
		this.currentOrientation = currentOrientation;
	}

	public void rotateLeft() {
		
	}

	public void rotateRight() {
		
	}

	public boolean moveForward() {
		return true;
	}
}