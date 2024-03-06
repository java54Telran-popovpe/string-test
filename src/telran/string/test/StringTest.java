package telran.string.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class StringTest {

	@Test
	@DisplayName("Method \'concat\' test")
	void concatTest() {
		String hello = "Hello";
		assertEquals("Hello World", hello.concat( " World"));
	}
	
	@Test
	@DisplayName("Method \'contains\' test")
	void containsTest() {
		String hello = "Hello";
		assertTrue(hello.contains( "ell"));
		assertFalse(hello.contains( "lor"));
		
	}
	
	@Test
	@DisplayName("Method \'compareTo\' test")
	void compareToTest() {
		//two identical strings
		assertEquals(0, "aAgGher".compareTo("aAgGher"));
		//comparing E with e (index 5)
		assertEquals(-32, "aAgGhEr".compareTo("aAgGher"));
		//comparing g with F (index 2), also there is a difference in index 5
		assertEquals(33, "aAgGhEr".compareTo("aAFGher"));
		//the only difference - length
		assertEquals(-3, "aAgG".compareTo("aAgGher"));
		assertEquals(3, "aAgGher".compareTo("aAgG"));
	}
	
	@Test
	@DisplayName("Method \'compareToIgnoreCase\' test")
	void compareToIgnoreCaseTest() {
		//two identical strings
		assertEquals(0, "aAgGher".compareToIgnoreCase("AaGgHER"));
		//comparing e with A (index 5)
		assertEquals(4, "aAgGher".compareToIgnoreCase("AaGgHAR"));
		//comparing a with B (index 0), also there is a difference in index 5
		assertEquals(-1, "aAgGher".compareToIgnoreCase("BaGgHAR"));
		//the only difference - length
		assertEquals(-3, "aAgG".compareToIgnoreCase("AaGgHER"));
		assertEquals(4, "aAgGher".compareToIgnoreCase("AaG"));
	}
	
	@Test
	@DisplayName("Method \'equalsIgnoreCase\' test")
	void equalsIgnoreCaseTest() {
		//two identical strings
		assertTrue("aAgGher".equalsIgnoreCase("AaGgHer"));
		//only one difference
		assertFalse("aAgGher".equalsIgnoreCase("aAgGhfr"));
		//the only difference - length
		assertFalse("aAgGher".equalsIgnoreCase("aAgGherr"));
	}
	
	@Test
	@DisplayName("Method \'startsWith\' test")
	void startsWithTest() {
		//argument - empty string
		assertTrue("aAgGher".startsWith(""));
		//argument - equal string
		assertTrue("aAgGher".startsWith("aAgGher"));
		//argument - one character longer
		assertFalse("aAgGher".startsWith("aAgGherr"));
		//argument - substring, starting at index 0
		assertTrue("aAgGher".startsWith("aAgGh"));
		//argument - substring, starting at index 2
		assertTrue("aAgGher".startsWith("gGh", 2));
		//argument - negative offset
		assertFalse("aAgGher".startsWith("gGh", -2));
		//argument - maximum possible offset
		assertTrue("aAgGher".startsWith("r", 6));
		//argument - offset out of upper bound
		assertFalse("aAgGher".startsWith("r", 7));
	}
	
	@Test
	@DisplayName("Method \'endsWith\' test")
	void endsWithTest() {
		//argument - empty string
		assertTrue("aAgGher".endsWith(""));
		//argument - equal string
		assertTrue("aAgGher".endsWith("aAgGher"));
		//argument - substring from the start
		assertFalse("aAgGher".endsWith("aAgGh"));
		//argument - suffix of the string
		assertTrue("aAgGher".endsWith("er"));
		//argument equals the string plus a char preceding
		assertFalse("aAgGher".endsWith("QaAgGher"));
	}
	
	@Test
	@DisplayName("Method \'indexOf\' test")
	void indexOfTest() {
		//argument - empty string
		assertEquals(0, "aAgGher".indexOf(""));
		//argument - equal string
		assertEquals(0, "aAgGher".indexOf("aAgGher"));
		//argument - one character longer
		assertEquals(-1, "aAgGher".indexOf("aAgGherr"));
		//argument - substring, starting at index 3 and repeating two times
		//and repeating two times in this string
		assertEquals(3, "aAgGheGher".indexOf("Ghe"));
	}
	@Test
	@DisplayName("Method \'lastIndexOf\' test")
	void lastIndexOfTest() {
		//argument - out of the range 0x0 - 0xFFFF
		assertEquals(8, "aeg😀Ghe😀r".lastIndexOf( 0x1F600 ));
		//argument - in the range 0x0 - 0xFFFF
		assertEquals(7, "aeg😀Ghe😀r".lastIndexOf( 'e' ));
		//argument - not presented in string
		assertEquals(-1, "aAgGher".indexOf("!"));
	}
		
}
