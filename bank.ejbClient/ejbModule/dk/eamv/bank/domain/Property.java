package dk.eamv.bank.domain;

public class Property {

	private final String key;
	private final String value;
	
	public static class Builder {
		private final String key;
		private final String value;
		
		public Builder(String key, String value) {
			this.key = key;
			this.value = key;
		}
		
		public Property Build() {
			return new Property(this);
		}
	}

	private Property(Builder builder) {
		key = builder.key;
		value = builder.value;
	}

	public String getKey() {
		return key;
	}

	public Property setKey(String key) {
		return new Property.Builder(key, this.value).Build();
	}
	
	public String getValue() {
		return value;
	}
	
	public Property setValue(String value) {
		return new Property.Builder(this.key, value).Build();
	}
}
