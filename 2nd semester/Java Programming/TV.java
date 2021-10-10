public class TV extends Sound_Image implements Checking
{
  private String type;
  private int inches;
  private String display;
  private String ports;


public  TV (String name,int age,String manufacturer,double price,String type,int inches,String display,String ports)
{
  super(name,age,manufacturer,price);

  settype(type);
  setinches(inches);
  setdisplay(display);
  setports(ports);

}

  public void settype(String type){
    this.type= Checking.CheckInput("LCD","LED","Plasma",type,"TV type");
  }

  public void setinches(int inches){
    this.inches=inches;
  }

  public void setdisplay(String display){
    this.display=display;
  }

  public void setports(String ports){
    this.ports= Checking.CheckInput("HDMI","DVI","Composite",ports,"TV port");
  }

  public String gettype(){
    return type;
  }

  public int getinches(){
    return inches;
  }

  public String getdisplay(){
    return display;
  }

  public String getports(){
    return ports;
  }

  //toString
    public String toString()
    {
      return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"\nType:"+type+"\nDiameter In Inches:"+inches+"\nDisplay:"+display+"\nOutput:"+ports;
    }
}
