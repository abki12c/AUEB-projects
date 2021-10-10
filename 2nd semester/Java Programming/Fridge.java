public class Fridge extends Home implements Checking
{
  private String type;
  private String en_class;
  private float refr_storage;
  private float fr_storage;


//set
  public void settype(String type)
  {
    this.type=Checking.CheckInput("one door", "two door", "wardrobe",type,"Fridge type");
  }

  public void setrefr_storage(float refr_storage)
  {
    this.refr_storage=refr_storage;
  }

  public void setfr_storage(float fr_storage)
  {
    this.fr_storage=fr_storage;
  }


//get
  public String gettype()
  {
    return type;
  }

  public float getrefr_storage()
  {
    return refr_storage;
  }

  public float getfr_storage()
  {
    return fr_storage;
  }

//constructor
public Fridge(String name,int age,String manufacturer,double price,String type,String en_class,float refr_storage,float fr_storage)
{
  super(name,age,manufacturer,price);
  settype(type);
  seten_class(en_class);
  setrefr_storage(refr_storage);
  setfr_storage(fr_storage);
}
//toString
  public String toString()
  {
    return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"Type:"+type+"\nEnergy Class:"+en_class+"\nRetainer Storage:"+refr_storage+"\nFreezer Storage:"+fr_storage;
  }
}
