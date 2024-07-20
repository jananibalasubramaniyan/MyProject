package Generic_Utility;

import java.util.Date;
import java.util.Random;

public class Java_Utitlity {

	public int getRandomNum()
	{
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		return ranNum;
	}

	public String getSystemDateAndTime()
	{
		Date date=new Date();
		String dateAndTime=date.toString();
		System.out.println(dateAndTime);
		return dateAndTime;
		
	}
	
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime=date.toString();
		System.out.println(dateAndTime);
		
		String YYYY=dateAndTime.split("")[5];
		String DD=dateAndTime.split("")[2];
		
		int MM=date.getMonth()+1;
		
		String FinalFormat=YYYY+"-"+MM+"-"+DD;
		System.out.println(FinalFormat);
		return FinalFormat;
	}
}

