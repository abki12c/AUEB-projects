import java.io.*;
import java.util.*;

public class ReadFileApp {


	public void ReadFile(String data){

		BufferedReader reader = null;
		Device product = null;
		String line;
		System.out.println("\n >>>>>>> Adding Objects (Items) from File to List ...");
		try {
			reader = new BufferedReader(new FileReader(new File(data)));
			line = reader.readLine();
			while (line != null) {
			if (line.trim().toUpperCase().startsWith("ITEM_LIST")) {
					line = reader.readLine();
					if (line.trim().equals("{")) {
						line = reader.readLine();
						if (line.trim().toUpperCase().startsWith("ITEM")) {
							line = reader.readLine();
							if (line.trim().equals("{")) {
								line = reader.readLine();
								Device device = new Device();
								if(line.trim().toUpperCase().startsWith("CODE")){
									device.setcode(line);
								}
								line = reader.readLine();
								if(line.trim().toUpperCase().startsWith("MODEL")){
									device.setname(line);
								}
								line=reader.readLine();
								if(line.trim().toUpperCase().startsWith("MANUFACTURER"))
									device.setmanufacturer(line);
								line=reader.readLine();
								if(line.trim().toUpperCase().startsWith("MODEL_YEAR"))
									device.setage(Integer.parseInt(line.trim()));
								line=reader.readLine();
								if (line.trim().toUpperCase().startsWith("PRICE"))
									device.getprice(Integer.parseInt(line.trim()));
								line=reader.readLine();
								if(line.trim().toUpperCase().startsWith("PIECES"))
									device.setpieces(Integer.parseInt(line.trim()));
								line=reader.readLine();

								//Washing Machines

								if (line.trim().substring(5).trim().equalsIgnoreCase("TV")) {
									product = new CD();
									line = reader.readLine();
									if (line.trim().startsWith("Title "))
										product.setTitle(line.substring(6).trim());
									line = reader.readLine();
									if (line.trim().startsWith("Artist"))
										((CD) product).setArtist(line.trim().substring(7).trim());
									line = reader.readLine();
									if (line.trim().startsWith("Number of tracks "))
										((CD) product).setNumberOfTracks(Integer.parseInt(line.substring(17).trim()));
									line = reader.readLine();
									if (line.trim().startsWith("Playing time "))
										product.setplayingTime(Integer.parseInt(line.substring(13).trim()));
									line = reader.readLine();
									if (line.trim().startsWith("Price "))
										product.setPrice(Float.parseFloat(line.substring(6).trim()));
									line = reader.readLine();
									if (line.trim().equals("}"))
										products.add(product);

								} // TV
								else if (line.trim().substring(5).trim().equals("DVD")) {
									product = new DVD();
									line = reader.readLine();
									if (line.trim().startsWith("Title "))
										product.setTitle(line.substring(6).trim());
									line = reader.readLine();
									if (line.trim().startsWith("Director "))
										((DVD) product).setDirector(line.trim().substring(9).trim());
									line = reader.readLine();
									if (line.trim().startsWith("Star "))
										((DVD) product).setStar(line.trim().substring(5).trim());
									line = reader.readLine();
									if (line.trim().startsWith("Playing time "))
										product.setplayingTime(Integer.parseInt(line.substring(13).trim()));
									line = reader.readLine();
									if (line.trim().startsWith("Price "))
										product.setPrice(Float.parseFloat(line.substring(6).trim()));
									line = reader.readLine();
									if (line.trim().equals("}"))
										products.add(product);
								}//DVD
							}//{
							
						} //Item
					}
				} //Product
				line = reader.readLine();

			}//while
			reader.close();

		} //try

		catch (IOException e) {
			System.out.println	("Error reading line ...");
		}

	} // ReadFile

}
