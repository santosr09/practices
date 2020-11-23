package com.ns.dev.stats.model;

import com.ns.dev.utils.parser.MatchParser;

import java.util.Optional;

public class Result extends ResultType {
	
	public Result(MatchParser matchParser){
		this.date = matchParser.getDate();
		this.local = matchParser.getLocal();
		this.visitor = matchParser.getVisitor();
		this.score = matchParser.getScore();
		setGoals();
		setWinner();
	}
	
	@Override
	public void setGoals() {
		int index = this.score.indexOf('-');
		this.setLocalGoals(Integer.parseInt(score.substring(0,index)));
		this.setVisitorGoals(Integer.parseInt(score.substring(index+1)));
	}
	
	@Override
	public Optional<String> getWinner() {
		return winner;
	}
	
	@Override
	public void setWinner() {
		if(localGoals == visitorGoals){
			winner = Optional.of("NO WINNER");
		}else{
			winner = Optional.ofNullable((localGoals > visitorGoals) ? local : visitor);
		}
	}
	
	@Override
	protected void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}
	
	@Override
	protected void setVisitorGoals(int visitorGoals) {
		this.visitorGoals = visitorGoals;
	}
	
	@Override
	public String toString() {
		return "Result{" +
							 "date='" + date + '\'' +
							 ", local='" + local + '\'' +
							 ", visitor='" + visitor + '\'' +
							 ", score='" + score + '\'' +
							 ", localGoals=" + localGoals +
							 ", visitorGoals=" + visitorGoals +
							 ", winner='" + winner.get() + '\'' +
							 '}';
	}
}
