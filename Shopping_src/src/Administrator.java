import java.util.Scanner;

public class Administrator {

	private int a;
	private int i=0;
	
	RegisterLogin rl=new RegisterLogin();
	ShopInfo si=new ShopInfo();
	
	public void admin(Customer cust)
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("------*WELCOME ADMIN*-------");
		System.out.println("\n\t1->Customer Details\n\t2->Bill Details");
		System.out.println("\n\tEnter Your Choice :");
		a=sc.nextInt();
		switch(a)
		{
		case 1:
			System.out.println("\tCustomer ID-"+cust.getCustId());
			System.out.println("\tUserName -"+rl.getName());
			System.out.println("\tPassWord -"+rl.getPassword());
			System.out.println("\tMobile No. -"+rl.getMob());
			System.out.println("\tE-mail ID -"+rl.getMail());
			si.AddrProd(cust);
			System.out.println("--------------------------------------------------");
			break;
		case 2:
			si.Billdetails(cust);
			break;
		}
		
	}
}
