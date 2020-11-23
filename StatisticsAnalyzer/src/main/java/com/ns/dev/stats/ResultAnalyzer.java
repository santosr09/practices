package com.ns.dev.stats;

import com.ns.dev.Team;
import com.ns.dev.stats.model.TeamStatistics;
import com.ns.dev.utils.parser.MatchParser;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class ResultAnalyzer {
	
	private Stream resultList;
	private String mostWinner;
	
	public List<TeamStatistics> getTeamStatistics() {
		return teamStatistics;
	}
	
	public void setTeamStatistics(List<TeamStatistics> teamStatistics) {
		this.teamStatistics = teamStatistics;
	}
	
	private List<TeamStatistics> teamStatistics;
	private Map<String, Integer> rankingTable;
	
	public ResultAnalyzer(Stream resultList){
		this.resultList = resultList;
		this.rankingTable = new HashMap<String, Integer>();
	}
	
	public String getTeamNameWithMostWon() {
		return mostWinner;
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
	
	public void initAnalyzer(Stream<MatchParser> resultList) {
		this.resultList = resultList;
	}
	
	public void matchProcessor(Stream<? extends MatchParser> streamMatchs){
		teamStatistics = new ArrayList<TeamStatistics>();
		streamMatchs.forEach(setGoals);
	}
	
	public Consumer<MatchParser> setGoals =(match -> {
		int index = match.getScore().indexOf('-');
		int localGoals = Integer.parseInt(match.getScore().substring(0,index));
		int visitorGoals = Integer.parseInt(match.getScore().substring(index+1));
		Team localTeam = new Team(match.getLocal());
		Team visitorTeam = new Team(match.getVisitor());
		TeamStatistics localTeamStat = new TeamStatistics();
		localTeamStat.setTeam(localTeam);
		TeamStatistics visitorTeamStat = new TeamStatistics();
		visitorTeamStat.setTeam(visitorTeam);
		
		if(!teamStatistics.contains(localTeamStat)){
			teamStatistics.add(localTeamStat);
		}else{
			int indexLocal = teamStatistics.indexOf(localTeamStat);
			localTeamStat = teamStatistics.get(indexLocal);
		}
		if(!teamStatistics.contains(visitorTeamStat)){
			teamStatistics.add(visitorTeamStat);
		}else{
			int indexVisitor = teamStatistics.indexOf(visitorTeamStat);
			visitorTeamStat = teamStatistics.get(indexVisitor);
		}
		
		if(localGoals == visitorGoals){
			localTeamStat.setTotalDrawn(localTeamStat.getTotalDrawn() + 1);
			visitorTeamStat.setTotalDrawn(visitorTeamStat.getTotalDrawn() + 1);
		}
		else if(localGoals > visitorGoals){
			localTeamStat.setTotalWon(localTeamStat.getTotalWon() + 1);
			visitorTeamStat.setTotalLost(visitorTeamStat.getTotalLost() + 1);
		}
		else {
			visitorTeamStat.setTotalWon(visitorTeamStat.getTotalWon() + 1);
			localTeamStat.setTotalLost(localTeamStat.getTotalLost() + 1);
		}
		
	});
	
	public TeamStatistics getTeamStatistics(String teamName) {
		TeamStatistics teamStat = new TeamStatistics();
		teamStat.setTeam(new Team(teamName));
		return teamStatistics.get(teamStatistics.indexOf(teamStat));
	}
}
