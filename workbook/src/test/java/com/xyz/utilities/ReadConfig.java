package com.xyz.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	public static String getProperty(String key)   
	{
		Properties prop = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream("D:\\eclipse personal\\eclipse-workspace-New\\workbook\\Configuration\\config.properties");
			try 
			{
				prop.load(fis);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			String propValue = prop.getProperty(key);
			
			if(propValue != null)
			{
				return propValue;
			}
			else
			{
				throw new RuntimeException("This property is not initialised");
			}
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at ");
		} 
		
		
	}

}
