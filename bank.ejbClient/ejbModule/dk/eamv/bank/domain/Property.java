package dk.eamv.bank.domain;

public class Property {

	private final String regNumber;
	
	public static class Builder {
		private final String regNumber;
		
		public Builder(String regNumber) {
			this.regNumber = regNumber;
		}
		
		public Property Build() {
			return new Property(this);
		}
	}

	private Property(Builder builder) {
		regNumber = builder.regNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public Property setRegNumber(String regNumber) {
		return new Property.Builder(regNumber).Build();
	}
}
