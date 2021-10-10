import java.util.*;

/*
USER TEAM:30

KOMNAS KAFASIS:3190081
PETROS VARFIS :3180017

*/

public class mainApp implements Checking
{
	static String name;
	static int age;
	static String manufacturer;
	static double price;
	public static TV television;
	public static Players player;
	public static Cameras camera;
	public static Consoles console;
	public static Fridge fridge;
	public static W_Machine washingMachine;
	//Initialize Catalogs
	static List<Order> Orders = new ArrayList<Order>();
	static List<Sale> Sales = new ArrayList<Sale>();


	public static void stats(){
		Scanner in= new Scanner(System.in);

		System.out.print("\nEnter the name of the model: ");
		name = in.nextLine();
		System.out.print("\nEnter the production year: ");
		age=in.nextInt();
		System.out.print("\nEnter the manufacturer name: ");
		in.nextLine();
		manufacturer = in.nextLine();
		System.out.print("\nEnter the price of the product: ");
		price=Double.parseDouble(in.nextLine());
	}


	public static void SellOrOrder(Device device,float discount_rate)
	{
		int customerPhone;
		String customerName;
		String saleDate;
		String answer;
		String orderDate;
		String arriveDate;


		Scanner in= new Scanner(System.in);
		if(CreateFileApp.AvailableProducts.contains(device) && device.getpieces()>0){
			System.out.print("\nThe product is available for sale.Do you want to buy it? Yes/No: ");
			answer = Checking.CheckInput("Yes","No",in.nextLine(),"prefered answer Yes or No");
			if(answer.equalsIgnoreCase("Yes")){
				//you can sell
				System.out.print("\nEnter the customer phone: ");
				customerPhone = in.nextInt();
				System.out.print("\nEnter the customer name: ");
				in.nextLine();
				customerName = in.nextLine();
				System.out.print("\nEnter the sale date: ");
				saleDate = in.nextLine();
				System.out.print("Price before discount: "+ device.getprice());
				device.price=device.getprice()-device.getprice()*discount_rate;
				System.out.print("Price after discount:"+ device.getprice());
				Sale toBeSold = new Sale(device.getname(),device.getprice(),customerPhone,customerName,saleDate);
				Sales.add(toBeSold);
				//reduce model pieces by one
				for (Device dev : CreateFileApp.AvailableProducts) {
					if (CreateFileApp.AvailableProducts.equals(dev))
					  dev.setpieces(dev.getpieces()-1);
				}
				System.out.println("Congratulations, the product has been sold!");
			}
		}else{
			//you can order
			System.out.print("\nThe product is not available for sale .Do you want to order it? Yes/No: ");
			answer = Checking.CheckInput("Yes","No",in.nextLine(),"prefered answer Yes or No");
			if(answer.equalsIgnoreCase("Yes")){
				System.out.print("\nEnter the customer phone: ");
				customerPhone = in.nextInt();
				System.out.print("\nEnter the customer name: ");
				in.nextLine();
				customerName = in.nextLine();
				System.out.print("\nEnter the order date: ");
				orderDate = in.nextLine();
				System.out.print("\nEnter the arrive date: ");
				arriveDate = in.nextLine();
				Order toBeOrdered= new Order(device.getname(),device.getprice(),customerPhone,customerName,orderDate,arriveDate);
				Orders.add(toBeOrdered);
				System.out.println("Congratulations, the product has been ordered!");
			}
		}
	}


//main
	public static void main(String[] args)
	{
		String type;
		String opt;
		String opt1;
		String opt2;
		String opt3;

		CreateFileApp.CreateSet();
		CreateFileApp.CreateFile();
		CreateFileApp.PrintFile();
		//we transfer the Objects to the txt file here:

		Scanner in= new Scanner(System.in);
		System.out.println("Welcome to the App!");
		do{
			System.out.println("------------------------------------------");
			System.out.println("1.Review of available devices");
			System.out.println("2.Review of Orders");
			System.out.println("3.Review of Sales");
			System.out.println("4.Exit the program");
			System.out.println("------------------------------------------");
			System.out.println("Please choose one of the valid options above: ");
			opt=Checking.CheckInput("1","2","3","4",in.nextLine(), "correct desired number ");
			if(opt.equals("1"))
			{
				System.out.println("Main Menu");
				System.out.println("------------------------------------------");
				System.out.println("1.Screen And Sound");
				System.out.println("2.Gaming");
				System.out.println("3.Home");
				System.out.println("------------------------------------------");
				System.out.print("Please choose one of the valid options above: ");
				opt1=Checking.CheckInput("1","2","3",in.nextLine(), "correct desired number ");
				if(opt1.equals("1"))
				{
					//Screen and Sound category
					System.out.println("You have chosen the Screen and Sound category.");
					System.out.println("Press 1 for  TV, 2 for Blue ray/DVD players or 3 for Cameras: ");
					opt2=Checking.CheckInput("1","2","3",in.nextLine(), "correct desired number ");

					if (opt2.equals("1"))
					{
						//TV
						System.out.println("You have chosen the television category");
						System.out.println("Now you should give information about the specific model...");
						System.out.print("\nEnter the model type:");
						type = Checking.CheckInput("LCD","LED","Plasma",in.nextLine(),"TV type");
						System.out.print("\nEnter inches: ");
						int inches = in.nextInt();
						System.out.print("\nEnter the display resolution: ");
						in.nextLine();
						String display = in.nextLine();
						System.out.print("\nEnter the ports the model has: ");
						String ports =  Checking.CheckInput("HDMI","DVI","Composite",in.nextLine(),"TV port");
						stats();
						television = new TV(name,age,manufacturer,price,type,inches,display,ports);
						System.out.println(television);
				   		SellOrOrder(television,television.discount_rate);


					}else if(opt2.equals("2"))
					{
						//PLayers
						System.out.println("You have chosen the Blue ray/DVD players category");
						System.out.println("Now you should give information about the specific model...");
						System.out.println("Give more information about the specific model...");
						System.out.print("\nEnter the model type:");
						type = Checking.CheckInput("BLUE RAY","DVD",in.nextLine(),"Player type");
						System.out.print("\nEnter the display resolution:");
						String resolution =in.nextLine();
						System.out.print("\nEnter the format :");
						String format=Checking.CheckInput("BD-R", "BD-RD","DVD-RW","DVD+RW",in.nextLine(),"format type");
						stats();
						player = new Players(name,age,manufacturer,price,type,resolution,format);
						System.out.println(player);
						SellOrOrder(player,player.discount_rate);
					}
					else
					{
						//Cameras
						System.out.println("You have chosen the Cameras category");
						System.out.println("Now you should give information about the specific model...");
						System.out.print("\nEnter the model type: ");
						type=Checking.CheckInput("compact","DSLR","Action   camera",in.nextLine(),"camera type");
						System.out.print("\nEnter the Megapixels: ");
						int mgp=in.nextInt();
						System.out.print("\nEnter the Optical Zoom: ");
						int opt_zoom=in.nextInt();
						System.out.print("\nEnter the Digital Zoom: ");
						int dig_zoom=in.nextInt();
						System.out.print("\nEnter the Screen Size: ");
						int scr_size=in.nextInt();
						in.nextLine();
						stats();
						camera=new Cameras(name,age,manufacturer,price,type,mgp,opt_zoom,dig_zoom,scr_size);
						System.out.println(camera);
						SellOrOrder(camera,camera.discount_rate);
					}
				}
				else if (opt1.equals("2"))
				{
					//Gaming category
					System.out.println("You have chosen the Gaming category.");
					System.out.println("Now you should give information about the specific model...");
					System.out.print("\nEnter the console type: ");
					type=Checking.CheckInput("PS4","PS3","Xbox",in.nextLine(),"console type");
					System.out.print("\nEnter Processor : ");
					String cpu=in.nextLine();
					System.out.print("\nEnter Graphics : ");
					String gpu=in.nextLine();
					System.out.print("\nEnter Sound : ");
					String sound=in.nextLine();
					System.out.print("\nEnter Storage: ");
					float storage=in.nextFloat();
					in.nextLine();
					stats();
					console=new Consoles(name,age,manufacturer,price,type,cpu,gpu,sound,storage);
					System.out.println(console);
					SellOrOrder(console,console.discount_rate);

				}
				else
				{
					//Home category
					String en_class;

					System.out.println("You have chosen the Home category.");
					System.out.println("Press 1 for Fridges and 2 for Washing machines:");
					opt3 = Checking.CheckInput("1","2",in.nextLine(), "correct desired number ");
					if (opt3.equals("1")){
						float refr_storage;
					  float fr_storage;

						System.out.println("You have chosen the Fridges category");
						System.out.println("Give more information about the specific model...");
						System.out.print("\nEnter the Fridges type: ");
						type = Checking.CheckInput("one door", "two door", "wardrobe",in.nextLine(),"Fridge type");
						System.out.print("\nEnter the energy class: ");
						en_class = in.nextLine();
						System.out.print("\nEnter the Retainer storage: ");
						refr_storage = in.nextFloat();
						System.out.print("\nEnter the Freezer storage: ");
						fr_storage = in.nextFloat();
						in.nextLine();
						stats();
						fridge = new Fridge(name,age,manufacturer,price,type,en_class,refr_storage,fr_storage);
						System.out.println(fridge);
						SellOrOrder(fridge,fridge.discount_rate);
					}
					else {
						float storage;
						int rpm;

						System.out.println("You have chosen the Washing machine category");
						System.out.println("Give more information about the specific model...");
						System.out.print("\nEnter the energy class: ");
						en_class = in.nextLine();
						System.out.print("\nEnter the washing machine storage: ");
						storage = in.nextFloat();
						System.out.print("\nEnter the Washing machine rpm: ");
						rpm = in.nextInt();
						in.nextLine();
						stats();
						washingMachine = new W_Machine(name,age,manufacturer,price,en_class,storage,rpm);
						System.out.println(washingMachine);
						SellOrOrder(washingMachine,washingMachine.discount_rate);
					}


					}



			}else if (opt.equals("2"))
			{
				//orders
				int i = 0;
				System.out.println("You have chosen to review the Orders of products.");
				if(Orders.size()>0){
					System.out.println("Here are the ordered products:");
					for(Order order: Orders)
					{
						System.out.println("Order "+i+":");
						System.out.println(order.toString());
						i++;
					}
					System.out.println("Choose a product between 0 and "+ (Orders.size()-1)+":");
					int orderNumber = in.nextInt();
					while(orderNumber>=Orders.size() || orderNumber<0){
						System.out.println("Wrong number.Enter the correct number again:");
						orderNumber=in.nextInt();
					}
					in.nextLine();
					System.out.println(Orders.get(orderNumber));
					System.out.print("Would you like to buy this product?(Yes/no) : ");
					String option=Checking.CheckInput("Yes","No",in.nextLine(), "Yes or No");
					if (option.equalsIgnoreCase("Yes")){
						Sale newSale= new Sale(Orders.get(orderNumber).getname(),Orders.get(orderNumber).getprice(),Orders.get(orderNumber).CustomerPhone,Orders.get(orderNumber).CustomerName,Orders.get(orderNumber).arriveDate);
						Sales.add(newSale);
						Orders.get(orderNumber).setstatus("ARRIVED");
						System.out.println("Sale Successful!");
					}
				}else{
					System.out.println("There are no orders at the moment..");
				}



			}else if(opt.equals("3")) {
				//sales

				System.out.println("You have chosen to review the Sales of products.");
				if (Sales.size()>0){
					System.out.println("Here are the sold products:");
					for(Sale sale: Sales)
					{
						System.out.println(sale);

					}
				}else{
					System.out.println("There are no sold products at the moment..");
				}


			}

		}while(!opt.equals("4"));
		System.out.println("*You exited the App*");
	}
}
