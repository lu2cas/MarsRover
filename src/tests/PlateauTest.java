package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mars.Plateau;

public class PlateauTest {

	private Plateau plateau;

	@Before
	public void setUp() throws Exception {
		this.plateau = new Plateau(10, 5);
	}

	@Test
	public void testGetMaxX() {
		assertEquals(10, this.plateau.getMaxX());
	}

	@Test
	public void testGetMaxY() {
		assertEquals(5, this.plateau.getMaxY());
	}
}