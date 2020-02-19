package com.bnk.validations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bnk.model.Account;
import com.bnk.model.Operation;
import com.bnk.model.violations.AccountInitializedViolation;

class AccountValidationTest {
	
	AccountValidation validation;
	
	static List<String> Operations = List.of(
			"{\"account\": {\"active-card\": true, \"available-limit\": 100}}",
			"{\"account\": {\"active-card\": false, \"available-limit\": 250}}",
			"{\"transaction\": {\"merchant\": \"Burger King\", \"amount\": 20, \"time\":\"2019-02-13T10:00:00.000Z\"}}",
			"{\"transaction\": {\"merchant\": \"Habbib's\", \"amount\": 90.55, \"time\": \"2019-02-13T11:00:00.000Z\"}}",
			"{\"account\": {\"active-card\": true, \"available-limit\": 310}}",
			"{\"transaction\": {\"merchant\": \"Burger King\", \"amount\": 20, \"time\":\"2019-02-13T10:00:00.000Z\"}}",
			"{\"account\": {\"active-card\": true, \"available-limit\": 100}}",
			"{\"account\": {\"active-card\": true, \"available-limit\": 250}}",
			"{\"transaction\": {\"merchant\": \"Walmart\", \"amount\": 20.78, \"time\":\"2019-02-13T10:00:00.000Z\"}}",
			"{\"transaction\": {\"merchant\": \"Comex\", \"amount\": 340.54, \"time\":\"2019-02-13T10:11:00.000Z\"}}",
			"{\"transaction\": {\"merchant\": \"Sams\", \"amount\": 50.98, \"time\":\"2019-02-13T10:20:00.000Z\"}}"			
			);
	
	static Operation currentOperation;
	static Operation previousOperation;
	static JSONParser parser = new JSONParser();
	
	@BeforeAll
	private static void setUpFirstLineTest() {
		JSONObject jsonAccountA;
		JSONObject jsonAccountB;
		try {
			jsonAccountA = (JSONObject) ((JSONObject) parser.parse("{\"account\": {\"active-card\": true, \"available-limit\": 100}}")).get("account");
			jsonAccountB = (JSONObject) ((JSONObject) parser.parse("{\"account\": {\"active-card\": true, \"available-limit\": 300}}")).get("account");
			
			Account accountObj = Account.createAccount(
					(Boolean) jsonAccountA.get("active-card"),
					(Long) jsonAccountA.get("available-limit"));
			
			Account accountObjB = Account.createAccount(
					(Boolean) jsonAccountB.get("active-card"),
					(Long) jsonAccountB.get("available-limit"));
			
			previousOperation = accountObjB;
			
			currentOperation = accountObj;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	@DisplayName("The Operation is the first line of stream, no previous transaction")
	void testFirstLineOfTransaction() {
		Account validatedAccount;
		validatedAccount = (Account) AccountValidation.validate(null, (Account) currentOperation);
		assertTrue(validatedAccount.getViolations().isEmpty());
	}
	
	@Test
	@DisplayName("The Account has been already initialazed")
	void testAccountInitialazed() {
		Account validatedAccount;
		validatedAccount = (Account) AccountValidation.validate(previousOperation, (Account) currentOperation);
		assertTrue(validatedAccount.getViolations().get(0).toString().equals(AccountInitializedViolation.getViolationDetail().toString()));
	}

}
