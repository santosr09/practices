package com.ns.dev;

import lombok.Getter;
import lombok.Setter;

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
	
}
