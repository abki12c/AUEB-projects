public class Players extends Sound_Image implements Checking
{
  //variables
  private String type;
  private String  resolution;
  private String format;



//set
  public void settype(String type)
  {
    this.type=Checking.CheckInput("BLUE RAY","DVD",type,"Player type");
  }

  public void setresolution(String resolution)
  {
    this.resolution=resolution;
  }

  public void setformat(String format)
  {
    this.format=Checking.CheckInput("BD-R", "BD-RD","DVD-RW","DVD+RW",format,"format type");
  }
//get
  public String gettype()
  {
    return type;
  }

  public String getresolution()
  {
    return resolution;
  }

  public String getformat()
  {
    return format;
  }

//constructor
  public Players (String name,int age,String manufacturer,double price,String type, String resolution,String format)
  {
    super(name,age,manufacturer,price);
    settype(type);
    setresolution(resolution);
    setformat(format);
  }


  //toString
    public String toString()
    {
      return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"Type:"+type+"\nResolution:"+resolution+"\nFormat:"+format;
    }

}
