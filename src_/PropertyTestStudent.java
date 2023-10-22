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
class PropertyTestStudent {
	private Property prp, prp2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		prp = new Property("funny monkey gaming house", "Paris", 1234.23, "Ilyas");
		prp2 = new Property();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProperty() {
		prp2 = new Property();
		assertEquals(prp2.getCity(), "");
		
	}

	@Test
	void testPropertyStringStringDoubleString() {
		prp2 = new Property("building", "Robert", 123.32, "Owner");
		assertEquals(prp2.getCity(), "Robert");
	}

	@Test
	void testPropertyStringStringDoubleStringIntIntIntInt() {
		prp2 = new Property("Paris", "Gamer", 213123.23, "funny gammung", 1, 2, 3, 4);
		assertEquals(prp2.getCity(), "Gamer");
		assertEquals(prp2.getPlot().getX(), 1);
	}

	@Test
	void testPropertyProperty() {
		prp2 = new Property(prp);
		assertEquals(prp2.getCity(), "Paris");
	}
	
	@Test
	void testGetOwner() {
		assertEquals(prp.getOwner(), "Ilyas");
	}
	

	@Test
	void testToString() {
		assertEquals(prp.toString(),"funny monkey gaming house,Paris,Ilyas,1234.23");
	}

}
