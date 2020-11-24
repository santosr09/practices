package com.ns.dev.stats.model;

import com.ns.dev.Team;
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
	
	public TeamStatistics() {
	}
	
	public TeamStatistics(String teamName) {
		this.setTeam(new Team(teamName));
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeamStatistics that = (TeamStatistics) o;
		return Objects.equals(team, that.team);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(team);
	}
	
	@Override
	public String toString() {
		return "TeamStatistics{" +
							 "team=" + team +
							 ", totalWon=" + totalWon +
							 ", totalLost=" + totalLost +
							 ", totalDrawn=" + totalDrawn +
							 '}';
	}
}
