package com.ns.dev.stats;

import com.ns.dev.stats.model.MatchParserXML;
import com.ns.dev.stats.model.ResultType;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


public class ResultAnalyzer {
	
	private Stream<MatchParserXML> resultList;
	private String mostWinner;
	private Map<String, Integer> rankingTable;
	
	public ResultAnalyzer(Stream<MatchParserXML> resultList){
		this.resultList = resultList;
		this.rankingTable = new HashMap<String, Integer>();
	}
	
	public String getTeamNameWithMostWon() {
		return mostWinner;
	}
	
	private void populateRankingTable(){
		resultList
				.flatMap(MatchParserXML::get)
				.filter(result -> !result.getWinner().get().equals("NO WINNER"))
				.map(ResultType::getWinner)
				.forEach(sortTeams);
	}
	
	Consumer<Optional<String>> sortTeams = result -> {
		Integer value = rankingTable.get(result.get());
		int sum = (value != null)?value.intValue():0;
		rankingTable.put(result.get(), ++sum);
	};
	
	private void setMostWinner(){
		mostWinner =rankingTable
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
	}
	
	public void initAnalyzer(Stream<MatchParserXML> resultList) {
		this.resultList = resultList;
		this.populateRankingTable();
		this.setMostWinner();
	}

}
