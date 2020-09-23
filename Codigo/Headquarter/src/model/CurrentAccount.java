package model;

public class CurrentAccount {

	//------------------------------------------------------------------------------------
	
	//Constants of the CurrentAccount class
	
	public static double DEFAULT_CREDIT = 5000000;
	
	public static double POLICY_RATE = 0.05;
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the CurrentAccount class
	
	private String number;
	
	private double availableCredit;
	
	private double balanceToPay;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the DebitCard class

	public CurrentAccount(String number) {
		
		this.number = number;
		
		availableCredit = DEFAULT_CREDIT;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the DebitCard class

	public String getNumber() {
		return number;
	}

	public double getAvailableCredit() {
		return availableCredit;
	}

	public double getBalanceToPay() {
		return balanceToPay;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the DebitCard class

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setBalanceToPay(double balanceToPay) {
		this.balanceToPay = balanceToPay;
	}

	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}

	//------------------------------------------------------------------------------------
	
	// Operations of the DebitCard class
	
	public boolean pay(double amount) {
		if(balanceToPay - amount > 0) {
			balanceToPay -= amount;
			availableCredit += amount*(1/(1 + POLICY_RATE));
			return true;
		}
		else {
			return false;
		}
		
		
	}

	public boolean use(double amount) {
		if(availableCredit > 0) {
			availableCredit -= amount;
			balanceToPay += amount*(1 + POLICY_RATE);
			return true;
		}
		else {
			return false;
		}
	}
	
	//------------------------------------------------------------------------------------
	
}
