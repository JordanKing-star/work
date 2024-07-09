import java.util.Scanner;
import java.util.Date;
public class ShopInfo {
	int ch,i;
	
	public Customer accept() 
	{
		Scanner sc=new Scanner(System.in);

			System.out.println("\n\tEnter Customer id :");
			int custId=sc.nextInt();
			
			System.out.println("\n\tEnter Customer Name :");
			String custName=sc.next();
			
			
			System.out.println("\n\tEnter City :");
			String ct=sc.next();

			System.out.println("\n\tEnter State :");
			String st=sc.next();

			System.out.println("\n\tEnter Pin Code :");
			int pincode=sc.nextInt();
			
			Address addr=new Address(ct,st,pincode);

			
			Product prodarr[]=new Product[3];
			System.out.println("\n\n**You can purchase 3 products Now ...");
			for( i=0;i<prodarr.length;i++) {
				Product pobj=new Product();

				System.out.println("Enter Product ID of "+(i+1)+" Product");
				pobj.setProdId(sc.nextInt());

				System.out.println("Enter Product Name of "+(i+1)+" Product");
				pobj.setProdName(sc.next());

				System.out.println("Enter Product Price of "+(i+1)+" Product");
				pobj.setProdPrice(sc.nextDouble());

				System.out.println("Enter Product Quantity of "+(i+1)+" Product");
				pobj.setQuantity(sc.nextInt());

				prodarr[i]=pobj;
				System.out.println("\n");	
		}
		
			Customer cust=new Customer(custId, custName, addr,prodarr);
		return cust;
	}
	public void calculate(Customer cust) 
	{
		double total=0,finaltotal;
		double sgst,cgst;
		
		Product arr[]=cust.getProd();
		//Product arr[]=cust[i].getProd();
		for(Product p:arr)
		{
			total=total+(p.getProdPrice()*p.getQuantity());
		}
		cgst=total*0.06;
		sgst=total*0.06;
		finaltotal=total+cgst+sgst;
		Date d=new Date();
		Bill bill=new Bill(501,cgst,sgst,total,finaltotal,d);
		cust.setBill(bill);

	}
	public void display(Customer cust)
	{
		System.out.println("----------------*CUSTOMER DETAILS*----------------\n");
		System.out.println("Customer Id :" +cust.getCustId());
		System.out.println("Customer Name :"+cust.getCustName());
	}
	public void Billdetails(Customer cust)
	{
		System.out.println("\n\t----------------------------*BILL DETAILS*----------------------------");
		Bill bill=cust.getBill();
		//System.out.println("Bill No :"+cust.getBill().getBillno);
		System.out.println("\tTOTAL :"+cust.getBill().getTotal());
		System.out.println("\tCGST :"+cust.getBill().getCgst());
		System.out.println("\tSGST :"+cust.getBill().getSgst());
		System.out.println("\tFinal Total :"+cust.getBill().getFinaltotal());
		System.out.println("\tDate of Bill :"+cust.getBill().getToday());		
		System.out.println("\t----------------------------------------------------------------------");

	}
	public void AddrProd(Customer cust)
	{
		System.out.println("\n\t--------------------*ADDRESS DETAILS*--------------------");
		Address a=cust.getAddr();
		System.out.println("\n\tCustomer City\tCustomer State\tCustomer Pincode");
		System.out.println("\n\t"+cust.getAddr().getCity()+"\t"+cust.getAddr().getState()+"\t"+cust.getAddr().getPincode());
		System.out.println("\t---------------------------------------------------------");

		System.out.println("\n\t--------------------------*Product LIST*-------------------------------");
		Product prodarr[]=cust.getProd();
		System.out.println("\n\tProduct Id \tProduct Name \tProduct Price \tProduct quantity");
		for(i=0;i<prodarr.length;i++) 
		{
			System.out.println("\t"+prodarr[i].getProdId()+" \t"+prodarr[i].getProdName()+" \t"+prodarr[i].getProdPrice()+" \t"+prodarr[i].getQuantity());
		}
		System.out.println("\t-----------------------------------------------------------------------");
		
	}
}

