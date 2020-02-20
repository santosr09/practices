package com.ns.dev.stats.model;

public abstract class ResultType {
	
	protected String date;
	protected String local;
	protected String visitor;
	protected String score;
	protected int localGoals;
	protected int visitorGoals;
	
	protected abstract void setGoals();
	public abstract String getWinner();
	public abstract String getLoser();
	protected abstract void setLocalGoals(int localGoals);
	protected abstract void setVisitorGoals(int visitorGoals);
	
}
