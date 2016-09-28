package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mars.Rover;
import nasa.Control;

public class ControlTest {

	private Control control;

	@Before
	public void setUp() throws Exception {
		this.control = new Control();
		control.setInput("5 5" + System.lineSeparator() + "1 2 N" + System.lineSeparator() + "LMLMLMLMM" + System.lineSeparator() + "3 3 E" + System.lineSeparator() + "MMRMMRMRRM");
	}

	@Test
	public void testParseInput() {
		assertTrue(control.parseInput());
	}

	@Test
	public void testExecuteMovements() {
		control.parseInput();
		control.executeMovements();
		ArrayList<Rover> rovers = control.getRovers();

		assertEquals(1, rovers.get(0).getCurrentX());
		assertEquals(3, rovers.get(0).getCurrentY());
		assertEquals("N", rovers.get(0).getCurrentOrientation());

		assertEquals(5, rovers.get(1).getCurrentX());
		assertEquals(1, rovers.get(1).getCurrentY());
		assertEquals("E", rovers.get(1).getCurrentOrientation());
	}

}