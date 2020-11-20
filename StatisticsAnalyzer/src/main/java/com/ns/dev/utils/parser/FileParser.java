package com.ns.dev.utils.parser;

import com.ns.dev.stats.model.MatchParser;

import java.util.stream.Stream;

public abstract class FileParser {
	
	public abstract Stream<MatchParser> getStreamFromFile(String fileName);
}
