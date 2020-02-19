package com.bnk.model.violations;

public class CardNotActiveViolation extends Violation {
	
	private static final long serialVersionUID = 2518584796726438404L;

	private static CardNotActiveViolation violation;
	
	final static String VIOLATION_DETAIL = "card-not-active";
	
	public static String getViolationDetail() {
		return VIOLATION_DETAIL;
	}
	
	private CardNotActiveViolation() {}
	
	public static CardNotActiveViolation createCardNotActiveViolation() {
		if(violation == null) {
			violation = new CardNotActiveViolation();
			return violation;
		}else {
			return violation;
		}
	}
	
	@Override
	public String toString() {
		return VIOLATION_DETAIL;
	}

}
