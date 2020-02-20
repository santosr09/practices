package com.ns.dev.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileLoader {
	
	public static Stream<String> loadFile(String path, String fileName){
		try {
			return Files.lines(Paths.get(path, fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPathFile(String fileName) {
		return FileLoader.class.getClassLoader()
				.getResource(fileName)
				.getPath()
				.toString();
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
