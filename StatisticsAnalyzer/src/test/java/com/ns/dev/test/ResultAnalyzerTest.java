package com.ns.dev.test;

import com.ns.dev.stats.ResultAnalyzer;
import com.ns.dev.stats.model.TeamStatistics;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultAnalyzerTest {
	private ResultAnalyzer analyzer;
	private FileLoader fileLoader = new FileLoader();
	
	Stream XML_rawResults;
	private TeamStatistics mostWinnerTeam;
	private TeamStatistics mostLoserTeam;
	private TeamStatistics teamDerby;
	
	@BeforeAll
	private void setupTest(){
		teamDerby = new TeamStatistics("Derby");
		teamDerby.setTotalLost(16);
		teamDerby.setTotalWon(10);
		teamDerby.setTotalDrawn(12);
		
		mostWinnerTeam = new TeamStatistics("Manchester Utd");
		mostWinnerTeam.setTotalDrawn(8);
		mostWinnerTeam.setTotalWon(24);
		mostWinnerTeam.setTotalLost(6);
		
		mostLoserTeam = new TeamStatistics("Bradford");
		mostLoserTeam.setTotalDrawn(11);
		mostLoserTeam.setTotalWon(5);
		mostLoserTeam.setTotalLost(22);
		
		XML_rawResults = fileLoader.loadFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
		analyzer = new ResultAnalyzer(XML_rawResults);
		
	}
	
	@Test
	public void XML_initAnalyzer(){
		assertEquals(teamDerby, analyzer.getTeamStatistics("Derby").get());
	}
	
	@Test
	public void XML_matchProcessorTest(){
		assertEquals(teamDerby, analyzer.getTeamStatistics("Derby").get());
	}
	
	@Test
	public void XML_mostWinnerTest(){
		assertEquals(mostWinnerTeam, analyzer.getTeamStatistics("Manchester Utd").get());
	}
	
	@Test
	public void XML_mostLoserTest(){
		assertEquals(mostLoserTeam, analyzer.getTeamStatistics("Bradford").get());
	}

}
