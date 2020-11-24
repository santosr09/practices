package com.ns.dev.stats;

import com.ns.dev.Team;
import com.ns.dev.stats.model.TeamStatistics;
import com.ns.dev.utils.parser.MatchParser;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultAnalyzer {
	
	private Stream<? extends MatchParser> resultList;
	private Optional<TeamStatistics> mostWinnerTeam;
	private Optional<TeamStatistics> mostLoserTeam;
	private List<TeamStatistics> rankingOrderedList;
	private List<TeamStatistics> teamStatisticsList;
	
	public ResultAnalyzer(Stream<? extends MatchParser> resultList){
		this.matchProcessor(resultList);
	}
	
	private void matchProcessor(Stream<? extends MatchParser> streamMatchs) {
		teamStatisticsList = new ArrayList<TeamStatistics>();
		streamMatchs.forEach(setGoals);
		
		mostWinnerTeam = teamStatisticsList.stream().max(Comparator.comparing(TeamStatistics::getTotalWon));
		mostLoserTeam = teamStatisticsList.stream().max(Comparator.comparing(TeamStatistics::getTotalLost));
		rankingOrderedList = teamStatisticsList.stream()
											.sorted(Comparator.comparing(TeamStatistics::getTotalWon)
											.reversed())
											.collect(Collectors.toList());
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
		
		if(!teamStatisticsList.contains(localTeamStat)){
			teamStatisticsList.add(localTeamStat);
		}else{
			int indexLocal = teamStatisticsList.indexOf(localTeamStat);
			localTeamStat = teamStatisticsList.get(indexLocal);
		}
		if(!teamStatisticsList.contains(visitorTeamStat)){
			teamStatisticsList.add(visitorTeamStat);
		}else{
			int indexVisitor = teamStatisticsList.indexOf(visitorTeamStat);
			visitorTeamStat = teamStatisticsList.get(indexVisitor);
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
	
	public Optional<TeamStatistics> getTeamStatistics(String teamName) {
		TeamStatistics teamStat = new TeamStatistics(teamName);
		int index = teamStatisticsList.indexOf(teamStat);
		return index >= 0 ? Optional.ofNullable(teamStatisticsList.get(index)) : Optional.empty();
	}
	
	public Optional<TeamStatistics> getMostWinnerTeam() {
		return mostWinnerTeam;
	}
	
	public void setMostWinnerTeam(Optional<TeamStatistics> mostWinnerTeam) {
		this.mostWinnerTeam = mostWinnerTeam;
	}
	
	public Optional<TeamStatistics> getMostLoserTeam() {
		return mostLoserTeam;
	}
	
	public void setMostLoserTeam(Optional<TeamStatistics> mostLoserTeam) {
		this.mostLoserTeam = mostLoserTeam;
	}
	
	public List<TeamStatistics> getRankingOrderedList() {
		return rankingOrderedList;
	}
	
	public void setRankingOrderedList(List<TeamStatistics> rankingOrderedList) {
		this.rankingOrderedList = rankingOrderedList;
	}
	
	public List<TeamStatistics> getTeamStatisticsList() {
		return teamStatisticsList;
	}
	
}
