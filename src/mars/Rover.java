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

	public boolean rotateLeft() {
		switch (this.currentOrientation) {
			case "N":
				this.currentOrientation = "W";
				return true;
			case "W":
				this.currentOrientation = "S";
				return true;
			case "S":
				this.currentOrientation = "E";
				return true;
			case "E":
				this.currentOrientation = "N";
				return true;
		}
		return false;
	}

	public boolean rotateRight() {
		switch (this.currentOrientation) {
			case "N":
				this.currentOrientation = "E";
				return true;
			case "E":
				this.currentOrientation = "S";
				return true;
			case "S":
				this.currentOrientation = "W";
				return true;
			case "W":
				this.currentOrientation = "N";
				return true;
		}
		return false;
	}

	public boolean moveForward() {
		if (this.currentOrientation == "N") {
			if (this.currentY < this.plateau.getMaxY()) {
				this.currentY++;
				return true;
			}
		} else if (this.currentOrientation == "S") {
			if (this.currentY > 0) {
				this.currentY--;
				return true;
			}
		} else if (this.currentOrientation == "W") {
			if (this.currentX > 0) {
				this.currentX--;
				return true;
			}
		} else if (this.currentOrientation == "E") {
			if (this.currentX < this.plateau.getMaxX()) {
				this.currentX++;
				return true;
			}
		}
		return false;
	}
}