package com.ns.dev.utils;

import com.ns.dev.utils.parser.MatchParser;
import com.ns.dev.utils.parser.FileParser;
import com.ns.dev.utils.parser.FileTypes;
import com.ns.dev.utils.parser.ParserFactory;

import java.util.stream.Stream;

public class FileLoader {
	
	ParserFactory parserFactory = new ParserFactory();
	FileParser parser;
	
	public Stream<? extends MatchParser> loadFile(String fileName, FileTypes fileType){
		parser = parserFactory.getParser(fileType);
		return parser.getStreamFromFile(fileName);
	}
	
}
