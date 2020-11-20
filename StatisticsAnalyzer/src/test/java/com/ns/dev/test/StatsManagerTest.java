package com.ns.dev.test;

import com.ns.dev.stats.StatsManager;
import com.ns.dev.stats.model.MatchParser;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatsManagerTest {
	//private Path resourceDirectory = Paths.get("src","test","resources");
	private StatsManager _statsManager = new StatsManager();
	private FileLoader fileLoader = new FileLoader();
	
	@BeforeEach
	public void setUp(){
		 //_statsManager.loadStatsFromFile(PATH_RESOURCES + "england_premier_league_2000.xml");
		 _statsManager.loadStatsFromFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
	 }
	 
     @Test
		 public void getTeamWithMostWonMatches(){
       	 String  expectedTeamName = "Manchester Utd";
       	 assertEquals(expectedTeamName,	_statsManager.getTeamNameWithMostWon());
     }
     
     @Test
		 public void getTeamWithMostLostMatches(){
       	 String  expectedTeamName = "Bradford";
       	 //assertEquals(expectedTeamName,_statsManager.getTeamNameWithMostLost());
     }

    //@Test
		public void statsToString(){
    	//String expectedSummary = fileLoader.loadTextFile(resourceDirectory.toAbsolutePath().toString(), "summary_england_premier_league_2000.txt");
			Stream<MatchParser> expectedSummary = fileLoader.loadFile("summary_england_premier_league_2000.txt", FileTypes.TXT_FILE);
    	//assertEquals(expectedSummary,_statsManager.toString());
    }
     
     
}
