package com.ns.dev.utils;

import com.ns.dev.stats.model.MatchParser;
import com.ns.dev.utils.parser.FileTypes;
import com.ns.dev.utils.parser.FileParser;
import com.ns.dev.utils.parser.ParserFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader {
	
	ParserFactory parserFactory = new ParserFactory();
	FileParser parser;
	
	public Stream<MatchParser> loadFile(String fileName, FileTypes fileType){
		parser = parserFactory.getParser(fileType);
		return parser.getStreamFromFile(fileName);
	}
	
}
