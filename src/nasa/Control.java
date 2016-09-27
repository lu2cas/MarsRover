package nasa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import mars.*;

public class Control {

	private Scanner scanner;

	private Plateau plateau;
	private ArrayList<Rover> rovers;
	private ArrayList<String> movements;

	private ArrayList<String> input;

	private List<String> validOrientations;
	private List<String> validMovements;

	public Control() {
		this.scanner = new Scanner(System.in);

		this.validOrientations = Arrays.asList("N", "W", "S", "E");
		this.validMovements = Arrays.asList("L", "R", "M");

		this.movements = new ArrayList<String>();
		this.rovers = new ArrayList<Rover>();

		this.input = new ArrayList<String>();
	}

	public void readInput() {
		this.input.clear();
		String command = "";

		System.out.println("*** MARS ROVER ***");
		System.out.println("Entrada de dados (digite \".\" para encerrar):");

		while(!command.equals(".")) {
			command = scanner.nextLine();
			if (!command.equals(".")) {
				this.input.add(command);
			}
		}
	}

	public void setInput(String input) {
		String[] lines = input.split(System.lineSeparator());
		for (int c = 0; c < lines.length; c++) {
			this.input.add(lines[c]);
		}
	}

	public boolean parseInput() {
		if (this.input.size() > 1 && this.input.size() % 2 == 1) {
			try {
				// Plateau
				String[] plateau_dimensions = new String[2];
				plateau_dimensions = this.input.remove(0).split(" ");
				int plateau_max_x = Integer.parseInt(plateau_dimensions[0]);
				int plateau_max_y = Integer.parseInt(plateau_dimensions[1]);
	
				if (plateau_max_x > 0 && plateau_max_y > 0) {
					this.plateau = new Plateau(plateau_max_x, plateau_max_y);
				} else {
					return false;
				}
	
				// Rovers
				String[] rover_deployment = new String[3];
				String command;
				int rover_deployment_x;
				int rover_deployment_y;
				String rover_deployment_orientation;
	
				for (int n = 0; n < this.input.size(); n += 2) {
					command = this.input.get(n);
	
					rover_deployment = command.split(" ");
					rover_deployment_x = Integer.parseInt(rover_deployment[0]);
					rover_deployment_y = Integer.parseInt(rover_deployment[1]);
					rover_deployment_orientation = rover_deployment[2];

					if (rover_deployment_x >= 0 && rover_deployment_x <= plateau_max_x && rover_deployment_y >= 0 && rover_deployment_y <= plateau_max_y && this.validOrientations.contains(rover_deployment_orientation)) {
						this.rovers.add(new Rover(rover_deployment_x, rover_deployment_y, rover_deployment_orientation, this.plateau));
					} else {
						return false;
					}
				}

				// Movements
				String movement;
				for (int n = 1; n < this.input.size(); n += 2) {
					movement = this.input.get(n);
					for (char c : movement.toCharArray()) {
						if (!this.validMovements.contains(String.valueOf(c))) {
							return false;
						}
					}
					this.movements.add(movement);
				}

				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public void executeMovements() {
		Rover rover;
		String movement;

		for (int n = 0; n < this.rovers.size(); n++) {
			rover = this.rovers.get(n);
			movement = this.movements.get(n);
			for (char c : movement.toCharArray()) {
				switch (c) {
					case 'L':
						rover.rotateLeft();
						break;
					case 'R':
						rover.rotateRight();
						break;
					case 'M':
						rover.moveForward();
						break;
				}
			}
		}
	}

	public void showOutput() {
		System.out.println("Saída de dados:");
		for (Rover rover : this.rovers) {
			System.out.println(rover.getCurrentX() + " " + rover.getCurrentY() + " " + rover.getCurrentOrientation());
		}
	}
}