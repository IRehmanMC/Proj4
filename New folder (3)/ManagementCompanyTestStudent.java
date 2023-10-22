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
class ManagementCompanyTestStudent {
	private ManagementCompany m1, m2;
	
	@BeforeEach
	void setUp() throws Exception {
		m1 = new ManagementCompany("Ilyas & Co.", "1234", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testManagementCompany() {
		m1 = new ManagementCompany();
		assertEquals(m1.getMgmFeePer(), 0);
	}

	@Test
	void testManagementCompanyStringStringDouble() {
		m1 = new ManagementCompany("asd", "4634", 1.4);
		assertEquals(m1.getMgmFeePer(), 1.4);
	}

	@Test
	void testManagementCompanyStringStringDoubleIntIntIntInt() {
		m1 = new ManagementCompany("asdd", "11111", 100, 3, 2, 1, 12);
		assertEquals(m1.getMgmFeePer(), 100);
	}

	@Test
	void testManagementCompanyManagementCompany() {
		m1.addProperty("abc", "Paper", 1100, "Bear", 1, 2, 3, 4);
		m2 = new ManagementCompany(m1);
		assertEquals(m2.getProperties()[0].getCity(), "Paper");
	}

	@Test
	void testGetMgmFeePer() {
		assertEquals(m1.getMgmFeePer(), 10);
	}

	@Test
	void testGetPropertiesCount() {
		m1.addProperty("abc", "monkleey", 2123, "bannana", 1, 3, 2, 4);
		assertEquals(m1.getPropertiesCount(),1);
	}

	@Test
	void testAddPropertyProperty() {
		Property holder = null;
		assertEquals(m1.addProperty(holder), -2);
		holder = new Property("Hi", "Hello", 0, "Wells", 1, 1, 1, 1);
		m1.addProperty(holder);
		assertEquals(m1.getPropertiesCount(),1);
	}

	@Test
	void testAddPropertyStringStringDoubleString() {
		assertEquals(m1.addProperty("abc", "ccc", 1111.11, "placehold"),0);
		assertEquals(m1.getPropertiesCount(),1);
	}

	@Test
	void testAddPropertyStringStringDoubleStringIntIntIntInt() {
		assertEquals(m1.addProperty("abc", "ccc", 1111.11, "placehold", 2,2,4,2), 0);
		assertEquals(m1.getPropertiesCount(),1);
	}

	@Test
	void testGetHighestRentPropperty() {
		m1.addProperty("abc", "abc", 1232, "abc", 2, 2, 3, 3);
		m1.addProperty("ddd", "ddd", 1111, "ddd", 5, 5, 1, 1);
		assertEquals(m1.getHighestRentPropperty().getPropertyName(), "abc");

	}

	@Test
	void testGetTotalRent() {
		m1.addProperty("abc", "abc", 1232, "abc", 2, 2, 3, 3);
		m1.addProperty("ddd", "ddd", 1111, "ddd", 5, 5, 1, 1);
		assertEquals(m1.getTotalRent(), 2343);
	}

	@Test
	void testIsMangementFeeValid() {
		assertTrue(m1.isMangementFeeValid());
	}

	@Test
	void testIsPropertiesFull() {
		assertFalse(m1.isPropertiesFull());
	}

	@Test
	void testRemoveLastProperty() {
		m1.addProperty("abc", "abc", 1232, "abc", 2, 2, 3, 3);
		m1.removeLastProperty();
		assertEquals(m1.getProperties()[0], null);
	}

	@Test
	void testToString() {
		m1.addProperty("abc", "abc", 1232, "abc", 2, 2, 3, 3);
		String expectedString = "List of the properties for Ilyas & Co., taxID: 1234\n"
				+ "______________________________________________________\n"
				+ "abc,abc,abc,1232.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 123.2";
		assertEquals(m1.toString(), expectedString);
	}

}
