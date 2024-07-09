import java.util.Scanner;

public class ShoppingMain 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int ch;
		String cho;
		ShopInfo si=new ShopInfo();
		Customer cust=new Customer(0, null, null, null);
		RegisterLogin r=new RegisterLogin();
		Administrator ad=new Administrator();
		System.out.println("\t\t    | |------*BIG BAZAAR ONLINE-SHOPPING*-----| |");
		System.out.println("\t**________________________________________________________________________________________**");
		System.out.println("\t\t\t   <- Buy. Think. Grow. ->");
		System.out.println("\t\t  Near Pavillion Mall,University Road Opp,Pune, Maharashtra-411007\t");
		System.out.println("\n\t**________________________________________________________________________________________**");
		System.out.println("\n\n\n\t\t1.USER\t\t\t\t2.ADMINISTRATOR\t");
		System.out.println("\nEnter Your Choice :");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1://USER
			System.out.println("\n\t1.REGISTER\n\t2.LOGIN");
			System.out.println("\n\tEnter Your Choice :");
			ch=sc.nextInt();
			if(ch==1)			
			{							
				r.reg();
				System.out.println("\n\t\t --For LOG-IN Press L :");
				cho=sc.next();
				if(cho.equals("L")||cho.equals("l")){
					r.Log(cust);
				}					
			}
			if(ch==2)
			{			
				r.Log(cust);
			}
			break;
		case 2://ADMINISTRATOR
			ad.admin(cust);
			break;		
		/*si.calculate(cust);
		si.display(cust);
		}*/
		}
	}
}