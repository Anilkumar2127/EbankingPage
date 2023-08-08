
package com.Ebank.utilities;

//This java file is to create N no.of method creations to get the variables values in the properties file.
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadGlobal {
	
	Properties pro;
	public ReadGlobal()
	{
		File src = new File("./Configurations/globalval.properties");//locating the file path
		try
		{
			FileInputStream fs =new FileInputStream(src);//to read the file
			pro =new Properties();
			pro.load(fs);	//loads the property file
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		
	}
	public String getBrowser()
	{
		String Browser=pro.getProperty("browser");//get the browser value in properties file using".getProperty inbuilt method"
				return Browser;
	}
	public String getUserName()
	{
		String Username=pro.getProperty("username");
				return Username;
	}
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
				return pwd;
	}
	public String getUrl()
	{
		String burl=pro.getProperty("url");
				return burl;
	}
	public String getPath()
	{
		String Cpath=pro.getProperty("chromepath");
				return Cpath;
	}


}
