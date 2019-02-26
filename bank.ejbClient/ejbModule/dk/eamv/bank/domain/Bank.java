package dk.eamv.bank.domain;

public class Bank {

	private final String bankName;
	
	public static class Builder {
		private final String bankName;
		
		public Builder(String bankName) {
			this.bankName = bankName;
		}
		
		public Bank Build() {
			return new Bank(this);
		}
	}

	private Bank(Builder builder) {
		bankName = builder.bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public Bank setBankName(String bankName) {
		return new Bank.Builder(bankName).Build();
	}
}
