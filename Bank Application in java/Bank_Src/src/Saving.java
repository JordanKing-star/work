import java.util.Scanner;

public class Saving extends Account{
	
	Scanner sc=new Scanner(System.in);
	
	private int interest;

	public Saving(int accNo, String accType, double accBal, int interest) {
		super(accNo, accType, accBal);
		this.interest = interest;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}	
}
