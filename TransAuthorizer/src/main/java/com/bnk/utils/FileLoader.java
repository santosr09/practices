package com.bnk.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileLoader {
	
	public static Stream<String> loadFile(String fileName){
		Path pathFile = getFilePath.apply(fileName);
		try {
			return Files.lines(pathFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retrieve the Path for the specified file
	 */
	public static Function<String, Path> getFilePath = FileLoader::apply;
	
	private static Path apply(String filename) {
		ClassLoader cl = FileLoader.class.getClassLoader();
		return Paths.get(cl.getResource(filename).getPath());
	}
}
