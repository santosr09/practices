package com.ns.dev;

import java.sql.Connection;
import java.util.List;

public class PlayerRepository {
	private List<Player> players;
	
	public PlayerRepository(){
	
	}
	
	public PlayerRepository(Connection conn){
	
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public List<Player> getPlayersByTeamId(int i) {
		return null;
	}
}
