import java.util.Scanner;

public class Current extends Account {
	
	Scanner sc=new Scanner(System.in);
	private String comName;
	
	public Current(int accNo, String accType, double accBal, String comName) {
		super(accNo, accType, accBal);
		this.comName = comName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
}
