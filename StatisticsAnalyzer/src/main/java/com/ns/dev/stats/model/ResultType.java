package com.ns.dev.stats.model;

import java.util.Optional;

public abstract class ResultType {
	
	protected String date;
	protected String local;
	protected String visitor;
	protected String score;
	protected int localGoals;
	protected int visitorGoals;
	protected Optional<String> winner;
	
	protected abstract void setWinner();
	protected abstract void setGoals();
	public abstract Optional<String> getWinner();
	protected abstract void setLocalGoals(int localGoals);
	protected abstract void setVisitorGoals(int visitorGoals);
	
}
