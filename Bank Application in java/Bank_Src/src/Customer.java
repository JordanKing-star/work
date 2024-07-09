
public class Customer {

	private int custID=0;
	private String custName;
	private String mobNo;
	
	private Account acc[];
	
	private Address addr;

	public Customer(int custID, String custName, String mobNo, Account acc[], Address addr) {
		super();
		this.custID = custID;
		this.custName = custName;
		this.mobNo = mobNo;
		this.acc = acc;
		this.addr = addr;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public Account[] getacc() {
		return acc;
	}

	public void setacc(Account acc[]) {
		this.acc = acc;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
}
