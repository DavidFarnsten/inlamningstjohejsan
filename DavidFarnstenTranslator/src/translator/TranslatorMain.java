package translator;

import java.util.Scanner;

public class TranslatorMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Welcome! :) Please enter your English text to translate to Morse.");
		String input = scan.nextLine().toLowerCase();
		
		Converter c = new Converter();
		System.out.println(c.strToMorse(input));
		
		System.out.println("Input morse code.");
		input = scan.nextLine().toLowerCase();
		System.out.println(c.strMorseToStrEng(input));
		
		System.exit(0);
	}
}