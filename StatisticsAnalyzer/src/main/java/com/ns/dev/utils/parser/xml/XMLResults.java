package com.ns.dev.utils.parser.xml;

import com.ns.dev.stats.model.ResultListParser;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@XmlRootElement(name = "XMLResults")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLResults implements ResultListParser {
	
	@XmlElement(name = "matchResult")
	private List<MatchParserXML> XMLResultsList;

	public Stream<MatchParserXML> getResultsList(){
		return XMLResultsList.stream();
	}
	
}
