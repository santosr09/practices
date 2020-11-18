package com.bnk.utils;

import java.io.*;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import com.bnk.model.Account;
import com.bnk.model.Operation;
import com.bnk.model.Transaction;
import com.bnk.validations.OperationValidation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OperationReader {
	
	
	public void outputOperations(List<Operation> operationsResponse) {
		Charset utf8 = StandardCharsets.UTF_8;
                
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("operationsResponse.txt"), utf8)
        )) {
        	JSONArray.writeJSONString(operationsResponse, writer);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        
	}

	public Map<String, Account> readOperationsData(String fileName) {
		Map<String, Account> customers = null;

		Path pathFile = getFilePath.apply(fileName);
		List<String> list = new ArrayList<>();

		List<Operation> operationsToProcess = new ArrayList<Operation>();
		List<Operation> operationsResponse = new ArrayList<Operation>();

		//try (Stream<String> stream = Files.lines(pathFile)) {
		Stream<String> stream = FileLoader.loadFile(fileName);

			Iterator<String> iterator = stream.iterator();
			int count = 0;
			OperationValidation validation = new OperationValidation();
			while(iterator.hasNext()) {
				String line = (String) iterator.next();
				operationsToProcess.add(operationFromJSON.apply(getJsonFromString.apply(line)));	
				System.out.println(line);
				Operation previousOperation = (count == 0)?null:operationsToProcess.get(count-1);
				validation.validateOperation(operationsToProcess.get(count), previousOperation); 
				Operation responseAccount = validation.getValidatedOperation();
				operationsResponse.add(count, responseAccount);
				count++;
			}
			
			for(Operation item:operationsResponse) {
				System.out.println(item);
			}
			outputOperations(operationsResponse);
		
		list.forEach(System.out::println);

		return customers;
	}


	/**
	 * Retrieve the Path for the specified file
	 */
	public Function<String, Path> getFilePath = filename -> {
		ClassLoader cl = getClass().getClassLoader();
		return Paths.get(cl.getResource(filename).getPath());
	};

	/**
	 * Read the JSON entry and return customer Id
	 */
	private Function<String, JSONObject> getJsonFromString = c -> {
		JSONParser parser = new JSONParser();
		try {
			return (JSONObject) parser.parse(c);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	};

	private Function<JSONObject, Operation> operationFromJSON = c -> {
		Operation operation = null;
		for (Object key : c.keySet()) {
			switch ((String) key) {
			case "account":
				final JSONObject account = (JSONObject) c.get("account");
				Account accountObj = Account.createAccount((Boolean) account.get("active-card"),
						(Long) account.get("available-limit"));
				operation = accountObj;
				break;
			case "transaction":
				final JSONObject transaction = (JSONObject) c.get("transaction");
				Transaction transactionObj = Transaction.createTransaction((String) transaction.get("merchant"),
						Double.parseDouble(transaction.get("amount").toString()), (String) transaction.get("time"));
				operation = transactionObj;
				break;
			}
		}

		return operation;
	};

}
