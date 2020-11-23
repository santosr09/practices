package com.ns.dev.utils.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TXTFileParser extends FileParser{
	@Override
	public Stream<MatchParser> getStreamFromFile(String fileName) {
		try {
			Path path = Paths.get(getClass().getClassLoader()
																.getResource(fileName).toURI());
			return getMatchParserStream(Files.lines(path));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Stream<MatchParser> getMatchParserStream(Stream<String> stringStream){
		return null;
	}
}
