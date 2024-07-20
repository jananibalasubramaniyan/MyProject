package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	public String getKeyAndValuePair(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFile.properties.txt");
		
		Properties pro=new Properties();
		
		pro.load(fis);
		
		String Value=pro.getProperty(Key);
		
		return Value;
		

	}

}
