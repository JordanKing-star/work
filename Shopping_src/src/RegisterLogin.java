import java.util.Scanner;

public class RegisterLogin{//register class

	Scanner sc=new Scanner(System.in);
	
	ShopInfo sf=new ShopInfo();
	private int i=0;
	int choice;
	private String cho;
	private String user,Name;
	private String pass,password;
	private String mob;
	private String mail;


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	public void reg()
	{
		System.out.println("Enter Your Username :");
		user=sc.next();
		System.out.println("Enter Your Password :");
		pass=sc.next();
		System.out.println("Enter Your Mobile No :");
		mob=sc.next();
		System.out.println("Enter Your Email-ID :");
		mail=sc.next();

		System.out.println("\n\t\tRegistered Successfullyy ! !...");
	}
	public void Log(Customer cust)
	{
		System.out.println("Enter Your Registered Username :");
		Name=sc.next();
		System.out.println("Enter Your Registered Password :");
		password=sc.next();
		if(Name.contentEquals(user) && pass.contentEquals(pass))
		{
			System.out.println("\n\t**...Logged In SuccessFullyy....");
			do{
				System.out.println("\t******************************************\t");
				System.out.println("\t\t1-Purchase Products\n\t\t2-Bill Details\n\t\t3-Display Details");
				System.out.println("\t******************************************\t");
				System.out.println("\n\tEnter Your Choice :");
				choice=sc.nextInt();

				if(choice== 1)
				{
					System.out.println("NOTE - You Should Give Your Adress Details to Purchase the Products ->");
					cust=sf.accept();
				}
				if(choice== 2)
				{		
					sf.calculate(cust);

					System.out.println("....BILL Calculated...."); 

					sf.Billdetails(cust);

				}
				if(choice== 3)
				{
					sf.display(cust);
					display2();
					sf.AddrProd(cust);			
				}
				System.out.println("\n\tDo you want to Continue to Our Site ...Press C:");
				cho=sc.next();

			}while(cho.equals("c")||cho.equals("C"));
		}


	}
	public void display2()
	{
		System.out.println("Username :"+Name);
		System.out.println("Password :"+password);
		System.out.println("E-Mail ID :"+mail);
		System.out.println("Mobile No :"+mob);

	}
}
