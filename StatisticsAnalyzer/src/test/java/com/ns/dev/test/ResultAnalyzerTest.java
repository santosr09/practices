package com.ns.dev.test;

import com.ns.dev.stats.ResultAnalyzer;
import com.ns.dev.stats.model.TeamStatistics;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import com.ns.dev.utils.parser.MatchParser;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultAnalyzerTest {
	private ResultAnalyzer analyzer;
	private FileLoader fileLoader = new FileLoader();
	
	@Test
	public void initAnalyzer(){
		Stream rawResults = fileLoader.loadFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
		analyzer = new ResultAnalyzer(rawResults);
		TeamStatistics teamA = new TeamStatistics();
		assertEquals(teamA, analyzer.getTeamStatistics("Charlton"));
	}
	
	@Test
	public void matchProcessorTest(){
		Stream rawResults = fileLoader.loadFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
		analyzer = new ResultAnalyzer(rawResults);
		analyzer.matchProcessor(rawResults);
		analyzer.getTeamStatistics();
	}
	

}
