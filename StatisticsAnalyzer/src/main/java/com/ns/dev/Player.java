package com.ns.dev;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
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
	
}
