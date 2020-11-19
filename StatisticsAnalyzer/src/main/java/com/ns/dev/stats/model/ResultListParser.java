package com.ns.dev.stats.model;

import java.util.stream.Stream;

public interface ResultListParser {
	Stream<MatchParserXML> getResultList();
}
