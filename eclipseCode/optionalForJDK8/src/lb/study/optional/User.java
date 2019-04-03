package lb.study.optional;

public class User {
	
	public User() {}
	
	
	public User(String address, String name) {
		super();
		this.address = address;
		this.name = name;
	}


	private String address;

	private String name;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [address=" + address + ", name=" + name + "]";
	}
	
}
