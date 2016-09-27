package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mars.Plateau;
import mars.Rover;

public class RoverTest {

	private Rover rover;

	@Before
	public void setUp() throws Exception {
		Plateau plateau = new Plateau(5, 5);
		this.rover = new Rover(1, 2, "N", plateau);
	}

	@Test
	public void testGetCurrentX() {
		assertEquals(1, this.rover.getCurrentX());
	}

	@Test
	public void testGetCurrentY() {
		assertEquals(2, this.rover.getCurrentY());
	}

	@Test
	public void testGetCurrentOrientation() {
		assertEquals("N", this.rover.getCurrentOrientation());
	}

	@Test
	public void testRotateLeft() {
		this.rover.rotateLeft();
		assertEquals("W", this.rover.getCurrentOrientation());
		this.rover.rotateLeft();
		assertEquals("S", this.rover.getCurrentOrientation());
		this.rover.rotateLeft();
		assertEquals("E", this.rover.getCurrentOrientation());
		this.rover.rotateLeft();
		assertEquals("N", this.rover.getCurrentOrientation());
	}

	@Test
	public void testRotateRight() {
		this.rover.rotateRight();
		assertEquals("E", this.rover.getCurrentOrientation());
		this.rover.rotateRight();
		assertEquals("S", this.rover.getCurrentOrientation());
		this.rover.rotateRight();
		assertEquals("W", this.rover.getCurrentOrientation());
		this.rover.rotateRight();
		assertEquals("N", this.rover.getCurrentOrientation());
	}

	@Test
	public void testMoveForward() {
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.rotateRight();
		this.rover.moveForward();
		assertEquals(2, this.rover.getCurrentX());
		assertEquals(5, this.rover.getCurrentY());

		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		assertEquals(5, this.rover.getCurrentX());
		assertEquals(5, this.rover.getCurrentY());

		this.rover.rotateRight();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		assertEquals(5, this.rover.getCurrentX());
		assertEquals(0, this.rover.getCurrentY());

		this.rover.rotateRight();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		this.rover.moveForward();
		assertEquals(0, this.rover.getCurrentX());
		assertEquals(0, this.rover.getCurrentY());
	}
}