public class W_Machine extends Home
{
  private String en_class;
  private float storage;
  private int rpm;
//set
  public void setstorage(float storage){
    this.storage=storage;
  }

  public void setrpm(int rpm){
    this.rpm=rpm;
  }
//get
  public float getstorage(){
    return storage;
  }
  public int getrpm(){
    return rpm;
  }

//constructor here:
  public W_Machine(String name,int age,String manufacturer,double price,String en_class,float storage,int rpm)
  {
    super(name,age,manufacturer,price);
    seten_class(en_class);
    setstorage(storage);
    setrpm(rpm);
  }
  //toString
    public String toString()
    {
      return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"Energy Class:"+en_class+"\nStorage:"+storage+"\nRounds Per Minute:"+rpm ;
    }
}
