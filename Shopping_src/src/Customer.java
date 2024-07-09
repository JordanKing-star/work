public class Customer {
	private int custId;
	private String custName;	
	private Product prod[];
	private Address addr;
	private Bill bill;
	public Customer(int custId, String custName,Address addr, Product prod[]) 
	{
		this.custId = custId;
		this.custName = custName;
		this.addr=addr;
		this.prod = prod;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Product[] getProd() {
		return prod;
	}
	public void setProd(Product prod[]) {
		this.prod = prod;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}

}
