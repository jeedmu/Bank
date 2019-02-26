package dk.eamv.bank.domain;

public class Bank {

	private final String bankName;
	private final int regNumber;
	
	public static class Builder {
		private final String bankName;
		private final int regNumber;
		
		public Builder(String bankName, int regNumber) {
			this.bankName = bankName;
			this.regNumber = regNumber;
		}
		
		public Bank Build() {
			return new Bank(this);
		}
	}

	private Bank(Builder builder) {
		bankName = builder.bankName;
		regNumber = builder.regNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public Bank setBankName(String bankName) {
		return new Bank.Builder(bankName, this.regNumber).Build();
	}
	
	public int getRegNumber() {
		return regNumber;
	}

	public Bank setRegName(int regNumber) {
		return new Bank.Builder(this.bankName, regNumber).Build();
	}
}
