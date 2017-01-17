package org.jason.core.base64;

import java.util.LinkedList;
import java.util.Queue;

public class Base64Decoder {

	public String decode(String textToDecode) {

		Queue<String> inputTextList = new LinkedList<String>();
		StringBuilder textToDecrypt = new StringBuilder(textToDecode);
		StringBuilder outputDecodedText = new StringBuilder();
		StringBuilder encryptedBinary = new StringBuilder();
		String padRequiredCharacters = "";
		// removes padding from the encoded text
		while (textToDecrypt.charAt(textToDecrypt.length() - 1) == '=') {
			textToDecrypt.deleteCharAt(textToDecrypt.length() - 1);

		}
		int textLength = textToDecrypt.length();

		if (textLength % 4 == 2) {

			padRequiredCharacters = textToDecrypt.substring(textLength - 2);
			textToDecrypt.delete(textLength - 2, textLength);

		} else if (textLength % 4 == 3) {

			padRequiredCharacters = textToDecrypt.substring(textLength - 3);
			textToDecrypt.delete(textLength - 3, textLength);
		}

		System.out.println(padRequiredCharacters);

		do {

			inputTextList.add(textToDecrypt.substring(0, 4));
			textToDecrypt.delete(0, 4);
		} while (textToDecrypt.length() != 0);

		if (!padRequiredCharacters.isEmpty()) {

			inputTextList.add(padRequiredCharacters);
		}

		for (String listText : inputTextList) {
			// take the four characters, turns them into binary, and appends
			// them
			// into a single bitstream
			for (int i = 0; i < listText.length(); i++) {

				int tempDecimal = Base64.getBase64Decimal(listText.charAt(i));
				String binaryValue = padBinaryNumber(
						Integer.toBinaryString(tempDecimal), 6);
				encryptedBinary.append(binaryValue);
				System.out.println(binaryValue);

			}

			if (encryptedBinary.length() == 12) {
				encryptedBinary.append("0000");

			} else if (encryptedBinary.length() == 18) {
				encryptedBinary.append("000000");

			}

			// takes bitstream and separates it into three 8 bit binary numbers
			// and
			// converts them in single characters
			while (encryptedBinary.length() != 0) {

				int parsedEightBitNumber = Integer.parseInt(
						encryptedBinary.substring(0, 8), 2);
				encryptedBinary.delete(0, 8);
				outputDecodedText.append((char) parsedEightBitNumber);
				System.out.println(outputDecodedText.toString());

			}
		}
		return outputDecodedText.toString();
	}

	private static String padBinaryNumber(String binaryNumber, int desiredLength) {
		String tempString = binaryNumber;
		for (int i = binaryNumber.length(); i < desiredLength; i++) {
			tempString = "0" + tempString;
		}
		return tempString;

	}
}
