package com.ns.dev.utils.parser;

import com.ns.dev.utils.parser.xml.XMLFileParser;

public class ParserFactory {
	
	public FileParser getParser(FileTypes parser){
		switch (parser){
			case TXT_FILE:
				return new TXTFileParser();
			case XML_FILE:
				return new XMLFileParser();
			default:
				return null;
		}
	}
}
