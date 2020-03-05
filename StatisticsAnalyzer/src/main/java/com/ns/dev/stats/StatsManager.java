package com.ns.dev.stats;

import com.ns.dev.stats.model.ResultType;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.LoadFile;

import java.util.List;

public class StatsManager {
	
	private List<ResultType> statsInput;
	private LoadFile loader;
	private ResultAnalyzer resultsAnalyzer;
	
	public StatsManager(){
		this.loader = new LoadFile();
		this.resultsAnalyzer = new ResultAnalyzer(statsInput);
	}
	
	public void loadStatsFromFile(String nameFile) {
		statsInput = loader.loadXMLFile(FileLoader.getPathFile(nameFile));
		resultsAnalyzer.initAnalyzer(statsInput);
	}
	
	public String getTeamNameWithMostWon() {
		return resultsAnalyzer.getTeamNameWithMostWon();
	}
	
}
