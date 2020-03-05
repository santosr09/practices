package com.ns.dev.stats.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "XMLResults")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultListXML implements ResultListParser{
	
	@XmlElement(name = "matchResult")
	private List<ResultXML> XMLResults;
	
	public List<ResultXML> getXMLResults() {
		return XMLResults;
	}
	
	public void setXMLResults(List<ResultXML> XMLResults) {
		this.XMLResults = XMLResults;
	}
	
	public List<ResultType> getResultList(){
		List<ResultType> resultList = new ArrayList<ResultType>();
		for(ResultXML item : XMLResults){
			resultList.add(item.getResultType());
			//System.out.println("winner: "+item.getResultType().getWinner());
		}
		return resultList;
	}
}
