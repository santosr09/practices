package com.ns.dev.utils.parser;

public class ParserFactory {
	
	public FileParser getParser(AvailableParser parser){
		switch (parser){
			case XML_PARSER:
				return new XMLFileParser();
				default:
					return null;
		}
	}
}
