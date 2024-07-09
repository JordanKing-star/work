import java.util.Date;
public class Bill {
	private int billno;
	private double cgst;
	private double sgst;
	private double total;
	private double finaltotal;
	private Date today;
	public Bill(int billno, double cgst, double sgst, double total, double finaltotal, Date today) 
	{
		this.billno = billno;
		this.cgst = cgst;
		this.sgst = sgst;
		this.total = total;
		this.finaltotal = finaltotal;
		this.today = today;
	}
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getFinaltotal() {
		return finaltotal;
	}
	public void setFinaltotal(double finaltotal) {
		this.finaltotal = finaltotal;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}

}
