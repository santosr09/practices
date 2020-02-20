package com.ns.dev.utils.parser;

import com.ns.dev.stats.model.ResultListXML;
import com.ns.dev.stats.model.ResultType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLFileParser extends FileParser{
	
	public List<ResultType> convertFileToResult(String fileName){
		File xmlFile = new File(fileName);
		ResultListXML resultListXML = null;
		JAXBContext jaxbContext;
		try
		{
			jaxbContext = JAXBContext.newInstance(ResultListXML.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			resultListXML = (ResultListXML) jaxbUnmarshaller.unmarshal(xmlFile);
			//resultListXML.getXMLResults().forEach(item -> item.setGoals());
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return resultListXML.getResultList();
	}
	
}
