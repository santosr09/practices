package com.ns.dev;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Team {
	private int id=0;
	private String name;
	
	public Team(String name) {
		this.name = name;
	}
	
	public Team() {
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Team team = (Team) o;
		return Objects.equals(name, team.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public String toString() {
		return "Team{" +
							 "id=" + id +
							 ", name='" + name + '\'' +
							 '}';
	}
}
