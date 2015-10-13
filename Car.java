

public class Car 
{
	private String name;
	private Location currentLocation;
	
	public Car(String n, Location loc )
	{
		name =n;
		currentLocation = loc;
	}
	
	public Car()
	{
		name=null;
		currentLocation = null;
	}
	
	public String getname()
	{
		return name;
	}
	
	public Location getcurrentlocation()
	{
		return currentLocation;
	}
	
	public void moveCar()
	{
		currentLocation = currentLocation.goToNextLocation(this);
	}
}
