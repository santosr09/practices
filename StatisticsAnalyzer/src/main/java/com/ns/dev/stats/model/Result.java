package com.ns.dev.stats.model;

public class Result extends ResultType {
	
	public Result(ResultParser resultParser){
		this.date = resultParser.getDate();
		this.local = resultParser.getLocal();
		this.visitor = resultParser.getVisitor();
		this.score = resultParser.getScore();
	}
	
	@Override
	public void setGoals() {
		int index = this.score.indexOf('-');
		this.setLocalGoals(Integer.parseInt(score.substring(0,index)));
		this.setVisitorGoals(Integer.parseInt(score.substring(index+1)));
	}
	
	@Override
	public String getWinner() {
		return (localGoals > visitorGoals)? local : visitor ;
	}
	
	@Override
	public String getLoser() {
		return (localGoals < visitorGoals)? local : visitor ;
	}
	
	@Override
	protected void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}
	
	@Override
	protected void setVisitorGoals(int visitorGoals) {
		this.visitorGoals = visitorGoals;
	}
	
}
