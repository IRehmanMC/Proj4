import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Dr. Kuijt 
 * Description: property class
 * Due: 10/22/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ilyas Rehman
*/
class PlotTestStudent {
	private Plot plt1, plt2;

	@BeforeEach
	void setUp() throws Exception {
		plt1 = new Plot(1,1,1,1);
		plt2 = new Plot(2,3,4,4);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlot() {
		plt1 = new Plot();
		assertEquals(plt1.getX(), 0);
	}

	@Test
	void testPlotIntIntIntInt() {
		plt1 = new Plot(1,2,4,7);
		assertEquals(plt1.getX(), 1);
	}

	@Test
	void testPlotPlot() {
		plt1 = new Plot(plt2);
		assertEquals(plt1.getX(), 1);
		
	}

	@Test
	void testGetX() {
		assertEquals(plt2.getX(), 1);
	}
	
	@Test
	void testOverlaps() {
		assertTrue(plt2.overlaps(plt1));
		plt1 = new Plot();
		plt2 = new Plot(1,1,1,1);
		assertFalse(plt1.overlaps(plt2));
	}

	@Test
	void testEncompasses() {
		assertTrue(plt2.encompasses(plt1));
		assertFalse(plt1.encompasses(plt2));
	}

	@Test
	void testToString() {
		assertEquals(plt1.toString(), "1,1,1,1");
	}

}