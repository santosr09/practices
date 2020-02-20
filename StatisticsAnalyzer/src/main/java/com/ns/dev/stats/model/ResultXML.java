package com.ns.dev.stats.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "matchResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultXML implements  ResultParser{
	private String date;
	private String local;
	private String visitor;
	private String score;
	
	@Override
	public String toString() {
		return "XMLResult{" +
							 "date=" + date +
							 ", local='" + local + '\'' +
							 ", visitor='" + visitor + '\'' +
							 ", score='" + score + '\'' +
							 '}';
	}
	
	
	@Override
	public String getDate() {
		return null;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getVisitor() {
		return visitor;
	}
	
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public ResultType getResultType(){
		ResultType resultType = new Result(this);
		return resultType;
	}
	
}
