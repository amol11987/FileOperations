package com.file.operations.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.file.operations.main.Exceptions.OptionalNotPresent;



public class FileHandlar {
	
	public void printFileDetailsOnConsole(String fileName) throws OptionalNotPresent, IOException{
		Optional<String> fileOptional = Optional.of(fileName);
		try {
			List<String> lines = Util.getFileLines(fileOptional);
			System.out.println("++++++++++++++++++++Printing file content. FileName: "+fileName+"++++++++++++++++++++");
			
			for(String line : lines) {
				System.out.println(line);
			}
			System.out.println("++++++++++++++++++++Printing file content End++++++++++++++++++++");
		} catch (FileNotFoundException e) {
			throw e;
		}
	}
	
	

}
