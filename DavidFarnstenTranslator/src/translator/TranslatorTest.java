package translator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TranslatorTest {

	@Test
	public void testCharToString() {
		// Arrange
		char input = 'b';
		Converter convert = new Converter();

		// Act
		String output = convert.charToMorse(input);

		// Assert
		assertEquals(output, "-...");
	}
	
	@Test
	public void testCapitalChar() {
		// Arrange
		char input = 'B';
		Converter convert = new Converter();
		
		// Act
		String output = convert.charToMorse(input);
		
		// Assert
		assertEquals(output, "-...");
	}

	@Test
	public void testEngWordToMorse() {
		// Arrange
		String input = "dinosaur";
		Converter convert = new Converter();		

		// Act
		String reply = convert.strToMorse(input);

		// Assert
		assertEquals(reply, "-....-.---....-..-.-.");
	}
	
	@Test
	public void testEngTwoWordsToMorse() {
		// Arrange
		String input = "green saur";
		Converter convert = new Converter();		

		// Act
		String reply = convert.strToMorse(input);

		// Assert
		assertEquals(reply, "--..-...-. ....-..-.-.");
		
	}
	
	@Test
	public void testUnsupportedChar() {
		// Arrange
		char input = 'ö';
		Converter convert = new Converter();
		
		// Act
		String reply = convert.charToMorse(input);
		
		// Assert
		assertEquals(reply, "¿");
	}
	
	
	@Test
	public void testMorseStrToEngStr() {
		// Arrange
		String input = ". .- -.-";
		Converter convert = new Converter();
		
		// Act
		String reply = convert.strMorseToStrEng(input);
		
		// Assert
		assertEquals(reply, "e a k");
	}	
		
}

	


