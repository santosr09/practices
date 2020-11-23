package com.ns.dev.stats.model;

import com.ns.dev.Team;
import com.ns.dev.utils.parser.MatchParser;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TeamStatistics {

	private Team team;
	private int totalWon;
	private int totalLost;
	private int totalDrawn;
	
	public TeamStatistics(){
	
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeamStatistics that = (TeamStatistics) o;
		return Objects.equals(team.getName(), that.team.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(team.getName());
	}
}
