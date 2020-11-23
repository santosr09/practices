package com.ns.dev.test;

import com.ns.dev.utils.parser.xml.MatchParserXML;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderTest {
	
	private FileLoader fileLoader = new FileLoader();
	
	@Test
	public void cargaXML(){
		MatchParserXML expectedResult = new MatchParserXML();
		expectedResult.setDate("2001-05-19");
		expectedResult.setLocal("Charlton");
		expectedResult.setVisitor("Liverpool");
		expectedResult.setScore("0-4");
		
		Stream output = fileLoader.loadFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
		
		assertEquals(expectedResult, (MatchParserXML) output.map(
				element -> {
					return element;
				}).findFirst().get());
	}
}
