import nasa.*;

public class Main {

	public static void main(String[] args) {
		Control control = new Control();
		control.readCommands();
		if (control.parseCommands()) {
			System.out.println("HELL YEAH!");
		} else {
			System.out.println("ERROR!");
		}
	}

}