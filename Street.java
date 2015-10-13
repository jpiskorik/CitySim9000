
public class Street 
{
	private String street_name;
	
	public Street(String sn)
	{
		street_name = sn;
	}
	
	public Street()
	{
		street_name = null;
	}
	
	public String getStreetName()
	{
		return street_name;
	}
	
	public void setStreetName(String sn)
	{
		street_name = sn;
	}
}
