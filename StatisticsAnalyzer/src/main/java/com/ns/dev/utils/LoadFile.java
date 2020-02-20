package com.ns.dev.utils;

import com.ns.dev.utils.parser.AvailableParser;
import com.ns.dev.utils.parser.FileParser;
import com.ns.dev.utils.parser.ParserFactory;
import com.ns.dev.stats.model.ResultType;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<ResultType> loadXMLFile(String nameFile){
		parser = parserFactory.getParser(AvailableParser.XML_PARSER);
		return parser.convertFileToResult(nameFile);
	}
	
}
