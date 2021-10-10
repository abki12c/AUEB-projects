import java.io.*;
import java.util.*;


public class CreateFileApp
{
public static Set<Device> AvailableProducts = new HashSet<Device>();

/*public static void CreateSet(){

  System.out.println(" >>>>>>> Creating Objects (Devices) ...");

  System.out.println(" >>>>>>> Adding objects to AvailableProducts...");
  AvailableProducts.add(new TV("Panasonic G78",2007,"Samsung",99.99,"LED",32,"720p","DVI"));
  AvailableProducts.add(new TV(" LG 43UM7100",2019,"LG",289.99,"LCD",38,"1080p","HDMI"));
  AvailableProducts.add(new Players("Sony Blue Ray G5 ",2019,"Sony",169.99,"BLUE RAY","1080p","BD-R"));
  AvailableProducts.add(new Players("Sony DVD Player H3 ",2019,"Sony",289.99, "DVD","720p","DVD+RW"));
  AvailableProducts.add(new Consoles("Playstation 4 Pro",2016,"Sony",299.99,"PS4","AMD JAGUAR","AMD RADEON POLARIS","7.1 Sony Sound Card",500.0f));
  AvailableProducts.add(new Consoles("Xbox One",2016,"Microsoft",149.99,"Xbox","AMD JAGUAR","AMD RADEON POLARIS","7.1 Microsoft Sound Card",1000.0f));
  AvailableProducts.add(new Cameras("DSLR D5300",2017,"Nikon",699.99,"DSLR",24,40,60,4));
  AvailableProducts.add(new Cameras("Digital Camera Cybershot DSC-HX60B",2013,"Sony",399.99,"compact",23,20,30,2));
  AvailableProducts.add(new Fridge("CM 3352 W",2020,"CANDY",499.99,"two door","A", 262,98));
  AvailableProducts.add(new Fridge("GBP 31 DSLZN",2017,"LG",799.99,"wardrobe","A+", 305,112));
  AvailableProducts.add(new W_Machine("F4J5TN3W",2016,"LG",399.99,"A+++",8,1200));
  AvailableProducts.add(new W_Machine("FWSF61053W",2015,"WHIRLPOOL",289.99,"A++",6,1000));

}*/




  public void PrintSet()
  {
    for(Device product : AvailableProducts)
    {
      System.out.println(product);
    }
  }//PrintList



public static void CreateFile()
{
    System.out.println("\nNow we will write our items in a new txt file");
    FileWriter writer =null;
    try
    {
      writer =new FileWriter(new File("products.txt"));
      writer.write("ITEM_LIST"+"\n"+"{");
      for(Device product:AvailableProducts)
      {
        if (product instanceof TV)
        {
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : TV"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : " + product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+"TYPE : "+((TV)product).gettype()+"\n"+"\t"+"\t"+"INCHES : "+((TV)product).getinches()+"\n"+"\t"+"\t"+"DISPLAY : "+((TV)product).getdisplay()+"\n"+"\t"+"\t"+"PORTS : "+((TV)product).getports()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");
        }else if(product instanceof Consoles)
        {
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : CONSOLE"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : "+product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+"TYPE : "+((Consoles)product).gettype()+"\n"+"\t"+"\t"+"CPU : "+((Consoles)product).getcpu()+"\n"+"\t"+"\t"+"GPU : "+((Consoles)product).getgpu()+
          "\n"+"\t"+"\t"+"STORAGE : "+((Consoles)product).getstorage()+"\n"+"\t"+"\t"+"SOUND : "+((Consoles)product).getsound()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");
        }else if(product instanceof Players)
        {
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : PLAYER"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : "+product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+"TYPE : "+((Players)product).gettype()+"\n"+"\t"+"\t"+"RESOLUTION : "+((Players)product).getresolution()+"\n"+"\t"+"\t"+"format : "+((Players)product).getformat()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");

        }else if(product instanceof Fridge)
        {
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : FRIDGE"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : "+product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+"TYPE : "+((Fridge)product).gettype()+"\n"+"\t"+"\t"+"ENERGY_CLASS : "+((Fridge)product).geten_class()+"\n"+"\t"+"\t"+
          "REFRIDGERATOR STORAGE : "+((Fridge)product).getrefr_storage()+"\n"+"\t"+"\t"+"FRIDGE STORAGE : "+((Fridge)product).getfr_storage()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");
        }else if(product instanceof W_Machine)
        {
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : WASHING MACHINE"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : "+product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+"ENERGY_CLASS : "+((W_Machine)product).geten_class()+"\n"+"\t"+"\t"+"STORAGE : "+((W_Machine)product).getstorage()+"\n"+"\t"+"\t"+"RPM : "+((W_Machine)product).getrpm()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");
        }else
        {
          //Cameras
          writer.write("\n"+"ITEM"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"Code : "+product.getcode()+"\n"+"\t"+"\t"+"ITEM_TYPE : CAMERA"+"\n"+"\t"+"\t"+"MODEL: "+product.getname()+"\n"+"\t"+"\t"+"MANUFACTURER : "+product.getmanufacturer()+"\n"+"\t"+"\t"+"Age : "+product.getage()+
          "\n"+"\t"+"\t"+"PRICE : "+product.getprice()+"\n"+"\t"+"\t"+" TYPE: "+((Cameras)product).gettype()+"\n"+"\t"+"\t"+"MEGAPIXELS : "+((Cameras)product).getmgp()+"\n"+"\t"+"\t"+" OPTICAL ZOOM: "+((Cameras)product).getopt_zoom()+"\n"+"\t"+"\t"+"DIGITAL ZOOM: "+((Cameras)product).getdig_zoom()+
          "\n"+"\t"+"\t"+"SCREEN SIZE: "+((Cameras)product).getscr_size()+"\n"+"\t"+"\t"+"PIECES :"+product.getpieces()+"\n"+"\t"+"}");
        }
    }

      writer.write("\n"+"}");
	    writer.close();

    }//try

    catch(IOException e){
      System.err.println("Error writing file.Try again.");
    }//catch
    System.out.println("Items have been successfully written in the new file.");
  }//CreateFile



public static void PrintFile()
{
  System.out.println("-----------Printing File-------------");
  try{
    BufferedReader reader = new BufferedReader(new FileReader(new File("products.txt")));
    String line=reader.readLine();
    while(line!=null)
	{
      System.out.println(line);
      line=reader.readLine();
    }
    reader.close();

  }//try

  catch(IOException e)
  {
    System.err.println("Error Reader file");
  }//catch
}//PrintFile


}//CreateFile
