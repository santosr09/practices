package com.ns.dev.utils.parser;

import java.util.stream.Stream;

public abstract class FileParser {
	
	public abstract Stream<? extends MatchParser> getStreamFromFile(String fileName);
}
