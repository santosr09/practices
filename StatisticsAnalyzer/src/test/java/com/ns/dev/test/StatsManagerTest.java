package com.ns.dev.test;

import com.ns.dev.stats.StatsManager;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.LoadFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatsManagerTest {
	private Path resourceDirectory = Paths.get("src","test","resources");
	private StatsManager _statsManager;
	private FileLoader fileLoader;
	
	@BeforeAll
	public void setUp(){
		 _statsManager = new StatsManager();
		 //_statsManager.loadStatsFromFile(PATH_RESOURCES + "england_premier_league_2000.xml");
		 _statsManager.loadStatsFromFile( "england_premier_league_2000.xml");
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
    	String expectedSummary = LoadFile.loadTextFile(resourceDirectory.toAbsolutePath().toString(), "summary_england_premier_league_2000.txt");
    	assertEquals(expectedSummary,_statsManager.toString());
    }
     
     
}
