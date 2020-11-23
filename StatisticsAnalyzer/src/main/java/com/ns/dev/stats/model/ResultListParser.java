package com.ns.dev.stats.model;

import com.ns.dev.utils.parser.MatchParser;

import java.util.stream.Stream;

public interface ResultListParser {
	Stream<? extends MatchParser> getResultsList();
}
