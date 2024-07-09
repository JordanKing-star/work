
public class Transaction {

	int i=0;
	public void Deposit(Account a,double amt) {

		double bal=a.getAccBal()+amt;
		a.setAccBal(bal);	

	}

	public void Withdrawl(Account a,double amt) {

		if(a.getAccBal()-amt >=500) {
			amt = a.getAccBal() - amt;
			a.setAccBal(amt);
		}
		else {
			System.out.println("Insufficient Amount In Your Account...Kindly Try Later...");
		}
	}	
}