package com.ns.dev.utils.parser.xml;

import com.ns.dev.utils.parser.FileParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.stream.Stream;

public class XMLFileParser extends FileParser {
	
	public Stream<MatchParserXML> getStreamFromFile(String fileName){
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
		return objXMLResults.getResultsList();
	}
	
	private String getFilePathAndName(String fileName) {
		return getClass().getClassLoader()
							 .getResource(fileName)
							 .getPath();
	}
	
}
