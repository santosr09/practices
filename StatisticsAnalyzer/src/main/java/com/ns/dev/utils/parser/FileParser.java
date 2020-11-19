package com.ns.dev.utils.parser;

import com.ns.dev.stats.model.MatchParserXML;

import java.util.stream.Stream;

public abstract class FileParser {
	
	public abstract Stream<MatchParserXML> convertFileToResult(String fileName);
}
