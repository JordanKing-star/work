import java.util.Scanner;

public class TransInfo {
	
	public int Trans(Account arr[],int cnt) {
		Transaction t = new Transaction();
		String ch;
		int i;
		Scanner sc = new Scanner(System.in);
		boolean f = false;
		System.out.println("Enter Account Number For Transaction : ");
		int ano = sc.nextInt();
		for(i = 0;i<cnt;i++) {			
			if(arr[i].getAccNo() == ano) {
				f = true;
				break;
			}
			else
			{
				System.out.println("There is no Account found..for this Number");
			}
		}
		if(f) {
			
				System.out.println("------------------ Welcome To Transaction ------------------");
				System.out.println("\n\t1 - Deposit\n\t2 - Withdrawl");
				System.out.println("Enter Your Choice : ");
				int cho = sc.nextInt();
				switch (cho) {
				case 1 :
					System.out.println("----------------- Welcome To Deposit -----------------");
					System.out.println("Enter Amount To Deposit : ");
					t.Deposit(arr[i],sc.nextDouble());
					break;
				case 2 :
					System.out.println("------------------ Welcome To Withdrawl ---------------");
					System.out.println("Enter Amount To Withdrawl : ");
					t.Withdrawl(arr[i],sc.nextDouble());
					break;
				default :
					System.out.println("Invalid Choice....");		
				}
				System.out.println("Your Account Balance Is : "+arr[i].getAccBal());
				
			
		}
		else {
			System.out.println("Oops!! Account Not Found :(");
		}
		sc.close();
		return 0;
	}
	
	

}
