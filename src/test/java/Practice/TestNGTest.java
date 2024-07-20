package Practice;

import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(priority =1)
	public void createContactTest()
	{
		System.out.println("Contact Created");
	}
	
	@Test(priority =0)
	public void modifyContactTest()
	{
		System.out.println("Contact Modified");
	}
	
	@Test(priority =2)
	public void deleteContactTest()

	{
		System.out.println("Contact Deleted");
	}
}
