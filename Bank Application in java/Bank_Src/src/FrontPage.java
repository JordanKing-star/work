import java.util.Scanner;

import org.omg.CORBA_2_3.portable.OutputStream;

public class FrontPage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Customer C[] = new Customer[10];
		
		
		CustomerInfo CI = new CustomerInfo();
		ManagerInfo MI = new ManagerInfo();
		
		int cnt =0;
		
		String ch;
		do {
			System.out.println("----------------- Front Page ----------------- ");
			System.out.println("1 - Manager\n2 - Customer");
			System.out.println("Enter Your Choice : ");
			int cho = sc.nextInt();
			switch (cho) {
			case 1:
				MI.ManagerEntry(C,cnt);
				break; 
			case 2:
				cnt = CI.CustomerEnter(C);
				break;
			
			default:
				System.out.println("You Entered Invalid Choice....");
			}
			System.out.println("If You Want To Continue To Front Page Press [1] : ");			
		}while(sc.nextInt()==1);
		sc.close();
	}
}


//System.out.println("\t1 - Create Customer\n\t2 - Display Customer\n\t3 - Search Customer\n\t4 - Delete Customer\n\t5 - Transaction");