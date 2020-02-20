package com.ns.dev.utils.parser;

import com.ns.dev.stats.model.ResultType;

import java.util.List;

public abstract class FileParser {
	
	public abstract List<ResultType> convertFileToResult(String fileName);
}
