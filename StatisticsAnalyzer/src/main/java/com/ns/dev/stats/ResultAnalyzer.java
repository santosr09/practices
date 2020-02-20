package com.ns.dev.stats;

import com.ns.dev.stats.model.ResultType;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


public class ResultAnalyzer {
	
	private List<ResultType> resultList;
	private String mostWinner;
	private String mostLoser;
	private Map<String, Integer> rankingTable;
	
	public ResultAnalyzer(List<ResultType> resultList){
		this.resultList = resultList;
		this.rankingTable = new HashMap<String, Integer>();
	}
	
	public ResultAnalyzer(){
	}
	
	public String getTeamNameWithMostWon() {
		setMostWinner();
		return mostWinner;
	}
	
	public String getTeamNameWithMostLost() {
		setMostLoser();
		return mostLoser;
	}
	
	private void populateRankingTable(){
		List<ResultType> resultList = this.resultList;
		resultList.forEach(item -> {
			int wonGames = 0;
			if(rankingTable.containsKey(item.getWinner())){
				wonGames = rankingTable.get(item.getWinner());
				//System.out.println("Winner "+item.getWinner()+ "wonGames: "+ wonGames);
			}
			rankingTable.put(item.getWinner(), ++wonGames);
		});
	}
	
	private void setMostWinner(){
		this.populateRankingTable();
		Map<String, Integer> sortedMapDesc = getSortedRankingDesc();
		Map.Entry<String, Integer> entryDesc = sortedMapDesc.entrySet().iterator().next();
		mostWinner = entryDesc.getKey();
	}
	
	private void setMostLoser(){
		this.populateRankingTable();
		Map<String, Integer> sortedMapAsc = getSortedRankingAsc();
		Map.Entry<String, Integer> entryAsc = sortedMapAsc.entrySet().iterator().next();
		mostLoser = entryAsc.getKey();
	}
	
	private Map<String, Integer> getSortedRankingAsc() {
		Map<String, Integer> sortedMap = rankingTable
																				 .entrySet()
																				 .stream()
																				 .sorted(comparingByValue())
																				 .collect(
																						 toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
																								 LinkedHashMap::new));
		System.out.println(sortedMap.toString());
		return sortedMap;
	}
	
	private Map<String, Integer> getSortedRankingDesc() {
		Map<String, Integer> sortedMap = rankingTable
																				 .entrySet()
																				 .stream()
																				 .sorted(Collections.reverseOrder(comparingByValue()))
																				 .collect(
																						 toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
																								 LinkedHashMap::new));
		return sortedMap;
	}
	
	public List<ResultType> getResultList() {
		return resultList;
	}
	
	public void setResultList(List<ResultType> resultList) {
		this.resultList = resultList;
	}
	
	public Map<String, Integer> getRankingTable() {
		return rankingTable;
	}

}
