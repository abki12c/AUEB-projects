public class Sale extends SaleOrder
{
	private static int codes = 0;
	public String saleDate;

	public int nextCode(){
		Sale.codes+=1;
		return Sale.codes;
	}

	public String getsaleDate(){
		return saleDate;
	}

	//constructor
	public Sale(String name,double price,int customerPhone, String customerName,String saleDate)
	{
		super(name,price,customerPhone,customerName);
		this.saleDate = saleDate;
		this.code=nextCode();

	}

	public String toString()
	{
		return "The product: "+this.getname()+" with code: "+this.getcode()+" has been sold at: "+this.getprice()+"$"+" on: "+this.getsaleDate();
	}


}
