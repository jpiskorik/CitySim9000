 import java.util.Random;
 
public class Location 
{
	private String LocationName;
	private Street aStreet;
	private Location aLocation;
	private Street bStreet;
	private Location bLocation;
	
	public Location(String ln, Street as, Location al, Street bs, Location bl)
	{
		LocationName=ln;
		aStreet=as;
		aLocation=al;
		bStreet=bs;
		bLocation=bl;
	}
	
	public Location()
	{
		LocationName=null;
		aStreet=null;
		aLocation=null;
		bStreet=null;
		bLocation=null;
	
	}
	
	public String getLocationName()
	{
		return LocationName;
	}
	
	public Street getaStreet()
	{
		return aStreet;
	}
	
	public Location getaLocation()
	{
		return aLocation;
	}
	
	public Street getbStreet()
	{
		return bStreet;
	}
	public Location getbLocation()
	{
		return bLocation;
	}
	
	
	public void setLocationName(String ln)
	{
		LocationName=ln;
	}
	public void setaStreet(Street as)
	{
		aStreet=as;
	}
	public void setaLocation(Location al)
	{
		aLocation = al;
	}
	public void setbStreet(Street bs)
	{
		bStreet=bs;
	}
	public void setbLocation(Location bl)
	{
		bLocation = bl;
	}
	
	
	public Location goToNextLocation(Car c)
	{
		Location nextLocation = new Location();
		Street nextStreet= new Street();
		Random randomGenerator = new Random();
		if(randomGenerator.nextInt() %2 ==0)
		{
			nextLocation= this.getaLocation();
			nextStreet= this.getaStreet();
		}
		else
		{
			nextLocation= this.getbLocation();
			nextStreet= this.getbStreet();
		}
		
		System.out.println(c.getname() + " heading from " + 
		this.getLocationName() + " to " + nextLocation.getLocationName() + " via " + nextStreet.getStreetName());
		
		return nextLocation;
	}
}
