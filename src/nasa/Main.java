package nasa;

public class Main {

	public static void main(String[] args) {
		Control control = new Control();
		control.readInput();
		if (control.parseInput()) {
			control.executeMovements();
			control.showOutput();
		} else {
			System.out.println("Formato de entrada de dados incorreto!");
		}
	}

}