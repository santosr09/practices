package com.ns.dev.utils.parser;

import com.ns.dev.stats.model.MatchParser;
import com.ns.dev.stats.model.XMLResults;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.stream.Stream;

public class XMLFileParser extends FileParser{
	
	public Stream<MatchParser> getStreamFromFile(String fileName){
		File xmlFile = new File(getFilePathAndName(fileName));
		XMLResults objXMLResults = null;
		JAXBContext jaxbContext;
		try
		{
			jaxbContext = JAXBContext.newInstance(XMLResults.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			objXMLResults = (XMLResults) jaxbUnmarshaller.unmarshal(xmlFile);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return objXMLResults.getResultList();
	}
	
	private String getFilePathAndName(String fileName) {
		return getClass().getClassLoader()
							 .getResource(fileName)
							 .getPath();
	}
	
}
