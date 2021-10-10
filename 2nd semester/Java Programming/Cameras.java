public class Cameras extends Sound_Image implements Checking
{
  private String type;
  private int mgp;
  private int opt_zoom;
  private int dig_zoom;
  private int scr_size;



//set:
  public void settype(String type)
  {
    this.type=Checking.CheckInput("compact","DSLR","Action   camera",type,"camera type");
  }

  public void setmgp(int mgp)
  {
    this.mgp=mgp;
  }

  public void setopt_zoom(int opt_zoom)
  {
    this.opt_zoom=opt_zoom;
  }

  public void setdig_zoom(int dig_zoom)
  {
    this.dig_zoom=dig_zoom;
  }

  public void setscr_size(int scr_size)
  {
    this.scr_size=scr_size;
  }
//get:
  public String gettype()
  {
    return type;
  }

  public int getmgp()
  {
    return mgp;
  }

  public int getopt_zoom()
  {
    return opt_zoom;
  }

  public int getdig_zoom()
  {
    return dig_zoom;
  }
  public int getscr_size()
  {
    return scr_size;
  }

//constructor here:
  public Cameras(String name,int age,String manufacturer,double price,String type,int mgp,int opt_zoom,int dig_zoom,int scr_size)
  {
    super(name,age,manufacturer,price);
    settype(type);
    setmgp(mgp);
    setopt_zoom(opt_zoom);
    setdig_zoom(dig_zoom);
    setscr_size(scr_size);
  }

//toString
  public String toString()
  {
    return "\nDevice chracteristics:\n"+"\nModel name:"+this.getname()+"\nProduction year:"+this.getage()+"\nManufacturer name:"+this.getmanufacturer()+"\nPrice:"+this.getprice()+"Type:"+type+"\nMegapixels:"+mgp+"\nOptical Zoom:"+opt_zoom+"\nDigital Zoom"+dig_zoom+"\nScreen Size:"+ scr_size;
  }
}
