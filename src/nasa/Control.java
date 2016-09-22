package nasa;

import java.util.ArrayList;
import java.util.Scanner;

import mars.*;

public class Control {

	private Scanner scanner;

	private Plateau plateau;
	private ArrayList<Rover> rovers;

	private String plateauDimensions;
	private ArrayList<String> roversCommands;

	public Control() {
		this.scanner = new Scanner(System.in);
		this.roversCommands = new ArrayList<String>();
		this.rovers = new ArrayList<Rover>();

	}

	public void readCommands() {
		this.roversCommands.clear();
		String command = "";

		System.out.println("Insira os comandos:");
		this.plateauDimensions = scanner.next();

		while(!command.equals("end")) {
			command = scanner.next();
			if (!command.equals("end")) {
				this.roversCommands.add(command);
			}
		}

		this._parseCommands();
	}

	private void _parseCommands() {
		String[] plateau_dimensions = new String[2];
		plateau_dimensions = this.plateauDimensions.split(" ");
		this.plateau = new Plateau(Integer.parseInt(plateau_dimensions[0]), Integer.parseInt(plateau_dimensions[1]));

		for (String rover_command : this.roversCommands) {
			
		}
	}
}