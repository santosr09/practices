package com.bnk.validations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.bnk.model.Account;
import com.bnk.model.Operation;
import com.bnk.model.Transaction;
import com.bnk.model.violations.AccountNotInitializedViolation;
import com.bnk.model.violations.CardNotActiveViolation;
import com.bnk.model.violations.InsufficientLimitViolation;
import com.bnk.model.violations.Violation;

public class TransactionValidation {
	
	private Account currentAccount;
	
	private LocalDateTime time;
	
	
	public LocalDateTime getTime() {
		return time;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	private double accumulatedAmount = 0;
	
	public void setAccumulatedAmount(double accumulatedAmount) {
		this.accumulatedAmount += accumulatedAmount;
	}
	
	public TransactionValidation(Account account, double acumulatedAmount) {
		this.currentAccount = Account.createAccount(account.isActive(), account.getAvailableLimit());
		this.accumulatedAmount = acumulatedAmount;
	}
	
	private List<Violation> violations = new ArrayList<Violation>();
	
	public List<Violation> getViolations() {
		return violations;
	}

	public void validate(Operation previousOperation, Transaction currentOperation){
		accountNotInitializedValidation(previousOperation);
		if(previousOperation instanceof Account) {
			cardActivatedValidation(currentOperation);
			validateAvailableLimit(currentOperation);
		}else if (previousOperation instanceof Transaction) {
			validateRemainingLimit(currentOperation);
			validateInterval(currentOperation);
		}
		currentAccount.setViolations(violations);
	}
	
	private void accountNotInitializedValidation(Operation previousOperation) {
		if(previousOperation == null) {
			violations.add(AccountNotInitializedViolation.createAccountNotInitializedViolation());
		}
	}
	
	private void cardActivatedValidation(Transaction currentOperation) {
		if(!currentAccount.isActive()) {
			violations.add(CardNotActiveViolation.createCardNotActiveViolation());
		}
	}
	
	private void validateAvailableLimit(Transaction currentOperation) {
		if(currentAccount.isActive()) {
			double amountOperation = currentOperation.getAmount();
			double newLimit = (this.currentAccount.getAvailableLimit() - amountOperation); 
			if(amountOperation > this.currentAccount.getAvailableLimit()) {
				violations.add(InsufficientLimitViolation.createInsufficientLimitViolation());
			}else {
				currentAccount.setAvailableLimit(newLimit);
			}
		}
	}
	
	private void validateRemainingLimit(Transaction currentOperation) {
		double amountOperation = currentOperation.getAmount();
		double newLimit = this.currentAccount.getAvailableLimit() - amountOperation;
		if(amountOperation > this.accumulatedAmount) {
			violations.add(InsufficientLimitViolation.createInsufficientLimitViolation());
		}else {
			currentAccount.setAvailableLimit(newLimit);
		}
	}
	
	private void validateInterval(Transaction currentOperation) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		time = LocalDateTime.parse(currentOperation.getTime(), formatter);
	}

}
