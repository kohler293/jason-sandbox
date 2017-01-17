package org.jason.core.base64;

import java.util.LinkedList;
import java.util.Queue;

public class Base64Encoder {

	
	public byte[] encode(byte[] byteToEncode){
		
		byte[] array  = {122,13,124,126,112};
		
		StringBuilder encryptedBinary = new StringBuilder();
		StringBuilder outputEncodedText = new StringBuilder();

		int i = 0;
		for(byte s:array){
			
			String tempString = padBinaryNumber(Integer.toBinaryString(s), 8);
			encryptedBinary.append(tempString);
			i++;
			
			if(i==3){
				
				if (encryptedBinary.length() == 8) {
					encryptedBinary.append("0000");

				} else if (encryptedBinary.length() == 16) {
					encryptedBinary.append("00");

				}
				int newInt;
				while (encryptedBinary.length() != 0) {
					newInt = Integer.parseInt(encryptedBinary.substring(0, 6),
							2);
					outputEncodedText.append(Base64.getBase64Character(newInt));
					encryptedBinary.delete(0, 6);
				}
				i = 0;
			}

		}

		if (outputEncodedText.length() % 4 == 2) {
			outputEncodedText.append("==");

		} else if (outputEncodedText.length() % 4 == 3) {
			outputEncodedText.append("=");

		}
		
		
		return byteToEncode;
	}
	public String encode(String textToEncode) {

		Queue<String> inputTextList = new LinkedList<String>();
		StringBuilder textToEncrypt = new StringBuilder(textToEncode);
		StringBuilder outputEncodedText = new StringBuilder();
		String padRequiredCharacters = "";
		int textLength = textToEncrypt.length();

		if (textLength < 3) {
			inputTextList.add(textToEncrypt.toString());
		} else {
			if (textLength % 3 == 1) {

				padRequiredCharacters = textToEncrypt.substring(textLength - 1);
				textToEncrypt.delete(textLength - 1, textLength);

			} else if (textLength % 3 == 2) {

				padRequiredCharacters = textToEncrypt.substring(textLength - 2);
				textToEncrypt.delete(textLength - 2, textLength);
			}

			do {

				inputTextList.add(textToEncrypt.substring(0, 3));
				textToEncrypt.delete(0, 3);
			} while (textToEncrypt.length() != 0);

			if (!padRequiredCharacters.isEmpty()) {

				inputTextList.add(padRequiredCharacters);
			}

		}

		for (String listText : inputTextList) {

			StringBuilder encryptedBinary = new StringBuilder();

			byte[] stringByte = listText.getBytes();

			for (int i = 0; i < stringByte.length; i++) {
				String tempString = padBinaryNumber(
						Integer.toBinaryString(stringByte[i]), 8);
				encryptedBinary.append(tempString);

			}

			if (encryptedBinary.length() == 8) {
				encryptedBinary.append("0000");

			} else if (encryptedBinary.length() == 16) {
				encryptedBinary.append("00");

			}

			while (encryptedBinary.length() != 0) {
				int newInt = Integer.parseInt(encryptedBinary.substring(0, 6),
						2);
				outputEncodedText.append(Base64.getBase64Character(newInt));
				encryptedBinary.delete(0, 6);
			}

		}

		if (outputEncodedText.length() % 4 == 2) {
			outputEncodedText.append("==");

		} else if (outputEncodedText.length() % 4 == 3) {
			outputEncodedText.append("=");

		}
		return outputEncodedText.toString();

	}

	private static String padBinaryNumber(String binaryNumber, int desiredLength) {
		String tempString = binaryNumber;
		for (int i = binaryNumber.length(); i < desiredLength; i++) {
			tempString = "0" + tempString;
		}
		return tempString;

	}
}
