package com.ns.dev.utils;

import com.ns.dev.stats.model.MatchParserXML;
import com.ns.dev.utils.parser.AvailableParser;
import com.ns.dev.utils.parser.FileParser;
import com.ns.dev.utils.parser.ParserFactory;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadFile {
	
	ParserFactory parserFactory = new ParserFactory();
	FileParser parser;
	
	public static String loadTextFile(String path, String nameFile){
		//Stream<String> lines = null;
		//lines = Files.lines(Paths.get(nameFile));
		return FileLoader.loadFile(path, nameFile)
							 .collect(Collectors.toList())
							 .toString();
		//return lines.collect(Collectors.toList()).toString();
	}
	
	public Stream<MatchParserXML> loadXMLFile(String nameFile){
		parser = parserFactory.getParser(AvailableParser.XML_PARSER);
		return parser.convertFileToResult(nameFile);
	}
	
}
