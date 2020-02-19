package com.bnk.validations;

import java.util.ArrayList;
import java.util.List;

import com.bnk.model.Account;
import com.bnk.model.Operation;
import com.bnk.model.violations.AccountInitializedViolation;
import com.bnk.model.violations.Violation;

public class AccountValidation {
	
	private static Account validatedAccount;
	
	private static List<Violation> violations = new ArrayList<Violation>();
	
	private static void setValidatedAccount(Account account) {
		validatedAccount = Account.createAccount(account.isActive(), account.getAvailableLimit()); 
		validatedAccount.setViolations(violations);
	}
	
	public List<Violation> getViolations() {
		return violations;
	}

	public static Operation validate(Operation previousOperation, Account currentOperation){
		if(previousOperation != null) {
			accountInitializedValidation(previousOperation);
		}
		setValidatedAccount(currentOperation);
		return validatedAccount;
	}
	
	private static void accountInitializedValidation(Operation previousOperation) {
		if(previousOperation instanceof Account) {
			violations = new ArrayList<Violation>();
			violations.add(AccountInitializedViolation.createAccountInitializedViolation());
		}else {
			violations.clear();
		}
	}
	
}
