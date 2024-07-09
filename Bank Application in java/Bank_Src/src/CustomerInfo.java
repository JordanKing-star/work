import java.util.Scanner;

public class CustomerInfo {

	Scanner sc = new Scanner(System.in);
	AccountInfo ai = new AccountInfo();	
	//Account aobj= new Account[2];
	TransInfo T= new TransInfo();

	public int CustomerEnter(Customer arr[]) {

		int i=0,k=0,m=0;
		do {			
			Customer c = new Customer(0, null, null, null, null);
			arr[i]= c;
			System.out.println("\t1 - Register \n\t2 - Login\n\t3 - Display Details");
			System.out.println("Enter Your Choice : ");
			int cho = sc.nextInt();
			switch(cho) {
			case 1:
				System.out.println("--------------- Cutomer Details ---------------");
				System.out.println("Enter Customer Id : ");
				int custID = sc.nextInt();
				arr[i].setCustID(custID);

				System.out.println("Enter Customer Name : ");
				String custName = sc.next();
				arr[i].setCustName(custName);

				System.out.println("Enter Mobile Number : ");
				String mobNo = sc.next();
				arr[i].setMobNo(mobNo);			
				i++;								
				break;				
			case 2:
				//Customer temp = new Customer(0, null, null, null, null);
				System.out.println("---- Welcome To Login -----");
				System.out.println("Enter Customer Id : ");
				custID= sc.nextInt();
				k = checkid(arr, i, custID);
				if(k>-1) {					
					System.out.println("Successsfully Logged In....");
					Account accarr[] = new Account[2];
					showCust(arr[k]);
					int z =0;
					System.out.println("--------------------------------------------------------");					
					do {
						Account aobj = null;
						System.out.println("\n\t1 - Saving\n\t2 - Current\n3 - Transaction");
						System.out.println("Enter Your Choice : ");
						int ch = sc.nextInt();
						switch(ch) {					
						case 1:
							System.out.println("-------------- Welcome To Saving Account -------------");
							System.out.println("Your Account Number Is : ");
							aobj=ai.Create(1);
							m++;							
							break;
						case 2:
							System.out.println("-------------- Welcome to Current Account ------------");
							System.out.println("Your Account Number Is : ");
							aobj=ai.Create(2);
							m++;	
							break;
						case 3:
							int d;
							do {
								T.Trans(accarr, i);

								System.out.println("\nIf You Want To Continue To Transaction Press 1 : ");
								
							}while(sc.nextInt()==1);
							break;
						default:
							System.out.println("Invalid Choice....");
						}
						accarr[z]=aobj;
						if(m >0){
							arr[i].setacc(accarr);
							showAccount(accarr,m);
						}
						z++;
						System.out.println("If You Want To Stay Logged In Press [1] : ");										
					}while(sc.nextInt()==1);
				}
				else {
					System.out.println("Something Went Wrong...");
				}								
				break;
			case 3:
				System.out.println();
				System.out.println("Enter Customer Id : ");
				custID = sc.nextInt();
				k = checkid(arr, i, custID);			
				if(k>-1) {
					showCust(arr[k]);
				}
				else {
					System.out.println("Customer Not Found....");
				}				
				break;	
			default:
				System.out.println("You Enter Invalid Choice....");
			}
			System.out.println("If You Want to Continue To Customer Press [1] : ");
		}while(sc.nextInt()==1);
		return i;
	}

	public static void showCust(Customer cust) {		
		System.out.println("----------------- Customer Details ----------------");
		System.out.println("Customer Id\t:\t"+cust.getCustID());
		System.out.println("Customer Name\t:\t"+cust.getCustName());
		System.out.println("Customer MobNo\t:\t"+cust.getMobNo());
	}
	public static void showAccount(Account a[],int m) {

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

	public static int checkid(Customer cust[],int cnt,int custID) {
		int j,k=-1;
		for(j=0;j<=cnt;j++) {
			if(custID == cust[j].getCustID()) {			
				k=j;
				break;
			}
		}
		return k;
	}
}