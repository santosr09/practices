package com.ns.dev.stats.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "matchResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchParserXML implements MatchParser {
	private String date;
	private String local;
	private String visitor;
	private String score;
	
	public ResultType getResultType(){
		ResultType resultType = new Result(this);
		return resultType;
	}
	
	@Override
	public String toString() {
		return "XMLResult{" +
							 "date=" + date +
							 ", local='" + local + '\'' +
							 ", visitor='" + visitor + '\'' +
							 ", score='" + score + '\'' +
							 '}';
	}
	
}
