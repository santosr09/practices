package com.ns.dev.stats.model;

import com.ns.dev.Team;
import com.ns.dev.utils.parser.MatchParser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Match {
	
	private LocalDate localDate;
	private Team localTeam;
	private Team visitorTeam;
	private int visitorGoals;
	private int localGoals;
	
	public Match(MatchParser matchParser){
		this.localTeam = new Team(matchParser.getLocal());
		this.visitorTeam = new Team(matchParser.getVisitor());
		setDateTime(matchParser.getDate());
		setGoals(matchParser.getScore());
	}
	
	private void setDateTime(String strDate){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		localDate = LocalDate.from(dateFormatter.parse(strDate));
	}
	
	public void setGoals(String score) {
		int index = score.indexOf('-');
		this.setLocalGoals(Integer.parseInt(score.substring(0,index)));
		this.setVisitorGoals(Integer.parseInt(score.substring(index+1)));
	}
	
}
