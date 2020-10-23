package com.file.operations.main;

import java.io.IOException;

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
	

	

	
}

interface testinterface {
	public abstract void print();
}
