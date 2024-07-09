import java.util.Scanner;

public class AccountInfo {

	Scanner sc=new Scanner(System.in);
	public Account Create(int r)
	{
		Scanner sc = new Scanner(System.in);
		Account a = new Account(0,null,0);
		System.out.println("Enter Account Number :");
		int accNo=sc.nextInt();						
		
		if(r==1){
			double accBal = 500;
			String accType="Saving";
			System.out.println("Enter Interest Rate : ");
			int interest=sc.nextInt();
			a = new Saving(accNo,accType,accBal,interest);
		}
		if(r==2){
			double accBal = 1000;
			String accType="Current";
			System.out.println("Enter Company Name : ");
			String comName=sc.next();
			a = new Current(accNo,accType,accBal,comName);
		}
		return a;
	}	
	public void display(Account a[],int m)
	{
		for(int i=0;i<m;i++) {
			System.out.println("------------- ACCOUNT DETAILS --------------");
			System.out.println("\nAccount No\t: "+a[i].getAccNo());
			System.out.println("\nAccount Type\t: "+a[i].getAccType());
			System.out.println("\nAccount Balance\t: "+a[i].getAccBal());
			if(a[i] instanceof Saving)
			{
				Saving s=(Saving)a[i];//downcasting
				System.out.println("\nInterest Rate is\t: "+s.getInterest());
			}
			if(a[i] instanceof Current)
			{
				Current c=(Current)a[i];
				System.out.println("\nCompany Name is\t: "+c.getComName());
			}
		}
	}
}