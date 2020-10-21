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

}
