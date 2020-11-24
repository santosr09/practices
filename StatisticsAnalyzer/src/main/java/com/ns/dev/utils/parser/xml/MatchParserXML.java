package com.ns.dev.utils.parser.xml;

import com.ns.dev.utils.parser.MatchParser;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@XmlRootElement(name = "matchResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchParserXML extends MatchParser {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MatchParserXML that = (MatchParserXML) o;
		return Objects.equals(date, that.date) &&
							 Objects.equals(local, that.local) &&
							 Objects.equals(visitor, that.visitor) &&
							 Objects.equals(score, that.score);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, local, visitor, score);
	}
}
