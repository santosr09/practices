package com.bnk.utils;

public class RunApplication {
	
	public static void main(String []args) {
		OperationReader reader = new OperationReader();
		reader.readOperationsData("operations.txt");
	}

}
