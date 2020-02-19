package com.bnk.validations;

import com.bnk.model.Account;
import com.bnk.model.Operation;
import com.bnk.model.Transaction;

public class OperationValidation {
	
	private Operation validatedOperation;
	
	private Account currentValidAccount;
	
	public Operation getValidatedOperation() {
		return validatedOperation;
	}

	public void setValidatedOperation(Operation validatedOperation) {
		if(validatedOperation instanceof Account){
				setCurrentValidAccount((Account) validatedOperation);
				this.validatedOperation = Account.createAccount(
						((Account) validatedOperation).isActive(), 
						((Account) validatedOperation).getAvailableLimit());
				this.validatedOperation.setViolations(((Account) validatedOperation).getViolations());
			}else {
				this.validatedOperation = Transaction.createTransaction(((Transaction) validatedOperation).getMerchant(), 
						((Transaction) validatedOperation).getAmount(), ((Transaction) validatedOperation).getTime());
				this.validatedOperation.setViolations(((Transaction) validatedOperation).getViolations());
		}
	}
	
	public void setCurrentValidAccount(Account currentValidAccount) {
		if(currentValidAccount.getViolations().isEmpty())
			this.currentValidAccount = Account.createAccount(currentValidAccount.isActive(), currentValidAccount.getAvailableLimit());
	}

	public Account getCurrentValidAccount() {
		return currentValidAccount;
	}

	private double accumulatedAmount = 0;
	
	public void restartAccumulatedAmount() {
		this.accumulatedAmount = 0;
	}
	
	public double getAccumulatedAmount() {
		return accumulatedAmount;
	}

	public void setAccumulatedAmount(double accumulatedAmount) {
		this.accumulatedAmount += accumulatedAmount;
	}

	public Operation validateOperation(Operation currentOperation, Operation previousOperation) {
		if(currentOperation instanceof Account) {//Account Validation
			AccountValidation validation = new AccountValidation();
			setValidatedOperation((Account) AccountValidation.validate(previousOperation, (Account) currentOperation));
			if(currentValidAccount.getViolations().isEmpty()) {// New Account
				restartAccumulatedAmount();
			}
		}else if(currentOperation instanceof Transaction) {//Transaction Validation
			TransactionValidation validation = new TransactionValidation(this.currentValidAccount, this.accumulatedAmount);
			validation.validate(previousOperation, (Transaction) currentOperation);
			setValidatedOperation(validation.getCurrentAccount());
			if(validation.getViolations().isEmpty()) {
				setAccumulatedAmount(((Transaction)currentOperation).getAmount());
			}
		}
		return currentOperation;
	}
	

}
