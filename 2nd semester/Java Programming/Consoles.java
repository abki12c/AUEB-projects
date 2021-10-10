public class Consoles extends Device implements Checking
{
  private String type;
  private String cpu;
  private String gpu;
  private String sound;
  private float storage;
  protected final float discount_rate = 0.1f;

//set
  public void settype(String type)
  {
    this.type=Checking.CheckInput("PS4","PS3","Xbox",type,"console type");
  }

  public void setcpu(String cpu)
  {
    this.cpu=cpu;
  }

  public void setgpu(String gpu)
  {
    this.gpu=gpu;
  }

  public void setsound(String sound)
  {
    this.sound=sound;
  }

  public void setstorage(float storage)
  {
    this.storage=storage;
  }


//get
  public String gettype()
  {
    return type;
  }

  public String getcpu()
  {
    return cpu;
  }

  public String getgpu()
  {
    return gpu;
  }

  public String getsound()
  {
    return sound;
  }

  public float getstorage()
  {
    return storage;
  }

//constructor here:
public Consoles(String name,int age,String manufacturer,double price,String type,String cpu,String gpu,String sound,float storage)
{
  super(name,age,manufacturer,price);
  settype(type);
  setcpu(cpu);
  setgpu(gpu);
  setsound(sound);
  setstorage(storage);
}


//toString
  public String toString()
  {
    return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"Type:"+type+"\nProcessor:"+cpu+"\nGraphics:"+gpu+"\nSound:"+sound+"\nStorage:"+storage;
  }
}
