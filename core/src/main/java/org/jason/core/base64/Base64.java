package org.jason.core.base64;

import java.util.HashMap;

public class Base64 {

	private static HashMap<Character, Integer> decodeBase64Map = new HashMap<Character, Integer>();
	private static final char[] base64Encode = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
			'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '+', '/' };

	static {
		decodeBase64Map.put('A', 0);
		decodeBase64Map.put('B', 1);
		decodeBase64Map.put('C', 2);
		decodeBase64Map.put('D', 3);
		decodeBase64Map.put('E', 4);
		decodeBase64Map.put('F', 5);
		decodeBase64Map.put('G', 6);
		decodeBase64Map.put('H', 7);
		decodeBase64Map.put('I', 8);
		decodeBase64Map.put('J', 9);
		decodeBase64Map.put('K', 10);
		decodeBase64Map.put('L', 11);
		decodeBase64Map.put('M', 12);
		decodeBase64Map.put('N', 13);
		decodeBase64Map.put('O', 14);
		decodeBase64Map.put('P', 15);
		decodeBase64Map.put('Q', 16);
		decodeBase64Map.put('R', 17);
		decodeBase64Map.put('S', 18);
		decodeBase64Map.put('T', 19);
		decodeBase64Map.put('U', 20);
		decodeBase64Map.put('V', 21);
		decodeBase64Map.put('W', 22);
		decodeBase64Map.put('X', 23);
		decodeBase64Map.put('Y', 24);
		decodeBase64Map.put('Z', 25);
		decodeBase64Map.put('a', 26);
		decodeBase64Map.put('b', 27);
		decodeBase64Map.put('c', 28);
		decodeBase64Map.put('d', 29);
		decodeBase64Map.put('e', 30);
		decodeBase64Map.put('f', 31);
		decodeBase64Map.put('g', 32);
		decodeBase64Map.put('h', 33);
		decodeBase64Map.put('i', 34);
		decodeBase64Map.put('j', 35);
		decodeBase64Map.put('k', 36);
		decodeBase64Map.put('l', 37);
		decodeBase64Map.put('m', 38);
		decodeBase64Map.put('n', 39);
		decodeBase64Map.put('o', 40);
		decodeBase64Map.put('p', 41);
		decodeBase64Map.put('q', 42);
		decodeBase64Map.put('r', 43);
		decodeBase64Map.put('s', 44);
		decodeBase64Map.put('t', 45);
		decodeBase64Map.put('u', 46);
		decodeBase64Map.put('v', 47);
		decodeBase64Map.put('w', 48);
		decodeBase64Map.put('x', 49);
		decodeBase64Map.put('y', 50);
		decodeBase64Map.put('z', 51);
		decodeBase64Map.put('0', 52);
		decodeBase64Map.put('1', 53);
		decodeBase64Map.put('2', 54);
		decodeBase64Map.put('3', 55);
		decodeBase64Map.put('4', 56);
		decodeBase64Map.put('5', 57);
		decodeBase64Map.put('6', 58);
		decodeBase64Map.put('7', 59);
		decodeBase64Map.put('8', 60);
		decodeBase64Map.put('9', 61);
		decodeBase64Map.put('+', 62);
		decodeBase64Map.put('/', 63);
	}

	public static Character getBase64Character(int key) {

		return base64Encode[key];
	}

	public static int getBase64Decimal(Character key) {

		return decodeBase64Map.get(key);

	}

}
