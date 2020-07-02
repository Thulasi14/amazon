package utilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {
	
	public static String read(String key) {
		
		Properties pr=new Properties();
		try{
			pr.load(new FileInputStream("C:\\Users\\home\\NewMavenWorkspace\\addtocart\\src\\test\\java\\files\\config.properties"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return pr.getProperty(key);
		
	}

}
