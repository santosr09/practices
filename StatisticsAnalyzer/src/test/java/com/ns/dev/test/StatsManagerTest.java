package com.ns.dev.test;

import com.ns.dev.stats.StatsManager;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StatsManagerTest {
	
	private StatsManager statsManager = new StatsManager();
	private FileLoader fileLoader = new FileLoader();
	
	@BeforeAll
	public void setUp() {
		 statsManager.loadStatsFromFile( "england_premier_league_2000.xml", FileTypes.XML_FILE);
	 }
	 
     @Test
		 public void getTeamWithMostWonMatches() {
       	 String  expectedTeamName = "Manchester Utd";
       	 assertEquals(expectedTeamName,	statsManager.getMostWinner().get().getTeam().getName());
     }
     
     @Test
		 public void getTeamWithMostLostMatches() {
       	 String  expectedTeamName = "Bradford";
       	 assertEquals(expectedTeamName, statsManager.getMostLoser().get().getTeam().getName());
     }
     
}
