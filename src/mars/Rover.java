package mars;

public class Rover {

	private int currentX;
	private int currentY;
	private String currentOrientation;
	private Plateau plateau;

	public Rover(int current_x, int current_y, String current_orientation, Plateau plateau) {
		this.currentX = current_x;
		this.currentY = current_y;
		this.currentOrientation = current_orientation;
		this.plateau = plateau;
	}

	public int getCurrentX() {
		return this.currentX;
	}

	public int getCurrentY() {
		return this.currentY;
	}

	public String getCurrentOrientation() {
		return this.currentOrientation;
	}

	public void rotateLeft() {
		switch (this.currentOrientation) {
			case "N":
				this.currentOrientation = "W";
				break;
			case "W":
				this.currentOrientation = "S";
				break;
			case "S":
				this.currentOrientation = "E";
				break;
			case "E":
				this.currentOrientation = "N";
				break;
		}
	}

	public void rotateRight() {
		switch (this.currentOrientation) {
			case "N":
				this.currentOrientation = "E";
				break;
			case "E":
				this.currentOrientation = "S";
				break;
			case "S":
				this.currentOrientation = "W";
				break;
			case "W":
				this.currentOrientation = "N";
				break;
		}
	}

	public boolean moveForward() {
		if (this.currentOrientation.equals("N")) {
			if (this.currentY < this.plateau.getMaxY()) {
				this.currentY++;
				return true;
			}
		} else if (this.currentOrientation.equals("S")) {
			if (this.currentY > 0) {
				this.currentY--;
				return true;
			}
		} else if (this.currentOrientation.equals("W")) {
			if (this.currentX > 0) {
				this.currentX--;
				return true;
			}
		} else if (this.currentOrientation.equals("E")) {
			if (this.currentX < this.plateau.getMaxX()) {
				this.currentX++;
				return true;
			}
		}
		return false;
	}
}