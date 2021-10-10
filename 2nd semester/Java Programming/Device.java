import java.util.Random;
public class Device {

  protected String name;
  private  int age;
  private  String manufacturer;
  protected double price;
  protected int code;
  protected int pieces;
  private int id;

  //get
  public String getname(){
    return name;
  }

  public double getprice(){
    return price;
  }

  public String getmanufacturer(){
    return manufacturer;
  }

  public int getage(){
    return age;
  }

  public int getcode(){
    return this.code;
  }

  public int getpieces()
  {
    return pieces;
  }

  //set
  public void setpieces(int pieces)
  {
    this.pieces = pieces;
  }

  public void setcode(int code){
    this.code = code;
  }

  public void setmanufacturer(String manufacturer){
    this.manufacturer=manufacturer;
  }

  public void setage(int age){
    this.age = age;
  }
  
//constructor
  public  Device(String name,int age,String manufacturer,double price)
  {
    this.name = name;
    this.age = age;
    this.manufacturer = manufacturer;
    this.price = price;
    this.id = this.age - (int)Math.round(this.price) + this.name.length() + this.manufacturer.length();
    Random rand = new Random();
    this.code=rand.nextInt(1000000);
  }

  public  Device(String name,double price)
  {
    this.name = name;
    this.price = price;
  }

  public  Device(){}

  @Override
  public boolean equals(Object obj)
  {
    Device device = (Device) obj;
    return device.getname().equals(this.getname()) && device.getprice() == this.getprice() && device.getage() == this.getage() && device.getmanufacturer().equals(this.getmanufacturer()) && this.id == device.id ;
  }

  @Override
  public int  hashCode()
  {
    return this.id;
  }

}
