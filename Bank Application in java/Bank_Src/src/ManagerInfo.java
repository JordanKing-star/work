import java.util.Scanner;

public class ManagerInfo {

	public int ManagerEntry(Customer cust[],int cnt) {
		
		Scanner sc = new Scanner(System.in);	
		
		CustomerInfo ci = new CustomerInfo();
		do {
			System.out.println("\t1 - Edit Manager Id\n\t2 - Edit Manager Name\n\t3 - Display All Customers");
			System.out.println("Enter Your Choice : ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("---------- All Customer Details ------------");
				for(int i=0;i<cnt;i++) {
					if(cust[0].getCustID()==0) {
						System.out.println("Sorry there is no one registered customer..");
						break;
					}
					else {
						System.out.println("------------ Customer "+(i+1)+" Details ------------");
						ci.showCust(cust[i]);
						
						System.out.println("----------------------------------------------------------");
					}
				}				
				break;
			default:
				System.out.println("Invalid Choice....");
			}
			System.out.println("If You Want To Continue To Manager Press [1] : ");						
		}while(sc.nextInt()==1);		
		sc.close();
		return 0;
	}
	
	public void getMan() {
		
	}
}