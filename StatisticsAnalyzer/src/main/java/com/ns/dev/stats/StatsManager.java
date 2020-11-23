package com.ns.dev.stats;

import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;

import java.util.stream.Stream;

public class StatsManager {
	
	private Stream statsInput;
	private ResultAnalyzer resultsAnalyzer;
	private FileLoader fileLoader;
	
	public StatsManager(){
		fileLoader = new FileLoader();
		this.resultsAnalyzer = new ResultAnalyzer(statsInput);
	}
	
	public void loadStatsFromFile(String nameFile, FileTypes fileType) {
		statsInput = fileLoader.loadFile(nameFile, fileType);
		resultsAnalyzer.initAnalyzer(statsInput);
	}
	
	public String getTeamNameWithMostWon() {
		return resultsAnalyzer.getTeamNameWithMostWon();
	}
	
}
