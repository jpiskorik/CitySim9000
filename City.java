import java.util.Random;

public class City {

	public static void main(String[] args) 
	{
		int NUM_CARS = 5;
	 	Street fourth = new Street("Fourth Ave.");
	 	Street fifth = new Street("Fifth Ave.");
	 	Street meow = new Street("Meow Street.");
	 	Street chirp = new Street("Chirp Street.");
	 
	 	Location [] _locs = new Location[5];
		_locs[0] = new Location("Mall",fourth, null, meow,null);
		_locs[1] = new Location("Bookstore",fourth,null,chirp,null);
		_locs[2] = new Location("University", fifth,null,chirp,_locs[1]);
		_locs[3] = new Location("Coffee",fifth,null,meow,_locs[0]);
		_locs[4] = new Location("Outside",fifth,null,fourth,null);
	
		_locs[0].setaLocation(_locs[1]);   //setting 1st location to bookstore
		_locs[0].setbLocation(_locs[3]);    //setting 2nd location to Coffee
	
		_locs[1].setaLocation(_locs[4]);     //setting 1st location to Outside
		_locs[1].setbLocation(_locs[2]);		//setting 2nd location to University
	
		_locs[2].setaLocation(_locs[3]);		//setting 1st Location to coffee
	
		_locs[3].setaLocation(_locs[4]);		//setting 1st location to outside
	
	
	
		int firstArg=0;
		if (args.length > 0) 
		{
			//Checking to see if an arguement is passed into the command line
			try 
			{
        		firstArg = Integer.parseInt(args[0]);
			}	 
			catch (NumberFormatException e) 
			{
        		System.err.println("Argument " + args[0] + " must be an integer.");
        		System.exit(1);
    		}
		}
		Random rnd = new Random();
		rnd.setSeed(firstArg);
		
	
		for (int j = 0; j<NUM_CARS; j++)
		{
			Car c = new Car("Driver " +j,pickRandomLocation( _locs,firstArg,rnd));

			do
			{
				c.moveCar();
			
		 	}while(c.getcurrentlocation() != _locs[4]);
			
			System.out.println(c.getname() + " has left the city!");
			System.out.println("--------");
			
		}


	}
	
	public static Location pickRandomLocation(Location [] l, int arg, Random r)
	{
		int MAX =4;
		int MIN =0;
		
		int randomNumber = r.nextInt(MAX - MIN) +MIN;
	
		return l[randomNumber];
	}
	

}
