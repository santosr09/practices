package com.ns.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player implements Comparable{
	
	private String userName;
	private String lastName;
	private String firstName;
	private Team team = new Team();
	
	private static List<Player> players = new ArrayList<Player>();
	
	public static List<Player> sortByUserNameDesc(List<Player> playersToSort){
		Comparator comparator = Collections.reverseOrder();
		Collections.sort(playersToSort, comparator);
		return playersToSort;
	}
	
	public static List<Player> sortByUserNameAsc(List<Player> playersToSort){
		Collections.sort(playersToSort);
		return playersToSort;
	}
	
	@Override
	public int compareTo(Object obj) {
		Player p = (obj instanceof Player) ? (Player) obj : new Player();
		return this.getUserName().compareToIgnoreCase(p.getUserName());
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getTeamId() {
		return team.getId();
	}
	
	public void setTeamId(int teamId) {
		this.team.setId(teamId);
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
