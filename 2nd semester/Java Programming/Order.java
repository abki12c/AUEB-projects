public class Order extends SaleOrder
{
	//vairables
	private String status;
	public static int codes = 0;
	public String orderDate;
	public String arriveDate;

	public void setstatus(String status)
	{
		this.status = status;
	}


	public int nextCode(){
		Order.codes+=1;
		return Order.codes;
	}


	public String getarriveDate(){
		return arriveDate;
	}

	public String getorderDate(){
		return orderDate;
	}

	public String getstatus()
	{
		return this.status;
	}

	//constructor
	public Order(String name,double price,int phone, String customerName,String orderDate,String arriveDate)
	{
		super(name,price,phone,customerName);
		this.orderDate = orderDate;
		this.arriveDate =  arriveDate;
		this.setstatus("EXPECTED");
		this.code=nextCode();
	}

	public String toString()
	{
		return "The product: "+this.getname()+" with code: "+this.getcode()+" has been ordered at: "+this.getprice()+"$"+" on: "+this.getorderDate()+" and it will arrive on: "+this.getarriveDate();
	}
}
