package com.file.operations.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;

import com.file.operations.main.Exceptions.OptionalNotPresent;

public class Util {

	public static List<String> getFileLines(Optional<String> fileOptional) throws OptionalNotPresent, IOException {
		List<String> lines = null;
		
		if(fileOptional.isPresent()) {
			File file = new File(fileOptional.get());
			if(file.exists()) {
				lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
				
			} else {
				throw new FileNotFoundException("File not exists. FileName: "+file.getAbsolutePath());
			}
		} else {
			System.out.println("File option is null");
			throw new OptionalNotPresent("File name is present in fileOptional");
		}
		
		
		return lines;
	}
	
	private static int reverseNumber(int num) {
		int reverseNumber = 0;
		while(num != 0 )
		{
			int digit = num % 10;
			reverseNumber = reverseNumber*10 + digit;
			num = num /10;
		}
		
		return reverseNumber;
	}


	public static String reverseString(String str) {
		String reverseString = "";
		for (int i = str.length()-1; i >= 0; i--) {
			reverseString += str.charAt(i);
			
		}
		return reverseString;
	}
	
	public static String reverseStringRecursion(String str) {
		if(str.length() == 0) {
			return str;
		}
		return reverseStringRecursion(str.substring(1)) + str.charAt(0);
	}
	
	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			//int j;
			int j = i;
			for (; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}

	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			System.out.println(val);
			System.out.println(checker);
			System.out.println(1 << val);
			System.out.println("------------");
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static boolean isStringContainsDuplicateChar(String str) {

		boolean[] charArr = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(val);
			if (charArr[val]) {
				return true;
			}
			charArr[val] = true;
		}

		return false;
	}

}
