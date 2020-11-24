package com.ns.dev.stats;

import com.ns.dev.stats.model.TeamStatistics;
import com.ns.dev.utils.FileLoader;
import com.ns.dev.utils.parser.FileTypes;
import com.ns.dev.utils.parser.MatchParser;

import java.util.Optional;
import java.util.stream.Stream;

public class StatsManager {
	
	private Stream<? extends MatchParser>  statsInput;
	private ResultAnalyzer resultsAnalyzer;
	private FileLoader fileLoader;
	
	public StatsManager(){
		fileLoader = new FileLoader();
	}
	
	public void loadStatsFromFile(String nameFile, FileTypes fileType) {
		statsInput = fileLoader.loadFile(nameFile, fileType);
		this.resultsAnalyzer = new ResultAnalyzer(statsInput);
	}
	
	public Optional<TeamStatistics> getMostWinner() {
		return resultsAnalyzer.getMostWinnerTeam();
	}
	
	public Optional<TeamStatistics> getMostLoser() {
		return resultsAnalyzer.getMostLoserTeam();
	}
	
}
