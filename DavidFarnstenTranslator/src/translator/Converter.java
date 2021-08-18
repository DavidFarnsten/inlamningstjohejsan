package translator;

public class Converter {

	char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?' };

	String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
			"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
			"...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", ".-.-.-", "--..--", "..--.." };

	// Find character's index and use the same index to read Morse code
	// representation.
	public String charToMorse(char c) {
		char _c = Character.toLowerCase(c);
		// new String(english), building a String from a char array
		// .indexOf(c), getting the index of that character
		int idx = new String(english).indexOf(_c);

		// indexOf returns -1 if it can't find the character and if that happens we
		// return a string "?" to signal that we couldn't properly translate to Morse.
		// Otherwise we just return a corresponding Morse symbol.
		// Error handling: indexOf returns -1 if it can't find the character in the
		// array. If so,
		// return an upside-down questionmark.
		if (idx == -1) {

			// Not sure about this solution yet.
			return "¿";
		} else {
			return morse[idx];
		}
	}

	public String strToMorse(String in) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] chars = in.toCharArray();

		for (char ch : chars) {
			if (ch == ' ') {
				stringBuilder.append(' ');
			} else {
				String m = charToMorse(ch);
				stringBuilder.append(m);
			}
		}

		return stringBuilder.toString();
	}

	public char strMorseToChar(String mo) {
		// We assume that we don't have a proper index yet. -1 represents 'unknown
		// index'.
		int index = -1;
		// Here we try to find the index of the Morse symbol in the morse array.
		// If we managed to find the first matching symbol we break the loop.
		for (int i = 0; i < morse.length; i++) {
			// Test for a matching string.
			if (morse[i].equals(mo)) {
				index = i;
				break;
			}
		}

		// By now we either set the index to a proper index or we failed to find a match
		// which means index is still equal to -1. If so then we return a '¿' character.
		// Otherwise we return the english symbol saved under that index.
		if (index != -1) {
			return english[index];
		} else {
			return '¿';
		}
	}

	// Input string needs to be space separated Morse.
	public String strMorseToStrEng(String in) {
		String[] split = in.split("\\s+");
		System.out.println(split);

		StringBuilder stringBuilder = new StringBuilder();

		for (String st : split) {
			System.out.println(st);
			char eng = strMorseToChar(st);
			stringBuilder.append(eng);
			stringBuilder.append(" ");
		}
		String trimmed = stringBuilder.toString().trim();

		return trimmed;
	}
}