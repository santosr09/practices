package com.ns.dev.stats.model;

import java.util.List;

public class ResultList {
	
	ResultListParser resultListParser;
	
	private List<ResultType> resultList;
	
	public List<ResultType> getResultList() {
		return resultList;
	}
	
	public void setResultList(List<ResultType> results) {
		this.resultList = results;
	}
	
	public void populateList(List<ResultType> results){
		//resultList = resultListParser.getResultList();
	}
}
