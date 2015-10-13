import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.Random;

public class CityTest {

	//Testing to get a location that is not
	//outside the city
	//
	@Test
	public void TestReturnRandomLocation()
    {
		String location;
    	Location loc = Mockito.mock(Location.class);
    	Random r = Mockito.mock(Random.class);
    			
    	//Test when random is 0 return Mall Location
    	when(r.nextInt(4)).thenReturn(0);
    	location = loc.getLocationName();
    	assertEquals(location, "Mall");
    	
    	//Test when random is 1 return the Bookstore Location
    	when(r.nextInt(4)).thenReturn(1);
    	location = loc.getLocationName();
    	assertEquals(location, "Bookstore");
    	
    	//Test when random is 2 return the University Location
    	when(r.nextInt(4)).thenReturn(2);
    	location = loc.getLocationName();
    	assertEquals(location, "University");
    	
    	//Test when random is 3 return the Coffee Location
    	when(r.nextInt(4)).thenReturn(3);
    	location = loc.getLocationName();
    	assertEquals(location, "Coffee");
    	
    	//Test when random is 4 return the Outisde Location
    	when(r.nextInt(4)).thenReturn(4);
    	location = loc.getLocationName();
    	assertEquals(location, "Outside");
    	
    }	

	//When a new string is defined in the Car class
	//that string should be returned in the getter method
	//create a new string and a mock location and make sure they equal
	 @Test
	public void TestNewCarName() 
	 {
		 String TestString = "Jeff Gordon";
		 Location mockLocation = Mockito.mock(Location.class);
		 Car TestCar =  new Car(TestString,mockLocation);
		 assertEquals(TestString, TestCar.getname());
	 }
	//When a string and a new Location are defined in Car class
	//This new location will be the same as the getcurrentlocation
	//
	@Test
	public void TestGetCurrentLocation()
	{
	    	Location mockLocation = Mockito.mock(Location.class);
	    	Car TestCar = new Car("nothing", mockLocation);
	    	assertEquals(mockLocation, TestCar.getcurrentlocation());
	 }
	    
	 //Testing a car with no values
	 //if no values are assigned the program will do it for the user
	 //
	 @Test
	 public void TestCarWithNoValues()
	 {
	    	Location MockLocation = Mockito.mock(Location.class);
	    	MockLocation = null;
	    	String Str = null;
	    	Car TestCar = new Car();
	    	assertEquals(Str, TestCar.getname()); 
	    	assertEquals(MockLocation, TestCar.getcurrentlocation());
	     	
	  }	    
	 
	 
	//Defining a new street with any name will result in that name 
	    //being printed out 
	    //
	    @Test
	    public void TestStreetName()
	    {
	    	String FakeStreet = "Seasame Street";
	    	Street TestStreet = new Street (FakeStreet);
	    	assertEquals(FakeStreet, TestStreet.getStreetName());
	    }

	    
	    //Testing to see if a streetname was not given
	    //StreetName should become null
	    @Test
	    public void TestNUllName()
	    {
	    	String test =null;
	    	Street TestStreet = new Street();
	    	assertEquals(test, TestStreet.getStreetName());
	    	
	    }
	    
	    //Testing to see when a string is defined the
	    //new street will contain that output
	    
	    @Test
	    public void TestSetName()
	    {
	    	String testName = ("Louis Lane");
	    	Street TestStreet = new Street();
	    	TestStreet.setStreetName(testName);
	    	assertEquals(testName, TestStreet.getStreetName());
	    }
	    
	    //testing to see if a new location is called
	    //and pre-exsiting attributes are defined then
	    //the object will be given these attributes
	    @Test
	    public void TestLocationDeclartaion()
	    {
	    	String name = "Party";
	    	Street mockStreet1 = Mockito.mock(Street.class);
		 	Street mockStreet2 = Mockito.mock(Street.class);
		 	Location mockLocation1 = Mockito.mock(Location.class);
		 	Location mockLocation2 = Mockito.mock(Location.class);
		 	Location locs = new Location(name,mockStreet1,mockLocation1,mockStreet2,mockLocation2);
		 	
		 	assertEquals(locs.getaStreet(), mockStreet1);
		 	assertEquals(locs.getaLocation(), mockLocation1);
		 	assertEquals(locs.getbStreet(), mockStreet2);
		 	assertEquals(locs.getbLocation(), mockLocation2);
		 	assertEquals(locs.getLocationName(), "Party");
	    	
	    }
	    //Testing if an empty Location object is defined
	    
	    @Test
	    public void TestEmptyLocation()
	    {
	    	Location mlocs = new Location();
	    	
	    	assertEquals(mlocs.getaStreet(), null);
		 	assertEquals(mlocs.getaLocation(), null);
		 	assertEquals(mlocs.getbStreet(), null);
		 	assertEquals(mlocs.getbLocation(), null);
		 	assertEquals(mlocs.getLocationName(), null);
	    	
	    
	    }
	    
	    //Testing to see if the set methods properly set the Location variables
	    @Test
	    public void TestSetLocation()
	    {
	    	Location mlocs = new Location();
	    	Location  mockloc = Mockito.mock(Location.class);
	    	Street mockStreet = Mockito.mock(Street.class);
	    	
	    	mlocs.setLocationName("Rivertown");
	    	mlocs.setaStreet(mockStreet);
	    	mlocs.setaLocation(mockloc);
	    	mlocs.setbStreet(mockStreet);
	    	mlocs.setbLocation(mockloc);
	    	
	    	assertEquals(mlocs.getaStreet(), mockStreet);
		 	assertEquals(mlocs.getaLocation(), mockloc);
		 	assertEquals(mlocs.getbStreet(), mockStreet);
		 	assertEquals(mlocs.getbLocation(), mockloc);
		 	assertEquals(mlocs.getLocationName(), "Rivertown");
	    
	    }
	
	    //Testing to see if the program goes to the next Location
	    @Test
	    public void TestGoToNextLoc()
	    {
	    	Car mockCar = new Car();
	    	Street mockStreet = Mockito.mock(Street.class);
		 	Location mockLocation = Mockito.mock(Location.class);
		 	
		 	Location mockALocation = mockLocation.getaLocation();
		 	Location mockBLocation = mockLocation.getbLocation();
		 	
		 	Street mockAStreet = mockLocation.getaStreet();
		 	Street mockBStreet = mockLocation.getbStreet();
		 	Random mockRandom = Mockito.mock(Random.class);
		 	
		 	//when random returns even
		 	when (mockRandom.nextInt(4)).thenReturn(2);
		 	Location testLoc = mockLocation.goToNextLocation(mockCar);
		 	
		 	assertEquals(mockLocation, mockALocation);
		 	assertEquals(mockStreet, mockAStreet);
		 	assertEquals(mockLocation, testLoc);
		 
		 	//when random returns odd
		 	when (mockRandom.nextInt(4)).thenReturn(1);
		 	assertEquals(mockLocation, mockBLocation);
		 	assertEquals(mockStreet, mockBStreet);
		 	assertEquals(mockLocation, testLoc);
		 }
	    
	    //Testing to move the car
	    @Test
	    public void TestMoveCar()
	    {
	    	Car TestCar = new Car();
	    	Location loc = new Location();
	    	Location loc2 = new Location();
	    	when(loc.goToNextLocation(TestCar)).thenReturn(loc2);
	    	TestCar.moveCar();
	    	assertEquals(loc2,TestCar.getcurrentlocation());
	    	
	    }
	    
	    
}		    
