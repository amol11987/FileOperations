package com.file.operations.main;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

import com.file.operations.main.Exceptions.ArgumentMissingException;
import com.file.operations.main.Exceptions.OptionalNotPresent;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) throws ArgumentMissingException, OptionalNotPresent, IOException {
		if(args.length > 0) {
			FileHandlar fileHandlar = new FileHandlar();
			fileHandlar.printFileDetailsOnConsole(args[0]);
		} else {
			throw new ArgumentMissingException("Argument is missing for App.main method");
		}
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

interface testinterface {
	public abstract void print();
}
